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
import util.DBConnection;

/**
 *
 * @author itu
 */
public class StyleMateriel {
    int id;
    int idStyle;
    int idMateriel;

    public StyleMateriel() {
    }

    public StyleMateriel(int id, int idMeubleType, int idMateriel) {
        this.id = id;
        this.idStyle = idMeubleType;
        this.idMateriel = idMateriel;
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

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int id_meubleType) {
        this.idStyle = id_meubleType;
    }
    
    public void setIdStyle(String idStyle) {
        this.setIdStyle(Integer.parseInt(idStyle));
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }
    
    public void setIdMateriel(String nomMateriel){
         int idMateriel = Integer.parseInt(nomMateriel);
         this.setIdMateriel(idMateriel);
    }
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".style_materiel (id,style_id, materiel_id) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getIdStyle());
            stmt.setInt(2, this.getIdMateriel());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
    
}
