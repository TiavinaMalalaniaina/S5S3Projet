package models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itu
 */
public class MaterielStock {
    int id;
    int materiel_id;
    double quantite;

    public MaterielStock(int id, int materiel_id, double quantite) {
        this.id = id;
        this.materiel_id = materiel_id;
        this.quantite = quantite;
    }

    public MaterielStock(int materiel_id, double quantite) {
        this.materiel_id = materiel_id;
        this.quantite = quantite;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMateriel_id() {
        return materiel_id;
    }

    public void setMateriel_id(int materiel_id) {
        this.materiel_id = materiel_id;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    
       public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".materiel_stock (id, materiel_id, quantity) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getId());
            stmt.setDouble(2, this.getQuantite());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
}
