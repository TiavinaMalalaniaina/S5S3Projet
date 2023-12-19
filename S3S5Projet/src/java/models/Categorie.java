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
public class Categorie {
    int id_categorie;
    String nom_categorie;

    public Categorie(int id_categorie, String nom_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
    }

    public Categorie() {
         //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    
     public static List<Categorie> findAll(Connection connection) throws SQLException, Exception {
        List<Categorie> categories = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM categorie";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Categorie categorie = new Categorie();
                categorie.setId_categorie(rs.getInt("id"));   // int
                categorie.setNom_categorie(rs.getString("nom"));  // String
                categories.add(categorie);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return categories;
    }
}
