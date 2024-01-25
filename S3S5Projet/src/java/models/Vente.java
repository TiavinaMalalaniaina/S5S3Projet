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
public class Vente {
    int id;
    int client_id;
    int meuble_id;
    int taille;
    int quantite;
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getMeuble_id() {
        return meuble_id;
    }

    public void setMeuble_id(int meuble_id) {
        this.meuble_id = meuble_id;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

  
    
       public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".vente (id, client_id,meuble_id,taille,quantite) VALUES (default,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
           
            stmt.setInt(1,this.getClient_id());
            stmt.setInt(2, this.getMeuble_id());
            stmt.setInt(3, this.getTaille());
            stmt.setInt(4, this.getQuantite());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
      public static List<Vente> findAll(Connection connection) throws SQLException, Exception {
        List<Vente> ventes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM vente";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Vente vente = new Vente();
              
               vente.setId(rs.getInt("id"));
               vente.setClient_id(rs.getInt("client_id"));
               vente.setMeuble_id(rs.getInt("meuble_id"));
               vente.setTaille(rs.getInt("taille"));
               vente.setQuantite(rs.getInt("quantite"));
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return ventes;
    }
    
}
