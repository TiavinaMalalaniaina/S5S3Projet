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
 * @author itu
 */
public class Style {
    int id;
    String nom;
    List<Materiel> materiaux;

    public Style(int id, String nom, List<Materiel> materiaux) {
        this.id = id;
        this.nom = nom;
        this.materiaux = materiaux;
    }

    public Style() {
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
    
    public List<Materiel> getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(List<Materiel> materiaux) {
        this.materiaux = materiaux;
    }
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".style (id, nom) VALUES (default,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
      public static List<Style> findAll(Connection connection) throws SQLException, Exception {
        List<Style> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM style";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Style model = new Style();
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

}
