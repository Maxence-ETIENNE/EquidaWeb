package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cheval {

    private int id;
    private String nom;
    private LocalDate dateNaissance;
    private String sexe;
    private String sire;
    private int idPere;
    private int idMere;

    private Race race;
    
    private ArrayList<Lot> lesLots ;
    private ArrayList<Cheval> lesEnfants ;

    public Cheval() {
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
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public String getSire() {
        return sire;
    }
    public void setSire(String sire) {
        this.sire = sire;
    }
    
    public int getIdPere() {
        return idPere;
    }
    public void setIdPere(int idPere) {
        this.idPere = idPere;
    }
    public int getIdMere() {
        return idMere;
    }
    public void setIdMere(int idMere) {
        this.idMere = idMere;
    }
    
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }
    
    public ArrayList<Lot> getLesLots() {
        return lesLots;
    }
    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }
    public void addLot(Lot unLot){
        if (lesLots ==null ){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(unLot);
    }
    
    public ArrayList<Cheval> getLesEnfants() {
        return lesEnfants;
    }
    public void setLesEnfants(ArrayList<Cheval> lesEnfants) {
        this.lesEnfants = lesEnfants;
    }
    public void addEnfant(Cheval unEnfant){
        if (lesEnfants ==null ){
            lesEnfants = new ArrayList<Cheval>();
        }
        lesEnfants.add(unEnfant);
    }
}
