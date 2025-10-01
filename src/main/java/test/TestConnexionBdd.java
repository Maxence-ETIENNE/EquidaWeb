package test;

import java.sql.Connection;
import java.util.ArrayList;

import model.Cheval;
import model.Vente;

import database.Connexionbdd;
import database.DaoCheval;
import database.DaoVente;

public class TestConnexionBdd {

    public static void main (String args[]) {

        Connection cnx = Connexionbdd.ouvrirConnexion();
        System.out.println ("nombre de chevaux = " + DaoCheval.getLesChevaux(cnx).size());

        System.out.println ("nombre de ventes = " + DaoVente.getLesVentes(cnx).size());
        
        for (Cheval c : DaoCheval.getLesChevaux(cnx)) {
        System.out.println("Cheval : " + c.getId() + " " + c.getNom() + " " + c.getDateNaissance() + " "
                + c.getRace().getId() + " " + c.getRace().getNom());
        }
        
        Cheval c = DaoCheval.getLeCheval(cnx, 17);
        System.out.println("Cheval spécifié : " + c.getId() + " " + c.getNom() + " " + c.getDateNaissance() + " "
                + c.getRace().getId() + " " + c.getRace().getNom());
        
        for (Vente v : DaoVente.getLesVentes(cnx)) {
        System.out.println("Vente : " + v.getId() + " " + v.getNom() + " "
                + v.getLieu().getId() + " " + v.getLieu().getVille());
        }
        
        Vente v = DaoVente.getLaVente(cnx, 2);
        System.out.println("Vente spécifiée : " + v.getId() + " " + v.getNom() + " "
                + v.getLieu().getId() + " " + v.getLieu().getVille());
    }

}
