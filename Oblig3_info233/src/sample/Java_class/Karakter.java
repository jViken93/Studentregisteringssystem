package sample.Java_class;

import javafx.fxml.Initializable;

import java.util.ArrayList;

/*Klasse for karakter*/
public class Karakter{
    private Integer id;
    private String karakter;
    private Integer ar;
    private ArrayList<Student> student;


    public Karakter(Integer id, String karakter, Integer ar){
        this(id, karakter, ar, null);
    }

    public Karakter(Integer id, String karakter, Integer ar, ArrayList<Student> student) {
        this.id = id;
        this.karakter = karakter;
        this.ar = ar;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public String getKarakter() {
        return karakter;
    }

    public Integer getAr() {
        return ar;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }

    public String toString(){
        return id + " " + karakter + " " + ar;
    }
}
