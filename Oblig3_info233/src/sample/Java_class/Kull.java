package sample.Java_class;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*Klasse for kull*/
public class Kull{
    private String kode;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Skole> skole = new ArrayList<>();

    public Kull(String kode){
        this(kode, null, null);
    }

    public Kull(String kode, ArrayList<Student> students, ArrayList<Skole> skole) {
        this.kode = kode;
        this.skole = skole;
        this.students = students;
    }

    public String getKull() {
        return kode;
    }

    public void setKull(String kull) {
        this.kode = kull;
    }

    public String toString(){
        return kode;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Skole> getSkole() {
        return skole;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void setSkole(ArrayList<Skole> skole) {
        this.skole = skole;
    }
}
