package test;

import model.CategVente;
import model.Vente;

public class TestCategVente {

    public static void main (String args[]){

        // création d'une instance de lieu nommée c
        CategVente g = new CategVente();
        g.setCode(1);
        g.setLibelle("Vente");       

        //affectation de  la race au cheval grâce à la relation ManyToOne
        

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Catégorie de vente : " + g.getCode() + " " + g.getLibelle());
        
        Vente v = new Vente();
        v.setId(1);
        v.setNom("Vente de Houri");
        
        g.addVente(v);
        
        for (Vente ve : g.getLesVentes()){
            System.out.println("Vente correspond à cette catégorie : " + ve.getId() + " " + ve.getNom());
        }
    }
}
