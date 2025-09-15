package test;

import model.Cheval;
import model.Race;

public class TestCheval {

    public static void main (String args[]){

        // création d'une instance de cheval nommée c
        Cheval c = new Cheval();
        c.setId(6);
        c.setNom("Houri");
        c.setSexe("M");
        c.setSire("0807.000.010Z");

        // création d'une instance de race nommée r
        Race r = new Race();
        r.setId(1);
        r.setNom("pur-sang anglais");

        //affectation de  la race au cheval grâce à la relation ManyToOne
        c.setRace(r);

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Cheval : " + c.getId() + " " + c.getNom() + " " + c.getSexe() + " " + c.getSire() + " "
                + c.getRace().getId() + " " + c.getRace().getNom());
        
        Cheval e1 = new Cheval();
        e1.setId(1);
        e1.setNom("Valdack");
        
        Cheval e2 = new Cheval();
        e2.setId(3);
        e2.setNom("Herricka");
        
        c.addEnfant(e1);
        c.addEnfant(e2);
        
        for (Cheval e : c.getLesEnfants()){
            System.out.println("Enfant : " + e.getId() + " " + e.getNom());
        }
    }
}
