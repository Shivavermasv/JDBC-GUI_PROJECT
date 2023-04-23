package com.student.management;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class student_frame extends JFrame {
	JLabel label, label2, label3, label4;

	student_frame(String name, String phone, String city) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.setBounds(400, 500, 300, 140);
		this.setVisible(true);
		this.setTitle("STUDENT's DATA");
		Color ivory=new Color(255,255,208);
		this.getContentPane().setBackground(ivory);
		
		label = new JLabel("DATA OF THE STUDENT");
		label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));;
		label.setBounds(70, 5, 200, 20);

		label2 = new JLabel("NAME" + "  :" + name);
		label2.setBounds(100, 30, 200, 20);
		label2.setFont(new Font("consolas", Font.BOLD, 13));

		label3 = new JLabel("PHONE" + "  :" + phone);
		label3.setBounds(100, 50, 200, 20);
		label3.setFont(new Font("consolas", Font.BOLD, 13));

		label4 = new JLabel("CITY" + "  :" + city);
		label4.setBounds(100, 70, 200, 20);
		label4.setFont(new Font("consolas", Font.BOLD, 13));

		this.add(label);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.setLayout(null);
	}

	student_frame(String str) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		this.setBounds(400, 200, 300, 100);
		this.setVisible(true);
		this.setTitle("STUDENT's DATA");
		this.setBackground(Color.YELLOW);
		label = new JLabel(str);
		label.setBounds(75, 20, 200, 20);

		this.add(label);
		this.setLayout(null);
	}
}
