//brukergrensesnitt
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//endre på brukergrensesnittet dvs input og output til modellen (labyrinten)
//alt er i konstruktøren
public class GUILabyrint {
	Kontroller kontroller;
	JFrame vindu; 
	JPanel panel, konsoll, rutenett;
	JButton[][] ruter;  
	JLabel labyrint, koordinat; 
	JButton startknapp, stoppknapp; 
    Dimension knappeDimensjon = new Dimension(90, 20);


	GUILabyrint(Kontroller k, int rad, int kol){
		try {
        	UIManager.setLookAndFeel(
        	 UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
             System.exit(9); 
        }


		
	ruter = new JButton[rad][kol]; //fra konstruktør
	kontroller = k; 

	vindu = new JFrame("Labyrint"); 
	vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	panel = new JPanel();
	panel.setLayout(new BorderLayout());
	vindu.add(panel);

	konsoll = new JPanel();
	panel.add(konsoll);


	labyrint = new JLabel("Slik ser labyrinten ut: " );
	//skriver ut array med knapper i gridlayout

	koordinat = new JLabel(); //viser hvilken rute bruker har valgt
	startknapp = new JButton("Start"); 
	startknapp.addActionListener(new Startbehandler());
	startknapp.setPreferredSize(new Dimension(knappeDimensjon));

	stoppknapp = new JButton("Avslutt");
	stoppknapp.addActionListener(new Stoppebehandler()); 
	stoppknapp.setPreferredSize(knappeDimensjon);

	konsoll.add(labyrint);

	konsoll.add(startknapp);
	konsoll.add(stoppknapp);


	//lager rutenettet med tilfeldig antall celler: 
	rutenett = new JPanel();
	rutenett.setLayout(new GridLayout(rad, kol));
	for (int i = 0; i <rad; i++) {
		for (int j = 0; j< kol; j++) {
			JButton b = new JButton(" ");
			ruter[i][j] = b; 
			b.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
			b.addActionListener(new RuteVelger(i, j));
			rutenett.add(b);
		}
	}
	




	panel.add(rutenett, BorderLayout.CENTER);

	vindu.pack();
	vindu.setSize(600, 600);
	vindu.setLocationRelativeTo(null);
	vindu.setVisible(true);


	}


	void velgStartRute(int rad, int kol){
		labyrint.setText("Valgt startrute: " + rad + kol);
	}

	void tegnSortRute(JButton b){
		b.setBackground(Color.black);

	}

	void tegnHvitRute(JButton b){
		b.setBackground(Color.white);
	}

	//tegn rutene hvit og svar 
	class Startbehandler implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kontroller.start();
        }
    }


    class Stoppebehandler implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            kontroller.avsluttSpillet();
        }
    }


    class RuteVelger implements ActionListener { 
        int rad, kol; 

        RuteVelger (int r, int k) {
            rad = r; kol = k;
        }

        @Override
        public void actionPerformed (ActionEvent e) {
            kontroller.velgStartRute(rad, kol);
        }
    }


}