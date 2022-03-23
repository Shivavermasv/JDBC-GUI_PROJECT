package com.student.management;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class start {
public static void main(String[] args) throws Exception {
	InputStreamReader is=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(is);
	new student_add_frame();
	System.out.println("WELCOME_TO_STUDENT_MANGEMENT");
	System.out.println("++++++++++++++++++++++++++++");
	while(true) {
		System.out.println("->PRESS 1 TO ADD A STUDENT");
		System.out.println("->PRESS 2 TO DELELTE A STUDENT");
		System.out.println("->PRESS 3 TO DISPLAY A STUDENT");
		System.out.println("->PRESS 4 TO EXIT THE PROGRAM");
		int c=Integer.parseInt(br.readLine());
		if (c==1) {
			//add student//
			System.out.println("-->ENTER NAME OF STUDENT");
			String sname=br.readLine();
			
			
			System.out.println("-->ENETR STUDENT PHN_NO.");
			String sphn=br.readLine();
			
			System.out.println("-->ENETR STUDENT CITY");  
			String scity=br.readLine();
			//creating an obj of class student//
			student st=new student(sname,sphn,scity);
			boolean ans=studentDao.insert_studenttoDB(st);
			if(ans) {
				System.out.println("----STUDENT ADDED SUCCESFULLY");
			}
			else {
				System.out.println("----TRY AGAIN.......");
			}
			//System.out.println(st);
			}
		else if(c==2) {
			//Delete student//
			System.out.println("-->ENTER STUDENT ID OR NAME");
			System.out.println("---->FOR ID ENTER 1 OR ENTER 0 FOR NAME ");
			int op=Integer.parseInt(br.readLine());
			if(op==1) {
				System.out.println("----->ENTER STUDENT ID:");
				int sid=Integer.parseInt(br.readLine());
				boolean d=studentDao.delete_studentfromDB(sid);
				if(d) {
					System.out.println("------DATA SUCCESFULLY DELETED!!");
				}
				else {
					System.out.println("------TRY AGAIN WITH VALID INFO....");
				}
			}
			if(op==0) {
				System.out.println("---->ENTER STUDENT NAME:");
				String sname=br.readLine();
				boolean dn=studentDao.delete_studentfromDB(sname);
				if(dn) {
					System.out.println("--------DATA SUCCESFULLY DELETED!!");
				}
				else {
					System.out.println("--------TRY AGAIN WITH VALID INFO....");
				}
			}
			
			
		}
		
		else if (c==3) {
			//display student//
		System.out.println("-->FOR ALL STUDENTS ENTER 1 OR 0 FOR A PARTICULAR STUDENT:");
		int s=Integer.parseInt(br.readLine());
		if(s==1) {
			studentDao.show_Allstudents();
		}
		if(s==0) {
			System.out.println("---->ENTER STUDENT ID OR NAME:");
			System.out.println("------>1 FOR ID 0 FOR NAME ");
			int k=Integer.parseInt(br.readLine());
			if(k==0) {
				System.out.println("------>ENTER STUDENT NAME:");
				String name=br.readLine();
				boolean sd =studentDao.show_student(name);
				if(sd) {
					
				}
				else {
					System.out.println("NO SUCH DATA......");
				}
			}
			if(k==1) {
				System.out.println("------>ENTER STUDENT'S ID:");
				int id=Integer.parseInt(br.readLine());
				boolean sd=studentDao.show_student(id);
                if(sd) {
					
				}
				else {
					System.out.println("NO SUCH DATA......");
				}
			}
			
		}
		}
		
		else if(c==4) {
			//EXIT//
			break;
			
		}
		else {
			
		}
	}
	System.out.println("thank_you_for_using_this_program");
}
}
