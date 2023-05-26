import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ColourPick extends JFrame implements ActionListener{
	Random rand= new Random();
	
	double S, agg;
	int puntata, numBombe=1, contB=0;
	boolean play=false, persa=false;
	
	double [][] quote= {{1.02, 1.05, 1.1, 1.15, 1.21, 1.28, 1.35, 1.43, 1.52, 1.62, 1.73, 1.87, 2.02, 2.2, 2.43, 2.69, 3.03, 3.46, 4.04, 4.85, 6.06, 8.08, 12.13, 24.25},
					   {1.06, 1.15, 1.26, 1.39, 1.53, 1.7, 1.9, 2.14, 2.43, 2.77, 3.2, 3.73, 4.41, 5.29, 6.47, 8.08, 10.39, 13.86, 19.4, 29.1, 48.5, 97.0, 291.0},
					   {1.11, 1.26, 1.45, 1.68, 1.96, 2.3, 2.75, 3.3, 4, 4.9, 6.11, 7.8, 10.15, 13.55, 18.6, 26.56, 39.35, 63.75, 111.55, 223.1, 558, 1112.6},
					   {1.16, 1.39, 1.68, 2.05, 2.54, 3.17, 4.01, 5.16, 6.75, 9, 12.26, 17.17, 24.8, 37.2, 58.45, 97.4, 175.3, 350.6, 818, 1219, 1942.2},
					   {1.22, 1.54, 1.96, 2.53, 3.33, 4.44, 6.02, 8.33, 11.8, 17.17, 25.75, 40.05, 65.1, 111.55, 204.5, 409, 920, 1492.2, 1912, 2204.8},
					   {1.28, 1.7, 2.3, 3.17, 4.45, 6.35, 9.25, 13.9, 21.45, 34.35, 57.2, 100.1, 185.9, 371.85, 818, 2045, 2744, 4104, 6828},
					   {1.35, 1.9, 2.74, 4.01, 6.01, 9.25, 14.65, 24, 40.75, 72.5, 135.85, 271.7, 588.75, 1413, 3886, 5213, 8694.5, 18089},
					   {1.42, 2.05, 3.02, 4.53, 7.02, 10.67, 16.00, 26.66, 48.38, 85.22, 152.14, 301.04, 640.1, 1693.4, 4104.5, 6730, 15016, 23843},
					   {1.63, 2.42, 4.44, 6.98, 8.92, 12.45, 23.21, 37.12, 82.49, 198,91, 428.67, 960.27, 3104.04, 8563.39, 19378.45, 31000}};
	
	Font fon= new Font("Algerian", Font.BOLD, 24);
	Font font= new Font("Algerian", Font.BOLD, 64);
	Font fontt= new Font("Bodoni MT", Font.PLAIN, 18); 
	Font fonttt= new Font("Bodoni MT", Font.BOLD, 22); 
	Font font1= new Font("Bodoni MT", Font.PLAIN, 12); 
	Font fontnum= new Font("Bodoni MT", Font.BOLD, 55); 
	Font fontbonamo= new Font("Algerian", Font.BOLD, 35); 
	Font fonet= new Font("Bodoni MT", Font.BOLD, 20);
	
	JLabel label0= new JLabel ("COLOUR PICK");
	
	JFrame pagina=new JFrame();
	
	JLabel l1= new JLabel ("COLOUR PICK");
	JLabel title= new JLabel (" COLOUR PICK");
	JLabel l2= new JLabel ("SALDO: ");
	JButton aggSaldo=new JButton("ENTRA");
	JTextArea addSaldo= new JTextArea ();
	
	JTextArea caricamento= new JTextArea ();
	
	//BET ZONE
	
	JLabel label1= new JLabel ("SALDO: ");
	JLabel label2= new JLabel ("PUNTATA: ");
	JLabel label3= new JLabel ("RISCUOTI:");
	JLabel label= new JLabel ("");
	
	JTextArea saldo= new JTextArea(5,20);
	JTextField bet= new JTextField();
	JTextArea mine= new JTextArea(5,20);
	JTextField text= new JTextField();
	
	String cont= "";
	
	
	JButton vincita= new JButton("SCOMMETTI");
	JButton risc= new JButton(""+agg+"€");
	
	JButton mostra= new JButton("MOSTRA");
	JButton restart= new JButton("RICOMINCIA");


	
	JButton ricerca= new JButton ("Ricerca");
	JButton cancella= new JButton ("Cancella");
	
	
	JButton a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5,d1,d2,d3,d4,d5,e1,e2,e3,e4,e5;
	JButton[][] bottoni= {{a1,a2,a3,a4,a5},{b1,b2,b3,b4,b5},{c1,c2,c3,c4,c5},{d1,d2,d3,d4,d5},{e1,e2,e3,e4,e5}};
	int[][] bombe= new int[5][5];
	
	JButton btp=new JButton("->");
	JButton btm=new JButton("<-");
	
	JButton bt1=new JButton("1€");
	
	JButton bt5=new JButton("5€");
	JButton bt10=new JButton("10€");
	JButton bt25=new JButton("25€");
	JButton bt50=new JButton("50€");
	JButton bt100=new JButton("100€");
	
	JTextField nbombe=new JTextField(""+numBombe);
	JButton addb=new JButton("+");
	JButton toglib=new JButton("-");
	
	ImageIcon sfondo= new ImageIcon("sondocave.jpg");
	
	JPanel panel= new JPanel (); 
	
	
	public ColourPick() {
		super("Colour Pick");
		
		//START
		pagina.add(title);
		title.setFont(font);
		title.setBounds(150, 25, 200, 40);
		
		pagina.setSize(450,250);
		pagina.setLocation(125, 275);
		pagina.setResizable(false);
		pagina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pagina.setVisible(true);
		
		try {
           Thread.sleep(2500);
        } catch (InterruptedException t) {
            t.printStackTrace();
        }
		title.setVisible(false);
		
		
		pagina.add(l1);
		l1.setBounds(110, 25, 400, 40);
		l1.setFont(fontbonamo);
		pagina.add(addSaldo);
		addSaldo.setBounds(220,75,110,20);
		pagina.add(aggSaldo);
		aggSaldo.setBounds(145, 120, 150, 40);
		aggSaldo.setFont(fonet);
		aggSaldo.setMargin(new Insets(0, 0, 0, 0));
		aggSaldo.addActionListener(this);
		pagina.add(l2);
		l2.setBounds(110,75, 100, 20);
		l2.setFont(fonet);
		
		
		pagina.add(panel);
		pagina.setVisible(true);
		pagina.setResizable(false);
		pagina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pagina.add(label);
		
		setSize (700, 900);
		Container cont= this.getContentPane();
		setResizable(false);

		cont.setBackground(new Color(242, 242, 242));
		cont.add(label0);
		label0.setBounds(135, 40, 500, 60);
		label0.setFont(font);

		
		//Ciclo creazione bottoni
		int y=135;
		for(int i=0; i<5; i++) {
			int x=100;
			for(int j=0; j<5; j++) {
				bottoni[i][j]= new JButton();
				bottoni[i][j].setBackground(new Color(51, 204, 255));
				bottoni[i][j].addActionListener(this); 
				bottoni[i][j].setBounds(x, y, 75, 75);
				cont.add(bottoni[i][j]);
				x=x+100;
			}
			y=y+100;
		}
		
		//label per riscuotere
		cont.add(label1);
		label1.setBounds(250, 755, 130, 20);
		label1.setFont(fontt);
		
		cont.add(saldo);
		saldo.setBounds(320,755, 130, 20);
		saldo.setFont(fontt);
		saldo.setEditable(false);
		
		cont.add(vincita);
		vincita.setBounds(250, 660, 200, 80);
		//vincita.setBackground(new Color(255, 204, 0));
		
		cont.add(risc);
		risc.setBounds(250, 660, 200, 80);
		risc.setVisible(false);
		
		cont.add(label3);
		label3.setBounds(295, 615, 500, 60);
		label3.setFont(fonttt);
		label3.setVisible(false);
		
		//TASTI PER LA PUNTATA
		
		cont.add(label2);
		label2.setBounds(100, 615, 500, 60);
		label2.setFont(fontt);
		
		cont.add(bet);
		bet.setBounds(125, 660, 40, 20);
		bet.setText("1");
		bet.setHorizontalAlignment(JTextField.CENTER);
		
		cont.add(mostra);
		mostra.setBounds(250, 660, 200, 80);
		mostra.setVisible(false);
		
		cont.add(restart);
		restart.setBounds(250, 660, 200, 80);
		restart.setVisible(false);

		
		cont.add(btp);
		cont.add(btm);
		btm.setFont(font1);
		btp.setFont(font1);
		btm.setBounds(100,660,20,20);
		btp.setBounds(170,660,20,20);
		
		btm.setMargin(new Insets(0, 0, 0, 0));
		btp.setMargin(new Insets(0, 0, 0, 0));
		
		//SCELTA PUNTATA RAPIDA
		cont.add(bt1);
		bt1.setBounds(100, 690, 40, 20);
		cont.add(bt5);
		bt5.setBounds(150, 690, 40, 20);
		cont.add(bt10);
		bt10.setBounds(100, 720, 40, 20);
		cont.add(bt25);
		bt25.setBounds(150, 720, 40, 20);
		cont.add(bt50);
		bt50.setBounds(100, 750, 40, 20);
		cont.add(bt100);
		bt100.setBounds(150, 750, 40, 20);
	
		bt1.setMargin(new Insets(0, 0, 0, 0));
		bt5.setMargin(new Insets(0, 0, 0, 0));
		bt10.setMargin(new Insets(0, 0, 0, 0));
		bt25.setMargin(new Insets(0, 0, 0, 0));
		bt50.setMargin(new Insets(0, 0, 0, 0));
		bt100.setMargin(new Insets(0, 0, 0, 0));
		
		//BOMBEE
		
		cont.add(nbombe);
		nbombe.setBounds(502,660,60,60);
		nbombe.setMargin(new Insets(0, 0, 0, 0));
		nbombe.setEditable(false);
		nbombe.setFont(fontnum);
		nbombe.setHorizontalAlignment(JTextField.CENTER);
		nbombe.setBackground(Color.WHITE);
		
		cont.add(addb);
		addb.setBounds(540,740,35,35);
		addb.setMargin(new Insets(0, 0, 0, 0));

		cont.add(toglib);
		toglib.setBounds(490,740,35,35);
		toglib.setMargin(new Insets(0, 0, 0, 0));
		
		
		//TESTO 
		cont.add(text);
		text.setBounds(100,790,475,35);
		text.setFont(fontt);
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setEditable(false);
		
		
		//ACTIONLISTENER BOTTONI
		
		vincita.addActionListener(this);
		btp.addActionListener(this);
		bt1.addActionListener(this);
		bt5.addActionListener(this);
		bt10.addActionListener(this);
		bt25.addActionListener(this);
		bt50.addActionListener(this);
		bt100.addActionListener(this);
		btm.addActionListener(this);
		toglib.addActionListener(this);
		addb.addActionListener(this);
		mostra.addActionListener(this);
		restart.addActionListener(this);
		risc.addActionListener(this);
		
		
		
		//LIVELLO DEBUG
		
		cont.add(label);
		setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aggSaldo){
			
			S=Double.parseDouble(addSaldo.getText());
			saldo.setText(""+S);
			pagina.setVisible(false);
			this.setVisible(true);
			
		}
		if(e.getSource()==btp){
			cont= bet.getText();
			if(Integer.parseInt(cont)<1000){
				puntata=Integer.parseInt(cont);
				puntata++;
			}
			bet.setText("" +puntata);
		}
		
		if(e.getSource()==btm){
			cont= bet.getText();
			if(Integer.parseInt(cont)>1){
				puntata=Integer.parseInt(cont);
				puntata--;
			}
			bet.setText(""+puntata);
		}
		
		if(e.getSource()==bt1){
			puntata=1;
			bet.setText(""+puntata);
		}
		if(e.getSource()==bt5){
			puntata=5;
			bet.setText(""+puntata);
		}
		if(e.getSource()==bt10){
			puntata=10;
			bet.setText(""+puntata);
		}
		if(e.getSource()==bt25){
			puntata=25;
			bet.setText(""+puntata);
		}
		if(e.getSource()==bt50){
			puntata=50;
			bet.setText(""+puntata);
		}
		if(e.getSource()==bt100){
			puntata=100;
			bet.setText(""+puntata);
		}
		// + - BOMBO
		if(e.getSource()==addb){
			if(numBombe==9){
				numBombe=9;
			}else if(numBombe<9){
				numBombe++;
			}
			nbombe.setText(""+numBombe);
		}
		if(e.getSource()==toglib){
			if(numBombe==1){
				numBombe=1;
			}else if(numBombe>1){
				numBombe--;
			}
			nbombe.setText(""+numBombe);
		}
		//TASTI SCOMMETTI E RISCUOTI
		if(e.getSource()==vincita){
			if(Integer.parseInt(bet.getText()) >= 1 && Integer.parseInt(bet.getText()) <= S && Integer.parseInt(bet.getText()) <= 1000) {
				text.setText("");
				puntata=Integer.parseInt(bet.getText());
				S-= Integer.parseInt(bet.getText());
				S=Math.round(S*100.0)/100.0;
				saldo.setText(""+S);
				vincita.setVisible(false);
				risc.setVisible(true);
				label3.setVisible(true);
				toglib.setVisible(false);
				addb.setVisible(false);
				bt1.setVisible(false);
				bt5.setVisible(false);
				bt10.setVisible(false);
				bt25.setVisible(false);
				bt50.setVisible(false);
				bt100.setVisible(false);
				btp.setVisible(false);
				btm.setVisible(false);
				play=true;
				agg=0;
				genBombe();

			}else if(Integer.parseInt(bet.getText()) > 1000){
				text.setText("PUNTATA NON VALIDA: MIN 1 E MAX 1000");
			}else if(Integer.parseInt(bet.getText()) > S){
				text.setText("IL SALDO È INSUFFICENTE");
			}
		}
		if(play==true) {
			for(int p= 0; p < 5; p++) {
				for(int h= 0; h < 5; h++) {
					if(e.getSource()==bottoni[p][h]){
						if(bombe[p][h]==1) {
							bottoni[p][h].setBackground(new Color(255, 51, 0));
							text.setText("HAI PERSO!");
							play=false;
							persa=true;
							mostra.setVisible(true);
							risc.setVisible(false);
							agg=0;
							risc.setText(""+agg+"€");
						}else if(bombe[p][h]==0){
							bottoni[p][h].setBackground(new Color(102, 255, 102));
							agg=quote[numBombe-1][contB]*puntata;
							agg=Math.round(agg*100.0)/100.0;
							contB++;
							risc.setText(""+agg+"€");
							bombe[p][h]=2;
							if(25-numBombe == contB){
								text.setText("HAI VINTO, RISCUOTENDO: " + agg + "€");
								S=S+agg;
								S=Math.round(S*100.0)/100.0;
								saldo.setText(""+S);
								play=false;
								mostra.setVisible(true);
								risc.setVisible(false);
								agg=0;
								risc.setText(""+agg+"€");
							}
						}
			
					}
				}
			}
		}	
		if(e.getSource()==risc){
			mostra.setVisible(true);
			risc.setVisible(false);
			text.setText("HAI VINTO, RISCUOTENDO: " + agg + "€");
			S=S+agg;
			S=Math.round(S*100.0)/100.0;
			saldo.setText(""+S);
			agg=0;
			risc.setText(""+agg+"€");
			
		}
		if(e.getSource()==mostra){	
				for(int pp= 0; pp < 5; pp++) {
					for(int hh= 0; hh < 5; hh++) {
						if(bombe[pp][hh]==1) {
							bottoni[pp][hh].setBackground(new Color(255, 51, 0));
						}else {
							bottoni[pp][hh].setBackground(new Color(102, 255, 102));
						}
					}
				}
				restart.setVisible(true);
				mostra.setVisible(false);
		}
		if(e.getSource()==restart){
			text.setText("");
			vincita.setVisible(true);
			risc.setVisible(false);
			label3.setVisible(false);
			toglib.setVisible(true);
			addb.setVisible(true);
			bt1.setVisible(true);
			bt5.setVisible(true);
			bt10.setVisible(true);
			bt25.setVisible(true);
			bt50.setVisible(true);
			bt100.setVisible(true);
			btp.setVisible(true);
			btm.setVisible(true);
			restart.setVisible(false);
			play=false;
			
			contB=0;
			agg=0;
			risc.setText(""+agg+"€");
			for(int pp= 0; pp < 5; pp++) {
				for(int hh= 0; hh < 5; hh++) {
						bombe[pp][hh]=0;
						bottoni[pp][hh].setBackground(new Color(51, 204, 255));
						persa=false;
					}
				}
			}
		}
		
	
	
	
	
	void genBombe(){
		int num= Integer.parseInt(nbombe.getText());
		
		for(int i= 0; i < num; i++) {
		int x1= rand.nextInt(5);
		int y1= rand.nextInt(5);
			if(bombe[x1][y1]==1)
				i--;
			else
				bombe[x1][y1]=1;
		}
	}
}