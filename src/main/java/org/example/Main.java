package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       StudentTable studentTable = new StudentTable();
       CourseTable courseTable = new CourseTable();
       MarksTable marksTable = new MarksTable() ;
   Scanner scanner = new Scanner(System.in);
   while (true) {
       System.out.println("Welcome to my student management system ");
       System.out.println("1. Add student ");
       System.out.println("2. View student ");
       System.out.println("3. Update student ");
       System.out.println("4. Delete student ");
       System.out.println("5. Add course ");
       System.out.println("6. getAll course ");
       System.out.println("7. View course ");
       System.out.println("8. Update course ");
       System.out.println("9. Delete course ");
       System.out.println("10. Add marks[StudentID, courseID, mark] ");
       System.out.println("11. View marks[StudentID");
       System.out.println("12. Update student marks in course ");
       System.out.println("13. Delete student marks in course ");
       System.out.println("14. Exit ");
       System.out.println("choose an option: ");

       String  option = scanner.nextLine() ;
       switch (option) {
           case "1":
               System.out.println("Enter firstName:");
               String firstName = scanner.nextLine();
               System.out.println("Enter lastName:");
               String lastName = scanner.nextLine();
               System.out.println("Enter email:");
               String email = scanner.nextLine();
               System.out.println("Enter dateOfBirth:");
               String dateOfBirth = scanner.nextLine();
               StudentTable.addStudent( firstName,  lastName, email,  dateOfBirth);
               break;
               case "2":
                   StudentTable.getAllStudents().forEach(System.out::println) ;
                   break;
                   case "3":
                       System.out.println("Enter studentID to update: :");
                       int studentID = scanner.nextInt();
                       scanner.nextLine();
                       System.out.println("Enter new first name :");
                       String newFirstName = scanner.nextLine();
                       System.out.println("Enter new last name :");
                       String newLastName = scanner.nextLine();
                       System.out.println("Enter new email :");
                       String newEmail = scanner.nextLine();
                       System.out.println("Enter new dateOfBirth :");
                       String newDateOfBirth = scanner.nextLine();
                       StudentTable.updateStudent(studentID, newFirstName, newLastName,  newEmail,  newDateOfBirth);
                       break;
                       case "4":
                           System.out.println("Enter studentID to delete: :");
                           int studentid = scanner.nextInt();
                           StudentTable.deleteStudent(studentid);
                           break;
                           case "5":
                               System.out.println("Enter course name  :");
                               String courseName = scanner.nextLine();
                               System.out.println("Enter course description :");
                               String description = scanner.nextLine();
                               CourseTable.addCourse(courseName,  description);
                               break;
                               case "6":
                                   CourseTable.getAllCourses().forEach(System.out::println) ;
                                   break;
//
                                       case "8":
                                           System.out.println("Enter courseID to update  :");
                                           int courseId= scanner.nextInt();
                                           scanner.nextLine();
                                           System.out.println("Enter new course name :");
                                           String newCourseName = scanner.nextLine();
                                           System.out.println("Enter new course description :");
                                           String newCourseDescription = scanner.nextLine();
                                           CourseTable.updateCourse( courseId, newCourseName,  newCourseDescription);
                                           break;
                                           case "9":
                                               System.out.println("Enter courseID to delete  :");
                                               courseId = scanner.nextInt();
                                               courseTable.deleteCourse(courseId );
                                               break;
                                               case "10":
                                                   System.out.println("Enter StudentID  :");
                                                   int StudentID = scanner.nextInt();
                                                   System.out.println("Enter course ID  :");
                                                   int CourseID = scanner.nextInt();
                                                   System.out.println("Enter new marks :");
                                                   float Marks = scanner.nextFloat();
                                                   MarksTable.assignMark(StudentID , CourseID  , Marks);
                                                   break;


       }

   }

    }

}

