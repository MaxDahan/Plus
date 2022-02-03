
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatTester {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Login");
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(300, 400);
    	
    	JPanel panel = new JPanel();
    	frame.add(panel);
    	panel.setLayout(null);
    	
    	JLabel name = new JLabel("Name");
    	name.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		name.setBounds(95, 30, 100, 30);
		panel.add(name);
		
		JTextField textName = new JTextField("", 20);
		textName.setBounds(40, 80, 200, 30);
		panel.add(textName);
		
    	JLabel otherName = new JLabel("Other Name");
    	otherName.setFont(new Font("Bauhaus 93", Font.BOLD, 25));
		otherName.setBounds(65, 120, 150, 20);
		panel.add(otherName);
    	
		JTextField textOName = new JTextField("", 20);
		textOName.setBounds(40, 160, 200, 30);
		panel.add(textOName);
		
		Button Login = new Button("Login");
		Login.setForeground(Color.BLACK);
		Login.setBackground(Color.WHITE);
		Login.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
		Login.setBounds(90, 200, 80, 80);
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String otherPort = "";
				String yName = "";
				String otherIP = "";
				String yourPort = "";
				String oName = "";
				
				Scanner saveFile = new Scanner("directory.txt");
				try {
					saveFile = new Scanner(new File(System.getProperty("user.dir") + "/data/ChatApp/directory.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				yName = textName.getText();
				oName = textOName.getText();
				String currentN = "";
				while(!currentN.equals(yName) && saveFile.hasNextLine()) {
					String line = saveFile.nextLine();
					Scanner lineScan = new Scanner(line);
					currentN = lineScan.next();	
					if(currentN.equals(yName)) {
						lineScan.next();
						yourPort = lineScan.next();
					}
				}
				currentN = "";
				while(!currentN.equals(oName) && saveFile.hasNextLine()) {
					String line = saveFile.nextLine();
					Scanner lineScan = new Scanner(line);
					currentN = lineScan.next();
					if(currentN.equals(oName)) {
						otherIP = lineScan.next();
						otherPort = lineScan.next();
						
					}
				}
				Profile me = new Profile(yName, "10.54.106.44", yourPort, true);
				Profile you = new Profile(oName, otherIP, otherPort, false);
				MainScreen chat = new MainScreen(me, you);
				chat.show();
				frame.dispose();
				}
		});
		panel.add(Login);
	}
}
	
