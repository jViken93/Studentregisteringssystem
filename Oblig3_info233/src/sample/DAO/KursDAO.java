package sample.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Java_class.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*DAO klasse for Kurs
 *
 *
 * @Author Joakim Viken, Ingvild Hagesæter
 * */
public class KursDAO {

    Connection conn;

    public KursDAO(Connection conn){
        this.conn = conn;
    }

    public void addKurs(Kurs kurs, Skole skole, Integer karakterId) {
        String sql = "INSERT INTO Kurs(kode, navn, skole, karakter) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kurs.getKode());
            pstmt.setString(2, kurs.getNavn());
            pstmt.setString(3, skole.getNavn());
            pstmt.setInt(4, karakterId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Succses");
    }

    public void deletKurs(Kurs kurs) {
        String sql = "DELETE FROM Kurs WHERE kode = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, kurs.getKode() );
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateKurs(Kurs kurs){
        String sql = "UPDATE Kurs SET navn = ? WHERE kode = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kurs.getNavn());
            pstmt.setString(2, kurs.getKode());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Kurs getAllKurs(Integer karakterId){
        String sql = "SELECT * FROM Kurs WHERE karakter = ?";
        PreparedStatement pstmt = null;
        Kurs kurs;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, karakterId);
            ResultSet rs = pstmt.executeQuery();


            kurs = new Kurs(rs.getString("kode"), rs.getString("navn"));

            return kurs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
