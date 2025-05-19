import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentTable implements MenuService {
   public void addStudent(String firstName, String lastName, String email, String dateOfBirth) {
       String sql = "INSERT INTO students (first_name, last_name ,email, date_of_birth)VALUES (?,?,?,?)";
       try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setString(1, firstName);
           stmt.setString(2, lastName);
           stmt.setString(3, email);
           stmt.setString(4, dateOfBirth);
           stmt.executeUpdate() ;
           System.out.println("addStudent: student added" + "student added successfully");
       }catch(SQLException e){
       e.printStackTrace();
       }
       }
    public List<String> getAllStudents() {
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
    public void updateStudent(int studentID,String newFirstName, String newLastName, String newEmail, String newDateOfBirth) {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ?, date_of_birth = ? WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
              stmt.setInt(5, studentID);
              stmt.setString(1, newFirstName);
              stmt.setString(2, newLastName);
              stmt.setString(3, newEmail);
              stmt.setString(4, newDateOfBirth);
              stmt.executeUpdate() ;
            System.out.println("updateStudent: student updated" + "student updated successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    public void deleteStudent(int studentID) {
       String sql = "DELETE FROM students WHERE id = ?";
       try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)){
             stmt.setInt(1, studentID);
             stmt.executeUpdate() ;
             System.out.println("deleteStudent: student deleted" + "student deleted successfully");
       }catch(SQLException e){
           e.printStackTrace();
       }
    }

    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }
    @Override
    public void delete() {

    }
    @Override
    public void view() {

    }
    public static void main (String[] args) {
    StudentTable studentTable = new StudentTable();
     studentTable.addStudent("mwambutsa","daryce","daryce@gmail.com","27/5/2019") ;
        System.out.println( studentTable );
    }
};



