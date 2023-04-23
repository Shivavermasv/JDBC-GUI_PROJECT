package com.student.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class student_add_frame extends JFrame implements ActionListener {
	JLabel label1;
	JButton b1, b2, b3, b4, b5, b6, b7;
	Border border;

	student_add_frame() throws IOException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setUndecorated(true);
		this.setBounds(200, 200, 500, 550);
		this.setVisible(true);
		this.setTitle("STUDENT_MANAGEMENT_PROGRAM");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		// this.setUndecorated(true);

		label1 = new JLabel("WELCOME_TO_STUDENT_MANAGEMENT");
		label1.setForeground(Color.BLACK);
		label1.setBounds(20, 20, 450, 20);
		label1.setFont(new Font("verdana", Font.BOLD, 20));
		label1.setDisplayedMnemonic(0);

		b1 = new JButton("TAP TO ADD A STUDENT");
		b1.setBounds(130, 100, 260, 30);
		b1.setFocusable(false);
		b1.addActionListener(this);

		b2 = new JButton("TAP TO DISPLAY STUDENTS");
		b2.setBounds(130, 150, 260, 30);
		b2.setFocusable(false);
		b2.addActionListener(this);

		b3 = new JButton("TAP TO DISPLAY A STUDENT(ID)");
		b3.setBounds(130, 200, 260, 30);
		b3.setFocusable(false);
		b3.addActionListener(this);

		b6 = new JButton("TAP TO DISPLAY A STUDENT(NAME)");
		b6.setBounds(130, 250, 260, 30);
		b6.setFocusable(false);
		b6.addActionListener(this);

		b4 = new JButton("TAP TO DELETE A STUDENT(NAME)");
		b4.setBounds(130, 300, 260, 30);
		b4.setFocusable(false);
		b4.addActionListener(this);

		b7 = new JButton("TAP TO DELETE A STUDENT(ID)");
		b7.setBounds(130, 350, 260, 30);
		b7.setFocusable(false);
		b7.addActionListener(this);

		b5 = new JButton("TAP TO EXIT");
		b5.setBounds(180, 400, 150, 40);
		b5.setFocusable(false);
		b5.addActionListener(this);

		this.add(label1);
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b6);
		this.add(b4);
		this.add(b5);
		this.add(b7);
		this.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// to add a student
		if (e.getSource() == b1) {
			new add_frame();
		}

		// to display a student
		if (e.getSource() == b2) {
			studentDao obj = new studentDao();
			obj.show_Allstudents();
			// studentDao.stud_clear();
		}

		// to display student using student's id
		if (e.getSource() == b3) {
			studentDao obj = new studentDao();
			String str = JOptionPane.showInputDialog("ENTER STUDENT ID");
			while (!Character.isDigit(str.toString().charAt(0)) && str != null) {
				str = JOptionPane.showInputDialog("ENTER VALID STUDENT ID");
			}
			if (str != null) {
				obj.show_student(Integer.parseInt(str));
			}
		}

		// to display student details using student name
		if (e.getSource() == b6) {
			studentDao obj = new studentDao();
			String str = JOptionPane.showInputDialog("ENTER STUDENT NAME");
			while (str != null && !str.matches("[a-zA-Z ]+")) {
				str = JOptionPane.showInputDialog("ENTER VALID STUDENT NAME");
			}
			if (str != null) {
				obj.show_student(str);
			}
		}

		// to delete a student from database using student name
		if (e.getSource() == b4) {
			studentDao obj = new studentDao();
			String str = JOptionPane.showInputDialog("ENTER STUDENT NAME TO DELETE");
			while (str != null && !str.matches("[a-zA-Z ]+")) {
				str = JOptionPane.showInputDialog("ENTER VALID STUDENT NAME");
			}
			if (str != null) {
				boolean b = obj.delete_studentfromDB(str);
				if (b) {
					JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
				} else {
					JOptionPane.showMessageDialog(null, "TRY AGAIN");
				}
			}
		}

		// to delete a student from database using student id
		if (e.getSource() == b7) {
			studentDao obj = new studentDao();
			String str = JOptionPane.showInputDialog("ENTER STUDENT NAME TO DELETE");
			while (!Character.isDigit(str.toString().charAt(0)) && str != null) {
				str = JOptionPane.showInputDialog("ENTER VALID STUDENT ID");
			}
			if (str != null) {
				boolean b = obj.delete_studentfromDB(Integer.parseInt(str));
				if (b) {
					JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
				} else {
					JOptionPane.showMessageDialog(null, "TRY AGAIN");
				}
			}
		}

		// exit
		if (e.getSource() == b5) {
			System.out.println("thank_you_for_using_this_program");
			System.exit(0);
			this.dispose();
		}

	}
}
