import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Font;

import javax.microedition.lcdui.game.GameCanvas;

import java.io.IOException;

public class AutoEstradaCanvas extends GameCanvas implements Runnable
{
    private Veiculo carroJogador;
    private final static int col1 = 46;
    private final static int col2 = 82;
    private final static int col3 = 116;
    
    private final static int MARGEM_ESQUERDA = 36;
    private final static int MARGEM_DIREITA = 143;

    /* Imagens que deverão ser utilizadas no jogo */
    private Image carro1;
    private Image carro2;
    private Image carro3;
    private Image carro4;
    private Image caminhao;
    private Image placa;
    private Image back;
    
    /* posicao y das linhas do chão */
    private final static int linhas[]={150,100,50,0,-50,-100,-150};

    /* posicao y da placa na beira da estrada */
    private int placapy = 90;
    
    /* variavel que armazena o atual estado do semáforo */
    /* 0 = apagado 1 = primeiro vermelho 2 = segundo vermelho 3 = verde*/
    private int semaforo;


    private boolean pausado;
    
    /* Vetor de objetos veiculo de inimigos. */
    private Veiculo veiculoInimigo[];

    /* mapa = numero de veiculos - (tipo, px, py)) */;
    private int mapa1[]=
    {   49,1,col1,60,1,col3,60,1,col2,-40,1,col3,-140,4,col1,-200,
        2,col2,-270,2,col2,-500,1,col3, -580, 2,col1,-630, 4,col2,-730,
        2,col1,-780,3,col1,-850,2,col1,-930,3,col2,-990,4,col1,-1100,
        1,col3,-1200,2,col2,-1300,4,col1,-1400,1,col2,-1490,2,col3,-1600,
        3,col1,-1700,3,col3,-1800,2,col2,-1890,1,col1,-1960,4,col3,-2120,
        1,col2,-2200,2,col1,-2270,2,col3,-2350,4,col1,-2450,1,col2,-2500,
        4,col1,-2650,4,col3,-2650,3,col1,-2750,2,col2,-2830,1,col1,-2900,
        3,col1,-3100,3,col3,-3300,3,col1,-3500,1,col3,-3600,2,col2,-3670,
        1,col2,-3750,4,col3,-3770,3,col1,-3870,2,col3,-3950,1,col2,-4070,
        1,col1,-4140,3,col3,-4220,2,col2,-4300,3,col3,-4390
    };

    private int mapa[];

    /* variável com o numero de veículos de inimigos do mapa atual */
    private int numVeiculos;

    /* número atual de loops executados dentro de um segundo */
    private int loopCounter;
    /* número de milisegundos que o jogo dorme voluntariamente */
    private final static int sleepTime = 30;

    public AutoEstradaCanvas()
    {
        /* constructor GameCanvas(boolean suppressKeyEvents)*/
        super(true);
        carregaImagens();
        iniciaJogo();
        new Thread(this).start();
    }
    
    /* Carrega as imagens do jogo */
    private void carregaImagens() {
        try {
            carro1 = Image.createImage("/imagens/carro1.png");
            carro2 = Image.createImage("/imagens/carro2.png");
            carro3 = Image.createImage("/imagens/carro3.png");
            carro4 = Image.createImage("/imagens/carro4.png");
            caminhao = Image.createImage("/imagens/caminhao.png");
            placa = Image.createImage("/imagens/placa.png");
            back = Image.createImage("/imagens/back.png");
        }
        catch(IOException e){
            System.out.println("Erro ao carregar Imagens");
            e.printStackTrace();
        }
    }

    private void iniciaJogo(){
        carroJogador = new Veiculo(carro1, 0, col2,130, 130, 5);
        setMapa(mapa1);
        carregaMapa();
        pausado     = false;
        semaforo    = 0;
        loopCounter = 0;
    }
    
    private void setMapa(int m[]) { mapa = m; }
    
    private void carregaMapa(){
        Image img=null;
        int x,y;
        numVeiculos = mapa[0];
        veiculoInimigo = new Veiculo[numVeiculos];
        for(y=0, x=1; y<numVeiculos; x+=3, y++)
        {
            if(mapa[x] == 1)
            img = carro2;
            else if(mapa[x] == 2)
            img = carro3;
            else if(mapa[x] == 3)
            img = carro4;
            else if(mapa[x] == 4)
            img = caminhao;

            veiculoInimigo[y] = new Veiculo(img, mapa[x], mapa[x+1], mapa[x+2], 100 ,3);
            veiculoInimigo[y].setVelocidade(10);
        }
    }
    
    /* método simples para desenhar as linhas, sao desenhadas duas linhas dividindo a estrada em 3. */
    private void desenhaLinhas(Graphics g) {
        g.setColor(255,255,255);
        for(int x=0; x<linhas.length;x++){
            g.fillRect(34+MARGEM_ESQUERDA,linhas[x],3,20);
            g.fillRect(69+MARGEM_ESQUERDA,linhas[x],3,20);
        }   
    }
    
    private void andaLinhas() {
        int vel = carroJogador.getVelocidade();
        for(int x=0; x<linhas.length;x++) {
            if(vel > 5)
                linhas[x]+=vel/5;
            else if(vel != 0)
                linhas[x]++;

            if(linhas[x] > 180 )
                linhas[x]-=300;
        }
    }

    /* Funciona da mesma maneira que andaLinhas(). */
    private void andaPlacas() {
        int vel = carroJogador.getVelocidade();

        if(vel > 5)
            placapy+=vel/5;
        else if(vel != 0)
            placapy++;

        if(placapy > 180 )
            placapy-=210;
    }
    
    /* Funciona da mesma maneira que desenhaPlacas(). */
    private void desenhaPlacas(Graphics g) {
        g.drawImage(placa, 5, placapy, Graphics.TOP | Graphics.LEFT);
        g.drawImage(placa, 150, placapy, Graphics.TOP | Graphics.LEFT);
    }
    
    private void desenhaVeiculos(Graphics g){
        int x;
        carroJogador.meDesenha(g);

        for(x=0; x<numVeiculos; x++){
            if(veiculoInimigo[x].getPy() +veiculoInimigo[x].getAltura() > 0)
                veiculoInimigo[x].meDesenha(g);
        }
    }
    
    private void desenhaInterface(Graphics g){
        g.setColor(0,0,0);
        g.fillRect(0,164,getHeight(),getWidth());
        g.setColor(255,255,255);
        g.drawString("Vel: " + carroJogador.getVelocidade() + " Pos: "+ getPosicao()+" Ener: "+carroJogador.getEnergia(), 50,165, Graphics.TOP | Graphics.LEFT);
        semaforo(g);
    }
    
    private void semaforo(Graphics g){
        int bola1 = 0x960000; /* RGB 150,0,0 */
        int bola2 = 0x960000;
        int bola3 = 0x009600; /* RGB 0,150,0 */
        if(semaforo > 0)
        bola1 = 0xFF0000;
        if(semaforo > 1)
        bola2 = 0xFF0000;
        if(semaforo > 2)
        bola3 = 0x00FF00;

        g.setColor(bola1);
        g.fillArc(2,167,8,8,0,360);
        g.setColor(bola2);
        g.fillArc(12,167,8,8,0,360);
        g.setColor(bola3);
        g.fillArc(22,167,8,8,0,360);
    }
    
    private int getPosicao(){
        int carros = mapa[0];
        int p=0;
        
        for(int x=0; x<numVeiculos; x++){
            if(carroJogador.getPy() < veiculoInimigo[x].getPy())
                p++;
        }
        
        return numVeiculos-p+1;
    }

    private void andaVeiculos(){

        /* pega os atributos do carro do jogador */
        int x;
        int j_px, j_c, i_px, i_c, i_py, i_a;
        j_px = carroJogador.getPx();
        j_c = carroJogador.getComprimento();

        for(x=0; x<numVeiculos; x++)
        {

            /* pega os atributos do carro do inimigo */
            i_px = veiculoInimigo[x].getPx();
            i_c = veiculoInimigo[x].getComprimento();
            i_py = veiculoInimigo[x].getPy();
            i_a = veiculoInimigo[x].getAltura();
            veiculoInimigo[x].incVelocidade(1);
            veiculoInimigo[x].setPy(veiculoInimigo[x].getPy() + ((carroJogador.getVelocidade() - veiculoInimigo[x].getVelocidade())/5));
            
            if(colisaoVeiculos()){
                veiculoInimigo[x].setPy(i_py);
                carroJogador.setVelocidade(60);
                carroJogador.incEnergia(-1);
            }

            if(veiculoInimigo[x].getPy() > carroJogador.getPy()) {
                if((i_px <= j_px && i_px+i_c > j_px) || (i_px >= j_px && i_px+i_c <= j_px+j_c)) {
                    if(j_px-j_c > MARGEM_ESQUERDA)
                        veiculoInimigo[x].setPx(veiculoInimigo[x].getPx() - 3);
                    else
                        veiculoInimigo[x].setPx(veiculoInimigo[x].getPx() + 3);
                }
                else if(i_px+i_c >= j_px+j_c && i_px < j_px+j_c) {
                    if(j_px+j_c+j_c < MARGEM_DIREITA)
                        veiculoInimigo[x].setPx(veiculoInimigo[x].getPx() + 3);
                    else
                        veiculoInimigo[x].setPx(veiculoInimigo[x].getPx() - 3);
                }
            }

            if(veiculoInimigo[x].getTipo() == 3) {
                if(i_py+i_a > 0 && i_py < 60) {
                    if(i_px < j_px) {
                        if(i_px+3 > j_px)
                            veiculoInimigo[x].setPx(j_px);
                        else
                            veiculoInimigo[x].setPx(i_px + 3);
                    }
                    else if(i_px > j_px) {
                        if(i_px -3 < j_px)
                            veiculoInimigo[x].setPx(j_px);
                        else
                            veiculoInimigo[x].setPx(i_px - 3);
                    }
                }
            }
        }
    }
    
    private void processaTeclas() {
        int keyStates = getKeyStates();

        if((keyStates & UP_PRESSED)!=0)
            carroJogador.incVelocidade(1);
        else {
            if(carroJogador.getVelocidade() >= 1) {
                if(loopCounter % 3 == 0)
                    carroJogador.incVelocidade(-1);
            }
        }

        if((keyStates & DOWN_PRESSED)!=0) {
            if(carroJogador.getVelocidade() >=5)
                carroJogador.incVelocidade(-1);
        }

        if((keyStates & LEFT_PRESSED)!=0) {
            int px_ant = carroJogador.getPx();
            if(px_ant - 3 >= MARGEM_ESQUERDA) {
                carroJogador.setPx(carroJogador.getPx()-3);

                if(colisaoVeiculos()) {
                    carroJogador.setPx(px_ant+10);
                    carroJogador.setVelocidade(60);
                    carroJogador.incEnergia(-1);
                }
            }
        }

        if((keyStates & RIGHT_PRESSED)!=0) {
            int px_ant = carroJogador.getPx();
            if(px_ant + 3 <= MARGEM_DIREITA) {
                carroJogador.setPx(px_ant+3);
                if(colisaoVeiculos()) {
                    carroJogador.setPx(px_ant-10);
                    carroJogador.setVelocidade(60);
                    carroJogador.incEnergia(-1);
                }
            }
        }
        
        if((keyStates & FIRE_PRESSED) != 0) {
            if(pausado) {
                pausado = false;
                iniciaJogo();
            }
        }
    }

    /* Método para verificar se ocorreu colisão, retorna true caso sim, false caso nao. */ 
    private boolean colisaoVeiculos() {
        int j_px = carroJogador.getPx(),
        j_py = carroJogador.getPy(),
        j_c = carroJogador.getComprimento(),
        j_a = carroJogador.getAltura();

        int i_px,
        i_py,
        i_c,
        i_a;

        for(int x=0;x<numVeiculos;x++) {
            i_px = veiculoInimigo[x].getPx();
            i_py = veiculoInimigo[x].getPy();
            i_c = veiculoInimigo[x].getComprimento();
            i_a = veiculoInimigo[x].getAltura();
            if(!(i_py > -100 && i_py < 280))
                continue;

            if((j_px <= i_px && j_px+j_c > i_px) || (j_px < i_px+i_c && j_px+j_c >= i_px+i_c) || (j_px >= i_px && j_px+j_c <= i_px+i_c) || (i_px >= j_px && i_px+i_c <= j_px+j_c)) {
                if((j_py < i_py+i_a && j_py > i_py) || (j_py+j_a > i_py && j_py+j_a < i_py+i_a) || (j_py >= i_py && j_py+j_a <= i_py+i_a) || (i_py >= j_py && i_py+i_a <= j_py+j_a))
                    return true;
            }
        }
        
        return false;
    }
    
    /* Faz a mudança do estado semáforo caso ele não esteja verde */
    private void processaSemaforo(){
        if(loopCounter == sleepTime && semaforo != 3)
            semaforo++;
    }



    /* O paint chamará os métodos para desenhar cada Objeto. */
    public void paint(Graphics g){
        if(!pausado)
        {
            g.drawImage(back,0,0,Graphics.TOP | Graphics.LEFT);
            desenhaLinhas(g);
            desenhaPlacas(g);
            desenhaVeiculos(g);
            desenhaInterface(g);
        }
        
        if(getPosicao() == 1) {
            pausado = true;
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
            g.setColor(255,0,0);
            g.drawString("VOCÊ VENCEU!", 40,70, Graphics.TOP | Graphics.LEFT);
            g.drawString("PRESSIONE FIRE (5)", 20,90, Graphics.TOP | Graphics.LEFT);
        }
        
        else if(carroJogador.getEnergia() == 0) {
            pausado = true;
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
            g.setColor(255,0,0);
            g.drawString("GAME OVER", 40,70, Graphics.TOP | Graphics.LEFT);
            g.drawString("PRESSIONE FIRE (5)", 20,90, Graphics.TOP | Graphics.LEFT);
        }
    }
    
    public void run()
    {

        while(true)
        {
            try { 
                Thread.sleep(sleepTime);
                if(semaforo == 3) {
                    processaTeclas();
                    if(!pausado) {
                        andaLinhas();
                        andaPlacas();
                        andaVeiculos();
                    }
                }           
                else
                    processaSemaforo();
                
                repaint();
                if(loopCounter<sleepTime)
                    loopCounter++;
                else
                    loopCounter=0;
            } 
            catch (InterruptedException ex) {}   
        }
    }
}