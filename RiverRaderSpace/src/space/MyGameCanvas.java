package space;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.lcdui.game.TiledLayer;

/**
 * @author adelannucci
 */
public class MyGameCanvas extends GameCanvas implements Runnable  {
    private GameDesign gd;
    private Game midlet;
    Thread t;
    
    //Dados de controle
    private final int MAX_X; // Largura da tela
    private final int MAX_Y; // Altura da tela
    private final int PIXEL = 16;
    private int speed = 4;
    private final int SPEED_LEFTL_RIGHT = 4;
    private final int SPEED_BULLET = 16;
    private final int FUEL_RESTORE = 5;
    private final int ALCANCE_BULLET;
    private boolean completo = false;
    
    
    // Atributo para indicar estado do jogo
    private boolean rodando = false;
    private final int DELAY = 30; 
    
    // Atributos do teclado
    private GestureRecognizer recognizer;
    private int gesture; //clase para touch 
    private boolean show;
    
    //Elementos do Cenario
    private PlayerShip sp;
    private Sprite ponte;
    private Sprite fuel;
    private MapControlCenter mpc;
    private TiledLayer map;
    private LayerManager manager;
    private Enemy enemy;
    private Fire fire;

    
    //som
    //private PlayerMusic pm;
    private PlayerSound ps;
    
    private Render render;
    
    public MyGameCanvas(Game mid) 
    {
        super(true);
        this.midlet = mid;
        setFullScreenMode(true);
        MAX_X = getWidth(); // Largura da tela
        MAX_Y = getHeight();
        ALCANCE_BULLET = MAX_Y;
        gd = new GameDesign();
        render = new Render();
        enemy  = new Enemy();
        fire = new Fire();
        
        try {
            //inicia elementos do jogo
            sp = new PlayerShip(gd.getShip());
            sp.setFrame(4);
            ponte = gd.getPonte();
            ponte.setFrame(1);
            fuel = gd.getFuel();
            fuel.setFrame(0);
            mpc = new MapControlCenter((byte)8);
            configuracoes();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
        
        //this.sizeChanged(MAX_X, MAX_Y);
    }

    
    /**************************************************************************
            Funcoes para realizar o controle dos elementos do cenario
     **************************************************************************/
    
    private void configuracoes() throws IOException{
         
        //seleciona o mapa
         switch(mpc.nextMap()){
             case 1:
                 if(speed<9)
                     speed++;
                 map = gd.getMap1();
                 break;
             case 2:
                 map = gd.getMap2();
                 break;
             case 3:
                 map = gd.getMap3();
                 break;
             case 4:
                 map = gd.getMap4();
                 break;
             case 5:
                 map = gd.getMap5();
                 break;
             case 6:
                 map = gd.getMap6();
                 break;
             case 7: 
                 map = gd.getMap7();
                 break;
             case 8:
                 map = gd.getMap8();
                 break;
             default:
                 break;
         }
         managerInsert();
         enemy.inicia();
         sp.setPosition(7*PIXEL, 54*PIXEL);
         sp.checkPoint();
         ponte.setPosition(6*PIXEL, 1*PIXEL);
         fuel.setPosition(mpc.getFuelX()*PIXEL, mpc.getFuelY()*PIXEL);
         completo = false;
    }
    
    //controla a velocidade do jogo
    private void speedGame(){
        if(!sp.colisionMap(map, true) && (!sp.colisionSprite(ponte, true))){
            //sp.y-=SPEED;
            sp.move(0, -speed);
            sp.fuellControl();
        }     
        
    }
    
    //verifica colisao com o fuel e recarrega.
    private void fuelPoint(){
        if (sp.collidesWith(fuel, true) && sp.fuel<=595){    
            sp.fuel += FUEL_RESTORE;      
            sp.score++;
        }
    }
    
    // verifica se o mapa foi completado
    private void endCurrentMap(){
        if(sp.getY() <= 0)
            completo = true;
    }
    
    //Insere os elementos do cenario no LayerManager
    private void managerInsert(){
        // Cria o layer manager
        manager = new LayerManager();
        manager.append(sp);
        //printEnemy();
        enemy.printEnemy();
        manager.append(ponte);
        manager.append(fuel);
        manager.append(map);
        // Coloca a visão do gerente
        manager.setViewWindow(0,0,MAX_X,MAX_Y);
        
    }

    /**************************************************************************
                                Controle do Jogo
     **************************************************************************/
    
    public void inicia() {
        // Indica que deve rodar
        rodando=true;
        // Cria a thread baseado neste objeto
        t = new Thread(this);
        // Inicia a thread
        t.start();
    }

    public void pausa()
    {
        // Indica que a thread deve encerrar
        
        int teclas;
        while(true){
            teclas = getKeyStates();
            if((teclas & FIRE_PRESSED)!=0){
                //pm.tradeMusic();
                ps.deallocate();
                midlet.end();
                rodando=false;
            }   
        }
        
    }
    
    protected void touch() { 
        if (show) {
            boolean drawTap = false;
            boolean drawArea = false;

            switch (gesture) {
            case GestureRecognizer.TAP:
                fire.shot();
                show = false;
                break;
            case GestureRecognizer.TAP_N_HOLD:
                break;
            case GestureRecognizer.DRAG_UP:
                sp.setFrame(7);
                sp.move(0, -5);
                break;
            case GestureRecognizer.DRAG_DOWN:
                sp.setFrame(1);
                sp.move(0, 1);
                break;
            case GestureRecognizer.DRAG_LEFT:
                sp.setFrame(3);
                sp.move(-SPEED_LEFTL_RIGHT, 0);
                break;
            case GestureRecognizer.DRAG_RIGHT:
                sp.setFrame(5);
                sp.move(SPEED_LEFTL_RIGHT, 0);
                break;
            case GestureRecognizer.CIRCLE_CLOCK:
                drawArea = true;
                break;
            case GestureRecognizer.CIRCLE_ANTI:
                drawArea = true;
                break;
            default:
                break;
            }
 
            if (drawTap) {
                //g.drawRect(recognizer.getTapX() - 4, recognizer.getTapY() - 4, 8, 8);
            }
            if (drawArea) {
                //g.drawRect(recognizer.getAreaX(), recognizer.getAreaY(), recognizer.getAreaWidth(), recognizer.getAreaHeight());
            }
        }
        
    }
 
    protected void pointerPressed(int x, int y) {
        recognizer = new GestureRecognizer(x, y);
        show = false;
    }
 
    protected void pointerDragged(int x, int y) {
        recognizer.addMotion(x, y);
    }
 
    protected void pointerReleased(int x, int y) {
        recognizer.endGesture(x, y);
        gesture = recognizer.getGesture();
        show = true;
    }
    
    
    public void leTeclas()
    {
            int teclas = getKeyStates();
            // Testa as teclas
            if((teclas & LEFT_PRESSED)!=0){
                sp.setFrame(3);
                sp.move(-SPEED_LEFTL_RIGHT, 0);
            }
            
            if((teclas & RIGHT_PRESSED)!=0){
                sp.setFrame(5);
                sp.move(SPEED_LEFTL_RIGHT, 0);
            }
            
            if((teclas & UP_PRESSED)!=0 && (teclas & LEFT_PRESSED)!=0){
                sp.setFrame(6);
                sp.move(0, -5);
            }
            else if((teclas & UP_PRESSED)!=0 && (teclas & RIGHT_PRESSED)!=0){
                sp.setFrame(8);
                sp.move(0, -5);
            }
            else if((teclas & UP_PRESSED)!=0){
                sp.setFrame(7);
                sp.move(0, -5);
            }
            
            if((teclas & DOWN_PRESSED)!=0 && (teclas & LEFT_PRESSED)!=0){
                sp.setFrame(0);
                sp.move(0, 1);
            }
            else if((teclas & DOWN_PRESSED)!=0 && (teclas & RIGHT_PRESSED)!=0){
                sp.setFrame(2);
                sp.move(0, 1);
            }
            else if((teclas & DOWN_PRESSED)!=0){
                sp.setFrame(1);
                sp.move(0, 1);
            }

            if((teclas & FIRE_PRESSED)!=0){
                fire.shot();
            }
    }
    
    //Movimenta a nave e atira    
    private void move(){
        sp.setFrame(4);
        leTeclas();
        touch(); 
        speedGame();
    }
                
    // Este método é chamado a pelo objeto Thread do Java.
    public void run()
    {		
           // pm = new PlayerMusic(2);
            //pm.musicStart();
            ps = new PlayerSound();
            fire.inicia();
            while(rodando){
                try{
                    if(completo){ 
                        configuracoes();
                        System.gc();
                    }
                    
                    
                    if(!sp.kill){
                        move();
                    }else{
                        if(sp.explodir < 12){
                            sp.explodir();
                        }else{
                            sp.kill = false;
                            sp.explodir = 9;
                            sp.kill();
                        }
                    }
                    fuelPoint();
                    render.render();
                    endCurrentMap();
                    Thread.sleep(DELAY);
                    //System.gc();
                    
                    
                    if(sp.life == 0){
                        rodando = false;
                        render.gameOver();
                        fire.stop();
                        enemy.stop();
                        flushGraphics();
                        this.pausa();
                    }
                }   
                catch (IOException ex) {}
                catch(InterruptedException e){}
            }
            System.gc();       
    }
    
    /**************************************************************************
                    Thread para controle dos inimigos
    **************************************************************************/
    
    private class Enemy implements Runnable{
        
        
        public boolean end = false;
        public Thread t;
        
        //inimigos
        private Sprite enemy1;
        private Sprite enemy2;
        private Sprite enemy3;
        private int moveEnemy = 0;
        private EnemyControlCenter spc;
        
        public Enemy(){
            spc = new EnemyControlCenter();
        }
 
         private void printEnemy(){
            //define qual sera a posicao dos inimigos no mapa adequado.
            spc.pointEnemy(mpc.currentMap);

            //seta os inimigos no lugar certo.
            try {
                enemy1 = gd.getEnemy_1();
                enemy1.setPosition(spc.getenemy1X()*PIXEL, spc.getenemy1Y()*PIXEL);
                manager.append(enemy1);

                enemy2 = gd.getEnemy_2();
                enemy2.setPosition(spc.getenemy2X()*PIXEL, spc.getenemy2Y()*PIXEL);
                manager.append(enemy2);


                enemy3 = gd.getEnemy_3();
                enemy3.setPosition(spc.getenemy3X()*PIXEL, spc.getenemy3Y()*PIXEL);
                manager.append(enemy3);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        //seta a direcao e a velocidade dos movimentos das naves inimigas
        private void enememyMove(int direcao,int frame){
            enemy1.move(direcao*4, 0);
            enemy1.setFrame(frame);

            enemy2.move(direcao*7, 0);
            enemy2.setFrame(frame);

            enemy3.move(direcao*10, 0);
            enemy3.setFrame(frame);
        }
        
        //verifica se ouve colisao com o playership e movimenta as naves inimigas
        private void updateEnemy(){

            if (enemy1.collidesWith(sp, true) || enemy2.collidesWith(sp, true) || enemy3.collidesWith(sp, true)){
                sp.kill = true;
            }

            if(moveEnemy == 15){
                enememyMove(1,1);
                moveEnemy = 0;
            }
            else if(moveEnemy > 8 && moveEnemy < 15){
                enememyMove(1,2);
                moveEnemy++;
            }
            else if(moveEnemy == 8){
                enememyMove(1,1);
                moveEnemy++;
            }
            else if(moveEnemy == 0 || moveEnemy == 7){
                enememyMove(-1,4);
                moveEnemy++;
            }
            else if(moveEnemy > 0 && moveEnemy < 7){
                enememyMove(-1,5);
                moveEnemy++;
            }  
        } 
        
        //inicia o jogo
        public void inicia() {
            // Indica que deve rodar
            if(!end){
                end=true;
                // Cria a thread baseado neste objeto
                t = new Thread(this);
                // Inicia a thread
                t.start();
            }
        }
        
        public void stop(){
            end = false;
            t.interrupt();
        }
        
        public void run(){
            while(end){
                try {
                    updateEnemy();
                    Thread.sleep(DELAY);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.gc();
        }
        
    }
    
    
    /**************************************************************************
                           Thread para controle dos tiros
     *************************************************************************/
    
    private class Fire implements Runnable{
        
        public boolean end = false;
        public Thread t;
        
        private Sprite bullet;
        private Vector bullets;
        private boolean shot = true;
        
        public Fire(){
            bullets = new Vector();
        }
        
        // dispara o tiro cria um sprite bullet novo
        public Sprite fire() throws IOException {       
            bullet = gd.getBullet();
            bullet.setFrame(0);
            bullet.setPosition(sp.getX()+12, sp.getY()-1);
            return bullet;
        }
        
        //cria o novo sprite
        public void shot(){
            try {
                if(shot){
                    bullet = fire.fire();
                    ps.shot();
                    if (bullet != null) {
                        bullets.addElement(bullet);
                        manager.insert(bullet,1);
                    }
                    shot = false;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        //remove o tiro do manager
        private int removeBullet(int i){
            bullets.removeElementAt(i);
            manager.remove(bullet);
            i--;
            shot = true;
            ps.explosion();
            return i;
        }

        public void fireUpdate(){
            // Update Bullet(s) Movement
            for (int i = 0; i < bullets.size(); ++i) {
                for (int j = 0; j < 2; ++j) {
                    Sprite bullet = (Sprite)(bullets.elementAt(i));
                    bullet.move(0, -SPEED_BULLET);

                    //remove o tiro e libera para atirar novamente se
                    //a posisao da nave menos a do tiro for maior que 
                    //o tamanho da tela menos o tamanho do painel
                    if((sp.getY() - bullet.getY())>ALCANCE_BULLET){
                        i = removeBullet(i);
                        break;
                    }
                    else if (bullet.collidesWith(map, false)) {
                        i = removeBullet(i);
                        sp.score -= 5;
                        break;
                    }
                    else if(bullet.collidesWith(ponte, true)){
                        ponte.move(0, -1600);
                        i = removeBullet(i);
                        sp.score += 10;
                        
                        break;
                    }
                    
                     else if(bullet.collidesWith(fuel, true)){
                        fuel.move(0, -1600);
                        i = removeBullet(i);
                        sp.score += 50;
                        break;
                    }
                     
                    else if(bullet.collidesWith(enemy.enemy1, true)){
                        //manager.remove(enemy.enemy1);
                        enemy.enemy1.setPosition(3200,3200);
                        i = removeBullet(i);
                        sp.score += 20;
                        break;
                    }
                    else if(bullet.collidesWith(enemy.enemy2, true)){
                        //manager.remove(enemy2);
                        enemy.enemy2.setPosition(3200,3200);
                        i = removeBullet(i);
                        sp.score += 20;
                        break;
                    }
                     else if(bullet.collidesWith(enemy.enemy3, true)){
                        //manager.remove(enemy2);
                        enemy.enemy3.setPosition(3200,3200);
                        i = removeBullet(i);
                        sp.score += 30;
                        break;
                    }
                }
            }
        }

        public void inicia() {
            // Indica que deve rodar
            if(!end){
                end=true;
                // Cria a thread baseado neste objeto
                t = new Thread(this);
                // Inicia a thread
                t.start();
            }
        }
        
        public void stop(){
            end = false;
            t.interrupt();
        }
        
        public void run(){
            while(end){
                try {
                    fireUpdate();
                    Thread.sleep(DELAY);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.gc();
        }
        
    }
    
    private class Render{
        
        private Graphics gbg;
        private Graphics gp;
        private Graphics g;
        private Image life;
        private Image energyFuel;
        private Image bgImg;
        
        private int lifePosition;
        private int energyPosition;
        private int managerX;
        private int managerY;
        
        
        public Render(){
            try {
                bgImg = Image.createImage("/img/bgGame.png");
                life = Image.createImage("/img/life.png");
                energyFuel = Image.createImage("/img/energy.png");
                lifePosition = (MAX_X/2) - 36;
                energyPosition = (MAX_X/2) + 36;
                managerX = MAX_X/2;
                managerY = (3*MAX_Y)/4;
                g = getGraphics();
                g.setColor(255,255,255);
                g.fillRect(0,0,MAX_X, MAX_Y);
                
                g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL));
                //fonteForPainel();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        //desenha o fundo do cenario
        private  void backGround(){
            g.drawImage(bgImg, 0, 0, Graphics.TOP | Graphics.LEFT);
        }

        //Campo de visao do mapa
        private void gameScrean(){
            g = getGraphics();
            manager.setViewWindow((sp.getX()-managerX), (sp.getY() - managerY) , MAX_X, MAX_Y);
            manager.paint(g,0,0);
        }
    
        //desenha o Painel de informacoes 
        private void painel(){
            //g.setColor(0,0,0);
            //g.fillRect(0,0,MAX_X, 20);
            //g.setColor(0,0,0);
            //String pos= "";
            //pos = "map: "+mpc.currentMap+ " - life: "+sp.life +
            //pos = " - fuel: " + sp.fuel;     
            //g.drawString(pos, MAX_X/2, 15, Graphics.RIGHT|Graphics.BASELINE);
            switch (sp.life){
                case 1:
                    g.drawRegion(life, 0, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 2:
                    g.drawRegion(life, 18, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 3:
                    g.drawRegion(life, 36, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 4:
                    g.drawRegion(life, 54, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 5:
                    g.drawRegion(life, 72, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 6:
                    g.drawRegion(life, 90, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 7:
                    g.drawRegion(life, 108, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 8:
                    g.drawRegion(life, 126, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 9:
                    g.drawRegion(life, 144, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                case 10:
                    g.drawRegion(life, 162, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
                default:
                    g.drawRegion(life, 180, 0, 18, 18, Sprite.TRANS_NONE, lifePosition, 1,  Graphics.TOP | Graphics.LEFT);
                    break;
            }
            //atualiza a barra de fuel
            if(sp.fuel>599){
                g.drawRegion(energyFuel, 0, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            else if(sp.fuel>499){
                g.drawRegion(energyFuel, 18, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            else if(sp.fuel>399){
                g.drawRegion(energyFuel, 36, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            else if(sp.fuel>299){
                g.drawRegion(energyFuel, 54, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            else if(sp.fuel>199){
                g.drawRegion(energyFuel, 72, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            else if(sp.fuel>99){
                g.drawRegion(energyFuel, 90, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            else {
                g.drawRegion(energyFuel, 108, 0, 18, 18, Sprite.TRANS_NONE, energyPosition, 1,  Graphics.TOP | Graphics.LEFT);
            }
            
            
        }
    
        //Game Over na tela
        private void gameOver(){
            String pos= "";
            g.setColor(0,0,0);
            g.fillRect(0,0,MAX_X, MAX_Y);
            g.setColor(255,255,0);
            g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_LARGE));
            pos = "Game Over \n\nSCORE: "+sp.score;
            g.drawString(pos, MAX_X/2, MAX_Y/2, Graphics.HCENTER|Graphics.BASELINE);
        }
    
        //printa na tela os elementos
        private void render(){
            backGround();
            gameScrean();
            painel();
            flushGraphics();
        }
    }
                
}

