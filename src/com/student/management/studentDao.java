package com.student.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class studentDao {
	static String[] data= { "ID" , "ID" , "NAME" , "CONTACT" };
	static String [][] stud=new String[20][20];
	public static void stud_clear() {
		for(int I=0;I<stud.length;I++) {
			for(int j=0; j<stud.length;j++) {
				stud[I][j]="";
			}
		}
	}
	static int id;
	static String sdname ;
	static String sdphn ;
	static String sdcity ;
public static boolean insert_studenttoDB(student st) {
	boolean f=false;
	try {
		//jdbc code...
		Connection con =connection.createc();
		String query="INSERT INTO `Student` (`sname`,`sphone`,`scity`) VALUES (?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(query);
		//set the value of parameter 
		pstmt.setString(1,st.getStudentname());
		pstmt.setString(2,st.getStudentphn());
		pstmt.setString(3,st.getStudentcity());
		
		//excecute//
		pstmt.executeUpdate();
		f=true;
		
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	return f;
	
}
public static boolean delete_studentfromDB(int sid) {
	boolean d;
	
	try {
		Connection con=connection.createc();
		String query="DELETE FROM `student` WHERE `sid`=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setInt(1, sid);
		
		pstmt.executeUpdate();
		d=true;
	}
	catch(SQLException e) {
		e.printStackTrace();
		d=false;
	}
	
	
	return d;
}
public static boolean delete_studentfromDB(String sname) {
	boolean d;
	
	try {
		Connection con=connection.createc();
		String query="DELETE FROM `student` WHERE `sname`=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, sname);
		
		pstmt.executeUpdate();
		d=true;
	}
	catch(SQLException e) {
		e.printStackTrace();
		d=false;
	}
	
	
	return d;
}
public static void show_Allstudents() {
	
	try {
		Connection con=connection.createc();
		String query="SELECT * FROM `student`";
		Statement smnt=con.createStatement();
		ResultSet set=smnt.executeQuery(query);
	
		System.out.println("ID    NAME           PHN           CITY ");
		int i=0;
		while(set.next()) {
			int id=set.getInt(1);
			String sname=set.getString(2);
			String phn=set.getString(3);
			String city=set.getString(4);
			stud[i][1]=Integer.toString(id);
			stud[i][2]=sname;
			stud[i][3]=phn;
			stud[i][4]=city;
			i++;
		System.out.println(id+"    "+sname+"    "+phn+"    "+city);	
			
		}
		if(set.next()==false) {
			System.out.println("END_OF_DATA");
		}
		
	}
	catch(SQLException e) {
		e.printStackTrace();
		
	}
}
public static boolean show_student(String sname) {
	
	boolean s=true;
	try {
		Connection con=connection.createc();
		String query="SELECT * FROM `student` WHERE `sname`=?";
		PreparedStatement psmnt=con.prepareStatement(query);
		psmnt.setString(1, sname);
		ResultSet set=psmnt.executeQuery();
	
		System.out.println("ID    NAME           PHN           CITY ");
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String phn=set.getString(3);
			String city=set.getString(4);
			if(set.getString(2)==null) {
				System.out.println("END_OF_DATA");
				return s=false;
			}
		System.out.println(id+"    "+name+"    "+phn+"    "+city);	
		    studentDao.id=id;
		    sdname=name;
	        sdphn=phn;
	        sdcity=city;

		}
		//s=true;
	}
	catch(SQLException e) {
		e.printStackTrace();
		s=false;
	}
	return s;
}

public static boolean show_student(int id) {
	
	boolean s=false;
	try {
		Connection con=connection.createc();
		String query="SELECT * FROM `student` WHERE `sid`=?";
		PreparedStatement psmnt=con.prepareStatement(query);
		psmnt.setInt(1, id);
		ResultSet set=psmnt.executeQuery();
	
		System.out.println("ID    NAME           PHN           CITY ");

		while(set.next()) {
			int sid=set.getInt(1);
			String name=set.getString(2);
			String phn=set.getString(3);
			String city=set.getString(4);
			
		System.out.println(sid+"    "+name+"    "+phn+"    "+city);	
        sdname=name;
        sdphn=phn;
        sdcity=city;
		if(name==null) {
			System.out.println("END_OF_DATA");
			s=false;
		}
		s=true;
		}
		
	}
	catch(SQLException e) {
		e.printStackTrace();
		
	}
	return s;
}

}
