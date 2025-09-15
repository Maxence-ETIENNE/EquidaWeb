package model;

import java.util.ArrayList;

public class Race {

    private int id;
    private String nom;
    private String description;
    
    private Vente vente;

    private ArrayList<Cheval> lesChevaux ;

    public Race() {
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Vente getVente() {
        return vente;
    }
    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public ArrayList<Cheval> getLesChevaux() {
        return lesChevaux;
    }

    public void setLesChevaux(ArrayList<Cheval> lesChevaux) {
        this.lesChevaux = lesChevaux;
    }

    public void addCheval(Cheval unCheval){
        if (lesChevaux ==null ){
            lesChevaux = new ArrayList<Cheval>();
        }
        lesChevaux.add(unCheval);
    }
}
