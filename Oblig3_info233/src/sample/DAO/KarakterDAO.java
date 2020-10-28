package sample.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Java_class.Karakter;
import sample.Java_class.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*DAO klasse for Karakter
*
*
* @Author Joakim Viken, Ingvild Hagesæter
* */
public class KarakterDAO {
    private Connection conn;

    public KarakterDAO(Connection conn){
        this.conn = conn;
    }

    public void addKrakter(Karakter karakter, Student student) {
        String sql = "INSERT INTO Karakter(id, karakter, ar, student) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, karakter.getId());
            pstmt.setString(2, karakter.getKarakter());
            pstmt.setInt(3, karakter.getAr());
            pstmt.setString(4, student.getNr());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Succses");
    }

    public void updateKarakter(Karakter karakter, Student student) {
        String sql = "UPDATE Karakter SET karakter = ?, ar = ? WHERE student = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, karakter.getKarakter());
            pstmt.setInt(2, karakter.getAr());
            pstmt.setString(3, student.getNr());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletKarakter(Integer id) {
        String sql = "DELETE FROM Karakter WHERE student = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Karakter getAllKarakter(String studentnr){
        String sql = "SELECT * FROM Karakter WHERE student = ?";
        PreparedStatement pstmt = null;
        Karakter karakter;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentnr);
            ResultSet rs = pstmt.executeQuery();

            karakter = new Karakter(rs.getInt("id"), rs.getString("karakter"), rs.getInt("ar"));
            return karakter;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
