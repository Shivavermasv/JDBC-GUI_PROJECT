package com.student.management;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class students_display extends JFrame implements ActionListener{
	JLabel label;
	JTable table;
	JScrollPane sp;
	JButton button;
	students_display(){
	this.setBounds(400, 300, 500, 500);
	this.setTitle("STUDENTS DATA");
	this.setVisible(true);
	label=new JLabel("STUDENTS DATA TABLE:");
	label.setBounds(50,0,300,20);
	label.setFont(new Font("consolas",Font.BOLD,20));
	
	table=new JTable(studentDao.stud,studentDao.data);
	table.setBounds(10,30,400,400);
	table.setName("students");
	
	
	sp=new JScrollPane(table);
	sp.setBounds(10,30,400,400);
	
	button=new JButton("REFRESH");
	button.setBounds(150,430,100,25);
	button.addActionListener(this);
	
	this.add(label);
	this.add(sp,BorderLayout.CENTER);
	//this.pack();
	this.setLayout(null);
	this.setVisible(true);
	this.add(button);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button) {
			studentDao.stud_clear();
		}
	}
}
