/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meuble;

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
public class MaterielType {
    int id;
    int id_meubleType;
    int id_materiel;

    public MaterielType() {
    }

    public MaterielType(int id, int id_meubleType, int id_materiel) {
        this.id = id;
        this.id_meubleType = id_meubleType;
        this.id_materiel = id_materiel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_meubleType() {
        return id_meubleType;
    }

    public void setId_meubleType(int id_meubleType) {
        this.id_meubleType = id_meubleType;
    }

    public int getId_materiel() {
        return id_materiel;
    }

    public void setId_materiel(int id_materiel) {
        this.id_materiel = id_materiel;
    }
    
     public void setId_materiel(String nom_materiel){
         int id_materiel = Integer.parseInt(nom_materiel);
         this.setId_materiel(id_materiel);
    }
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".materiel_type (id, materiel_id, meuble_type_id) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getId_materiel());
            stmt.setInt(2, this.getId_meubleType());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
    
}
