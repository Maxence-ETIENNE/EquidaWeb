package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Epreuve {

    private int id;
    private String nom;
    private LocalDate dateDebut;
    private LocalTime heureDebut;

    private Sport sport;

    public Epreuve() {
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
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalTime getHeureDebut() {
        return heureDebut;
    }
    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }
    
    public Sport getSport() {
        return sport;
    }
    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
