import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Plus implements KeyListener {
	public static void main(String[] args) {
		new Plus();
	}
	public Plus() {
		
		f_plus.setUndecorated(true);
		f_plus.setLocation(1845, 0);
		f_plus.setSize(75, 75);
		f_plus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f_plus.setAlwaysOnTop(true);
		f_plus.setVisible(true);
		f_plus.addKeyListener(this);
		
		File file = new File("data\\BLOBS\\plus.png");
		String path = file.getAbsolutePath();
		file = new File(path);
	    BufferedImage image = null;
	    try {image = ImageIO.read(file);} catch (IOException e1) {e1.printStackTrace();}
	    plus = new JLabel(new ImageIcon(image));
	    f_plus.getContentPane().add(plus);
	    f_plus.pack();
	    
	    plus.addMouseListener(new mouseAdapt());
	}
	
	
	//BUTTONS TO OPEN APPS
	//Used for tic-tac-to button
	private class ttt implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				if(ttt_but.getText().equals("Open")) {
					open_apps[4] = true;
					ttt_but.setText("Close");
					ttt = new TTT();
				} else if(ttt_but.getText().equals("Close")) {
					open_apps[4] = false;
					ttt_but.setText("Open");
					ttt.closeMe();
				}
			}
		}
	//Used for calculator button
	private class calc implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(calc_but.getText().equals("Open")) {
				open_apps[0] = true;
				calc_but.setText("Close");
				try {
					calccc = new EZCmain(false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if(calc_but.getText().equals("Close")) {
				open_apps[0] = false;
				calc_but.setText("Open");
				calccc.closeMe();
			}
		}
	}
	//Used for agenda button
	private class chatapp implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(chatapp_but.getText().equals("Open")) {
				open_apps[3] = true;
				chatapp_but.setText("Close");
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
							ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
							ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
							ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null,
							ex);
				}
				// </editor-fold>

				/* Create and display the form */
				java.awt.EventQueue.invokeLater(new Runnable() {
					public void run() {
						chatapp = new MainScreen();
						chatapp.setVisible(true);
					}
				});
				
				chatapp = new MainScreen();
			} else if(chatapp_but.getText().equals("Close")) {
				open_apps[3] = false;
				chatapp_but.setText("Open");
				chatapp.closeMe();
			}
		}
	}
	//Used for agenda button
	private class agenda implements ActionListener {
			public void actionPerformed (ActionEvent e) {
				if(agenda_but.getText().equals("Open")) {
					open_apps[1] = true;
					agenda_but.setText("Close");
					agenda = new Planner();
				} else if(agenda_but.getText().equals("Close")) {
					open_apps[1] = false;
					agenda_but.setText("Open");
					agenda.closeMe();
				}
			}
		}
	//Used for snow ball button
	private class Snowball implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if(snowball_but.getText().equals("Open")) {
				open_apps[2] = true;
				snowball_but.setText("Close");
				snowball_thrd_snd = new sound();
				snowball_thrd_snd.start();
				try {snowball = new Main();} catch (Exception e1) {e1.printStackTrace();}
				snowball_thrd.start();
			} else if(snowball_but.getText().equals("Close")) {
				open_apps[2] = false;
				snowball_thrd.stop();
				snowball_thrd_snd.stop();
				clip.close();
				snowball_but.setText("Open");
				snowball.closeMe();
			}
		}
	}	
	
	
	//BASIC FUNCTIONS
	//Mouse press and release
	public class mouseAdapt extends MouseAdapter {
		private int lastX = 0; private int lastY = 0;
		private Thread move_plus = new Thread();
    	private Thread plus_follow = new Thread();
        public void mousePressed(MouseEvent e) {
        	lastX = f_plus.getX(); lastY = f_plus.getY();
        	move_plus = new move_plus();
        	plus_follow = new plus_follow();
        	move_plus.start();
        	plus_follow.start();
        }
        public void mouseReleased(MouseEvent e) {
        	plus_follow.stop();
        	move_plus.stop();
        	lastX = Math.abs(lastX - f_plus.getX());
        	lastY = Math.abs(lastY - f_plus.getY());
        	if(plus_hold_timer <= 2) {
        		if(lastX <= 5 && lastY <= 5) {
        		//when you click plus to expand
        		if(f_plus.getWidth() <= 80) {
        			//Adding in minus picture
        			f_plus.getContentPane().remove(plus);
        			File file = new File("data\\BLOBS\\minus.png");
					String path = file.getAbsolutePath();
					file = new File(path);
        	    	BufferedImage image = null;
        	    	try {
        	    		image = ImageIO.read(file);
        			} catch (IOException e1) {
        				e1.printStackTrace();
        			}
        	    	plus = new JLabel(new ImageIcon(image));
        	    	f_plus.getContentPane().add(plus);
        	    	
        	    	//Reseting frame
        	    	go = true;
        			f_plus.setLayout(null);
        			int x = f_plus.getX();
        			int y = f_plus.getY();
        			f_plus.setSize(200, 400);
        			f_plus.setLocation(x - 120, y);
        			f_plus.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        			plus.setBounds(115, 0, 75, 75);
        		    plus.removeMouseListener(mouseAdapt);
        		    plus.addMouseListener(mouseAdapt);
        		    
        		    //Welcome word
        		    welcome.setFont(new Font("arial", Font.BOLD, 23));
        		    welcome.setForeground(Color.BLACK);
        		    f_plus.getContentPane().add(welcome);
        		    welcome.setBounds(5, 12, 100, 15);
        		    
        		    //To plus words
        		    to_plus.setFont(new Font("arial", Font.BOLD, 26));
        		    to_plus.setForeground(Color.BLACK);
        		    f_plus.getContentPane().add(to_plus);
        		    to_plus.setBounds(4, 40, 120, 25);
        		    
        		    //Calculator button and label
        		    calc_but.setForeground(Color.BLUE);
        		    calc_but.setBackground(Color.WHITE);
        		    calc_but.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        		    calc_but.setFont(new Font("arial", Font.BOLD, 17));
        		    calc_but.setBounds(125, 90, 57, 20);
        		    if(open_apps[0]) {
        		    	calc_but.setText("Close");
        		    } else if(!open_apps[0]) {
        		    	calc_but.setText("Open");
        		    }
        		    f_plus.getContentPane().add(calc_but);
        		    calc_but.removeActionListener(calcClass);
        		    calc_but.addActionListener(calcClass);
        		    
        		    calc.setForeground(Color.BLACK);
        		    calc.setFont(new Font("arial", Font.BOLD, 20));
        		    calc.setBounds(7, 89, 100, 20);
        		    f_plus.getContentPane().add(calc);
        		    
        		    //agenda button and label
        		    agenda_but.setForeground(Color.BLUE);
        		    agenda_but.setBackground(Color.WHITE);
        		    agenda_but.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        		    agenda_but.setFont(new Font("arial", Font.BOLD, 17));
        		    agenda_but.setBounds(125, 130, 57, 20);
        		    if(open_apps[1]) {
        		    	agenda_but.setText("Close");
        		    } else if(!open_apps[1]) {
        		    	agenda_but.setText("Open");
        		    }
        		    f_plus.getContentPane().add(agenda_but);
        		    agenda_but.removeActionListener(agendaClass);
        		    agenda_but.addActionListener(agendaClass);
        		    
        		    agenda_txt.setForeground(Color.BLACK);
        		    agenda_txt.setFont(new Font("arial", Font.BOLD, 20));
        		    agenda_txt.setBounds(20, 129, 100, 25);
        		    f_plus.getContentPane().add(agenda_txt);
        		    
        		    //snowball button and label
        		    snowball_but.setForeground(Color.BLUE);
        		    snowball_but.setBackground(Color.WHITE);
        		    snowball_but.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        		    snowball_but.setFont(new Font("arial", Font.BOLD, 17));
        		    snowball_but.setBounds(125, 170, 57, 20);
        		    if(open_apps[2]) {
        		    	snowball_but.setText("Close");
        		    } else if(!open_apps[2]) {
        		    	snowball_but.setText("Open");
        		    }
        		    f_plus.getContentPane().add(snowball_but);
        		    snowball_but.removeActionListener(snowballClass);
        		    snowball_but.addActionListener(snowballClass);
        		    
        		    snowball_txt.setForeground(Color.BLACK);
        		    snowball_txt.setFont(new Font("arial", Font.BOLD, 20));
        		    snowball_txt.setBounds(15, 169, 100, 25);
        		    f_plus.getContentPane().add(snowball_txt);
        		    
        		  //chatapp button and label
        		    chatapp_but.setForeground(Color.BLUE);
        		    chatapp_but.setBackground(Color.WHITE);
        		    chatapp_but.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        		    chatapp_but.setFont(new Font("arial", Font.BOLD, 17));
        		    chatapp_but.setBounds(125, 210, 57, 20);
        		    if(open_apps[3]) {
        		    	chatapp_but.setText("Close");
        		    } else if(!open_apps[3]) {
        		    	chatapp_but.setText("Open");
        		    }
        		    f_plus.getContentPane().add(chatapp_but);
        		    chatapp_but.removeActionListener(chatappClass);
        		    chatapp_but.addActionListener(chatappClass);
        		    
        		    chatapp_txt.setForeground(Color.BLACK);
        		    chatapp_txt.setFont(new Font("arial", Font.BOLD, 20));
        		    chatapp_txt.setBounds(16, 209, 100, 25);
        		    f_plus.getContentPane().add(chatapp_txt);
        		    
        		  //tic-tac-to button and label
        		    ttt_but.setForeground(Color.BLUE);
        		    ttt_but.setBackground(Color.WHITE);
        		    ttt_but.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        		    ttt_but.setFont(new Font("arial", Font.BOLD, 17));
        		    ttt_but.setBounds(125, 250, 57, 20);
        		    if(open_apps[4]) {
        		    	ttt_but.setText("Close");
        		    } else if(!open_apps[4]) {
        		    	ttt_but.setText("Open");
        		    }
        		    f_plus.getContentPane().add(ttt_but);
        		    ttt_but.removeActionListener(tttClass);
        		    ttt_but.addActionListener(tttClass);
        		    
        		    ttt_txt.setForeground(Color.BLACK);
        		    ttt_txt.setFont(new Font("arial", Font.BOLD, 20));
        		    ttt_txt.setBounds(8, 249, 150, 25);
        		    f_plus.getContentPane().add(ttt_txt);
        		    
        		} else if(f_plus.getWidth() > 80) { //when you click minus to close
        			f_plus.getContentPane().removeAll();
        			File file = new File("data\\BLOBS\\plus.png");
					String path = file.getAbsolutePath();
        			file = new File(path);
        	    	BufferedImage image = null;
        	    	try {
        	    		image = ImageIO.read(file);
        			} catch (IOException e1) {
        				e1.printStackTrace();
        			}
        	    	plus = new JLabel(new ImageIcon(image));
        	    	f_plus.getContentPane().add(plus);
        	    	f_plus.setSize(80, 80);
        			f_plus.setLayout(null);
        			int x = f_plus.getX();
        			int y = f_plus.getY();
        			f_plus.setLocation(x + 120, y);
        			plus.setBounds(0, 0, 75, 75);
        			plus.removeMouseListener(mouseAdapt);
        		    plus.addMouseListener(mouseAdapt);
        		}
        	}
        	}
        	mouseLastx = 0;
        	mouseLasty = 0;
        	plus_hold_timer = 0;
        }
	}
	//Makes the plus frame follow your cursor
	private class plus_follow extends Thread {
		private boolean first = true;
		public void run() {
			while(true) {
				try {Thread.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
				Point mousePos = MouseInfo.getPointerInfo().getLocation();
				if(!first) {
					mouseLastx = (int)mousePos.getX() - mouseLastx;
					mouseLasty = (int)mousePos.getY() - mouseLasty;
					f_plus.setLocation(f_plus.getX() + mouseLastx, f_plus.getY() + mouseLasty);
				}
				first = false;
				mouseLastx = (int)mousePos.getX();
				mouseLasty = (int)mousePos.getY();
			}
		}
	}
	//Helper class for plus_follow
	private class move_plus extends Thread {
		public void run() {
			while(true) {
				plus_hold_timer++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//Sound
	private class sound extends Thread {
		public void run() {
			try {
			    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("data\\Snowball\\MUSAC.wav").getAbsoluteFile());
		        clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.loop(9999);
			} catch (Exception e) {e.printStackTrace();}
		}
	}


	
	//FIELDS
	private JFrame f_plus = new JFrame("PLUS");
	//Function classes
	private mouseAdapt mouseAdapt = new mouseAdapt();
	private Clip clip = null;
	//Button Classes
	private Snowball snowballClass = new Snowball(); private Thread snowball_thrd = new Thread(), snowball_thrd_snd = new Thread();
	private agenda agendaClass = new agenda();
	private calc calcClass = new calc();
	private chatapp chatappClass = new chatapp();
	private ttt tttClass = new ttt();	
	//App classes
	private TTT ttt = null;
	private MainScreen chatapp = null;
	private Main snowball = null;
	private Planner agenda = null;
	private EZCmain calccc = null;
	//Booleans
	private boolean go = false, go2 = false;
	//Integers
	private int plus_hold_timer = 0, mouseLastx = 0, mouseLasty = 0;
	//All of the JLabels
	private JLabel ttt_txt = new JLabel("Tic-Tac-Toe"), chatapp_txt = new JLabel("ChatApp"), agenda_txt = new JLabel("Agenda"), to_plus = new JLabel("To Plus!"); 
	private JLabel welcome = new JLabel("Welcome"), calc = new JLabel("Calculator"), snowball_txt = new JLabel("Snowball"), plus = new JLabel("BOI");
	//All of the JButtons
	private JButton ttt_but = new JButton("Open"), chatapp_but = new JButton("Open"), snowball_but = new JButton("Open"), calc_but = new JButton("Open");
	private JButton agenda_but = new JButton("Open");
	//Array of booleans to see all open apps   |   Calculator, agenda, snowball, chatapp, tic-tac-to
	private boolean[] open_apps = new boolean[5];
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} 
	}
	public void keyReleased(KeyEvent e) {}
}