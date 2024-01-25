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
public class VenteStat {
    int meuble_id;
    int genre_id;
    int taille;
    int quantite;
    int categorie_id;
    int style_id;
    String style_nom;
    String categorie_nom;
    double prix_vente;

    public int getMeuble_id() {
        return meuble_id;
    }

    public void setMeuble_id(String meuble_id) {
        this.meuble_id = Integer.parseInt(style_nom);
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = Integer.parseInt(genre_id);
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = Integer.parseInt(taille);
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = Integer.parseInt(quantite);
    }

    public int getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(String categorie_id) {
        this.categorie_id = Integer.parseInt(style_nom);
    }

    public int getStyle_id() {
        return style_id;
    }

    public void setStyle_id(String style_id) {
        this.style_id = Integer.parseInt(style_id);
    }

    public String getStyle_nom() {
        return style_nom;
    }

    public void setStyle_nom(String style_nom) {
        this.style_nom = style_nom;
    }

    public String getCategorie_nom() {
        return categorie_nom;
    }

    public void setCategorie_nom(String categorie_nom) {
        this.categorie_nom = categorie_nom;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(String prix_vente) {
        this.prix_vente = Double.parseDouble(style_nom);
    }
    
   
    
      public static List<VenteStat> findAll(Connection connection) throws SQLException, Exception {
        List<VenteStat> ventes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_vente_stat_genre_detailled";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               VenteStat vente = new VenteStat();
              
               vente.setMeuble_id(rs.getString("meuble_id"));
               vente.setGenre_id(rs.getString("genre_id"));
               vente.setTaille(rs.getString("taille"));
               vente.setQuantite(rs.getString("quantite"));
               vente.setCategorie_id(rs.getString("categorie_id"));
               vente.setStyle_id(rs.getString("style_id"));
               vente.setStyle_nom(rs.getString("style_nom"));
               vente.setCategorie_nom(rs.getString("categorie_nom"));
               vente.setPrix_vente(rs.getString("prix_vente"));
               ventes.add(vente);
              
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return ventes;
    }
      
        public static List<VenteStat> findVenteStat(Connection connection) throws SQLException, Exception {
        List<VenteStat> ventes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_vente_stat_all";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               VenteStat vente = new VenteStat();
              
               vente.setGenre_id(rs.getString("genre_id"));
               vente.setQuantite(rs.getString("quantite"));
               
               ventes.add(vente);
              
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return ventes;
    }
      
        public static List<VenteStat> findByMeubleId(Connection connection,int id) throws SQLException, Exception {
        List<VenteStat> ventes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_vente_stat_genre_detailled where meuble_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               VenteStat vente = new VenteStat();
              
               vente.setMeuble_id(rs.getString("meuble_id"));
               vente.setGenre_id(rs.getString("genre_id"));
               vente.setTaille(rs.getString("taille"));
               vente.setQuantite(rs.getString("quantite"));
               vente.setCategorie_id(rs.getString("categorie_id"));
               vente.setStyle_id(rs.getString("style_id"));
               vente.setStyle_nom(rs.getString("style_nom"));
               vente.setCategorie_nom(rs.getString("categorie_nom"));
               vente.setPrix_vente(rs.getString("prix_vente"));
              
               ventes.add(vente);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return ventes;
    }
}
