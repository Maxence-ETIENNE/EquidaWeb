package test;

import model.Enchere;
import model.Lot;

public class TestEnchere {

    public static void main (String args[]){

        // création d'une instance de lieu nommée c
        Enchere e = new Enchere();
        e.setNumero(1);
        e.setMontant(540);       

        Lot l = new Lot();
        l.setId(1);
        l.setPrixDepart(5000);
        
        e.setLot(l);

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Enchère numéro " + e.getNumero() + " ayant comme montant " + e.getMontant()
        + "\nfaisant partie du lot " + e.getLot().getId() + " avec un prix de départ de " + e.getLot().getPrixDepart());
        
    }
}
