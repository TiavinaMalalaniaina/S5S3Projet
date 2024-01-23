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
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author tiavi
 */
public class Employe {
    int id;
    String nom;
    int type_employe_id;
    Date dateEmbauche;
    Date date_naissance;
    double salaire_base;

    private Employe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public double getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(double salaire_base) {
        this.salaire_base = salaire_base;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getType_employe_id() {
        return type_employe_id;
    }

    public void setType_employe_id(int type_employe_id) {
        this.type_employe_id = type_employe_id;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Employe(String nom, int type_employe_id, Date dateEmbauche, Date date_naissance, double salaire_base) {
        this.nom = nom;
        this.type_employe_id = type_employe_id;
        this.dateEmbauche = dateEmbauche;
        this.date_naissance = date_naissance;
        this.salaire_base = salaire_base;
    }

   
    
    
     public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".employe (id, nom,type_emplye_id,date_embauche,date_naissance,salaire_base) VALUES (default,?,?,?,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            stmt.setInt(2,this.getType_employe_id());
            stmt.setDate(3,this.getDateEmbauche());
            stmt.setDate(4,this.getDate_naissance());
            stmt.setDouble(5,this.getSalaire_base());
      
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
      public static List<Employe> findAll(Connection connection) throws SQLException, Exception {
          
        List<Employe> employes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM employe";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Employe employe = new Employe();
               employe.setId(rs.getInt("id"));
               employe.setNom(rs.getString("nom"));
               employe.setType_employe_id(rs.getInt("type_employe_id"));
               employe.setDateEmbauche(rs.getDate("date_embauche"));
               employe.setDate_naissance(rs.getDate("date_naissance"));
               employe.setSalaire_base(rs.getDouble("salaire_base"));
               employes.add(employe);
               
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return employes;
    }
         
}
