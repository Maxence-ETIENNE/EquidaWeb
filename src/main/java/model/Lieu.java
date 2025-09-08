package model;

import java.util.ArrayList;

public class Lieu {

    private int id;
    private String ville;
    private int nbBoxes;
    private String commentaires;

    private ArrayList<Vente> lesVentes ;

    public Lieu() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public int getNbBoxes() {
        return nbBoxes;
    }
    public void setNbBoxes(int nbBoxes) {
        this.nbBoxes = nbBoxes;
    }
    public String getCommentaires() {
        return commentaires;
    }
    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public ArrayList<Vente> getLesVentes() {
        return lesVentes;
    }

    public void setLesVentes(ArrayList<Vente> lesVentes) {
        this.lesVentes = lesVentes;
    }

    public void addVente(Vente uneVente){
        if (lesVentes ==null ){
            lesVentes = new ArrayList<Vente>();
        }
        lesVentes.add(uneVente);
    }
}
