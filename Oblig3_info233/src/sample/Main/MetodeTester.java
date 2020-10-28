package sample.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import sample.DAO.KarakterDAO;
import sample.DAO.KullDAO;
import sample.DAO.KursDAO;
import sample.DAO.StudentDAO;
import sample.Database.Database;
import sample.Java_class.*;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;

public class MetodeTester {
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
        KarakterDAO karakterDAO =  new KarakterDAO(DriverManager.getConnection(Database.getUrl()));
        KursDAO kursDAO = new KursDAO(DriverManager.getConnection(Database.getUrl()));

        Kurs kurs = new Kurs("2019V", "Avansert programmering");
        Karakter karakter = new Karakter(2, "A", 2019);
        Karakter karakter2 = new Karakter(3, "A", 2019);
        Student student = new Student("1", "Per", "2019V");
        Student student2 = new Student("2", "Kari", "2019V");
        Skole skole = new Skole("UIB");
        kursDAO.addKurs(kurs, skole, karakter2.getId());







        //ArrayList<Student> studentList = studentDAO.getAllStudent(student);
        //ArrayList<Karakter> karakters = karakterDAO.getAllKarakter(student);








        }
    public static void printList() {
        String sql = "SELECT * FROM Student";
        Statement stmt = null;

        try (Connection conn = DriverManager.getConnection(Database.getUrl())) {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("nr"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> getAllStudent(Student student) throws SQLException {
        String sql = "SELECT * FROM Student";
        PreparedStatement pstmt = null;
        //ObservableList<Student> students = FXCollections.observableArrayList();
        ArrayList<Student> students;
        Connection conn = DriverManager.getConnection(Database.getUrl());

        students = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()){
                students.add(new Student(rs.getString("nr"), rs.getString("navn"),
                        rs.getString("kull")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        students.forEach(System.out::println);
        return students;
    }
}
