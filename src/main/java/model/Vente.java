package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vente {

    private int id;
    private String nom;
    private LocalDate dateDebutVente;

    private Lieu lieu;
    private Race race;
    private CategVente categVente;
    
    private ArrayList<Lot> lesLots ;

    public Vente() {
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

    public LocalDate getDateDebutVente() {
        return dateDebutVente;
    }

    public void setDateDebutVente(LocalDate dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }
    public Lieu getLieu() {
        return lieu;
    }
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race){
        this.race = race;
    }
    public CategVente getCategVente() {
        return categVente;
    }
    public void setCategVente(CategVente categVente) {
        this.categVente = categVente;
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
}
