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
import util.DBConnection;

/**
 *
 * @author itu
 */
public class MeubleMateriel {
    int id;
    int meubleId;
    int materielId;
    double petit;
    double grand;

    public MeubleMateriel() {
    }

    public double getPetit() {
        return petit;
    }

    public MeubleMateriel(int meubleId, int materielId, double petit, double grand) {
        this.meubleId = meubleId;
        this.materielId = materielId;
        this.petit = petit;
        this.grand = grand;
    }

    public void setPetit(double petit) {
        this.petit = petit;
    }

    public double getGrand() {
        return grand;
    }

    public void setGrand(double grand) {
        this.grand = grand;
    }

    public MeubleMateriel(int id, int meubleId, int materielId) {
        this.id = id;
        this.meubleId = meubleId;
        this.materielId = materielId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeubleId() {
        return meubleId;
    }

    public void setMeubleId(int meubleId) {
        this.meubleId = meubleId;
    }

    public int getMaterielId() {
        return materielId;
    }

    public void setMaterielId(int materielId) {
        this.materielId = materielId;
    }
    
      public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble_materiel (id,meuble_id, materiel_id,petit,grand) VALUES (default,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getMeubleId());
            stmt.setInt(2, this.getMaterielId());
            stmt.setDouble(3,this.getPetit());
             stmt.setDouble(4,this.getGrand());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
}

