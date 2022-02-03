import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Planner {
       private static String[][] planner = new String[7][7];
       private JFrame frame = new JFrame("Weekly Planner");
       
       public Planner() {
           jFrame();
       }
       
       public static void main(String[] args) {
    	   new Planner();
       }
       
       public void jFrame() {
    	   frame.setSize(1100, 950);
    	   frame.setVisible(true);
    	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   
    	   JPanel panel = new JPanel();
    	   panel.setLayout(null);
    	   frame.add(panel);
    	   
    	   //ALL DAY LABELS
    	   JLabel mon = new JLabel("Monday");
    	   mon.setBounds(80, 50, 200, 60);
    	   mon.setFont(new Font("Arial", Font.BOLD, 20));
   		   mon.setForeground(Color.BLACK);
    	   panel.add(mon);
    	   
    	   JLabel tue = new JLabel("Tuesday");
    	   tue.setBounds(210, 50, 200, 60);
    	   tue.setFont(new Font("Arial", Font.BOLD, 20));
   		   tue.setForeground(Color.BLACK);
    	   panel.add(tue);
    	   
    	   JLabel wed = new JLabel("Wednesday");
    	   wed.setBounds(335, 50, 200, 60);
    	   wed.setFont(new Font("Arial", Font.BOLD, 20));
   		   wed.setForeground(Color.BLACK);
    	   panel.add(wed);
    	   
    	   JLabel thu = new JLabel("Thursday");
    	   thu.setBounds(470, 50, 200, 60);
    	   thu.setFont(new Font("Arial", Font.BOLD, 20));
   		   thu.setForeground(Color.BLACK);
    	   panel.add(thu);
    	   
    	   JLabel fri = new JLabel("Friday");
    	   fri.setBounds(620, 50, 200, 60);
    	   fri.setFont(new Font("Arial", Font.BOLD, 20));
   		   fri.setForeground(Color.BLACK);
    	   panel.add(fri);
    	   
    	   JLabel sat = new JLabel("Saturday");
    	   sat.setBounds(730, 50, 200, 60);
    	   sat.setFont(new Font("Arial", Font.BOLD, 20));
   		   sat.setForeground(Color.BLACK);
    	   panel.add(sat);
    	   
    	   JLabel sun = new JLabel("Sunday");
    	   sun.setBounds(870, 50, 200, 60);
    	   sun.setFont(new Font("Arial", Font.BOLD, 20));
   		   sun.setForeground(Color.BLACK);
    	   panel.add(sun);
    	   
    	   
    	   
    	   //ALL PERIOD LABELS
    	   JLabel p1 = new JLabel("P.1");
    	   p1.setBounds(20, 115, 200, 60);
    	   p1.setFont(new Font("Arial", Font.BOLD, 20));
   		   p1.setForeground(Color.BLACK);
    	   panel.add(p1);
    	   
    	   JLabel p2 = new JLabel("P.2");
    	   p2.setBounds(20, 200, 200, 60);
    	   p2.setFont(new Font("Arial", Font.BOLD, 20));
   		   p2.setForeground(Color.BLACK);
    	   panel.add(p2);
    	   
    	   JLabel p3 = new JLabel("P.3");
    	   p3.setBounds(20, 285, 200, 60);
    	   p3.setFont(new Font("Arial", Font.BOLD, 20));
   		   p3.setForeground(Color.BLACK);
    	   panel.add(p3);
    	   
    	   JLabel p4 = new JLabel("P.4");
    	   p4.setBounds(20, 370, 200, 60);
    	   p4.setFont(new Font("Arial", Font.BOLD, 20));
   		   p4.setForeground(Color.BLACK);
    	   panel.add(p4);
    	   
    	   JLabel p5 = new JLabel("P.5");
    	   p5.setBounds(20, 455, 200, 60);
    	   p5.setFont(new Font("Arial", Font.BOLD, 20));
   		   p5.setForeground(Color.BLACK);
    	   panel.add(p5);
    	   
    	   JLabel p6 = new JLabel("P.6");
    	   p6.setBounds(20, 540, 200, 60);
    	   p6.setFont(new Font("Arial", Font.BOLD, 20));
   		   p6.setForeground(Color.BLACK);
    	   panel.add(p6);
    	   
    	   JLabel p7 = new JLabel("P.7");
    	   p7.setBounds(20, 625, 200, 60);
    	   p7.setFont(new Font("Arial", Font.BOLD, 20));
   		   p7.setForeground(Color.BLACK);
    	   panel.add(p7);
    	   
    	   
    	   
    	   //P1 ALL DAYS
    	   JTextField p1M = new JTextField();
    	   p1M.setBounds(70, 115, 120, 80);
    	   panel.add(p1M);
    	   p1M.repaint();
    	   
    	   JTextField p1T = new JTextField();
    	   p1T.setBounds(200, 115, 120, 80);
    	   panel.add(p1T);
    	   p1T.repaint();
    	   
    	   JTextField p1W = new JTextField();
    	   p1W.setBounds(330, 115, 120, 80);
    	   panel.add(p1W);
    	   p1W.repaint();
    	   
    	   JTextField p1Th = new JTextField();
    	   p1Th.setBounds(460, 115, 120, 80);
    	   panel.add(p1Th);
    	   p1Th.repaint();
    	   
    	   JTextField p1F = new JTextField();
    	   p1F.setBounds(590, 115, 120, 80);
    	   panel.add(p1F);
    	   p1F.repaint();
    	   
    	   JTextField p1S = new JTextField();
    	   p1S.setBounds(720, 115, 120, 80);
    	   panel.add(p1S);
    	   p1S.repaint();
    	   
    	   JTextField p1Su = new JTextField();
    	   p1Su.setBounds(850, 115, 120, 80);
    	   panel.add(p1Su);
    	   p1Su.repaint();
    	   
    	   
    	   
    	   
    	   //ALL P2 DAYS
    	   JTextField p2M = new JTextField();
    	   p2M.setBounds(70, 200, 120, 80);
    	   panel.add(p2M);
    	   p2M.repaint();
    	   
    	   JTextField p2T = new JTextField();
    	   p2T.setBounds(200, 200, 120, 80);
    	   panel.add(p2T);
    	   p2T.repaint();
    	   
    	   JTextField p2W = new JTextField();
    	   p2W.setBounds(330, 200, 120, 80);
    	   panel.add(p2W);
    	   p2W.repaint();
    	   
    	   JTextField p2Th = new JTextField();
    	   p2Th.setBounds(460, 200, 120, 80);
    	   panel.add(p2Th);
    	   p2Th.repaint();
    	   
    	   JTextField p2F = new JTextField();
    	   p2F.setBounds(590, 200, 120, 80);
    	   panel.add(p2F);
    	   p2F.repaint();
    	   
    	   JTextField p2S = new JTextField();
    	   p2S.setBounds(720, 200, 120, 80);
    	   panel.add(p2S);
    	   p2S.repaint();
    	   
    	   JTextField p2Su = new JTextField();
    	   p2Su.setBounds(850, 200, 120, 80);
    	   panel.add(p2Su);
    	   p2Su.repaint();
    	   
    	   
    	   
    	   
    	   //ALL P3 DAYS
    	   JTextField p3M = new JTextField();
    	   p3M.setBounds(70, 285, 120, 80);
    	   panel.add(p3M);
    	   p3M.repaint();
    	   
    	   JTextField p3T = new JTextField();
    	   p3T.setBounds(200, 285, 120, 80);
    	   panel.add(p3T);
    	   p3T.repaint();
    	   
    	   JTextField p3W = new JTextField();
    	   p3W.setBounds(330, 285, 120, 80);
    	   panel.add(p3W);
    	   p3W.repaint();
    	   
    	   JTextField p3Th = new JTextField();
    	   p3Th.setBounds(460, 285, 120, 80);
    	   panel.add(p3Th);
    	   p3Th.repaint();
    	   
    	   JTextField p3F = new JTextField();
    	   p3F.setBounds(590, 285, 120, 80);
    	   panel.add(p3F);
    	   p3F.repaint();
    	   
    	   JTextField p3S = new JTextField();
    	   p3S.setBounds(720, 285, 120, 80);
    	   panel.add(p3S);
    	   p3S.repaint();
    	   
    	   JTextField p3Su = new JTextField();
    	   p3Su.setBounds(850, 285, 120, 80);
    	   panel.add(p3Su);
    	   p3Su.repaint();
    	   
    	   
    	   
    	   //ALL P4 DAYS
    	   JTextField p4M = new JTextField();
    	   p4M.setBounds(70, 370, 120, 80);
    	   panel.add(p4M);
    	   p4M.repaint();
    	   
    	   JTextField p4T = new JTextField();
    	   p4T.setBounds(200, 370, 120, 80);
    	   panel.add(p4T);
    	   p4T.repaint();
    	   
    	   JTextField p4W = new JTextField();
    	   p4W.setBounds(330, 370, 120, 80);
    	   panel.add(p4W);
    	   p4W.repaint();
    	   
    	   JTextField p4Th = new JTextField();
    	   p4Th.setBounds(460, 370, 120, 80);
    	   panel.add(p4Th);
    	   p4Th.repaint();
    	   
    	   JTextField p4F = new JTextField();
    	   p4F.setBounds(590, 370, 120, 80);
    	   panel.add(p4F);
    	   p4F.repaint();
    	   
    	   JTextField p4S = new JTextField();
    	   p4S.setBounds(720, 370, 120, 80);
    	   panel.add(p4S);
    	   p4S.repaint();
    	   
    	   JTextField p4Su = new JTextField();
    	   p4Su.setBounds(850, 370, 120, 80);
    	   panel.add(p4Su);
    	   p4Su.repaint();
    	   
    	   
    	   
    	   //ALL P5 DAYS
    	   JTextField p6M = new JTextField();
    	   p6M.setBounds(70, 455, 120, 80);
    	   panel.add(p6M);
    	   p6M.repaint();
    	   
    	   JTextField p6T = new JTextField();
    	   p6T.setBounds(200, 455, 120, 80);
    	   panel.add(p6T);
    	   p6T.repaint();
    	   
    	   JTextField p6W = new JTextField();
    	   p6W.setBounds(330, 455, 120, 80);
    	   panel.add(p6W);
    	   p6W.repaint();
    	   
    	   JTextField p6Th = new JTextField();
    	   p6Th.setBounds(460, 455, 120, 80);
    	   panel.add(p6Th);
    	   p6Th.repaint();
    	  
    	   JTextField p6F = new JTextField();
    	   p6F.setBounds(590, 455, 120, 80);
    	   panel.add(p6F);
    	   p6F.repaint();
    	   
    	   JTextField p6S = new JTextField();
    	   p6S.setBounds(720, 455, 120, 80);
    	   panel.add(p6S);
    	   p6S.repaint();
    	   
    	   JTextField p6Su = new JTextField();
    	   p6Su.setBounds(850, 455, 120, 80);
    	   panel.add(p6Su);
    	   p6Su.repaint();
    	   
    	   
    	   
    	   
    	   //ALL P6 DAYS
    	   JTextField p5M = new JTextField();
    	   p5M.setBounds(70, 540, 120, 80);
    	   panel.add(p5M);
    	   p5M.repaint();
    	   
    	   JTextField p5T = new JTextField();
    	   p5T.setBounds(200, 540, 120, 80);
    	   panel.add(p5T);
    	   p5T.repaint();
    	   
    	   JTextField p5W = new JTextField();
    	   p5W.setBounds(330, 540, 120, 80);
    	   panel.add(p5W);
    	   p5W.repaint();
    	   
    	   JTextField p5Th = new JTextField();
    	   p5Th.setBounds(460, 540, 120, 80);
    	   panel.add(p5Th);
    	   p5Th.repaint();
    	  
    	   JTextField p5F = new JTextField();
    	   p5F.setBounds(590, 540, 120, 80);
    	   panel.add(p5F);
    	   p5F.repaint();
    	   
    	   JTextField p5S = new JTextField();
    	   p5S.setBounds(720, 540, 120, 80);
    	   panel.add(p5S);
    	   p5S.repaint();
    	   
    	   JTextField p5Su = new JTextField();
    	   p5Su.setBounds(850, 540, 120, 80);
    	   panel.add(p5Su);
    	   p5Su.repaint();
    	   
    	   
    	   
    	   
       	   //ALL P7 DAYS
    	   JTextField p7M = new JTextField();
    	   p7M.setBounds(70, 625, 120, 80);
    	   panel.add(p7M);
    	   p7M.repaint();
    	   
    	   JTextField p7T = new JTextField();
    	   p7T.setBounds(200, 625, 120, 80);
    	   panel.add(p7T);
    	   p7T.repaint();
    	   
    	   JTextField p7W = new JTextField();
    	   p7W.setBounds(330, 625, 120, 80);
    	   panel.add(p7W);
    	   p7W.repaint();
    	   
    	   JTextField p7Th = new JTextField();
    	   p7Th.setBounds(460, 625, 120, 80);
    	   panel.add(p7Th);
    	   p7Th.repaint();
    	   
    	   JTextField p7F = new JTextField();
    	   p7F.setBounds(590, 625, 120, 80);
    	   panel.add(p7F);
    	   p7F.repaint();
    	   
    	   JTextField p7S = new JTextField();
    	   p7S.setBounds(720, 625, 120, 80);
    	   panel.add(p7S);
    	   p7S.repaint();
    	   
    	   JTextField p7Su = new JTextField();
    	   p7Su.setBounds(850, 625, 120, 80);
    	   panel.add(p7Su);
    	   p7Su.repaint();
    	   
    	   
    	   JLabel fileName = new JLabel("FileName");
    	   fileName.setBounds(140, 720, 200, 50);
    	   fileName.setFont(new Font("Arial", Font.BOLD, 30));
   		   fileName.setForeground(Color.BLACK);
    	   panel.add(fileName);
    	   
    	   JTextField name = new JTextField();
    	   name.setBounds(150, 760, 120, 80);
    	   panel.add(name);
    	   name.repaint();
    	   
    	   JButton save = new JButton("Save");
    	   save.setForeground(Color.BLACK);
   		   save.setBackground(Color.WHITE);
   		   save.setFont(new Font("Arial", Font.BOLD, 40));
   		   save.setBounds(300, 750, 150, 100);
   		   save.addActionListener(new ActionListener() {
   			   public void actionPerformed(ActionEvent e) {
   				   PrintStream out = null;
   				   String fName = name.getText();
   				   try {
   					   out = new PrintStream(new File(fName + ".txt"));
   				   } catch (FileNotFoundException e1) {
   					   e1.printStackTrace();
   				   }
   				   out.println(p1M.getText()); out.println(p1T.getText());out.println(p1W.getText()); out.println(p1Th.getText()); out.println(p1F.getText());out.println(p1S.getText()); out.println(p1Su.getText());
   				   out.println(p2M.getText()); out.println(p2T.getText());out.println(p2W.getText()); out.println(p2Th.getText()); out.println(p2F.getText());out.println(p2S.getText()); out.println(p2Su.getText());
   				   out.println(p3M.getText()); out.println(p3T.getText());out.println(p3W.getText()); out.println(p3Th.getText()); out.println(p3F.getText());out.println(p3S.getText()); out.println(p3Su.getText());
 				   out.println(p4M.getText()); out.println(p4T.getText());out.println(p4W.getText()); out.println(p4Th.getText()); out.println(p4F.getText());out.println(p4S.getText()); out.println(p4Su.getText());
 				   out.println(p5M.getText()); out.println(p5T.getText());out.println(p5W.getText()); out.println(p5Th.getText()); out.println(p5F.getText());out.println(p5S.getText()); out.println(p5Su.getText());
  				   out.println(p6M.getText()); out.println(p6T.getText());out.println(p6W.getText()); out.println(p6Th.getText()); out.println(p6F.getText());out.println(p6S.getText()); out.println(p6Su.getText());
  				   out.println(p7M.getText()); out.println(p7T.getText());out.println(p7W.getText()); out.println(p7Th.getText()); out.println(p7F.getText());out.println(p7S.getText()); out.println(p7Su.getText());
   			   }
   		   });
   		   panel.add(save);
   		   save.repaint();
   		   
   		   JButton load = new JButton("Load");
   		   load.setForeground(Color.BLACK);
		   load.setBackground(Color.WHITE);
		   load.setFont(new Font("Arial", Font.BOLD, 40));
		   load.setBounds(500, 750, 150, 100);
		   load.addActionListener(new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   try {
					   Scanner input = new Scanner (new File(name.getText() + ".txt"));
					   p1M.setText(input.nextLine()); p1T.setText(input.nextLine()); p1W.setText(input.nextLine()); p1Th.setText(input.nextLine()); p1F.setText(input.nextLine()); p1S.setText(input.nextLine()); p1Su.setText(input.nextLine());
					   p2M.setText(input.nextLine()); p2T.setText(input.nextLine()); p2W.setText(input.nextLine()); p2Th.setText(input.nextLine()); p2F.setText(input.nextLine()); p2S.setText(input.nextLine()); p2Su.setText(input.nextLine());
					   p3M.setText(input.nextLine()); p3T.setText(input.nextLine()); p3W.setText(input.nextLine()); p3Th.setText(input.nextLine()); p3F.setText(input.nextLine()); p3S.setText(input.nextLine()); p3Su.setText(input.nextLine());
					   p4M.setText(input.nextLine()); p4T.setText(input.nextLine()); p4W.setText(input.nextLine()); p4Th.setText(input.nextLine()); p4F.setText(input.nextLine()); p4S.setText(input.nextLine()); p4Su.setText(input.nextLine());
					   p5M.setText(input.nextLine()); p5T.setText(input.nextLine()); p5W.setText(input.nextLine()); p5Th.setText(input.nextLine()); p5F.setText(input.nextLine()); p5S.setText(input.nextLine()); p5Su.setText(input.nextLine());
					   p6M.setText(input.nextLine()); p6T.setText(input.nextLine()); p6W.setText(input.nextLine()); p6Th.setText(input.nextLine()); p6F.setText(input.nextLine()); p6S.setText(input.nextLine()); p6Su.setText(input.nextLine());
					   p7M.setText(input.nextLine()); p7T.setText(input.nextLine()); p7W.setText(input.nextLine()); p7Th.setText(input.nextLine()); p7F.setText(input.nextLine()); p7S.setText(input.nextLine()); p7Su.setText(input.nextLine());
				   } catch (FileNotFoundException e1) {
					   System.err.println("COULD NOT FIND FILE");
				   }
			   }
		   });
		   panel.add(load);
		   load.repaint();
       }	

       public void closeMe() {
    	   frame.dispose();
       }
}
