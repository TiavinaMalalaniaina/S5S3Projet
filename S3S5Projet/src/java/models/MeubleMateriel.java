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
 * @author tiavi
 */
public class MeubleMateriel {
    int id;
    int meubleId;
    int materielId;
    double petit;
    double grand;

    public MeubleMateriel() {
      
    }

    @Override
    public String toString() {
        return "MeubleMeubleMateriel{" + "id=" + id + ", meubleId=" + meubleId + ", materielId=" + materielId + ", petit=" + petit + ", grand=" + grand + '}';
    }

    public MeubleMateriel(int id, int meubleId, int materielId, double petit, double grand) {
        this.id = id;
        this.meubleId = meubleId;
        this.materielId = materielId;
        this.petit = petit;
        this.grand = grand;
    }
    
    
    
    public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble_materiel (id, meuble_id, materiel_id, petit, grand) VALUES (default,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getMeubleId());
            stmt.setInt(2, this.getMeubleMaterielId());
            stmt.setDouble(3, this.getPetit());
            stmt.setDouble(4, this.getGrand());
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
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

    public int getMeubleMaterielId() {
        return materielId;
    }

    public void setMeubleMaterielId(int materielId) {
        this.materielId = materielId;
    }

    public double getPetit() {
        return petit;
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
    
     public static List<MeubleMateriel> findByType(Connection connection,int id) throws SQLException, Exception {
        List<MeubleMateriel> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM meuble_materiel where meuble_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MeubleMateriel model = new MeubleMateriel();
                model.setId(rs.getInt("id"));   // int
                model.setMeubleId(rs.getInt("meuble_id")); 
                model.setMeubleMaterielId(rs.getInt("materiel_id"));
                 model.setPetit(rs.getDouble("petit"));
                  model.setGrand(rs.getDouble("grand"));
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }
}
