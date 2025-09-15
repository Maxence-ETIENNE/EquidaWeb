package test;

import model.Epreuve;
import model.Sport;

public class TestEpreuve {

    public static void main (String args[]){

        // création d'une instance d'épreuve nommée e
        Epreuve e = new Epreuve();
        e.setId(1);
        e.setNom("Course d'équitation");
        // e.setDateDebut("2025-06-17"); // Je n'arrive pas à tester les LocalDate et LocalTime
        // e.setHeureDebut("16:30");

        // création d'une instance de sport nommée s
        Sport s = new Sport();
        s.setId(1);
        s.setNom("Equitation");

        //affectation du sport à l'épreuve grâce à la relation ManyToOne
        e.setSport(s);

        // Affichage des informations dans la console
        //voir notamment du nom du sport sur lequel se porte l'épreuve
        System.out.println("Epreuve : " + e.getNom() + " (id " + e.getId() + ") " 
                //+ "se déroulant le " + e.getDateDebut() + " à " + e.getHeureDebut() + " "
                + "et porte sur : " + e.getSport().getNom() + " (id " + e.getSport().getId() + ")");
    }
}
