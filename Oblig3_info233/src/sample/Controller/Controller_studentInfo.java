package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DAO.StudentDAO;
import sample.Database.Database;
import sample.Java_class.Student;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*Klasse som fungerer som controller til studentInfo.fxml
*
*
* @Author Joakim Viken, Ingvild Hagesæter
* */
public class Controller_studentInfo implements Initializable {
    @FXML
    private TableView studentTabel2;

    @FXML
    private TableView selectedStudent;

    @FXML
    private TableColumn<Student, String> studentNr2;

    @FXML
    private TableColumn<Student, String> studentName2;

    //@FXML
    //private TableColumn<Student, String> studentNr2;

    @FXML
    private TableRow<Student> studentTableRow;

    public ObservableList<Student> studentList = FXCollections.observableArrayList();


    //Når JavaFX blir satt i gang vil student nummer bli vist i en tableview
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentDAO studentDAO = null;
        try {
            studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
            studentTabel2.setItems(studentDAO.getAllStudent());
            studentNr2.setCellValueFactory(new PropertyValueFactory<>("nr"));

            studentTabel2.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            studentTabel2.getSelectionModel().setCellSelectionEnabled(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * Funksjon som tar for seg det som blir klikket på i Tableview.
    * Hvis et student nummer blir klikket på, vil den bli vist i den andre tableviwen
    *
    * */
    public void clickItem(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        Student student = (Student)studentTabel2.getSelectionModel().getSelectedItem();


        StudentDAO studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
        studentList.add(studentDAO.getStudent(student.getNr()));
        selectedStudent.setItems(studentList);
        studentName2.setCellValueFactory(new PropertyValueFactory<>("name"));
    }
}
