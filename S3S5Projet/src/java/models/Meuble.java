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
public class Meuble {
    int id;
    int styleId;
    int categorieId;
    List<Materiel> materiels;
    String styleNom;
    String categorieNom;
    double petit;
    double grand;
    
    public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble (id, style_id, categorie_id) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getStyleId());
            stmt.setInt(2, this.getCategorieId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
    public static List<Meuble> findAll(Connection connection) {
        return new ArrayList<>();
    }

    public static List<Meuble> findByMateriel(Connection connection, int materielId) throws SQLException {
        List<Meuble> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_meuble_materiel where materiel_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, materielId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Meuble model = new Meuble();
                model.setId(rs.getInt("meuble_id"));   // int
                model.setStyleNom(rs.getString("style_nom"));  // String
                model.setCategorieNom(rs.getString("categorie_nom"));  // String
                model.setPetit(rs.getDouble("petit"));
                model.setGrand(rs.getDouble("grand"));
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public String getStyleNom() {
        return styleNom;
    }

    public void setStyleNom(String styleNom) {
        this.styleNom = styleNom;
    }

    public String getCategorieNom() {
        return categorieNom;
    }

    public void setCategorieNom(String categorieNom) {
        this.categorieNom = categorieNom;
    }

    public double getPetit() {
        return petit;
    }

    public void setPetit(double petit) {
        this.petit = petit;
    }

    public double getGrand() {
        return grand;
    }

    public void setGrand(double grand) {
        this.grand = grand;
    }
    
    
    
}
