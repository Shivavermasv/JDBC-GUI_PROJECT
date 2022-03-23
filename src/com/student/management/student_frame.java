package com.student.management;

import javax.swing.*;

public class student_frame extends JFrame {
	JLabel label,label2,label3,label4;
student_frame(){
	this.setBounds(400, 400, 300, 100);
	this.setVisible(true);
	this.setTitle("STUDENT's DATA");
	label=new JLabel("DATA OF THE STUDENT");
	label.setBounds(100,0,200,20);
	
    label2=new JLabel("NAME"+"  :"+studentDao.sdname);
    label2.setBounds(100,40,200,20);
    
    label3=new JLabel("PHONE"+"  :"+studentDao.sdphn);
    label3.setBounds(100,60,200,20);
    
    label4=new JLabel("CITY"+"  :"+studentDao.sdcity);
    label4.setBounds(100,80,200,20);
	
	this.add(label);
	this.add(label2);
	this.add(label3);
	this.add(label4);
	this.setLayout(null);
}
}
