package sample.Controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DAO.KarakterDAO;
import sample.DAO.KursDAO;
import sample.DAO.StudentDAO;
import sample.Database.Database;
import sample.Java_class.Karakter;
import sample.Java_class.Kull;
import sample.Java_class.Kurs;
import sample.Java_class.Student;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;


/*Klasse som fungerer som kontroll til hviskarakter.fxml
*
*
*
* @Author Joakim Viken, Ingvild Hagesæter
* */
public class Controller_hvisKarakter implements Initializable {

    //variablene til tableview
    @FXML
    private TableView studentTable;

    @FXML
    private TableView karakterTable;

    @FXML
    private TableView kurs;

    @FXML
    private TextField studentSearchName;

    @FXML
    private TextField studentSearchNr;

    @FXML
    private TableColumn<Student, String> kull;

    @FXML
    private TableColumn<Student, String> studentName;

    @FXML
    private TableColumn<Karakter, String> karakter;

    @FXML
    private TableColumn<Karakter, Integer> arstall;

    @FXML
    private TableColumn<Kull, String> kursKode;

    @FXML
    private TableColumn<Kull, String> kursNavn;

    //Lister til de tre forskjellige tabels
    public ObservableList<Student> list = FXCollections.observableArrayList();
    public ObservableList<Karakter> list2 = FXCollections.observableArrayList();
    public ObservableList<Kurs> list3 = FXCollections.observableArrayList();

    private Integer tall;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /*
    Søker etter informasjon om en student fra DAO klassene.
     */
    public void searchButton(javafx.event.ActionEvent event) throws SQLException {
        StudentDAO studentDAO = new StudentDAO(DriverManager.getConnection(Database.getUrl()));
        KarakterDAO karakterDAO = new KarakterDAO(DriverManager.getConnection(Database.getUrl()));
        KursDAO kursDAO = new KursDAO(DriverManager.getConnection(Database.getUrl()));

        Student student = studentDAO.getStudent(studentSearchNr.getText());
        Karakter karakter2 = karakterDAO.getAllKarakter(studentSearchNr.getText());
        tall = karakter2.getId();

        //adder de til listene
        list.add(studentDAO.getStudent(studentSearchNr.getText()));
        list2.add(karakterDAO.getAllKarakter(studentSearchNr.getText()));
        list3.add(kursDAO.getAllKurs(tall));

        //Setter de inn i JAvaFx tabels
        studentTable.setItems(list);
        karakterTable.setItems(list2);
        kurs.setItems(list3);

        //Setter data inn i de forksjellige columns
        studentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        kull.setCellValueFactory(new PropertyValueFactory<>("kull"));
        karakter.setCellValueFactory(new PropertyValueFactory<>("karakter"));
        arstall.setCellValueFactory(new PropertyValueFactory<>("ar"));
        kursKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        kursNavn.setCellValueFactory(new PropertyValueFactory<>("navn"));
    }

}

