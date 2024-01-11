/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import models.Model;
import util.DBConnection;

/**
 *
 * @author itu
 */
public class Materiel {
    int id;
    String nom;
    double prixUnitaire;
    double quantite;

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
    
    
    public Materiel(){}

    public Materiel(String nom, double prixUnitaire) {
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }
    
    public Materiel(int id,String nom){
        this.id = id;
        this.nom = nom;
    }

    public Materiel(int id, String nom, double prixUnitaire) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public List<Materiel> findByMeubleId(Connection connection) {
        return new ArrayList<>();
    }
 
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".materiel (id, nom,prix_unitaire) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            stmt.setDouble(1, this.getPrixUnitaire());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
     
     public static List<Materiel> findByType(Connection connection,int id) throws SQLException, Exception {
        List<Materiel> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_style_materiel where style_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Materiel model = new Materiel();
                model.setId(rs.getInt("materiel_id"));   // int
                model.setNom(rs.getString("materiel_nom"));  // String
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }

       public static List<Materiel> findAll(Connection connection) throws SQLException, Exception {
        List<Materiel> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM materiel";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Materiel model = new Materiel();
                model.setId(rs.getInt("id"));   // int
                model.setNom(rs.getString("nom"));  // String
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }
         public static Materiel findQuantite(Connection connection,int id) throws SQLException, Exception {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_materiel_stock where materiel_id = ?";
        
        Materiel model = new Materiel();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                model.setId(rs.getInt("materiel_id"));   // int
                model.setNom(rs.getString("materiel_nom"));  // String
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return model;
    }

       
}
