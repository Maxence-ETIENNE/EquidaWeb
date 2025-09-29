package database;

import model.Vente;
import model.Lieu;
import model.Cheval;
import model.Lot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoVente {
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;

    /**
     * Récupère tous les chevaux présents dans la base de données avec leurs lieus associées
     * @param cnx La connexion active à la base de données
     * @return ArrayList<Vente> La liste de tous les chevaux trouvés
     */
    public static ArrayList<Vente> getLesVentes(Connection cnx) {
        ArrayList<Vente> lesVentes = new ArrayList<Vente>();
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, v.dateDebutVente as v_dateDebutVente, " +
                "l.id as l_id, l.ville as l_ville " +
                "FROM vente v " +
                "INNER JOIN lieu l ON v.lieu_id = l.id"
            );
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Vente v = new Vente();
                v.setId(resultatRequete.getInt("v_id"));
                v.setNom(resultatRequete.getString("v_nom"));
                v.setDateDebutVente(resultatRequete.getString("v_dateDebutVente"));
                Lieu l = new Lieu();
                l.setId(resultatRequete.getInt("l_id"));
                l.setVille(resultatRequete.getString("l_ville"));
                v.setLieu(l);
                lesVentes.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLesVentes a généré une exception SQL");
        }
        return lesVentes;
    }

    /**
     * Récupère un vente spécifique par son identifiant
     * @param cnx La connexion active à la base de données
     * @param id L'identifiant du vente recherché
     * @return Vente Le vente trouvé ou null si non trouvé
     */
    public static Vente getLaVente(Connection cnx, int idVente) {
        Vente vente = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT v.id as v_id, v.nom as v_nom, v.dateDebutVente as v_dateDebutVente, " +
                "l.id as l_id, l.ville as l_ville " +
                "FROM vente v " +
                "INNER JOIN lieu l ON v.lieu_id = l.id " +
                "WHERE v.id = ?"
            );
            requeteSql.setInt(1, idVente);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                vente = new Vente();
                vente.setId(resultatRequete.getInt("v_id"));
                vente.setNom(resultatRequete.getString("v_nom"));
                vente.setDateDebutVente(resultatRequete.getString("v_dateDebutVente"));
                Lieu lieu = new Lieu();
                lieu.setId(resultatRequete.getInt("l_id"));
                lieu.setVille(resultatRequete.getString("l_ville"));
                vente.setLieu(lieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLaVente a généré une exception SQL");
        }
        return vente;
    }
    /**
     * Ajoute un nouveau vente dans la base de données
     * @param cnx La connexion active à la base de données
     * @param vente Le vente à ajouter
     * @return boolean true si l'ajout a réussi, false sinon
     */
    public static boolean ajouterVente(Connection cnx, Vente vente) {
    try {
        requeteSql = cnx.prepareStatement(
            "INSERT INTO vente (nom, date_naissance, lieu_id) VALUES (?, ?, ?)",
            PreparedStatement.RETURN_GENERATED_KEYS
        );
        requeteSql.setString(1, vente.getNom());
        
        // Gestion de la date de naissance
        if (vente.getDateDebutVente() != null) {
            requeteSql.setDate(2, java.sql.Date.valueOf(vente.getDateDebutVente()));
        } else {
            requeteSql.setNull(2, java.sql.Types.DATE);
        }
        
        requeteSql.setInt(3, vente.getLieu().getId());
        
        int result = requeteSql.executeUpdate();
        
        if (result == 1) {
            // Récupération de l'id auto-généré
            ResultSet rs = requeteSql.getGeneratedKeys();
            if (rs.next()) {
                vente.setId(rs.getInt(1));
            }
            return true;
        }
        return false;
        
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erreur lors de l'ajout du vente");
        return false;
    }
}
    
    public static Lieu getLieuById(Connection cnx, int idLieu) {
        Lieu lieu = null;
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT l.id as l_id, l.ville as l_ville " +
                "FROM lieu l " +
                "INNER JOIN lieu l ON v.lieu_id = l.id " +
                "WHERE l.id = ?"
            );
            requeteSql.setInt(1, idLieu);
            resultatRequete = requeteSql.executeQuery();
            if (resultatRequete.next()) {
                lieu.setId(resultatRequete.getInt("l_id"));
                lieu.setVille(resultatRequete.getString("l_ville"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLieuById a généré une exception SQL");
        }
        
        return lieu;
    }
    
    public static ArrayList<Lot> getLotsByVenteId(Connection cnx, int idVente) {
        ArrayList<Lot> lesLots = new ArrayList<Lot>();
        
        try {
            requeteSql = cnx.prepareStatement(
                "SELECT l.id as l_id, c.id as c_id, c.nom as c_nom, l.prixDepart as l_prixDepart " +
                "FROM vente v " +
                "INNER JOIN lot l on v.id = l.vente_id " +
                "INNER JOIN cheval c on c.id = l.cheval_id " +
                "WHERE v.id = ?"
            );
            requeteSql.setInt(1, idVente);
            resultatRequete = requeteSql.executeQuery();
            while (resultatRequete.next()) {
                Lot lot = new Lot();
                Cheval cheval = new Cheval();
                lot.setId(resultatRequete.getInt("l_id"));
                cheval.setId(resultatRequete.getInt("c_id"));
                cheval.setNom(resultatRequete.getString("c_nom"));
                lot.setPrixDepart(resultatRequete.getInt("l_prixDepart"));
                lot.setCheval(cheval);
                lesLots.add(lot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("La requête de getLotsByVenteId a généré une exception SQL");
        }
        return lesLots;
    }
}