/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author tiavi
 */
public class Grade {
    int id;
    String nom;
    int annee;
    int tauxHoraire;

    public Grade(int id, String nom, int annee, int tauxHoraire) {
        this.setId(id);
        this.setNom(nom);
        this.setAnnee(annee);
        this.setTauxHoraire(tauxHoraire);
    }

    public Grade(String id, String nom, String annee, String tauxHoraire) {
        this.setId(id);
        this.setNom(nom);
        this.setAnnee(annee);
        this.setTauxHoraire(tauxHoraire);
    }
    
    
    
    public static List<Grade> findAll(Connection connection) throws SQLException {
        List<Grade> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM grade";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                String id = rs.getString("id");
                String nom = rs.getString("nom");
                String annee = rs.getString("annee");
                String tauxHoraire = rs.getString("taux_horaire");
                
                Grade model = new Grade(id, nom, annee, tauxHoraire);
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }
     
    public void update(int id, Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "UPDATE grade SET annee=?, taux_horaire=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getAnnee());
            stmt.setInt(2, this.getTauxHoraire());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }

    public Grade(String nom, int annee, int tauxHoraire) {
        this.nom = nom;
        this.annee = annee;
        this.tauxHoraire = tauxHoraire;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setId(String id) {
        this.setId(Integer.parseInt(id));
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
    public void setAnnee(String annee) {
        this.setAnnee(Integer.parseInt(annee));
    }

    public int getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(int tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    
    public void setTauxHoraire(String tauxHoraire) {
        this.setTauxHoraire(Integer.parseInt(tauxHoraire));
    }
    
    
}
