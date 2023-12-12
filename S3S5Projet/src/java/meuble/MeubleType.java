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
import java.util.List;
import util.DBConnection;

/**
 *
 * @author itu
 */
public class MeubleType {
    int id;
    String nom;
    List<Materiel> materiaux;

    public MeubleType(int id, String nom, List<Materiel> materiaux) {
        this.id = id;
        this.nom = nom;
        this.materiaux = materiaux;
    }

    public MeubleType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Materiel> getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(List<Materiel> materiaux) {
        this.materiaux = materiaux;
    }
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble_type (id, nom) VALUES (default,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
    
}
