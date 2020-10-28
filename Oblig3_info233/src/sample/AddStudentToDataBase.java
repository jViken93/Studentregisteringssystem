package sample;

import sample.Database.Database;

import java.sql.*;

/*Denne klassen adder de fra deloppgave D) til databasen. Ble aldri sakt om de skulle bli lagt til fra java klasser
* eller inn i databasen via SQL kode... Har og laget en som lager objecter fra java kalssen i
* CeateStudentFromJavaClasses filen. Hvis du vil sjekke det ut*/
public class AddStudentToDataBase {
    public static void main (String[]args) throws SQLException {

        Statement stmt = null;


        String sql3 = "INSERT INTO Karakter(id, karakter , ar, student) VALUES(2, 'A', '2019', '1')";
        String sql4 = "INSERT INTO Karakter(id, karakter, ar, student) VALUES(3, 'B', '2019', '2')";



        try(Connection conn = DriverManager.getConnection(Database.getUrl())){
            stmt = conn.createStatement();
            stmt.executeUpdate(sql3);
            stmt.executeUpdate(sql4);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if(stmt != null){
                stmt.close();
            }
        }

        printList();
    }

    /*Metode for å printe ut fra forskjellige tabels i databasen*/
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
