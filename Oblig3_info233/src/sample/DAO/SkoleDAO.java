package sample.DAO;

import sample.Java_class.Kull;
import sample.Java_class.Kurs;
import sample.Java_class.Skole;
import sample.Java_class.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*DAO klasse for Skole
 *
 *
 * @Author Joakim Viken, Ingvild Hagesæter
 * */
public class SkoleDAO {

    Connection conn;

    public SkoleDAO(Connection conn){
        this.conn = conn;
    }

    public void addSkole(Skole skole) {
        String sql = "INSERT INTO Skole(navn) VALUES(?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, skole.getNavn());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Succses");
    }

    public void deletSkole(Skole skole) {
        String sql = "DELETE FROM Skole WHERE navn = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, skole.getNavn());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
