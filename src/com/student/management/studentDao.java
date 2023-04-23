package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class studentDao {
	// to store new student details in the database
	void insert_studenttoDB(student st) {
		try {
			// jdbc code...
			Connection con = connection.createc();
			String query = "INSERT INTO `Student` (`sname`,`sphone`,`scity`) VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			// set the value of parameter
			pstmt.setString(1, st.getStudentname());
			pstmt.setString(2, st.getStudentphn());
			pstmt.setString(3, st.getStudentcity());

			pstmt.executeUpdate();
			new student_frame("STUDENT ADDED SUCCESSFULLY !!");
		} catch (SQLException e) {
			e.printStackTrace();
			new student_frame("TRY AGAIN !!");
		}
	}

	// To Delete a student from the database using student id
	boolean delete_studentfromDB(int sid) {
		try {
			Connection con = connection.createc();
			String query = "DELETE FROM `student` WHERE `sid`=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sid);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// to delete a student from the database using name
	boolean delete_studentfromDB(String sname) {
		try {
			Connection con = connection.createc();
			String query = "DELETE FROM `student` WHERE `sname`=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, sname);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// to show all students
	void show_Allstudents() {
		try {
			Connection con = connection.createc();
			String query = "SELECT * FROM `student`";
			Statement smnt = con.createStatement();
			ResultSet set = smnt.executeQuery(query);

			if (!set.next()) {
				new student_frame("NO DATA IS PRESENT !!");
				return;
			}
			ArrayList<ArrayList<String>> list = new ArrayList<>();
			ArrayList<String> data;
			do {
				data = new ArrayList<>();
				data.add(set.getString(2));
				data.add(set.getString(3));
				data.add(set.getString(4));
				list.add(data);
			} while (set.next());
			String data_array[][] = new String[list.size()][3];
			int i = 0;
			for (ArrayList<String> l : list) {
				String arr[] = l.toString().split(",");
				int j = 0;
				for (String s : arr) {
					data_array[i][j] = s.replaceAll("[^a-zA-Z0-9]", "");
					j++;
				}
				i++;
			}
			String[] col_name = { "NAME", "PHN", "CITY" };

			new students_display(data_array, col_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// to show student details using student name
	void show_student(String sname) {
		try {
			Connection con = connection.createc();
			String query = "SELECT * FROM `student` WHERE `sname`=?";
			PreparedStatement psmnt = con.prepareStatement(query);
			psmnt.setString(1, sname);
			ResultSet set = psmnt.executeQuery();
			if (!set.next()) {
				new student_frame("STUDENT DOESNT EXIST !!");
				return;
			} else {
				new student_frame(set.getString(2), set.getString(3), set.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// to show student details using student id
	void show_student(int id) {
		try {
			Connection con = connection.createc();
			String query = "SELECT * FROM `student` WHERE `sid`=?";
			PreparedStatement psmnt = con.prepareStatement(query);
			psmnt.setInt(1, id);
			ResultSet set = psmnt.executeQuery();
			if (!set.next()) {
				new student_frame("STUDENT DOESNT EXIST !!");
				return;
			} else {
				new student_frame(set.getString(2), set.getString(3), set.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
