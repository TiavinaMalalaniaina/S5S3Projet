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
public class Client {
    int id;
    String nom;
    int genre_id;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom.trim().equals("")) throw new Exception("Le nom est vide");
        this.nom = nom;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = Integer.parseInt(genre_id);
    }
    
      public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".client (id, nom,genre_id) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            stmt.setInt(2,this.getGenre_id());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getString("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
      public static List<Client> findAll(Connection connection) throws SQLException, Exception {
        List<Client> clients = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM client";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Client client = new Client();
              
                client.setId(rs.getString("id"));
                client.setNom(rs.getString("nom"));
                client.setGenre_id(rs.getString("genre_id"));
                clients.add(client);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return clients;
    }

}
