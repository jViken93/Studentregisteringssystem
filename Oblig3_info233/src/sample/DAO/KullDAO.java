package sample.DAO;

import sample.Java_class.Karakter;
import sample.Java_class.Kull;
import sample.Java_class.Skole;
import sample.Java_class.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*DAO klasse for Kull
 *
 *
 * @Author Joakim Viken, Ingvild Hagesæter
 * */
public class KullDAO {
    Connection conn;

    public KullDAO(Connection conn){
        this.conn = conn;
    }

    public void addKull(Kull kull, Skole skole) {
        String sql = "INSERT INTO Kull(kode, skole) VALUES(?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kull.getKull());
            pstmt.setString(2, skole.getNavn());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Succses");
    }

    public void deletKull(Kull kull) {
        String sql = "DELETE FROM Kull WHERE kode = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, kull.getKull() );
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Kull> getAllKull(Kull kull){
        String sql = "SELECT * FROM Kull WHERE kode = ?";
        PreparedStatement pstmt = null;
        ArrayList<Kull> Kull = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kull.getKull());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                Kull.add(new Kull(rs.getString("kode")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Kull;
    }
}
