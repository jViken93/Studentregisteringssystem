package sample.Java_class;

import java.util.ArrayList;

public class Kurs {
    private String kode;
    private String navn;
    private ArrayList<Skole> skole;
    private ArrayList<Karakter> karakter;
    private ArrayList<Student> student;

    public Kurs(String kode, String navn){
        this(kode, navn, null, null, null);
    }

    public Kurs(String kode, String navn, ArrayList<Skole> skole, ArrayList<Karakter> karakter, ArrayList<Student> student){
        this.kode = kode;
        this.navn = navn;
        this.skole = skole;
        this.karakter = karakter;
        this.student = student;
    }

    public String getKode() {
        return kode;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Skole> getSkole() {
        return skole;
    }

    public ArrayList<Karakter> getKarakter() {
        return karakter;
    }

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setSkole(ArrayList<Skole> skole) {
        this.skole = skole;
    }

    public void setKarakter(ArrayList<Karakter> karakter) {
        this.karakter = karakter;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }
}
