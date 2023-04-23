package com.student.management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

@SuppressWarnings({ "serial" })
public class add_frame extends JFrame implements ActionListener {
	JLabel label1, l2, l22, l3, l32, l4, l42, l5;
	JButton button;
	JTextField f1, f2, f3;

	add_frame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.setUndecorated(true);
		this.setBounds(400, 300, 400, 300);
		this.setVisible(true);
		this.setTitle("ENTER STUDENT DATA");
		this.getContentPane().setBackground(Color.YELLOW);

		label1 = new JLabel("ENTER STUDENT DATA");
		label1.setForeground(Color.BLACK);
		label1.setBounds(100, 10, 200, 20);
		label1.setFont(new Font("verdana", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		label1.setDisplayedMnemonic(0);

		l2 = new JLabel("NAME OF STUDENT :");
		l2.setBounds(25, 50, 150, 20);
		l22 = new JLabel();
		l22.setBounds(25, 70, 150, 20);
		l2.setFont(new Font("verdana", Font.BOLD, 12));
		f1 = new JTextField();
		f1.setBounds(200, 50, 150, 20);
		f1.setFont(new Font("consolas", Font.ITALIC, 13));
		f1.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= 'A' || ke.getKeyChar() >= 'a')
						&& (ke.getKeyChar() <= 'Z' || ke.getKeyChar() <= 'z')) {
					f1.setEditable(true);
					l22.setText("");
				} else {
					f1.setEditable(true);
					l22.setText("* Enter only alphabets");
				}
			}
		});

		l3 = new JLabel("CONTACT OF STUDENT :");
		l32 = new JLabel();
		l3.setBounds(25, 100, 150, 20);
		l32.setBounds(25, 120, 150, 20);
		l3.setFont(new Font("verdana", Font.BOLD, 12));
		f2 = new JTextField();
		f2.setBounds(200, 100, 150, 20);
		f2.setFont(new Font("consolas", Font.BOLD, 13));
		f2.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
					f2.setEditable(true);
					l32.setText("");
				} else {
					f2.setEditable(true);
					l32.setText("* Enter only numeric digits(0-9)");
				}
			}
		});

		l4 = new JLabel("CITY OF STUDENT :");
		l4.setBounds(25, 150, 150, 20);
		l42 = new JLabel();
		l42.setBounds(25, 170, 150, 20);
		l4.setFont(new Font("verdana", Font.BOLD, 12));
		f3 = new JTextField();
		f3.setBounds(200, 150, 150, 20);
		f3.setFont(new Font("consolas", Font.ITALIC, 13));
		f3.addKeyListener((KeyListener) new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if ((ke.getKeyChar() >= 'A' || ke.getKeyChar() >= 'a')
						&& (ke.getKeyChar() <= 'Z' || ke.getKeyChar() <= 'z')) {
					f3.setEditable(true);
					l42.setText("");
				} else {
					f3.setEditable(true);
					l42.setText("* Enter only alphabets");
				}
			}
		});

		button = new JButton("SUBMIT");
		button.setBounds(150, 200, 100, 30);
		button.setFocusable(false);
		button.addActionListener(this);

		l5 = new JLabel();
		l5.setBounds(25, 300, 150, 20);
		l5.setFont(new Font("consolas", Font.PLAIN, 10));

		this.add(label1);
		this.add(l2);
		this.add(l22);
		this.add(f1);
		this.add(l3);
		this.add(l32);
		this.add(f2);
		this.add(l4);
		this.add(l42);
		this.add(f3);
		this.add(button);
		this.add(l5);
		this.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button && (!f1.getText().equals("")) && (!f2.getText().equals(""))
				&& (!f3.getText().equals(""))) {
			String sname = f1.getText();
			String sphn = f2.getText();
			String scity = f3.getText();
			student st = new student(sname, sphn, scity);
			studentDao obj = new studentDao();
			obj.insert_studenttoDB(st);
			this.dispose();

		} else {
			l5.setText("FILL ALL THE FIELDS");
		}

	}
}
