

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TTBoard {
	public JButton B1, B2, B3, B4, B5, B6, B7, B8, B9;
	public JLabel Tic;
	public JFrame TTF;
	public JPanel TTP;

	public TTBoard() {
		TTF = new JFrame("Tic-Tac-Toe Board");
		TTF.setSize(275, 400);
		TTF.setVisible(true);
		TTF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TTP = new JPanel();
		TTF.add(TTP);
		TTP.setBackground(Color.BLACK);
		TTP.setLayout(null);
		
		Tic = new JLabel("Tic-Tac-Toe");
		Tic.setFont(new Font("Forte", Font.BOLD, 35));
		Tic.setBounds(40, 20, 250, 30);
		Tic.setForeground(Color.WHITE);
		TTP.add(Tic);
		
		B1 = new JButton("");
		B1.setBounds(50, 70, 50, 50);
		B1.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B1);
		
		B2 = new JButton("");
		B2.setBounds(50, 120, 50, 50);
		B2.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B2);
		
		B3 = new JButton("");
		B3.setBounds(50, 170, 50, 50);
		B3.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B3);
		
		B4 = new JButton("");
		B4.setBounds(100, 70, 50, 50);
		B4.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B4);
		
		B5 = new JButton("");
		B5.setBounds(100, 120, 50, 50);
		B5.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B5);
		
		B6 = new JButton("");
		B6.setBounds(100, 170, 50, 50);
		B6.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B6);
		
		B7 = new JButton("");
		B7.setBounds(150, 70, 50, 50);
		B7.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B7);
		
		B8 = new JButton("");
		B8.setBounds(150, 120, 50, 50);
		B8.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B8);
		
		B9 = new JButton("");
		B9.setBounds(150, 170, 50, 50);
		B9.setFont(new Font("Arial", Font.BOLD, 25));
		TTP.add(B9);
	}
	
	public void sB1(String p) {
		//B1 = new Button(p);
		//B1.setBounds(50, 50, 50, 50);;
		//TTP.add(B1);
		B1.setText(p);
		B1.setEnabled(false);
	}
	
	public void sB2(String p) {
		//B2 = new Button(p);
		//B2.setBounds(50, 100, 50, 50);;
		//TTP.add(B2);
		B2.setText(p);
		B2.setEnabled(false);
	}	
	
	public void sB3(String p) {
		//B3 = new Button(p);
		//B3.setBounds(50, 150, 50, 50);;
		//TTP.add(B3);
		B3.setText(p);
		B3.setEnabled(false);
	}	
	
	public void sB4(String p) {
		//B4 = new Button(p);
		//B4.setBounds(100, 50, 50, 50);;
		//TTP.add(B4);
		B4.setText(p);
		B4.setEnabled(false);
	}	
	
	public void sB5(String p) {
		//B5 = new Button(p);
		//B5.setBounds(100, 100, 50, 50);;
		//TTP.add(B5);
		B5.setText(p);
		B5.setEnabled(false);
	}	
	
	public void sB6(String p) {
		//B6 = new Button(p);
		//B6.setBounds(100, 150, 50, 50);;
		//TTP.add(B6);
		B6.setText(p);
		B6.setEnabled(false);
	}	
	
	public void sB7(String p) {
		//B7 = new Button(p);
		//B7.setBounds(150, 50, 50, 50);;
		//TTP.add(B7);
		B7.setText(p);
		B7.setEnabled(false);
	}	
	
	public void sB8(String p) {
		//B8 = new Button(p);
		//B8.setBounds(150, 100, 50, 50);;
		//TTP.add(B8);
		B8.setText(p);
		B8.setEnabled(false);
	}	
	
	public void sB9(String p) {
		//B9 = new Button(p);
		//B9.setBounds(150, 150, 50, 50);;
		//TTP.add(B9);
		B9.setText(p);
		B9.setEnabled(false);
	}	
}
