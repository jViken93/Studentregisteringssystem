package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.DAO.StudentDAO;
import sample.Database.Database;
import sample.Java_class.Kull;
import sample.Java_class.Student;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

/*Klasse som fungerer som kontrollen til AddStudent.fxml. Her er det alle oprasjonene som blir gjort der foregår.
*
*
* @Author Joakim Viken, Ingvild Hagesæter
* */
public class Controller_AddStudent implements Initializable {

    /*Definisjonen av Tableview som blir vist*/
    @FXML
    private TableView tabell;
    @FXML
    private TableColumn<Student, String> navn;
    @FXML
    private TableColumn<Student, String> nr;
    @FXML
    private TextField navnInput;
    @FXML
    private TextField nrInput;


    /*Legger til studeneter i tableview*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            StudentDAO studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
            //Setter det inn i tableview
            tabell.setItems(studentDAO.getAllStudent());
            //setter de inn i sine kolonner
            navn.setCellValueFactory(new PropertyValueFactory<>("name"));
            nr.setCellValueFactory(new PropertyValueFactory<>("nr"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*Denne metoden legger til en student som er blitt skrevet inn i søke feltet
    *
    *
    * @Param Student id
    * @Param Student navn
    * */
    public void AddButton (javafx.event.ActionEvent event) throws SQLException {
        StudentDAO studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
        studentDAO.addStudent(nrInput.getText(), navnInput.getText());
        tabell.setItems(studentDAO.getAllStudent());
        navn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nr.setCellValueFactory(new PropertyValueFactory<>("nr"));
    }

    /*
    * Denne metoden oppdaterer en students navn
    *
    * @Param Student ID som skal bli oppdater
    * */
    public void upDateStudent(javafx.event.ActionEvent event) throws SQLException {
        StudentDAO studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
        studentDAO.updateStudent(navnInput.getText(), nrInput.getText());
        tabell.setItems(studentDAO.getAllStudent());
        navn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nr.setCellValueFactory(new PropertyValueFactory<>("nr"));
    }

    }




