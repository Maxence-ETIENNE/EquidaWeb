package test;

import model.Lieu;
import model.Vente;

public class TestLieu {

    public static void main (String args[]){

        // création d'une instance de lieu nommée c
        Lieu l = new Lieu();
        l.setId(1);
        l.setVille("Caen");
        l.setNbBoxes(6);
        l.setCommentaires("Belle ville");

        // création d'une instance de vente nommée v
        

        //affectation de  la race au cheval grâce à la relation ManyToOne
        

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Lieu : " + l.getId() + " " + l.getVille() + " " + l.getNbBoxes());
        
        Vente v = new Vente();
        v.setId(1);
        v.setNom("Vente de Houri");
        
        l.addVente(v);
        
        for (Vente ve : l.getLesVentes()){
            System.out.println("Vente se passant dans ce lieu : " + ve.getId() + " " + ve.getNom());
        }
    }
}
