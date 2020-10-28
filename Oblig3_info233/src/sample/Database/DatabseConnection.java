package sample.Database;

import java.sql.*;

/*Klasse for å opprette en database tilkobling og legge in et shecma inn i det*/

public class DatabseConnection {
    public static void main (String[]args)throws SQLException {

       databaseConnection();
       creatNewTable();

    }

    /*Metode for å lage en database tilkobling*/
    public static void databaseConnection(){
        try {
            Connection conn = DriverManager.getConnection(Database.getUrl());
            System.out.println("Database created.");

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    /*Metode for å legge in tomme tabels inn i databasen*/
    public static void creatNewTable(){
        /*Finne sikkert en lettere løsning. Prøvde å lese rett fra filen, men fikk ikke det til. Noen tilbakemelding på
         * hvordan jeg kan gjøre det?*/
        String sql = "CREATE TABLE IF NOT EXISTS Skole (\n" +
                "    navn text PRIMARY KEY\n" +
                ");CREATE TABLE IF NOT EXISTS Kull (\n" +
                "    kode text PRIMARY KEY,\n" +
                "    skole text REFERENCES Skole(navn)\n" +
                ");CREATE TABLE IF NOT EXISTS Student (\n" +
                "    nr text PRIMARY KEY,\n" +
                "    navn text NOT NULL,\n" +
                "    kull text REFERENCES Kull(kode)\n" +
                ");CREATE TABLE IF NOT EXISTS Karakter (\n" +
                "    id integer PRIMARY KEY,\n" +
                "    karakter text NOT NULL,\n" +
                "    ar integer NOT NULL,\n" +
                "    student text REFERENCES Student(nr)\n" +
                ");CREATE TABLE IF NOT EXISTS Kurs (\n" +
                "    kode text PRIMARY KEY,\n" +
                "    navn text NOT NULL,\n" +
                "    skole text REFERENCES Skole (navn),\n" +
                "    karakter integer REFERENCES Karakter (id)\n" +
                ");";
        try{
            Connection conn = DriverManager.getConnection(Database.getUrl());
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*metode for å printe ut listen*/
    public static void printList() {
        String sql = "SELECT * FROM Student";
        Statement stmt = null;

        try (Connection conn = DriverManager.getConnection(Database.getUrl())) {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("kode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*TEST METODER, IKKE FOR EGENRETTING*/
    public static void delete(String kode){

    }

    public static void Insert(){
        String sql1 = "INSERT INTO Skole(navn) VALUES('UIB')";
        String sql2 = "INSERT INTO Kull(kode, skole) VALUES('2019V', 'UIB')";
        String sql3 = "INSERT INTO Student(nr, navn, kull) VALUES('1', 'Joakim Viken', 'UIB')";


        try{
            Connection conn = DriverManager.getConnection(Database.getUrl());
            PreparedStatement pstmt = conn.prepareStatement(sql1);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            PreparedStatement pstmt3 = conn.prepareStatement(sql3);

            pstmt.executeUpdate();
            pstmt2.executeUpdate();
            pstmt3.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
