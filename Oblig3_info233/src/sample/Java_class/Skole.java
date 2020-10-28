package sample.Java_class;

import sample.Java_class.Kull;
import sample.Java_class.Kurs;

import java.util.ArrayList;

/*Skole klass*/
public class Skole {
    private String navn;
    ArrayList<Kurs> kurs = new ArrayList<>();
    ArrayList<Kull> kull = new ArrayList<>();

    public Skole(String navn){
        this(navn, null, null);
    }

    public Skole(String navn,  ArrayList<Kull> kull, ArrayList<Kurs> kurs){
        this.navn = navn;
        this.kurs = kurs;

    }

    public String getNavn() {
        return navn;
    }

    public void setSkole(String navn) {
        this.navn = navn;
    }

    public ArrayList<Kurs> getKurs() {
        return kurs;
    }

    public ArrayList<Kull> getKull() {
        return kull;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setKurs(ArrayList<Kurs> kurs) {
        this.kurs = kurs;
    }

    public void setKull(ArrayList<Kull> kull) {
        this.kull = kull;
    }
}
