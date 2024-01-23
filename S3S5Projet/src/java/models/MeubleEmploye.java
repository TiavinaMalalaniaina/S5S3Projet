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
 * @author tiavi
 */
public class MeubleEmploye {
    int id;
    int meubleId;
    int typeEmployeId;
    int heureTravail;
    int nbPersonne;
    
    public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble_employe (id,meuble_id,type_employe_id, nb_employe, heure_travail) VALUES (default,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getMeubleId());
            stmt.setInt(2, this.getTypeEmployeId());
            stmt.setInt(3, this.getNbPersonne());
            stmt.setInt(4, this.getHeureTravail());
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
    
    public void setId(String id) {
        this.setId(Integer.parseInt(id));
    }

    public int getMeubleId() {
        return meubleId;
    }
    
    public void setMeubleId(String meubleId) {
        this.setMeubleId(Integer.parseInt(meubleId));
    }

    public void setMeubleId(int meubleId) {
        this.meubleId = meubleId;
    }

    public int getTypeEmployeId() {
        return typeEmployeId;
    }

    public void setTypeEmployeId(int typeEmployeId) {
        this.typeEmployeId = typeEmployeId;
    }
    
    public void setTypeEmployeId(String typeEmployeId) {
        this.setTypeEmployeId(Integer.parseInt(typeEmployeId));
    }

    public int getHeureTravail() {
        return heureTravail;
    }

    public void setHeureTravail(int heureTravail) {
        this.heureTravail = heureTravail;
    }
    
    public void setHeureTravail(String heureTravail) {
        this.setHeureTravail(Integer.parseInt(heureTravail));
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(int nbPersonne) {
        this.nbPersonne = nbPersonne;
    }
    
    public void setNbPersonne(String nbPersonne) {
        this.setNbPersonne(Integer.parseInt(nbPersonne));
    }

    
}
