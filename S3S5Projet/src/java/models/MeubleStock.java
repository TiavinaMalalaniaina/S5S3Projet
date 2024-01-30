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
public class MeubleStock {
    int id;
    int meuble_id;
    double quantite_petit;
    double quantite_grand;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeuble_id() {
        return meuble_id;
    }

    public void setId(String id) {
        this.setId(Integer.parseInt(id));
    }
    
    public void setMeuble_id(int meuble_id) {
        this.meuble_id = meuble_id;
    }
    
    public void setMeuble_id(String meubleId) {
        this.setMeuble_id(Integer.parseInt(meubleId));
    }

    public double getQuantite_petit() {
        return quantite_petit;
    }

    public void setQuantite_petit(double quantite_petit) {
        this.quantite_petit = quantite_petit;
    }

    public void setQuantite_petit(String quantite) {
        this.setQuantite_petit(Double.parseDouble(quantite));
    }
    
    public double getQuantite_grand() {
        return quantite_grand;
    }

    public void setQuantite_grand(double quantite_grand) {
        this.quantite_grand = quantite_grand;
    }
    
    public void setQuantite_grand(String quantite) {
        this.setQuantite_grand(Double.parseDouble(quantite));
    }
    
    public MeubleStock() {
        
    }

    public MeubleStock(int meuble_id, double quantite_petit, double quantite_grand) {
        this.meuble_id = meuble_id;
        this.quantite_petit = quantite_petit;
        this.quantite_grand = quantite_grand;
    }
    
    

    public MeubleStock(int id, int meuble_id, double quantite_petit, double quantite_grand) {
        this.id = id;
        this.meuble_id = meuble_id;
        this.quantite_petit = quantite_petit;
        this.quantite_grand = quantite_grand;
    }
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble_stock (id,meuble_id,quantite_petit, quantite_grand) VALUES (default,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getMeuble_id());
            stmt.setDouble(2, this.getQuantite_petit());
            stmt.setDouble(3,this.getQuantite_grand());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
}
