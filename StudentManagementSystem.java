package StudentManagementSystem;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Nawal Abid 
 * Nawal Abid_Section002_Project3.java
 */
public class StudentManagementSystem {

  
  public static void main(String[] args) {

    int i, j, k, tempStudentID, loopIndex;
    int StudentIndex = 0;  //variables
    int CourseIndex = 0;
    String First_Name, Last_Name, Level_of_student;
    int Course_ID, Student_ID;
    String Course_Name;
    Student_Employee[] studentEmployee = new Student_Employee[5];     //student_emp array
    List<Course> course = new ArrayList<>();
    Map<Integer, Integer> studentWithCourse = new HashMap<>();

    Scanner S = new Scanner(System.in);  //scanner input
    do {

      System.out.println("***Welcome to Student and Course Management System***\n\n");
      System.out.println(
          "Press '1' for student Management System(SMS)\nPress '2' for Course Management System (CMS)\nPress '0' to exit\n");
                     //information entered by the user
      i = S.nextInt();
      switch (i) {  //switch statements used 
      case 1:

        do {
          System.out.println("**Welcome to SMS**\n"); //sms section
          System.out.println(
              "Press '1' to add a student \nPress '2' to deactivate\nPress '3' to Display all students\n Press'4' to search for a student by ID\nPress '5' to assign on-campus job\nPress'6' to display all student with on-campus jobs\n Press'0' to exit SMS\n");

          j = S.nextInt();
          switch (j) {
          case 1:

            try {
              FileWriter obj = new FileWriter("StudentReport.txt");//file writer
              First_Name = S.nextLine();
              System.out.print("Enter first name: ");
              First_Name = S.nextLine();
              System.out.print("Enter last name: ");
              Last_Name = S.nextLine();
              System.out.print("Enter Level of Student: ");
              Level_of_student = S.nextLine();
              obj.write("ID:" + (StudentIndex + 6) + "\n" + "Fisrt Name:" + First_Name + "\n" + "Last Name:" + Last_Name
                  + "\n" + "Level of Student:" + Level_of_student);
              obj.close();
              System.out.print("\nID:" + (StudentIndex + 6) + "\n" + "Fisrt Name:" + First_Name + "\n" + "Last Name:"
                  + Last_Name + "\n" + "Level of Student:" + Level_of_student + "\n");
              System.out.println(First_Name + " " + Last_Name + " has been added as a " + Level_of_student + " with ID "
                  + (StudentIndex + 6));

              studentEmployee[StudentIndex] = new Student_Employee();
              studentEmployee[StudentIndex].setID((StudentIndex + 6));
              studentEmployee[StudentIndex].setFirstName(First_Name);
              studentEmployee[StudentIndex].setLastName(Last_Name);
              studentEmployee[StudentIndex].setStudentLevel(Level_of_student);

              StudentIndex++;     //exception try/catch
            } catch (IOException e) {
              System.out.print("error");

            }
            break;

          case 2:
            System.out.print("Enter the ID for the student you want to deactivate: ");
            tempStudentID = S.nextInt();
            try {
              StudentIndex = StudentManagementSystem.indexOfStudentByID(studentEmployee, tempStudentID);
              studentEmployee[StudentIndex].setActive(false);
            } catch (Exception e) {
              // TODO: handle exception
              System.out.println("There is no Student with this ID!\n");
            }
            break;

          case 3:
            try {
              for (loopIndex = 0; loopIndex < studentEmployee.length; loopIndex++) {
                String isActive = studentEmployee[loopIndex].isActive() == true ? "Active" : "Deactivated";
                System.out.println("\n" + studentEmployee[loopIndex].getFirstName() + " "
                    + studentEmployee[loopIndex].getLastName() + "\nID: " + studentEmployee[loopIndex].getID() + "\n"
                    + "Level: " + studentEmployee[loopIndex].getStudentLevel() + "\nStatus: " + isActive + "\n");
              }
            } catch (Exception e) {
              // TODO: handle exception
              System.out.println("No student has been deactivated!\n");
            }
            break;

          case 4:
            System.out.print("Enter the student ID: ");
            tempStudentID = S.nextInt();
            try {
              StudentIndex = StudentManagementSystem.indexOfStudentByID(studentEmployee, tempStudentID);
              if (StudentIndex == -1) {
                System.out.println("There is no Student with this ID!");
                break;
              }
              String isActive = studentEmployee[StudentIndex].isActive() == true ? "Active" : "Deactivated";
              System.out.println("\n" + studentEmployee[StudentIndex].getFirstName() + " "
                  + studentEmployee[StudentIndex].getLastName() + "\nID: " + studentEmployee[StudentIndex].getID()
                  + "\n" + "Level: " + studentEmployee[StudentIndex].getStudentLevel() + "\nStatus: " + isActive
                  + "\n");
              break;
            } catch (Exception e) {
              // TODO: handle exception
              System.out.println("There is no Student with this ID!\n");
            }
            break;

          case 5:
            try {
              System.out.print("Enter the student ID: ");
              tempStudentID = S.nextInt();
              StudentIndex = StudentManagementSystem.indexOfStudentByID(studentEmployee, tempStudentID);

              String tempS = S.nextLine();
              System.out.print("Enter job: ");
              tempS = S.nextLine();
              studentEmployee[StudentIndex].setJob(tempS);
              System.out.print("Enter job type: ");
              tempS = S.nextLine();
              studentEmployee[StudentIndex].setEmployeeType(tempS);
              // System.out.println(studentEmployee[StudentIndex].getFirstName() + " "
              //     + studentEmployee[StudentIndex].getLastName() + " " + studentEmployee[StudentIndex].getEmployeeType()
              //     + " " + studentEmployee[StudentIndex].getJob() + " job\n");

              System.out.println("\n" + studentEmployee[StudentIndex].getFirstName() + " "
                  + studentEmployee[StudentIndex].getLastName() + " " + " has been assigned "
                  + studentEmployee[StudentIndex].getStudentLevel() + " " + studentEmployee[StudentIndex].getJob()
                  + " job\n");
            } catch (Exception e) {
              // TODO: handle exception
              System.out.println("There is no Student with this ID!\n");
            }
            break;

          case 6:
          try {
            for (loopIndex = 0; loopIndex < studentEmployee.length; loopIndex++) {
              System.out.println("\n" + studentEmployee[loopIndex].getFirstName() + " "
                  + studentEmployee[loopIndex].getLastName() + " " + " has been assigned "
                  + studentEmployee[loopIndex].getStudentLevel() + " " + studentEmployee[loopIndex].getJob()
                  + " job\n");
            }
              } catch (Exception e) {
            }
            break;
          }
        } while (j != 0); //while loop, cms section
        break;

      case 2:
      do {
        System.out.println("\n***Welcome to Course Management System(CMS)***\n");
        System.out.println(
            "Press '1' to add a new Course \nPress '2' Assign Student a new Course\nPress '3' Display student with assigned course\n Press'0' Exit ");
        k = S.nextInt();
        switch (k) {
        case 1:

          try {

            FileWriter obj = new FileWriter("Course.txt"); //file writing

            // System.out.println("");
            System.out.print("Enter Course ID:");
            Course_ID = S.nextInt();
            Course_Name = S.nextLine();
            System.out.print("Enter Course Name:");
            Course_Name = S.nextLine();
            obj.write("Cour ID:" + Course_ID + "\n" + "Course Name:" + Course_Name);
            obj.close();
            System.out.println("Confirmation new course " + Course_ID + "\n" + "Course Name:" + Course_Name);

            course.add(new Course(Course_ID, Course_Name));

            CourseIndex++;
          } catch (IOException e) {
            System.out.print("error");

          }
          break;

        case 2:
          try {

            FileWriter obj = new FileWriter("CourseAssignment.txt");

            // System.out.println("");
            // Student_ID = S.nextInt();
            System.out.print("Enter student ID:");
            Student_ID = S.nextInt();
            System.out.print("Enter course Name:");
            Course_ID = S.nextInt();
            String courseName = "";
            for (Course cs : course) {
              if(cs.getID() == Course_ID)
                courseName = cs.getCourseName();
            }
            obj.write("Cour ID:" + Course_ID + "\n" + "Course Name:" + courseName);
            obj.close();
            StudentIndex = StudentManagementSystem.indexOfStudentByID(studentEmployee, Student_ID);
            System.out.print("Confirmation: " + studentEmployee[StudentIndex].getFirstName() + " "
                + studentEmployee[StudentIndex].getLastName() + " has been assigned course " + Course_ID + '\n');

            studentWithCourse.put(Course_ID, Student_ID);

          } catch (IOException e) {
            System.out.print("error");

          }
          break;

        case 3:
          for (Map.Entry<Integer, Integer> entry : studentWithCourse.entrySet()) {
            StudentIndex = StudentManagementSystem.indexOfStudentByID(studentEmployee, entry.getValue());
            System.out.println(
                studentEmployee[StudentIndex].getFirstName() + " " + studentEmployee[StudentIndex].getLastName()
                    + "\nID - " + studentEmployee[StudentIndex].getID() + "\nCourse: " + entry.getKey() + "\n");
          }

          break;
        }
        } while (k != 0);

      }
      System.out.println("");

    } while (i != 0);

    
  }

  private static int indexOfStudentByID(Student_Employee[] studentEmployee, int id) {
    int loopIndex;
    for (loopIndex = 0; loopIndex < studentEmployee.length; loopIndex++) {
      if (studentEmployee[loopIndex].getID() == id) {
        break;
      }
    }
    if (loopIndex == studentEmployee.length)
      loopIndex = -1;
    return loopIndex;
  }

}
