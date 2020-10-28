package sample.Java_class;

import sample.Java_class.Karakter;
import sample.Java_class.Kull;
import sample.Java_class.Kurs;

import java.util.ArrayList;

/*Klasse for Studenter*/
public class Student {

    private String nr;
    private String name;
    private String kull;
    public ArrayList<Karakter> karakters;
    public ArrayList<Kurs> kurs;

    public Student(String nr, String name, String kull) {
        this(nr, name, kull, null, null);
    }

    public Student(String nr, String name, String kull, ArrayList<Karakter> karakters, ArrayList<Kurs> kurs){
        this.nr = nr;
        this.name = name;
        this.kull = kull;
        this.karakters = karakters;
        this.kurs = kurs;
    }

    public String getNr() {

        return nr;
    }

    public String getName() {
        return name;
    }

    public String getKull() {
        return kull;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKull(String kull){
        this.kull = kull;
    }

    public ArrayList<Karakter> getKarakters() {
        return karakters;
    }

    public ArrayList<Kurs> getKurs() {
        return kurs;
    }

    public void setKarakters(ArrayList<Karakter> karakters) {
        this.karakters = karakters;
    }

    public void setKurs(ArrayList<Kurs> kurs) {
        this.kurs = kurs;
    }

    public String toString(){
        return nr + " " + name + " " + kull;
    }
}
