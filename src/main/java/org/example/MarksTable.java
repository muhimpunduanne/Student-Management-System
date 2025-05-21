package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarksTable {
    public static void assignMark(int studentID, int  courseID, float  mark) {
        String sql = "INSERT INTO student_marks (student_id, course_id,mark) VALUES (?, ?, ?)"+
                "ON CONFLICT (student_id, course_id) DO UPDATE SET marks = EXCLUDED.marks";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, studentID);
            stmt.setInt(2, courseID) ;
            stmt.setFloat(3, mark);
            stmt.executeUpdate();
            System.out.println("marks assigned successfully");
        }catch(SQLException e ){
            e.printStackTrace();
        }

    }
}