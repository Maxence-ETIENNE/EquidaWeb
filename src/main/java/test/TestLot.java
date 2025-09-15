package test;

import model.Lot;
import model.Cheval;
import model.Vente;
import model.Enchere;

public class TestLot {

    public static void main (String args[]){

        Lot l = new Lot();
        l.setId(1);
        l.setPrixDepart(5000);
        
        // création d'une instance de cheval nommée c
        Cheval c = new Cheval();
        c.setId(6);
        c.setNom("Houri");
        c.setSexe("M");
        c.setSire("0807.000.010Z");
        
        l.setCheval(c);
        
        Vente v = new Vente();
        v.setId(1);
        v.setNom("Vente de Houri");
        
        l.setVente(v);

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Lot : " + l.getId() + " " + l.getPrixDepart() + " "
                + l.getCheval().getId() + " " + l.getCheval().getNom() + " "
                + l.getVente().getId() + " " + l.getVente().getNom());
        
        Enchere e1 = new Enchere();
        e1.setNumero(1);
        e1.setMontant(540);
        
        l.addEnchere(e1);
        
        for (Enchere e : l.getLesEncheres()){
            System.out.println("Enchère : " + e.getNumero() + " " + e.getMontant());
        }
    }
}
