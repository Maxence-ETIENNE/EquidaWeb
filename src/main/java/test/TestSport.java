package test;

import model.Epreuve;
import model.Sport;

public class TestSport {

    public static void main (String args[]){

        // création d'une instance de sport nommée s
        Sport s = new Sport();
        s.setId(2);
        s.setNom("Escalade");

        // Affichage des informations dans la console
        //voir notamment du nom de la race du cheval
        System.out.println("Sport : " + s.getNom() + " (id " + s.getId() + ") ");
        
        // création de deux instances d'épreuves nommée e1 et e2
        Epreuve e1 = new Epreuve();
        e1.setId(2);
        e1.setNom("Course d'escalade");
        // e.setDateDebut("2025-09-14"); // Je n'arrive pas à tester les LocalDate et LocalTime
        // e.setHeureDebut("15:30");
        
        // création de deux instances d'épreuves nommée e1 et e2
        Epreuve e2 = new Epreuve();
        e2.setId(3);
        e2.setNom("Escalade 100m");
        // e.setDateDebut("2025-09-15"); // Je n'arrive pas à tester les LocalDate et LocalTime
        // e.setHeureDebut("15:30");
        
        s.addEpreuve(e1);
        s.addEpreuve(e2);
        
        System.out.println("Liste des épreuves concernant ce sport: ");
        for (Epreuve e : s.getLesEpreuves()){
            System.out.println("Epreuve : " + e.getNom() + " (id " + e.getId() + ")");
        }
    }
}
