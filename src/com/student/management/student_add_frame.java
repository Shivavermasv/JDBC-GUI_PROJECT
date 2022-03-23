package com.student.management;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class student_add_frame extends JFrame implements ActionListener {
	JLabel label1;
	JButton b1,b2,b3,b4,b5,b6,b7;
	
student_add_frame(){
	this.setBounds(200, 200, 500, 600);
	this.setVisible(true);
	this.setTitle("STUDENT_MANAGEMENT_PROGRAM");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	label1=new JLabel("WELCOME_TO_STUDENT_MANAGEMENT");
	label1.setBounds(100, 0, 300, 25);
	label1.setFont(new Font("verdana",Font.BOLD,20));
	label1.setDisplayedMnemonic(0);
	
	b1=new JButton("TAP TO ADD A STUDENT");
	b1.setBounds(130,100,260,30);
	b1.setFocusable(false);
	b1.addActionListener(this);
	
	b2=new JButton("TAP TO DISPLAY STUDENTS");
	b2.setBounds(130,150,260,30);
	b2.setFocusable(false);
	b2.addActionListener(this);
	
	b3=new JButton("TAP TO DISPLAY A STUDENT(ID)");
	b3.setBounds(130,200,260,30);
	b3.setFocusable(false);
	b3.addActionListener(this);
	
	b6=new JButton("TAP TO DISPLAY A STUDENT(NAME)");
	b6.setBounds(130,250,260,30);
	b6.setFocusable(false);
	b6.addActionListener(this);
	
	b4=new JButton("TAP TO DELETE A STUDENT(NAME)");
	b4.setBounds(130,300,260,30);
	b4.setFocusable(false);
	b4.addActionListener(this);
	
	b7=new JButton("TAP TO DELETE A STUDENT(ID)");
	b7.setBounds(130,350,260,30);
	b7.setFocusable(false);
	b7.addActionListener(this);
	
	b5=new JButton("TAP TO EXIT");
	b5.setBounds(180,400,150,40);
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
	if(e.getSource()==b1) {
		new add_frame();
	}
	if(e.getSource()==b2) {
		studentDao.show_Allstudents();
		new students_display();
		//studentDao.stud_clear();
	}
	if(e.getSource()==b3) {
		boolean b=studentDao.show_student(Integer.parseInt(JOptionPane.showInputDialog("ENTER STUDENT ID")));
		if(b) {
			JOptionPane.showMessageDialog(null, "NAME :"+studentDao.sdname+" "+
					"||PHONE :"+studentDao.sdphn+" "+
							"||CITY :"+studentDao.sdcity,"STUDENT",
							JOptionPane.INFORMATION_MESSAGE);	
		}
		else {
			JOptionPane.showMessageDialog(null,"NO SUCH DATA");
		}
	}
	if(e.getSource()==b6) {
		boolean b=studentDao.show_student(JOptionPane.showInputDialog("ENTER STUDENT NAME"));
		System.out.println(b);
		if(b) {
			JOptionPane.showMessageDialog(null, "NAME :"+studentDao.sdname+" "+
					"||PHONE :"+studentDao.sdphn+" "+
							"||CITY :"+studentDao.sdcity,"STUDENT",
							JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "NO SUCH DATA");
		}
	}
	if(e.getSource()==b4) {
		boolean b=studentDao.delete_studentfromDB(JOptionPane.showInputDialog("ENTER STUDENT NAME TO DELETE"));
		if(b) {
			JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
		}
		else {
			JOptionPane.showMessageDialog(null, "TRY AGAIN");
		}
	}
	if(e.getSource()==b7) {
		boolean b=studentDao.delete_studentfromDB(Integer.parseInt(
				JOptionPane.showInputDialog("ENTER STUDENT ID TO DELETE")));
		if(b) {
			JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
		}
		else {
			JOptionPane.showMessageDialog(null, "TRY AGAIN");
		}
	}
	if(e.getSource()==b5) {
		System.exit(0);
		this.dispose();
	}
	
	
}
}
