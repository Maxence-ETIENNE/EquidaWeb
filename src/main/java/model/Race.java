package model;

import java.util.ArrayList;

public class Race {

    private int id;
    private String nom;
    
    private Vente vente;

    private ArrayList<Vente> lesChevaux ;

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
    public Vente getVente() {
        return vente;
    }
    public void setVente(Vente vente) {
        this.vente = vente;
    }

    public ArrayList<Vente> getLesChevaux() {
        return lesChevaux;
    }

    public void setLesChevaux(ArrayList<Vente> lesChevaux) {
        this.lesChevaux = lesChevaux;
    }

    public void addCheval(Vente unCheval){
        if (lesChevaux ==null ){
            lesChevaux = new ArrayList<Vente>();
        }
        lesChevaux.add(unCheval);
    }
}
