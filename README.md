# JDBC-GUI_PROJECT
## STUDENT MANAGEMENT SYSTEM
This is a subset of an actual Student Management System devloped using Java GUI, Core Java Concepts, JDBC Connector, and Mysql Database.

### MYSQL DATABASE AND TABLE 
Created a Database "student_m" on my local machine 

![image](https://user-images.githubusercontent.com/93510372/233863037-842d73ef-20f3-44d8-ac1e-48323c7ba182.png)

### FIRST FRAME("student_add_frame.java") CALLED FROM MAIN OF "start.java" 
In start.java file, it contains the  main function which calls student_add_frame.java, which is a JFrame class used to provide variety of features to the user
#### student_add_frame:
![image](https://user-images.githubusercontent.com/93510372/233863565-be0871cd-1759-44cd-af08-a5061cb37d78.png)

### ADDING A STUDENT 
To add a student, "add_frame.java" class collects data from user and then transfer to 
"studentDao.java" class which interacts with database using "connection.java" class 
which further uses JDBC connector to communicate with MySql DataBase .

#### add_frame.java:
![image](https://user-images.githubusercontent.com/93510372/233864064-766e16fe-05a4-45d0-9055-749e315d48b2.png)

In add_frame.java ,entries will be only submitted if correctly entered otherwise prompts will be given as well as
for null entry
After submiting correct details , a pop-up will appear whether the data is stored in database or not 
#### entry
![image](https://user-images.githubusercontent.com/93510372/233864353-67208257-6363-4a0e-8c4c-a3e0aaa4ba86.png)

#### pop-up:
![image](https://user-images.githubusercontent.com/93510372/233864384-41d8cdd7-5ffc-403f-bd98-211eafe4c468.png)

### ALL STUDENT's DATA 
For Presenting all the details of the students present in the database we have "students_display.java" class which implements JTable 
to show students details in tabular form.

![image](https://user-images.githubusercontent.com/93510372/233864784-18dc5baf-9f61-4e6d-9fdb-69cb57b5313f.png)

Refresh button updates changes in data








