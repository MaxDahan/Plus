import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class workingCalculator {

	public  String value = "";
	public  ArrayList<Double> numList = new ArrayList<Double>();
	public  JFrame frame = new JFrame("Calculator");
	public  JPanel panel = new JPanel();
	public  JLabel label = new JLabel("0");
	
	public  Button b1 = new Button("1");
	public  Button b2 = new Button("2");
	public  Button b3 = new Button("3");
	public  Button b4 = new Button("4");
	public  Button b5 = new Button("5");
	public  Button b6 = new Button("6");
	public  Button b7 = new Button("7");
	public  Button b8 = new Button("8");
	public  Button b9 = new Button("9");
	public  Button b0 = new Button("0");
	
	public  boolean div = false; //used to see if dividing numbers
	public  boolean dotC = false; //dotC stands for dot Check to make sure not more than one dot is placed
	public  boolean mult = false;
	public  boolean ad = false; 
	public  boolean sub = false; 
	
	public  Button add = new Button("+");
	public  Button equals = new Button("=");
	public  Button divide = new Button("/");
	public  Button multiply = new Button("x");
	public  Button subtract = new Button("-");
	
	public  Button dot = new Button(".");
	public  Button clear = new Button("c");
	
	public workingCalculator() {
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 800);
		frame.setVisible(true);

		frame.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		Border border = BorderFactory.createLineBorder(Color.BLUE, 10);
		panel.setBorder(border);

		label.setFont(new Font("Forte", Font.BOLD, 65));
		label.setForeground(Color.WHITE);
		label.setBounds(25, 50, 460, 100);
		panel.add(label);
		
		b1.setForeground(Color.BLACK);
		b1.setBackground(Color.WHITE);
		b1.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b1.setBounds(25, 200, 80, 80);
		panel.add(b1);
		b1.addActionListener(new b1());
		
		b2.setForeground(Color.BLACK);
		b2.setBackground(Color.WHITE);
		b2.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b2.setBounds(145, 200, 80, 80);
		panel.add(b2);
		b2.addActionListener(new b2());
		
		b3.setForeground(Color.BLACK);
		b3.setBackground(Color.WHITE);
		b3.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b3.setBounds(265, 200, 80, 80);
		panel.add(b3);
		b3.addActionListener(new b3());
		
		b4.setForeground(Color.BLACK);
		b4.setBackground(Color.WHITE);
		b4.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b4.setBounds(385, 200, 80, 80);
		panel.add(b4);
		b4.addActionListener(new b4());
		
		b5.setForeground(Color.BLACK);
		b5.setBackground(Color.WHITE);
		b5.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b5.setBounds(25, 320, 80, 80);
		panel.add(b5);
		b5.addActionListener(new b5());
		
		b6.setForeground(Color.BLACK);
		b6.setBackground(Color.WHITE);
		b6.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b6.setBounds(145, 320, 80, 80);
		panel.add(b6);
		b6.addActionListener(new b6());
		
		b7.setForeground(Color.BLACK);
		b7.setBackground(Color.WHITE);
		b7.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b7.setBounds(265, 320, 80, 80);
		panel.add(b7);
		b7.addActionListener(new b7());
		
		b8.setForeground(Color.BLACK);
		b8.setBackground(Color.WHITE);
		b8.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b8.setBounds(385, 320, 80, 80);
		panel.add(b8);
		b8.addActionListener(new b8());
		
		b9.setForeground(Color.BLACK);
		b9.setBackground(Color.WHITE);
		b9.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b9.setBounds(145, 440, 80, 80);
		panel.add(b9);
		b9.addActionListener(new b9());
		
		b0.setForeground(Color.BLACK);
		b0.setBackground(Color.WHITE);
		b0.setFont(new Font("Cooper Black", Font.BOLD, 60));
		b0.setBounds(265, 440, 80, 80);
		panel.add(b0);
		b0.addActionListener(new b0());
		
		add.setForeground(Color.BLACK);
		add.setBackground(Color.WHITE);
		add.setFont(new Font("Cooper Black", Font.BOLD, 60));
		add.setBounds(25, 540, 80, 80);
		panel.add(add);
		add.addActionListener(new add());
		
		subtract.setForeground(Color.BLACK);
		subtract.setBackground(Color.WHITE);
		subtract.setFont(new Font("Cooper Black", Font.BOLD, 60));
		subtract.setBounds(25, 640, 80, 80);
		panel.add(subtract);
		subtract.addActionListener(new sub());
		
		divide.setForeground(Color.BLACK);
		divide.setBackground(Color.WHITE);
		divide.setFont(new Font("Cooper Black", Font.BOLD, 60));
		divide.setBounds(145, 540, 80, 80);
		panel.add(divide);
		divide.addActionListener(new divide());
		
		multiply.setForeground(Color.BLACK);
		multiply.setBackground(Color.WHITE);
		multiply.setFont(new Font("Cooper Black", Font.BOLD, 60));
		multiply.setBounds(265, 540, 80, 80);
		panel.add(multiply);
		multiply.addActionListener(new multiply());
		
		divide.setForeground(Color.BLACK);
		divide.setBackground(Color.WHITE);
		divide.setFont(new Font("Cooper Black", Font.BOLD, 60));
		divide.setBounds(145, 540, 80, 80);
		panel.add(divide);
		divide.addActionListener(new divide());
		
		equals.setForeground(Color.BLACK);
		equals.setBackground(Color.WHITE);
		equals.setFont(new Font("Cooper Black", Font.BOLD, 60));
		equals.setBounds(385, 540, 80, 80);
		panel.add(equals);
		equals.addActionListener(new equals());

		clear.setForeground(Color.BLACK);
		clear.setBackground(Color.WHITE);
		clear.setFont(new Font("Cooper Black", Font.BOLD, 60));
		clear.setBounds(25, 440, 80, 80);
		panel.add(clear);
		clear.addActionListener(new clear());
		
		dot.setForeground(Color.BLACK);
		dot.setBackground(Color.WHITE);
		dot.setFont(new Font("Cooper Black", Font.BOLD, 60));
		dot.setBounds(385, 440, 80, 80);
		panel.add(dot);
		dot.addActionListener(new dot());
	}
	
	public static void main(String[] args) {
		new workingCalculator();
	}
	
	public void closeMe() {
		frame.dispose();
	}
	
	 class b1 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "1";
			label.setText(value);
		}	
	}
	
	 class b2 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "2";
			label.setText(value);
		}	
	}
	
	 class b3 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "3";
			label.setText(value);
		}	
	}
	
	 class b4 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "4";
			label.setText(value);
		}	
	}
	
	 class b5 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "5";
			label.setText(value);
		}	
	}
	
	 class b6 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "6";
			label.setText(value);
		}	
	}
	
	 class b7 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "7";
			label.setText(value);
		}	
	}
	
	 class b8 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "8";
			label.setText(value);
		}	
	}
	
	 class b9 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "9";
			label.setText(value);
		}	
	}
	
	 class b0 implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			value = value + "0";
			label.setText(value);
		}	
	}
	
	 class add implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			div = false;
			ad = true;
			dotC = false;
			mult = false;
			sub = false;
			numList.add(Double.parseDouble(value));
			value = "";
			label.setText("0");
		}	
	}
	
	 class sub implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			div = false;
			ad = false;
			dotC = false;
			mult = false;
			sub = true;
			numList.add(Double.parseDouble(value));
			value = "";
			label.setText("0");
		}	
	}
	
	 class divide implements ActionListener { 
		@Override
		public void actionPerformed (ActionEvent e) {
			div = true;
			ad = false;
			mult = false;
			dotC = false;
			sub = false;
			numList.add(Double.parseDouble(value));
			value = "";
			label.setText("0");
		}	
	}
	
	 class multiply implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			mult = true;
			dotC = false;
			div = false;
			ad = false;
			sub = false;
			numList.add(Double.parseDouble(value));
			value = "";
			label.setText("0");
		}	
	}
	
	public  void addM() {
		double num = 0;
		for (int i = 0; i < numList.size(); i++) {
			num += numList.get(i);
		}
		if(Math.abs(num) - Math.abs((int)(num)) != 0) {
			dotC = true;
		}
		else {dotC = false;}
		value = "" + num;
		label.setText(value);
	}

	public  void subM() {
		double num = numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			num -= numList.get(i);
		}
		if(Math.abs(num) - Math.abs((int)(num)) != 0) {
			dotC = true;
		}
		else {dotC = false;}
		value = "" + num;
		label.setText(value);
	}
	
	public  void multM() {
		double answer = numList.get(0);
		for(int i = 1; i < numList.size(); i++) {
			answer *= numList.get(i);
		}
		if(Math.abs(answer) - Math.abs((int)(answer)) != 0) {
			dotC = true;
		}
		else {dotC = false;}
		value = answer + "";
		label.setText(value);
	}
	
	public  void divM() {
		double answer = numList.get(0);
		for(int i = 1; i < numList.size(); i++) {
			answer /= numList.get(i);
		}
		if(Math.abs(answer) - Math.abs((int)(answer)) != 0) {
			dotC = true;
		}
		else {dotC = false;}
		value = answer + "";
		label.setText(value);
	}
	
	 class equals implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			numList.add(Double.parseDouble(value));
			if (ad) {
				addM();
				numList.clear();
				numList.add(Double.parseDouble(value));
				value = "";
			}
			
			else if (sub) {
				subM();
				numList.clear();
				numList.add(Double.parseDouble(value));
				value = "";
			}
			
			else if(div) {
				divM();
				numList.clear();
				numList.add(Double.parseDouble(value));
				value = "";
			}
			
			else if(mult) {
				multM();
				numList.clear();
				numList.add(Double.parseDouble(value));
				value = "";
			}
		}
	}
	
	 class clear implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			dotC = false;
			numList.clear();
			value = "";
			label.setText("0");
		}	
	}
	
	 class dot implements ActionListener {
		@Override
		public void actionPerformed (ActionEvent e) {
			if(value.equals("")) {
				dotC = true;
				value = value + "0.";
				label.setText(value);
			}
			else if(!dotC) {
				dotC = true;
				value = value + ".";
				label.setText(value);
			}
		}	
	}
}