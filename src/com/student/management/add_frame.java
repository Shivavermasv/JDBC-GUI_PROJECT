package com.student.management;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class add_frame extends JFrame implements ActionListener{
	JLabel label1,l2,l3,l4,l5;
	JButton button;
	JTextField f1,f2,f3;
	
add_frame(){
	this.setBounds(400, 400, 400, 400);
	this.setVisible(true);
	this.setTitle("ENTER STUDENT DATA");
	//this.setDefaultCloseOperation(3);
	
	label1=new JLabel("ENTER STUDENT DATA");
	label1.setBounds(100, 0, 200, 20);
	label1.setFont(new Font("verdana",Font.LAYOUT_LEFT_TO_RIGHT,15));
	label1.setDisplayedMnemonic(0);
	
	l2=new JLabel("NAME OF STUDENT :");
	l2.setBounds(25,50,150,20);
	l2.setFont(new Font("verdana",Font.BOLD,12));
	f1=new JTextField();
	f1.setBounds(200,50,150,20);
	f1.setFont(new Font("consolas",Font.ITALIC,13));
	
	l3=new JLabel("CONTACT OF STUDENT :");
	l3.setBounds(25,100,150,20);
	l3.setFont(new Font("verdana",Font.BOLD,12));
	f2=new JTextField();
	f2.setBounds(200,100,150,20);
	f2.setFont(new Font("consolas",Font.BOLD,13));
	
	l4=new JLabel("CITY OF STUDENT :");
	l4.setBounds(25,150,150,20);
	l4.setFont(new Font("verdana",Font.BOLD,12));
	f3=new JTextField();
	f3.setBounds(200,150,150,20);
	f3.setFont(new Font("consolas",Font.ITALIC,13));
	
	button=new JButton("SUBMIT");
	button.setBounds(200,250,100,30);
	button.setFocusable(false);
	button.addActionListener(this);
	
	l5=new JLabel();
	l5.setBounds(25,300,150,20);
	l5.setFont(new Font("consolas",Font.PLAIN,10));
	
	this.add(label1);
	this.add(l2);
	this.add(f1);
	this.add(l3);
	this.add(f2);
	this.add(l4);
	this.add(f3);
	this.add(button);
	this.add(l5);
	this.setLayout(null);
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==button) {
		String sname=f1.getText();
		String sphn=f2.getText();
		String scity=f3.getText();
		if((f1.getText()!=null) && (f2.getText()!=null) && (f3.getText()!=null))
		{
			student st=new student(sname,sphn,scity);
			boolean ans=studentDao.insert_studenttoDB(st);
			if(ans) {
				l5.setText("STUDENT ADDED SUCCESFULLY");
				//System.out.println("----STUDENT ADDED SUCCESFULLY");
			}
			else {
				l5.setText("----TRY AGAIN.......");
				//System.out.println("----TRY AGAIN.......");
			}
		}
		else {
			l5.setText("FILL ALL THE FIELDS");
		}
		
	}
	
}
}
