import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TTT {
	private JButton B1, B2, B3, B4, B5, B6, B7, B8, B9, AI, friend, ez, med, hard;
	private JLabel Tic, who, who2, finale;
	private JFrame TTF, start, dif;
	
	private String AI_turn = "H";
	
	private B1 B11 = new B1();
	private B2 B22 = new B2();
	private B3 B33 = new B3();
	private B4 B44 = new B4();
	private B5 B55 = new B5();
	private B6 B66 = new B6();
	private B7 B77 = new B7();
	private B8 B88 = new B8();
	private B9 B99 = new B9();
	private ezz ezz = new ezz();
	private med mediumClass = new med();
	private hard hardClass = new hard();
	
	private boolean play = true;
	
	private String[] board = new String[9];
	
	private Thread checker, AI_check;
	
	private int mouseLastx, mouseLasty;
	
	private mouseAdapt mouseAdapt = new mouseAdapt();
	
	private String frame = "start"; //false = start true = game
	
	private String playAgainst = "", difficulty = ""; //playAgainst = who you play against -- Difficulty = difficulty of AI
	private boolean turn = false; //false = p1, true = p2, AI = p2

	public static void main(String[] args) {
		new TTT();
	}
	
	//start
	public TTT() {
		for(int i = 0; i < board.length; i++) {board[i] = " ";} //so board is filled with atleast something
		
		start = new JFrame("Tic-Tac-Toe");
		start.setUndecorated(true);
		start.setAlwaysOnTop(true);
		start.getContentPane().setBackground(Color.BLACK);
		start.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		start.setSize(275, 400);
		start.setVisible(true);
		start.setLayout(null);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.addMouseListener(mouseAdapt);
		
		who = new JLabel("Who would you like");
		who.setForeground(Color.WHITE);
		who.setFont(new Font("arial", Font.BOLD, 25));
		who.setBounds(15, 15, 275, 40);
		start.getContentPane().add(who);
		
		who2 = new JLabel("to play against?");
		who2.setForeground(Color.WHITE);
		who2.setFont(new Font("arial", Font.BOLD, 25));
		who2.setBounds(30, 45, 200, 40);
		start.getContentPane().add(who2);
		
		AI = new JButton("AI");
		AI.setSelected(false);
		AI.setFont(new Font("arial", Font.BOLD, 20));
		AI.setForeground(Color.BLACK);
		AI.setBounds(30, 100, 200, 100);
		AI.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		AI.setBackground(Color.LIGHT_GRAY);
		start.getContentPane().add(AI);
		AI.addActionListener(new AI());
		
		friend = new JButton("Friend");
		friend.setFont(new Font("arial", Font.BOLD, 20));
		friend.setForeground(Color.BLACK);
		friend.setBounds(30, 240, 200, 100);
		friend.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		friend.setBackground(Color.LIGHT_GRAY);
		start.getContentPane().add(friend);
		friend.addActionListener(new friend());
	}
	
	public class mouseAdapt extends MouseAdapter {
    	private Thread follow = new Thread();
        public void mousePressed(MouseEvent e) {
        	follow = new follow();
        	follow.start();
        }
        public void mouseReleased(MouseEvent e) {
        	follow.stop();
        }
	}
	
	
	//Difficulty choice
	public void dif() {
		dif.setUndecorated(true);
		dif.setAlwaysOnTop(true);
		dif.setLocation(start.getX(), start.getY());
		dif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dif.getContentPane().setBackground(Color.BLACK);
		dif.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		dif.setSize(260, 275);
		dif.setLayout(null);
		dif.setVisible(true);
		dif.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dif.addMouseListener(mouseAdapt);
		
		ez = new JButton("Easy");
		ez.setBounds(25, 25, 200, 60);
		ez.setBackground(Color.WHITE);
		ez.setForeground(Color.BLACK);
		ez.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		ez.setFont(new Font("Arial", Font.BOLD, 25));
		dif.getContentPane().add(ez);
		ez.addActionListener(ezz);
		
		med = new JButton("Medium");
		med.setBounds(25, 105, 200, 60);
		med.setBackground(Color.WHITE);
		med.setForeground(Color.BLACK);
		med.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		med.setFont(new Font("Arial", Font.BOLD, 25));
		dif.getContentPane().add(med);
		med.addActionListener(mediumClass);
		
		hard = new JButton("Hard");
		hard.setBounds(25, 185, 200, 60);
		hard.setBackground(Color.WHITE);
		hard.setForeground(Color.BLACK);
		hard.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		hard.setFont(new Font("Arial", Font.BOLD, 25));
		dif.getContentPane().add(hard);
		hard.addActionListener(hardClass);
	}
	
	//friend game
	public void TTTT() {
		checker = new check();
		checker.start();
			
		TTF.setAlwaysOnTop(true);
		TTF.setUndecorated(true);
		TTF.getContentPane().setBackground(Color.BLACK);
		TTF.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		TTF.setSize(260, 275);
		TTF.setLayout(null);
		TTF.setVisible(true);
		TTF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TTF.addMouseListener(mouseAdapt);
			
		Tic = new JLabel("Tic-Tac-Toe");
		Tic.setFont(new Font("Forte", Font.BOLD, 45));
		Tic.setForeground(Color.WHITE);
		Tic.setBounds(24, 10, 250, 40);
		TTF.getContentPane().add(Tic);
			
		B1 = new JButton("");
		B1.setBounds(45, 65, 50, 50);
		B1.setBackground(Color.WHITE);
		B1.setForeground(Color.BLACK);
		B1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B1.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B1);
		B1.addActionListener(B11);
			
		B2 = new JButton("");
		B2.setBounds(45, 120, 50, 50);
		B2.setBackground(Color.WHITE);
		B2.setForeground(Color.BLACK);
		B2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B2.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B2);
		B2.addActionListener(B22);
			
		B3 = new JButton("");
		B3.setBounds(45, 175, 50, 50);
		B3.setBackground(Color.WHITE);
		B3.setForeground(Color.BLACK);
		B3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B3.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B3);
		B3.addActionListener(B33);
			
		B4 = new JButton("");
		B4.setBounds(100, 65, 50, 50);
		B4.setBackground(Color.WHITE);
		B4.setForeground(Color.BLACK);
		B4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B4.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B4);
		B4.addActionListener(B44);
			
		B5 = new JButton("");
		B5.setBounds(100, 120, 50, 50);
		B5.setBackground(Color.WHITE);
		B5.setForeground(Color.BLACK);
		B5.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B5.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B5);
		B5.addActionListener(B55);
			
		B6 = new JButton("");
		B6.setBounds(100, 175, 50, 50);
		B6.setBackground(Color.WHITE);
		B6.setForeground(Color.BLACK);
		B6.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B6.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B6);
		B6.addActionListener(B66);
			
		B7 = new JButton("");
		B7.setBounds(155, 65, 50, 50);
		B7.setBackground(Color.WHITE);
		B7.setForeground(Color.BLACK);
		B7.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B7.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B7);
		B7.addActionListener(B77);
			
		B8 = new JButton("");
		B8.setBounds(155, 120, 50, 50);
		B8.setBackground(Color.WHITE);
		B8.setForeground(Color.BLACK);
		B8.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B8.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B8);
		B8.addActionListener(B88);
		
		B9 = new JButton("");
		B9.setBounds(155, 175, 50, 50);
		B9.setBackground(Color.WHITE);
		B9.setForeground(Color.BLACK);
		B9.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B9.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B9);
		B9.addActionListener(B99);
	}
	
	//Buttons for AI difficulties
	private class ezz implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			difficulty = "easy";
			int x = dif.getX();
			int y = dif.getY();
			TTF = new JFrame("Tic-Tac-Toe");
			TTF.setLocation(x, y);
			closeMe();
			frame = "game";
			playAgainst = "AI";
			TTTTT();
		}
	}
	private class med implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			difficulty = "medium";
			int x = dif.getX();
			int y = dif.getY();
			TTF = new JFrame("Tic-Tac-Toe");
			TTF.setLocation(x, y);
			closeMe();
			playAgainst = "AI";
			frame = "game";
			TTTTT();
		}
	}
	private class hard implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			difficulty = "hard";
			int x = dif.getX();
			int y = dif.getY();
			TTF = new JFrame("Tic-Tac-Toe");
			TTF.setLocation(x, y);
			playAgainst = "AI";
			closeMe();
			frame = "game";
			TTTTT();
		}
	}
	
	
	//Universal checker to see if someone has won or if there is a tie
	private class check extends Thread{
		public void run() {
			while(play) {
				String check = checkerer();
				boolean full = true;
				for (int i = 0; i < board.length; i++) {
					if (board[i].equals(null) || board[i].equals(" ")) {
						full = false;
					}
				}
				if(check.equals("XXX") || check.equals("OOO") || full) {
					try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
					JButton restart = new JButton("Restart");
					restart.setForeground(Color.BLACK);
					restart.setBackground(Color.LIGHT_GRAY);
					restart.setFont(new Font("arial", Font.BOLD, 40));
					restart.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
					restart.setBounds(25, 180, 200, 70);
					TTF.setLayout(null);
					TTF.getContentPane().removeAll();
					TTF.repaint();
					TTF.getContentPane().add(restart);
					restart.addActionListener(new restart());
					
					if (check.equals("XXX")) {
						finale = new JLabel("PLAYER X");
						finale.setForeground(new Color(96, 199, 255));
						finale.setFont(new Font("Arial", Font.BOLD, 40));
						finale.setBounds(20, 30, 250, 60);
						TTF.getContentPane().add(finale);
						
						JLabel finale2 = new JLabel("WINS");
						finale2.setForeground(new Color(96, 199, 255));
						finale2.setFont(new Font("Arial", Font.BOLD, 40));
						finale2.setBounds(71, 92, 250, 60);
						TTF.repaint();
						TTF.getContentPane().add(finale2);
					} else if (check.equals("OOO")) {
						finale = new JLabel("PLAYER O");
						finale.setForeground(Color.RED);
						finale.setFont(new Font("arial", Font.BOLD, 40));
						finale.setBounds(20, 30, 250, 40);
						TTF.getContentPane().add(finale);
						
						JLabel finale2 = new JLabel("WINS");
						finale2.setForeground(Color.RED);
						finale2.setFont(new Font("Arial", Font.BOLD, 40));
						finale2.setBounds(71, 92, 250, 60);
						TTF.repaint();
						TTF.getContentPane().add(finale2);
					} else if (full) {
						finale = new JLabel("!ITS A TIE!");
						finale.setForeground(Color.WHITE);
						finale.setFont(new Font("arial", Font.BOLD, 45));
						finale.setBounds(18, 60, 250, 40);
						TTF.repaint();
						TTF.getContentPane().add(finale);
					}
					play = false;
				}
			}
		}
	}
	public String checkerer() { //Helper for checker
		String word = "";
		word = board[0] + board[1] + board[2]; // right, from first row starting at the left
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[3] + board[4] + board[5]; // right, from second row starting at the left
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[6] + board[7] + board[8]; // right, from third row starting at the left
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[0] + board[3] + board[6]; // down, from first row starting at the top
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[1] + board[4] + board[7]; // down, from second row starting at the top
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[2] + board[5] + board[8]; // down, from third row starting at the top
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[0] + board[4] + board[8]; // diagonal, down, and to the right, from first spot on the first row
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		word = board[2] + board[4] + board[6]; // diagonal, down, and to the left, from the last spot on the first row
		if (word.equals("XXX") || word.equals("OOO")) {
			return word;
		}
		return word;
	}
	
	
	//AI
	public void TTTTT() { //board maker for AI
		for(int i = 0; i < board.length; i++) {board[i] = " ";} 
		
		AI_check = new AI_check();
		AI_check.start();
		checker = new check();
		checker.start();
		
		TTF.setAlwaysOnTop(true);
		TTF.setUndecorated(true);
		TTF.getContentPane().setBackground(Color.BLACK);
		TTF.getRootPane().setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		TTF.setSize(260, 275);
		TTF.setLayout(null);
		TTF.setVisible(true);
		TTF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TTF.addMouseListener(mouseAdapt);
		
		Tic = new JLabel("Tic-Tac-Toe");
		Tic.setFont(new Font("Forte", Font.BOLD, 45));
		Tic.setForeground(Color.WHITE);
		Tic.setBounds(24, 10, 250, 40);
		TTF.getContentPane().add(Tic);	
		B1 = new JButton("");
		B1.setBounds(45, 65, 50, 50);
		B1.setBackground(Color.WHITE);
		B1.setForeground(Color.BLACK);
		B1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B1.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B1);
		B1.addActionListener(B11);
		
		B2 = new JButton("");
		B2.setBounds(45, 120, 50, 50);
		B2.setBackground(Color.WHITE);
		B2.setForeground(Color.BLACK);
		B2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B2.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B2);
		B2.addActionListener(B22);
		
		B3 = new JButton("");
		B3.setBounds(45, 175, 50, 50);
		B3.setBackground(Color.WHITE);
		B3.setForeground(Color.BLACK);
		B3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B3.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B3);
		B3.addActionListener(B33);
		
		B4 = new JButton("");
		B4.setBounds(100, 65, 50, 50);
		B4.setBackground(Color.WHITE);
		B4.setForeground(Color.BLACK);
		B4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B4.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B4);
		B4.addActionListener(B44);
		
		B5 = new JButton("");
		B5.setBounds(100, 120, 50, 50);
		B5.setBackground(Color.WHITE);
		B5.setForeground(Color.BLACK);
		B5.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B5.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B5);
		B5.addActionListener(B55);
		
		B6 = new JButton("");
		B6.setBounds(100, 175, 50, 50);
		B6.setBackground(Color.WHITE);
		B6.setForeground(Color.BLACK);
		B6.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B6.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B6);
		B6.addActionListener(B66);
		
		B7 = new JButton("");
		B7.setBounds(155, 65, 50, 50);
		B7.setBackground(Color.WHITE);
		B7.setForeground(Color.BLACK);
		B7.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B7.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B7);
		B7.addActionListener(B77);
		
		B8 = new JButton("");
		B8.setBounds(155, 120, 50, 50);
		B8.setBackground(Color.WHITE);
		B8.setForeground(Color.BLACK);
		B8.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B8.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B8);
		B8.addActionListener(B88);
		
		B9 = new JButton("");
		B9.setBounds(155, 175, 50, 50);
		B9.setBackground(Color.WHITE);
		B9.setForeground(Color.BLACK);
		B9.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
		B9.setFont(new Font("Arial", Font.BOLD, 25));
		TTF.getContentPane().add(B9);
		B9.addActionListener(B99);
		
		if(turn) {
			B1.removeActionListener(B11);
			B2.removeActionListener(B22);
			B3.removeActionListener(B33);
			B4.removeActionListener(B44);
			B5.removeActionListener(B55);
			B6.removeActionListener(B66);
			B7.removeActionListener(B77);
			B8.removeActionListener(B88);
			B9.removeActionListener(B99);
		}
	}
	private class AI_check extends Thread {
		@SuppressWarnings("unlikely-arg-type")
		public void run() {
			while(true) {
				System.out.println();
				if(turn) {
					turn = false;
					//De-Activating Buttons
					B1.removeActionListener(B11);
					B2.removeActionListener(B22);
					B3.removeActionListener(B33);
					B4.removeActionListener(B44);
					B5.removeActionListener(B55);
					B6.removeActionListener(B66);
					B7.removeActionListener(B77);
					B8.removeActionListener(B88);
					B9.removeActionListener(B99);
					
					//AI "thinking"
					try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
					
				//Choosing spot
					int num_choose = -1;
					//String dif = "";
					//anticipate two option win
					if(difficulty.equals("hard")) {
						//dif = "ard";
						num_choose = AI_hardCheck(num_choose);
					}
					boolean spot_taken = false;
					//block two in row
					if(!difficulty.equals("easy")) {
						//if(!dif.equals("ard")) {dif = "med";}
						num_choose = AI_medCheck(num_choose);
					}
					//random
					if(num_choose == -1 || spot_taken) {
						//dif = "ez";
						boolean[] open = new boolean[9];
						for(int i = 0; i < board.length; i++) {
							if(board[i].equals(" ")) {
								open[i] = true;
							}
						}
						Random rand = new Random();
						num_choose = rand.nextInt(9);
						while(!open[num_choose]) {
							num_choose = rand.nextInt(9);
						}
					}

					//Tic.setText(num_choose + " " + dif);
					//Setting AI choice
					board[num_choose] = "O";
					if(num_choose == 0) {B1.setForeground(Color.RED);B1.setText("O");}
					if(num_choose == 1) {B2.setForeground(Color.RED);B2.setText("O");}
					if(num_choose == 2) {B3.setForeground(Color.RED);B3.setText("O");}
					if(num_choose == 3) {B4.setForeground(Color.RED);B4.setText("O");}
					if(num_choose == 4) {B5.setForeground(Color.RED);B5.setText("O");}
					if(num_choose == 5) {B6.setForeground(Color.RED);B6.setText("O");}
					if(num_choose == 6) {B7.setForeground(Color.RED);B7.setText("O");}
					if(num_choose == 7) {B8.setForeground(Color.RED);B8.setText("O");}
					if(num_choose == 8) {B9.setForeground(Color.RED);B9.setText("O");}
					
					//Re-Activating Buttons
					B1.addActionListener(B11);
					B2.addActionListener(B22);
					B3.addActionListener(B33);
					B4.addActionListener(B44);
					B5.addActionListener(B55);
					B6.addActionListener(B66);
					B7.addActionListener(B77);
					B8.addActionListener(B88);
					B9.addActionListener(B99);
				}
			}
		}
	}
	public int AI_hardCheck(int num_choose) { //Medium difficulty check
		Random rand = new Random();
		int ran;
		//OFFENSIVE
		
		
				ran = rand.nextInt(4);
				
				//if first move start on any corner
				if((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("         ")) {if(ran == 0) {num_choose = 0;} if(ran == 1) {num_choose = 2;} if(ran == 2) {num_choose = 6;} if(ran == 3) {num_choose = 8;}}
				
				//If other player goes mid after first play, SO X always mid
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("    X   O")) {num_choose = 0;} //O bot right
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O   X    ")) {num_choose = 8;} //O top left
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O X    ")) {num_choose = 6;} //O bot left
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("    X O  ")) {num_choose = 2;} //O top right

				//If surrounding other and he goes corner, other always in mid
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("0   X X O")) {num_choose = 2;} //O bot right O top left X top right
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O X O X")) {num_choose = 0;} //O top left O bot right X bot left
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O X X   O")) {num_choose = 6;} //O bot right O top left X bot left
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X O X O  ")) {num_choose = 8;} //O top right O bot left X top left
				
				//If other player goes any other corner after first move
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("       XO")) {num_choose = 2;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" X      O")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 2;} if(ran == 1) {num_choose = 6;}
				}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("     X  O")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 2;} if(ran == 1) {num_choose = 6;}
				} 
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O  X   ")) {num_choose = 0;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" XO      ")) {num_choose = 8;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  OX     ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 0;} if(ran == 1) {num_choose = 8;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O    X ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 0;} if(ran == 1) {num_choose = 8;}
				} 
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O  X     ")) {num_choose = 2;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("OX       ")) {num_choose = 6;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O      X ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 2;} if(ran == 1) {num_choose = 6;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O    X   ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 2;} if(ran == 1) {num_choose = 6;}
				} 
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("   X  O  ")) {num_choose = 8;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("      OX ")) {num_choose = 0;}
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" X    O  ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 0;} if(ran == 1) {num_choose = 8;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("     XO  ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 0;} if(ran == 1) {num_choose = 8;}
				} 
				
				
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O  X XO")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 4;} if(ran == 1) {num_choose = 0;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" XO  X  O")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 4;} if(ran == 1) {num_choose = 6;}
				} 
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("   X  OXO")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 4;} if(ran == 1) {num_choose = 2;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("     XOXO")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 0;} if(ran == 1) {num_choose = 4;}
				} 
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("OXO  X   ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 4;} if(ran == 1) {num_choose = 6;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("OXOX     ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 8;} if(ran == 1) {num_choose = 4;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O  X  OX")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 0;} if(ran == 2) {num_choose = 4;}
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("OX X  O  ")) {
					ran = rand.nextInt(2); 
					if(ran == 0) {num_choose = 8;} if(ran == 1) {num_choose = 4;}
				} 
				
				
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O     X")) {
					num_choose = 6;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X O      ")) {
					num_choose = 6;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  X     O")) {
					num_choose = 0;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("      X O")) {
					num_choose = 0;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("      O X")) {
					num_choose = 2;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X     O  ")) {
					num_choose = 2;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O     X  ")) {
					num_choose = 8;
				} 
				if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O X      ")) {
					num_choose = 8;
				}
		
		
		//DEFENSIVE
		
		
		if((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X        ") || //top left
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("        X") || //bottom right
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  X      ") || //bottom left
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("      X  ")) { //top right
			num_choose = 4;
		}
		if((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("   X     ") || //top mid
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("     X   ") || //bottom mid
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" X       ") || //left mid
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("       X ")) { //right mid
			num_choose = 4;
		}
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("    X    ")) { //middle
			ran = rand.nextInt(4);
			if(ran == 0) {num_choose = 0;}
			if(ran == 1) {num_choose = 2;}
			if(ran == 2) {num_choose = 6;}
			if(ran == 3) {num_choose = 8;}
		}
		if((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X   O   X") || //O mid, X surrounding top left bot right
		   (board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  X O X  ")) { //O mid, X surrounding bot left top right
			ran = rand.nextInt(4);
			if(ran == 0) {num_choose = 1;}
			if(ran == 1) {num_choose = 3;}
			if(ran == 2) {num_choose = 5;}
			if(ran == 3) {num_choose = 7;}
		}
		//O mid all of these
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  XXO    ") || 					  //X top & X bot left
				(board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" X  O X  ")) {num_choose = 0;} //X left & X top right
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X   OX   ") ||  				 	  //X top left & X bot
				(board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals(" X  O   X")) {num_choose = 2;} //X left & X bot right
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X   O  X ") || 					  //X top left & X right
			(board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("   XO   X")) {num_choose = 6;}     //X top & X bot right
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("    OXX  ") || 					  //X top right & X bot
				(board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  X O  X ")) {num_choose = 8;} //X bot left & X right
		
		//X mid all of these
		ran = rand.nextInt(2);
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  X X O  ") || //X bot left & O top right
			(board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("  O X X  ")) { //X top right & O bot left
			if(ran == 0) {num_choose = 0;}
			if(ran == 1) {num_choose = 8;}
		} 
		ran = rand.nextInt(2);
		if ((board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("O   X   X") || //X bot right & O top left
			(board[0] + board[1] + board[2] +board[3] + board[4] + board[5] + board[6] + board[7] + board[8] + "").equals("X   X   O")) { //X top left & O bot right
			if(ran == 0) {num_choose = 2;}
			if(ran == 1) {num_choose = 6;}
		}
		
		
		
		
		return num_choose;
	}
	public int AI_medCheck(int num_choose) { //Medium difficulty check
		if((board[5] + board[4] + board[3] + "").equals("OO ")) {
			num_choose = 3;
		} else if((board[4] + board[3] + board[5] + "").equals("OO ")) {
			num_choose = 5;
		} else if((board[4] + board[1] + board[7] + "").equals("OO ")) {
			num_choose = 7;
		} else if((board[7] + board[4] + board[1] + "").equals("OO ")) {
			num_choose = 1;
		} else if((board[4] + board[0] + board[8] + "").equals("OO ")) {
			num_choose = 8;
		} else if((board[8] + board[4] + board[0] + "").equals("OO ")) {
			num_choose = 0;
		} else if((board[4] + board[2] + board[6] + "").equals("OO ")) {
			num_choose = 6;
		} else if((board[6] + board[4] + board[2] + "").equals("OO ")) {
			num_choose = 2;
		} else if((board[3] + board[0] + board[6] + "").equals("OO ")) {
			num_choose = 6;
		} else if((board[6] + board[3] + board[0] + "").equals("OO ")) {
			num_choose = 0;
		} else if((board[5] + board[2] + board[8] + "").equals("OO ")) {
			num_choose = 8;
		} else if((board[8] + board[5] + board[2] + "").equals("OO ")) {
			num_choose = 2;
		} else if((board[2] + board[1] + board[0] + "").equals("OO ")) {
			num_choose = 0; 
		} else if((board[1] + board[0] + board[2] + "").equals("OO ")) {
			num_choose = 2; 
		} else if((board[8] + board[7] + board[6] + "").equals("OO ")) {
			num_choose = 6;
		} else if((board[7] + board[6] + board[8] + "").equals("OO ")) {
			num_choose = 8;
		} else if((board[8] + board[0] + board[4] + "").equals("OO ")) {
			num_choose = 4;
		} else if((board[6] + board[2] + board[4] + "").equals("OO ")) {
			num_choose = 4;
		} else if((board[5] + board[3] + board[4] + "").equals("OO ")) {
			num_choose = 4;
		} else if((board[7] + board[1] + board[4] + "").equals("OO ")) {
			num_choose = 4;
		} else if((board[2] + board[0] + board[1] + "").equals("OO ")) {
			num_choose = 1;
		} else if((board[8] + board[6] + board[7] + "").equals("OO ")) {
			num_choose = 7;
		} else if((board[8] + board[2] + board[5] + "").equals("OO ")) {
			num_choose = 5;
		} else if((board[6] + board[0] + board[3] + "").equals("OO ")) {
			num_choose = 3;
		} else if((board[5] + board[4] + board[3] + "").equals("XX ")) {
			num_choose = 3;
		} else if((board[4] + board[3] + board[5] + "").equals("XX ")) {
			num_choose = 5;
		} else if((board[4] + board[1] + board[7] + "").equals("XX ")) {
			num_choose = 7;
		} else if((board[7] + board[4] + board[1] + "").equals("XX ")) {
			num_choose = 1;
		} else if((board[4] + board[0] + board[8] + "").equals("XX ")) {
			num_choose = 8;
		} else if((board[8] + board[4] + board[0] + "").equals("XX ")) {
			num_choose = 0;
		} else if((board[4] + board[2] + board[6] + "").equals("XX ")) {
			num_choose = 6;
		} else if((board[6] + board[4] + board[2] + "").equals("XX ")) {
			num_choose = 2;
		} else if((board[3] + board[0] + board[6] + "").equals("XX ")) {
			num_choose = 6;
		} else if((board[6] + board[3] + board[0] + "").equals("XX ")) {
			num_choose = 0;
		} else if((board[5] + board[2] + board[8] + "").equals("XX ")) {
			num_choose = 8;
		} else if((board[8] + board[5] + board[2] + "").equals("XX ")) {
			num_choose = 2;
		} else if((board[2] + board[1] + board[0] + "").equals("XX ")) {
			num_choose = 0; 
		} else if((board[1] + board[0] + board[2] + "").equals("XX ")) {
			num_choose = 2; 
		} else if((board[8] + board[7] + board[6] + "").equals("XX ")) {
			num_choose = 6;
		} else if((board[7] + board[6] + board[8] + "").equals("XX ")) {
			num_choose = 8;
		} else if((board[8] + board[0] + board[4] + "").equals("XX ")) {
			num_choose = 4;
		} else if((board[6] + board[2] + board[4] + "").equals("XX ")) {
			num_choose = 4;
		} else if((board[5] + board[3] + board[4] + "").equals("XX ")) {
			num_choose = 4;
		} else if((board[7] + board[1] + board[4] + "").equals("XX ")) {
			num_choose = 4;
		} else if((board[2] + board[0] + board[1] + "").equals("XX ")) {
			num_choose = 1;
		} else if((board[8] + board[6] + board[7] + "").equals("XX ")) {
			num_choose = 7;
		} else if((board[8] + board[2] + board[5] + "").equals("XX ")) {
			num_choose = 5;
		} else if((board[6] + board[0] + board[3] + "").equals("XX ")) {
			num_choose = 3;
		}
		return num_choose;
	}
	
	
	//Restart button after a game
	private class restart implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int x = TTF.getX();
			int y = TTF.getY();
			TTF.dispose();
			for(int i = 0; i < board.length; i++) {board[i] = " ";}
			checker.stop();
			play = true;
			TTF = new JFrame("Tic-Tac-Toe");
			TTF.setLocation(x, y);
			if(playAgainst.equals("friend")) {
				turn = false;
				TTTT();
			} else if(playAgainst.equals("AI")) {
				if(AI_turn.equals("AI")) {turn = false; AI_turn = "H";}
				else if(AI_turn.equals("H")) {turn = true; AI_turn = "AI";}
				AI_check.stop();
				
				TTTTT();
			}
		}
	}
	
	//Class used to make the frame follow mouse
	private class follow extends Thread {
		private boolean first = true; //used to get og mouse pos
		public void run() {
			while(true) {
				try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
				Point mousePos = MouseInfo.getPointerInfo().getLocation();
				if(!first) {
					if(frame.equals("start")) {
						mouseLastx = (int)mousePos.getX() - mouseLastx;
						mouseLasty = (int)mousePos.getY() - mouseLasty;
						start.setLocation(start.getX() + mouseLastx, start.getY() + mouseLasty);
					} else if(frame.equals("game")) {
						mouseLastx = (int)mousePos.getX() - mouseLastx;
						mouseLasty = (int)mousePos.getY() - mouseLasty;
						TTF.setLocation(TTF.getX() + mouseLastx, TTF.getY() + mouseLasty);
					} else if(frame.equals("dif")) {
						mouseLastx = (int)mousePos.getX() - mouseLastx;
						mouseLasty = (int)mousePos.getY() - mouseLasty;
						dif.setLocation(dif.getX() + mouseLastx, dif.getY() + mouseLasty);
					}
				}
				first = false;
				mouseLastx = (int)mousePos.getX();
				mouseLasty = (int)mousePos.getY();
			}
		}
	}
	
	//Closes curent frame when called
	public void closeMe() {
		if(frame.equals("start")) {
			start.dispose();
		} else if(frame.equals("game")) {
			TTF.dispose();
		} else if(frame.equals("dif")) {
			dif.dispose();
		}
	}
	
	
	
	//AI button
	private class AI implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int x = start.getX();
			int y = start.getY();
			dif = new JFrame("Tic-Tac-Toe");
			dif.setLocation(x, y);
			playAgainst = "AI";
			closeMe();
			frame = "dif";
			dif();
		}
	}
	
	//Friend button
	private class friend implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int x = start.getX();
			int y = start.getY();
			TTF = new JFrame("Tic-Tac-Toe");
			TTF.setLocation(x, y);
			playAgainst = "friend";
			closeMe();
			frame = "game";
			TTTT();
		}
	}
	
	//All the buttons
	private class B1 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B1.getText().equals("X") && !B1.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B1.setSelected(false);
					B1.setForeground(Color.BLUE);
					B1.setText("X");
					board[0] = "X";
				} else if(turn) {
					turn = false;
					B1.setSelected(false);
					B1.setForeground(Color.RED);
					B1.setText("O");
					board[0] = "O";
				}
			}
		}
	}
	private class B2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B2.getText().equals("X") && !B2.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B2.setSelected(false);
					B2.setForeground(Color.BLUE);
					B2.setText("X");
					board[1] = "X";
				} else if(turn) {
					turn = false;
					B2.setSelected(false);
					B2.setForeground(Color.RED);
					B2.setText("O");
					board[1] = "O";
				}
			}
		}
	}
	private class B3 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B3.getText().equals("X") && !B3.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B3.setSelected(false);
					B3.setForeground(Color.BLUE);
					B3.setText("X");
					board[2] = "X";
				} else if(turn) {
					turn = false;
					B3.setSelected(false);
					B3.setForeground(Color.RED);
					B3.setText("O");
					board[2] = "O";
				}
			}
		}
	}
	private class B4 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B4.getText().equals("X") && !B4.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B4.setSelected(false);
					B4.setForeground(Color.BLUE);
					B4.setText("X");
					board[3] = "X";
				} else if(turn) {
					turn = false;
					B4.setSelected(false);
					B4.setForeground(Color.RED);
					B4.setText("O");
					board[3] = "O";
				}
			}
		}
	}
	private class B5 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B5.getText().equals("X") && !B5.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B5.setSelected(false);
					B5.setForeground(Color.BLUE);
					B5.setText("X");
					board[4] = "X";
				} else if(turn) {
					turn = false;
					B5.setSelected(false);
					B5.setForeground(Color.RED);
					B5.setText("O");
					board[4] = "O";
				}
			}
		}
	}
	private class B6 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B6.getText().equals("X") && !B6.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B6.setSelected(false);
					B6.setForeground(Color.BLUE);
					B6.setText("X");
					board[5] = "X";
				} else if(turn) {
					turn = false;
					B6.setSelected(false);
					B6.setForeground(Color.RED);
					B6.setText("O");
					board[5] = "O";
				}
			}
		}
	}
	private class B7 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B7.getText().equals("X") && !B7.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B7.setSelected(false);
					B7.setForeground(Color.BLUE);
					B7.setText("X");
					board[6] = "X";
				} else if(turn) {
					turn = false;
					B7.setSelected(false);
					B7.setForeground(Color.RED);
					B7.setText("O");
					board[6] = "O";
				}
			}
		}
	}
	private class B8 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B8.getText().equals("X") && !B8.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B8.setSelected(false);
					B8.setForeground(Color.BLUE);
					B8.setText("X");
					board[7] = "X";
				} else if(turn) {
					turn = false;
					B8.setSelected(false);
					B8.setForeground(Color.RED);
					B8.setText("O");
					board[7] = "O";
				}
			}
		}
	}
	private class B9 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(!B9.getText().equals("X") && !B9.getText().equals("O")) {
				if(!turn) {
					turn = true;
					B9.setSelected(false);
					B9.setForeground(Color.BLUE);
					B9.setText("X");
					board[8] = "X";
				} else if(turn) {
					turn = false;
					B9.setSelected(false);
					B9.setForeground(Color.RED);
					B9.setText("O");
					board[8] = "O";
				}
			}
		}
	}
}