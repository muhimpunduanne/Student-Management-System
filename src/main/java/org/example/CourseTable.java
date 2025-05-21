package org.example;

import org.example.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseTable {
    public static void addCourse(String courseName, String description) {
        String sql = "INSERT INTO courses (courseName, description) VALUES (?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, courseName);
            stmt.setString(2, description);
            stmt.executeUpdate();
            System.out.println("Course added successfully" + courseName);
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public static List<String> getAllCourses() {
        List<String> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                courses.add(rs.getInt("id") + " " +
                        rs.getString("course_name"));
                rs.getString("description");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public static void updateCourse(int courseID,String newCourseName, String newDescription) {
        String sql = "UPDATE courses SET courseName = ?, description = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, newCourseName);
            stmt.setString(2, newDescription);
            stmt.setInt(3, courseID);
            stmt.executeUpdate();
            System.out.println("Course updated successfully" + courseID);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteCourse(int courseID) {
        String sql = "DELETE FROM courses WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, courseID);
            stmt.executeUpdate();
            System.out.println("Course deleted successfully" + courseID);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}