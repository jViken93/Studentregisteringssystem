package sample.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.Database.Database;
import sample.Java_class.Karakter;
import sample.Java_class.Kull;
import sample.Java_class.Student;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.*;
import java.util.ArrayList;


/*DAO klasse for Student
 * Jeg kommenterer bare metodene her pga. de går igjen i alle DAO klassene. De har bare forskjellige SQL spørringer
 *
 * @Author Joakim Viken, Ingvild Hagesæter
 * */
public class StudentDAO {

    private Connection conn;

    @FXML
    private TableView studentTable;

    @FXML
    private TableColumn<Student, String> studentName;

    public StudentDAO(Connection conn) {
        this.conn = conn;
    }

    /*
    * Metode for å legge inn en Student via en SQL spørring.
    * */
    public void addStudent(String nr, String navn){
        String sql = "INSERT INTO Student(nr, navn) VALUES(?, ?)";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nr);
            pstmt.setString(2, navn);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Succses");
        }

        /*
        * Metode for å oppdatere en valgt student via en SQL spørring
        * */
        public void updateStudent(String name, String nr){
        String sql = "UPDATE Student SET navn = ? WHERE nr = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, nr);
            pstmt.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
        }
        }

        /*
        * Metode som returnerer informasjonen til en student
        * */
        public Student getStudent(String nr) throws SQLException {
            String sql = "SELECT * FROM Student WHERE nr = ?";
            PreparedStatement pstmt = null;
            Student student;
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nr);

                ResultSet rs = pstmt.executeQuery();

                student = new Student(rs.getString("nr"), rs.getString("navn"), rs.getString("kull"));

                return student;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
            }

    /*
     * Metode som sletter en student
     * */
        public void deleteStudent(String nr){
            String sql = "DELETE FROM Student WHERE nr = ?";

            try {
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, nr);
                stmt.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    /*
     * Metode som returnerer alle studenter i databasen ved en sql spørring
     * */
    public ObservableList<Student> getAllStudent(){
        String sql = "SELECT * FROM Student";
        PreparedStatement pstmt = null;
        ObservableList<Student> students = FXCollections.observableArrayList();

        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                students.add(new Student(rs.getString("nr"), rs.getString("navn"),
                        rs.getString("kull")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        students.forEach(System.out::println);
        return students;
    }




}



