package com.student.management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class students_display extends JFrame implements ActionListener {
	JLabel label;
	JTable table;
	JScrollPane sp;
	JButton button;

	students_display(String data[][], String col[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setBounds(400, 300, 500, 500);
		this.setTitle("STUDENTS DATA");
		this.setVisible(true);
		this.getContentPane().setBackground(Color.YELLOW);
		label = new JLabel("STUDENTS DATA TABLE:");
		label.setBounds(125, 10, 300, 20);
		label.setFont(new Font("consolas", Font.BOLD, 20));

		Color ivory = new Color(255, 255, 208);
		table = new JTable(data, col);
		table.setName("students");
		table.setAutoscrolls(true);
		table.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
		table.getTableHeader().setBackground(ivory);

		sp = new JScrollPane(table);
		sp.setBounds(45, 30, 400, 400);
		sp.getViewport().setBackground(Color.YELLOW);

		button = new JButton("REFRESH");
		button.setBounds(200, 430, 100, 25);
		button.addActionListener(this);

		this.add(label);
		this.add(sp, BorderLayout.CENTER);
		this.setLayout(null);
		this.setVisible(true);
		this.add(button);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			studentDao obj = new studentDao();
			this.dispose();
			obj.show_Allstudents();
		}
	}
}
