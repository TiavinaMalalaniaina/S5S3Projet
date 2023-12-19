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
public class Meuble {
    int id;
    int styleId;
    int categorieId;
    List<Materiel> materiel;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    String styleNom;
    String categorieNom;
    String volume;
    
    public Meuble(int id, int styleId, int categorieId, List<Materiel> materiel, String styleNom, String categorieNom) {
        this.id = id;
        this.styleId = styleId;
        this.categorieId = categorieId;
        this.materiel = materiel;
        this.styleNom = styleNom;
        this.categorieNom = categorieNom;
    }

    public Meuble(int styleId, int categorieId, String styleNom, String categorieNom) {
        this.styleId = styleId;
        this.categorieId = categorieId;
        this.styleNom = styleNom;
        this.categorieNom = categorieNom;
    }

    public Meuble() {
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

    public List<Materiel> getMateriel() {
        return materiel;
    }

    public void setMateriel(List<Materiel> materiel) {
        this.materiel = materiel;
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
    
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble (id,categorie_id,style_id,) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getCategorieId());
            stmt.setInt(2, this.getStyleId());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
     }
        
    /**
     *
     * @param connection
     * @param id
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public static List<Meuble> findByMateriel(Connection connection,int id_materiel) throws SQLException, Exception {
        List<Meuble> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_meuble_materiel where materiel_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_materiel);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Meuble model = new Meuble();
                model.setId(rs.getInt("categorie_id"));   // int
                model.setStyleId(rs.getInt("style_id"));  
                model.setStyleNom(rs.getString("style_nom"));
                model.setCategorieNom(rs.getString("categorie_nom"));
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
    
    



