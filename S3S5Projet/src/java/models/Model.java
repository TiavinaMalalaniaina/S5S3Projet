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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author tiavi
 */
public class Model {
    int id;
    String nom;
    LocalDate dtn;
    double salaire;
    LocalTime heure;
    LocalDateTime dateHeure;
    boolean marie; 
    
    /**
     * 
     * @param connection
     * @return
     * @throws SQLException 
     */
    public static List<Model> findAll(Connection connection) throws SQLException, Exception {
        List<Model> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM model";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Model model = new Model();
                model.setId(rs.getInt("id"));   // int
                model.setNom(rs.getString("nom"));  // String
                model.setDtn(rs.getDate("dtn").toLocalDate());  // LocalDate
                model.setSalaire(rs.getDouble("salaire"));  // Double
                model.setHeure(rs.getTime("heure").toLocalTime());  // LocalTime
                model.setDateHeure(rs.getTimestamp("dateheure").toLocalDateTime()); // LocalDateTime
                model.setMarie(rs.getBoolean("marie")); // Boolean
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }
    
    /**
     * 
     * @param connection
     * @param id
     * @return
     * @throws SQLException 
     */
    public static Model findById(Connection connection, int id) throws SQLException, Exception {
        Model models = new Model();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM model WHERE id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Model model = new Model();
                model.setId(rs.getInt("id"));   // int
                model.setNom(rs.getString("nom"));  // String
                model.setDtn(rs.getDate("dtn").toLocalDate());  // LocalDate
                model.setSalaire(rs.getDouble("salaire"));  // Double
                model.setHeure(rs.getTime("heure").toLocalTime());  // LocalTime
                model.setDateHeure(rs.getTimestamp("dateheure").toLocalDateTime()); // LocalDateTime
                model.setMarie(rs.getBoolean("marie")); // Boolean
            } else {
                throw new SQLException("Model not found");
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
    }
    
    /**
     * Fonction pour sauvegarder l'objet
     * @param connection
     * @param models
     * @throws SQLException 
     */
    public static void save(Connection connection, Model[] models) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".model (id, nom, dtn, salaire, heure, dateHeure, marie) VALUES (default,?,?,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (Model model : models) {
                stmt.setString(1, model.getNom());
                stmt.setDate(2, Date.valueOf(model.getDtn()));
                stmt.setDouble(3, model.getSalaire());
                stmt.setTime(4, Time.valueOf(model.getHeure()));
                stmt.setTimestamp(5, Timestamp.valueOf( model.getDateHeure() ));
                stmt.setBoolean(6, model.isMarie());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) model.setId(rs.getInt("id"));
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
    /**
     * Fonction pour sauvegarder l'objet
     * @param connection
     * @throws SQLException 
     */
    public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".model (id, nom, dtn, salaire, heure, dateHeure, marie) VALUES (default,?,?,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            stmt.setDate(2, Date.valueOf(this.getDtn()));
            stmt.setDouble(3, this.getSalaire());
            stmt.setTime(4, Time.valueOf( this.getHeure() ));
            stmt.setTimestamp(5, Timestamp.valueOf( this.getDateHeure() ));
            stmt.setBoolean(6, this.isMarie());
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDtn() {
        return dtn;
    }

    public void setDtn(LocalDate dtn) throws Exception {
        if (getAge(dtn) < 18) throw new Exception("MINEUR");
        this.dtn = dtn;
    }
    
    public void setDtn(String dtn) throws Exception {
        setDtn(LocalDate.parse(dtn));
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    
    public void setSalaire(String salaire) {
        setSalaire(Double.parseDouble(salaire));
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }
    
    public void setHeure(String heure) {
        this.setHeure(LocalTime.parse(heure));
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }
    
    public void setDateHeure(String dateHeure) {
        this.setDateHeure(LocalDateTime.parse(dateHeure));
    }

    public boolean isMarie() {
        return marie;
    }

    public void setMarie(boolean marie) {
        this.marie = marie;
    }
    
    
    public static int getAge(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        Period difference = Period.between(date, currentDate);
        return difference.getYears();
    }

    
}
