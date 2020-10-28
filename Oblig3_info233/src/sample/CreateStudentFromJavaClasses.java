package sample;

import sample.Database.Database;
import sample.Java_class.Karakter;
import sample.Java_class.Kull;
import sample.Java_class.Skole;
import sample.Java_class.Student;

import java.sql.*;
import java.util.ArrayList;

/*Main klasse for å lage studenter som objecter fra de forskjellige klassen*/
public class CreateStudentFromJavaClasses {
    public static void main (String[]args){
    }

    /*TEST METODER. IKKE FOR EGENRETTING*/

    public static void insert(String name, String nr){
        String sql = "INSERT INTO Student(navn, nr) VALUES(?, ?)";
        try(Connection conn = DriverManager.getConnection(Database.getUrl())){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, nr);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printList() {
        String sql = "SELECT * FROM Student";
        Statement stmt = null;

        try (Connection conn = DriverManager.getConnection(Database.getUrl())) {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("navn"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
