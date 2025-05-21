//package org.example;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StudentTable  {
//    public static void addStudent(String firstName, String lastName, String email, String dateOfBirth) {
//        String sql = "INSERT INTO students (first_name, last_name ,email, date_of_birth)VALUES (?,?,?,?)";
//        try(Connection conn = DatabaseConnection.getConnection();
//            PreparedStatement stmt = conn.prepareStatement(sql)){
//            stmt.setString(1, firstName);
//            stmt.setString(2, lastName);
//            stmt.setString(3, email);
//
//            stmt.setString(4, java.sql.Date.valueOf(dateOfBirth));
//            stmt.executeUpdate() ;
//            System.out.println("addStudent: student added" + "student added successfully");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//    public static List<String> getAllStudents() {
//        List<String> students = new ArrayList<>();
//        String sql = "SELECT * FROM students";
//
//        try (Connection conn = DatabaseConnection.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                String student = rs.getInt("id") + " - " +
//                        rs.getString("first_name") + " " +
//                        rs.getString("last_name");
//                students.add(student);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }
//    public static void updateStudent(int studentID,String newFirstName, String newLastName, String newEmail, String newDateOfBirth) {
//        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ? WHERE id = ?";
//        try(Connection conn = DatabaseConnection.getConnection();
//            PreparedStatement stmt = conn.prepareStatement(sql)){
//            stmt.setInt(5, studentID);
//            stmt.setString(1, newFirstName);
//            stmt.setString(2, newLastName);
//            stmt.setString(3, newEmail);
//            stmt.setString(4, newDateOfBirth);
//            stmt.executeUpdate() ;
//            System.out.println("updateStudent: student updated" + "student updated successfully");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//
//    }
//    public static void deleteStudent(int studentID) {
//        String sql = "DELETE FROM students WHERE id = ?";
//        try(Connection conn = DatabaseConnection.getConnection();
//            PreparedStatement stmt = conn.prepareStatement(sql)){
//            stmt.setInt(1, studentID);
//            stmt.executeUpdate() ;
//            System.out.println("deleteStudent: student deleted" + "student deleted successfully");
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//
//
//};



package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTable {

    public static void addStudent(String firstName, String lastName, String email, String dateOfBirth) {
        String sql = "INSERT INTO students (first_name, last_name, email, date_of_birth) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setDate(4, java.sql.Date.valueOf(dateOfBirth)); // Must be in yyyy-MM-dd format

            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String student = rs.getInt("id") + " - " +
                        rs.getString("first_name") + " " +
                        rs.getString("last_name");
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void updateStudent(int studentID, String newFirstName, String newLastName, String newEmail, String newDateOfBirth) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newFirstName);
            stmt.setString(2, newLastName);
            stmt.setString(3, newEmail);
            stmt.setDate(4, java.sql.Date.valueOf(newDateOfBirth)); // Correct way to handle date
            stmt.setInt(5, studentID);

            stmt.executeUpdate();
            System.out.println("Student updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int studentID) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentID);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



