package br.cotuca.unicamp.grafo;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Principal extends JFrame {
	
	private Cidade a = new Cidade("A",  10, 200, 0); 
	private Cidade b = new Cidade("B", 100,  50, 1);
	private Cidade c = new Cidade("C", 150, 220, 2);
	private Cidade d = new Cidade("D", 100, 180, 3);
	private Cidade e = new Cidade("E", 240,  80, 4);  
	private Cidade f = new Cidade("F",  90, 120, 5);
	private Cidade g = new Cidade("G", 140,  20, 6);
	
	private Cidade c1 = new Cidade("Seatle", 120, 12,0);
	private Cidade c2 = new Cidade("Portland", 109, 56,1);
	private Cidade c3 = new Cidade("San Francisco", 56, 227,2);
	private Cidade c4 = new Cidade("Boise", 202, 113,3);
	private Cidade c5 = new Cidade("Yellowstone", 309, 117,4);
	private Cidade c6 = new Cidade("Lake Tahoe", 112, 213,5);
	private Cidade c7 = new Cidade("Los Angeles", 113, 355,6);
	private Cidade c8 = new Cidade("San Diego", 132, 386,7);
	private Cidade c9 = new Cidade("Las Vegas", 180, 313,8);
	private Cidade c10 = new Cidade("Palm Springs", 156, 361,9);
	private Cidade c11 = new Cidade("Grand Canyon", 247, 329,10);
	private Cidade c12 = new Cidade("Phoenix", 246, 408,11);
	private Cidade c13 = new Cidade("Salt Lake City", 268, 220,12);
	private Cidade c14 = new Cidade("Vail", 370, 268,13);
	private Cidade c15 = new Cidade("Aspen", 396, 297,14);
	private Cidade c16 = new Cidade("Denver", 407, 259,15);
	private Cidade c17 = new Cidade("Colorado Springs", 434, 292,16);
	private Cidade c18 = new Cidade("Minneapolis", 602, 112,17);
	private Cidade c19 = new Cidade ("Omaha", 542, 226,18);
	private Cidade c20 = new Cidade("Kansas City", 578, 292,19);
	private Cidade c21 = new Cidade("San Antonio", 505, 525,20);
	private Cidade c22 = new Cidade("Houston", 569, 524,21);
	private Cidade c23 = new Cidade("Dallas", 536, 436,22);
	private Cidade c24 = new Cidade("Nova Orleans", 668, 508,23);
	private Cidade c25 = new Cidade("Little Rock", 628, 394,24);
	private Cidade c26 = new Cidade("Saint Louis", 659, 298,25);
	private Cidade c27 = new Cidade("Chicago", 706, 206,26);
	private Cidade c28 = new Cidade("Memphis", 679, 372,27);
	private Cidade c29 = new Cidade("Atlanta", 778, 402,28);
	private Cidade c30 = new Cidade("Nashville", 769, 338,29);
	private Cidade c31 = new Cidade("Indianapolis", 742, 255,30);
	private Cidade c32 = new Cidade("Detroit", 781, 186,31);
	private Cidade c33 = new Cidade("Milwaukee", 697, 157,32);
	private Cidade c34 = new Cidade("Orlando", 872, 544,33);
	private Cidade c35 = new Cidade("Miami", 900, 573,34);
	private Cidade c36 = new Cidade("Fort Lauderdale", 898, 555,35);
	private Cidade c37 = new Cidade("Richmond", 905, 285,36);
	private Cidade c38 = new Cidade("Washington", 908, 239,37);
	private Cidade c39 = new Cidade("Nova York", 958, 183,38);
	private Cidade c40 = new Cidade("Boston", 987, 139,39);
	private Cidade c41 = new Cidade("Albany", 946, 135,40);
	
	private Vias vias[][];
	
	private JList listaDestino;
	private JList listaCidades;
	private JButton btnAdd;
	private JButton btnCalc;
	private JButton btnRemove;
	
	//private String[] cidadesNomes = { "a", "b", "c", "d","e", "f", "g" };
	private Cidade[] cidadesValues = { c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18 };
	private Container contentpane;
	//private ArrayList<Cidade> listaPontos = new ArrayList<Cidade>();
	
	//private ArrayList<String> listaCidadesNomes = new ArrayList<String>();
	//private ArrayList<Cidade> listaCidades = new ArrayList<Cidade>();
	
	DefaultListModel lmCidades  = new DefaultListModel();
	DefaultListModel lmDestinos = new DefaultListModel();
	
	public Principal() 
	{
		super("List Source Demo");
		contentpane = getContentPane();
		contentpane.setLayout(new GridLayout(4,2, 5, 5));
		
		for(Cidade cidade : cidadesValues)
			lmCidades.addElement(cidade);
		
		listaCidades = new JList(lmCidades);
		listaCidades.setSelectedIndex(0);
		listaCidades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listaDestino = new JList(lmDestinos);
		listaDestino.setSelectedIndex(0);
		listaDestino.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		btnAdd    = new JButton("Adicionar", null);
		btnRemove = new JButton("Remover", null);
		btnCalc = new JButton("Gerar Mapa", null);
		
		contentpane.add(new JLabel("Destino desejado:"));
		contentpane.add(new JLabel("Lista de Cidades:"));
		contentpane.add(listaDestino);
		contentpane.add(listaCidades);
		contentpane.add(listaDestino);
		
		contentpane.add(btnRemove);
		contentpane.add(btnAdd);
		contentpane.add(btnCalc);
		
		ButtonListener ouvinte = new ButtonListener();
		
		btnCalc.addActionListener(ouvinte);
		
		btnRemove.addActionListener(ouvinte);
		
		btnAdd.addActionListener(ouvinte);
		
		setSize(200, 400);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == btnRemove) {
				int index = listaDestino.getSelectedIndex();
				if (index != -1) {
					
					Cidade c = (Cidade)(lmDestinos.getElementAt(index));
					lmDestinos.remove(index);
					lmCidades.addElement(c);
					listaDestino.updateUI();
					listaCidades.updateUI();
				}
	
			}

			if (obj == btnAdd) {
	
				int index = listaCidades.getSelectedIndex();
				if (index != -1) {
					Cidade c = (Cidade)(lmCidades.getElementAt(index));
					lmCidades.remove(index);
					lmDestinos.addElement(c);
					listaDestino.updateUI();
					listaCidades.updateUI();
				}
	
			}
			
			if (obj == btnCalc)
				configuracao();
		}
	}
	
	
	private void cidadesMapeadas()
	{

		c1.proximaCidade(c2); 
		c1.proximaCidade(c4);
		
		c2.proximaCidade(c1);
		c2.proximaCidade(c3);
		c2.proximaCidade(c6);//Portland"
		
		c3.proximaCidade(c2);
		c3.proximaCidade(c6);//San Francisco
		
		c4.proximaCidade(c6);
		c4.proximaCidade(c5);//Boise
		
		
		c5.proximaCidade(c4);
		c5.proximaCidade(c16);
		c5.proximaCidade(c18);//Yellowstone
		
		c6.proximaCidade(c2);
		c6.proximaCidade(c3);
		c6.proximaCidade(c4);
		c6.proximaCidade(c13);//Lake Tahoe
		
		c7.proximaCidade(c3);
		c7.proximaCidade(c9);
		c7.proximaCidade(c10);
		c7.proximaCidade(c8);//Los Angeles
		
		c8.proximaCidade(c7);
		c8.proximaCidade(c10);
		c8.proximaCidade(c12);//San Diego
		
		c9.proximaCidade(c7);
		c9.proximaCidade(c10);
		c9.proximaCidade(c11);//las vegas
		
		c10.proximaCidade(c7);
		c10.proximaCidade(c9);
		c10.proximaCidade(c11);//Palm Springs
		
		c11.proximaCidade(c9);
		c11.proximaCidade(c10);
		c11.proximaCidade(c12);//Grand Canyon
		
		c12.proximaCidade(c8);
		c12.proximaCidade(c11);
		c12.proximaCidade(c13);//Phoenix
		
		c13.proximaCidade(c6);
		c13.proximaCidade(c9);
		c13.proximaCidade(c12);
		c13.proximaCidade(c16);//Salt Lake City
		
		c14.proximaCidade(c15);
		c14.proximaCidade(c16);//Vail
		
		c15.proximaCidade(c14);
		c15.proximaCidade(c16);
		c15.proximaCidade(c17);//Aspen

		c16.proximaCidade(c5);
		c16.proximaCidade(c13);
		c16.proximaCidade(c15);
		c16.proximaCidade(c17);//Denver
		
		c17.proximaCidade(c15);
		c17.proximaCidade(c16);//Colorado Springs
		
		c18.proximaCidade(c5);//Minneapolis
		
//		c18 ("Minneapolis", 602, 112,17);
//		c19  ("Omaha", 542, 226,18);
//		c20 ("Kansas City", 578, 292,19);
//		c21 ("San Antonio", 505, 525,20);
//		c22 ("Houston", 569, 524,21);
//		c23 ("Dallas", 536, 436,22);
//		c24 ("Nova Orleans", 668, 508,23);
//		c25 ("Little Rock", 628, 394,24);
//		c26 ("Saint Louis", 659, 298,25);
//		c27 ("Chicago", 706, 206,26);
//		c28 ("Memphis", 679, 372,27);
//		c29 ("Atlanta", 778, 402,28);
//		c30 ("Nashville", 769, 338,29);
//		c31 ("Indianapolis", 742, 255,30);
//		c32 ("Detroit", 781, 186,31);
//		c33 ("Milwaukee", 697, 157,32);
//		c34 ("Orlando", 872, 544,33);
//		c35 ("Miami", 900, 573,34);
//		c36 ("Fort Lauderdale", 898, 555,35);
//		c37 ("Richmond", 905, 285,36);
//		c38 ("Washington", 908, 239,37);
//		c39 ("Nova York", 958, 183,38);
//		c40 ("Boston", 987, 139,39);
//		c41 ("Albany", 946, 135,40);
		
		
//		a.proximaCidade(b);	  
//		a.proximaCidade(c); 
//		a.proximaCidade(d);
//
//		//b.proximaCidade(c);
//		b.proximaCidade(e);
//		  
//		  
//		//c.proximaCidade(b);	  
//		c.proximaCidade(d);
//		c.proximaCidade(e);
//		 
//		  
//		d.proximaCidade(a);
//		d.proximaCidade(e);
//		d.proximaCidade(f);
//		  
//		e.proximaCidade(g);
//		e.proximaCidade(f);
//		  
//		f.proximaCidade(b);
//		//f.proximaCidade(g);
//		f.proximaCidade(d);
//		
//		g.proximaCidade(e);
		
	}
	
	private void malhaViaria()
	{
		vias = new Vias[18][18];
		  
		for(int i = 0; i<18; i++)
		{
			for(int j = 0; j< 18; j++)
			{
				vias[i][j] = new Vias();
			}
		}
		
		
		vias[0][1] = new Vias(c1,c2);
		vias[0][3] = new Vias(c1,c3);
		
		vias[1][0] = new Vias(c2,c1);
		vias[1][2] = new Vias(c2,c3);
		vias[1][5] = new Vias(c2,c5);


		vias[2][1] = new Vias(c3,c2);
		vias[2][5] = new Vias(c3,c6);
		
		vias[3][4] = new Vias(c4,c5);
		vias[3][5] = new Vias(c4,c6);
		
		vias[4][3] = new Vias(c5,c4);
		vias[4][15] = new Vias(c5,c16);
		vias[4][17] = new Vias(c5,c18);
		
		vias[5][1] = new Vias(c6,c2);
		vias[5][2] = new Vias(c6,c3);
		vias[5][3] = new Vias(c6,c4);
		vias[5][12] = new Vias(c6,c13);
		
		vias[6][2] = new Vias(c7,c3);
		vias[6][8] = new Vias(c7,c9);
		vias[6][9] = new Vias(c7,c10);
		vias[6][7] = new Vias(c7,c8);
		
		vias[7][6] = new Vias(c8,c7);
		vias[7][9] = new Vias(c8,c10);
		vias[7][11] = new Vias(c8,c12);

		vias[8][6] = new Vias(c9,c7);
		vias[8][9] = new Vias(c9,c10);
		vias[8][10] = new Vias(c9,c11);
		
		vias[9][6] = new Vias(c10,c7);
		vias[9][8] = new Vias(c10,c9);
		vias[9][10] = new Vias(c10,c11);
		
		vias[10][8] = new Vias(c11,c9);
		vias[10][9] = new Vias(c11,c10);
		vias[10][11] = new Vias(c11,c12);
		
		vias[11][7] = new Vias(c12,c8);
		vias[11][10] = new Vias(c12,c11);
		vias[11][12] = new Vias(c12,c13);
		
	
		vias[12][5] = new Vias(c13,c6);
		vias[12][8] = new Vias(c13,c9);
		vias[12][11] = new Vias(c13,c12);
		vias[12][15] = new Vias(c13,c16);
		
		vias[13][14] = new Vias(c14,c15);
		vias[13][15] = new Vias(c14,c16);
		
		vias[14][13] = new Vias(c15,c14);
		vias[14][15] = new Vias(c15,c16);
		vias[14][16] = new Vias(c15,c17);

		vias[15][4] = new Vias(c16,c4);
		vias[15][12] = new Vias(c16,c13);
		vias[15][14] = new Vias(c16,c15);
		vias[15][16] = new Vias(c16,c17);
		
		vias[16][14] = new Vias(c17,c15);
		vias[16][15] = new Vias(c17,c16);
		
		vias[17][4] = new Vias(c18,c5);

		
//		vias[0][1] = new Vias(a,b);
//		vias[0][2] = new Vias(a,c);
//		vias[0][3] = new Vias(a,d);
		  
		//vias[1][3] = new Vias(b,c);
		  
//		vias[1][4] = new Vias(b,e);		  
//		vias[1][5] = new Vias(b,f);		  
//		  
//		//vias[2][2] = new Vias(c,b);
//		 
//		vias[2][3] = new Vias(c,d);		
//		vias[2][4] = new Vias(c,e);
//		  		
//		vias[3][0] = new Vias(d,a);		
//		vias[3][4] = new Vias(d,e);
//		vias[3][5] = new Vias(d,f);
//		  
//		vias[4][6] = new Vias(e,g);
//		vias[4][2] = new Vias(e,c);
//		
//		vias[5][1] = new Vias(f,b);
		
	}
	
	private void configuracao()
	{
		cidadesMapeadas();
		malhaViaria();
		gerarMapa();
	
	}
	
	private void gerarMapa(){
		//Gerar a rota
		List<Cidade> menorCaminho = new ArrayList<Cidade>();
		double distanciaCaminho;
		Cidade origem = null;
		Cidade destino = null;
		
		
		for(int j = 0; j<lmDestinos.getSize();j++)
		{
			if(j!=lmDestinos.getSize()-1){
				distanciaCaminho = Djikstra.calcularMenorCaminho((Cidade)lmDestinos.getElementAt(j), (Cidade)lmDestinos.getElementAt(j+1), menorCaminho);
			}
			else
			{
				distanciaCaminho = Djikstra.calcularMenorCaminho((Cidade)lmDestinos.getElementAt(j), (Cidade)lmDestinos.getElementAt(0), menorCaminho);
			}
			
			System.out.println(distanciaCaminho);
			int i = 1;
			destino = null;
			origem = null;
			
			for (Cidade cidade : menorCaminho) 
			{
				System.out.print("=> " + cidade.getNome() + " ");
				origem = destino;
				destino = cidade;
				//Mapear rota a ser seguida
				if(i==1){
					i=0; 	
				}
				else
				{
					vias[origem.getId()][destino.getId()] = new Vias(origem,destino, true);
					vias[destino.getId()][origem.getId()] = new Vias(destino,origem, true);	
				}	
			}
			
		}

		//gerar o mapa
		
		

		
		vias[origem.getId()][destino.getId()] = new Vias(origem,destino, true);
		vias[destino.getId()][origem.getId()] = new Vias(destino,origem, true);
		System.out.println();
		
		DrawPanel panel = new DrawPanel(vias,7);
		JFrame application = new JFrame();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		application.add( panel );
		application.setSize( 1100, 600 );
		application.setVisible( true );
	}
	

	public static void main(String[] args) {
		Principal test = new Principal();
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
