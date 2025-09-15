package test;

import model.Cheval;
import model.Race;

public class TestCheval {

    public static void main (String args[]){

        // création d'une instance de cheval nommée c
        Cheval c = new Cheval();
        c.setId(3);
        c.setNom("Herricka");
        c.setSexe("F");
        c.setSire("0808.000.020Z");

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
        
        Cheval p1 = new Cheval();
        p1.setId(6);
        p1.setNom("Houri");
        
        Cheval m1 = new Cheval();
        m1.setId(7);
        m1.setNom("Hussa");
        
        c.setPere(p1);
        c.setMere(m1);
        
        System.out.println("Père : " + c.getPere() + " | Mère " + c.getMere());
    }
}
