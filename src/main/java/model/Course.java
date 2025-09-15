package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

    private int id;
    private String nom;
    private String lieu;
    private LocalDate date;
    
//    private ArrayList<ChevalCourse> lesLots ;

    public Course() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
/*    public ArrayList<Course> getLesEnfants() {
        return lesEnfants;
    }
    public void setLesEnfants(ArrayList<Course> lesEnfants) {
        this.lesEnfants = lesEnfants;
    }
    public void addEnfant(Course unEnfant){
        if (lesEnfants ==null ){
            lesEnfants = new ArrayList<Course>();
        }
        lesEnfants.add(unEnfant);
    } */
}
