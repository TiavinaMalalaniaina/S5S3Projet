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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
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
    int anciennete;
    int poste;
    double salaire;
    String poste_employe;

    public Employe() {
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

    public void setDate_naissance(Date date_naissance) throws SQLException {
        if(getAge(date_naissance) < 18){
            throw  new SQLException("Age invalide");
        }
        this.date_naissance = date_naissance;
    }
    
     public void setDate_naissance(String date_naissance) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
        java.sql.Date sqlDate = null;
        try {
            java.util.Date d= format.parse(date_naissance);
            sqlDate = new java.sql.Date(d.getTime());
         } catch (Exception ex) {
             throw new SQLException("unparsable DATE");
         }
        this.setDate_naissance(sqlDate);
         
    }
     
    public double getSalaire_base() {
        return salaire_base;
    }

    public void setSalaire_base(double salaire_base) throws SQLException{
        if(salaire_base <= 0){
          throw new SQLException("salaire invalide");
        }
        this.salaire_base = salaire_base;
    }

    public void setNom(String nom) throws SQLException {
        if(nom.trim().equals("")){
          throw new SQLException("Le nom ne doit pas etre vide");
        }
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

    public String getPoste_employe() {
        return poste_employe;
    }

    public void setPoste_employe(String poste_employe) {
        this.poste_employe = poste_employe;
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
        String sql = "INSERT INTO \"public\".employe (id, nom,type_employe_id,date_embauche,date_naissance,salaire_base) VALUES (default,?,?,default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, this.getNom());
            stmt.setInt(2,this.getType_employe_id());
            stmt.setDate(3,this.getDate_naissance());
            stmt.setDouble(4,this.getSalaire_base());
      
            
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
        String sql = "SELECT * FROM v_employe_detailled";
        
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
               employe.setAnciennete(rs.getInt("anciennete"));
               employe.setPoste(rs.getInt("poste"));
               employe.setSalaire(rs.getDouble("salaire"));
               employe.setPoste_employe(rs.getString("poste_employe"));
               employes.add(employe);
               
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return employes;
    }
      
       public static List<Employe> findByTypeEmployeId(Connection connection,int id) throws SQLException, Exception {
          
        List<Employe> employes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_employe_detailled where type_employe_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Employe employe = new Employe();
               employe.setId(rs.getInt("id"));
               employe.setNom(rs.getString("nom"));
               employe.setType_employe_id(rs.getInt("type_employe_id"));
               employe.setDateEmbauche(rs.getDate("date_embauche"));
               employe.setDate_naissance(rs.getDate("date_naissance"));
               employe.setSalaire_base(rs.getDouble("salaire_base"));
               employe.setAnciennete(rs.getInt("anciennete"));
               employe.setPoste(rs.getInt("poste"));
               employe.setSalaire(rs.getDouble("salaire"));
               employe.setPoste_employe(rs.getString("poste_employe"));
               employes.add(employe);
               
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return employes;
    }
       
         public static List<Employe> findByTypeEmployePoste(Connection connection,int id,int poste) throws SQLException, Exception {
          
        List<Employe> employes = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_employe_detailled where type_employe_id = ? and poste = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setInt(2, poste);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
               Employe employe = new Employe();
               employe.setId(rs.getInt("id"));
               employe.setNom(rs.getString("nom"));
               employe.setType_employe_id(rs.getInt("type_employe_id"));
               employe.setDateEmbauche(rs.getDate("date_embauche"));
               employe.setDate_naissance(rs.getDate("date_naissance"));
               employe.setSalaire_base(rs.getDouble("salaire_base"));
               employe.setAnciennete(rs.getInt("anciennete"));
               employe.setPoste(rs.getInt("poste"));
               employe.setSalaire(rs.getDouble("salaire"));
               employe.setPoste_employe(rs.getString("poste_employe"));
               employes.add(employe);
               
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return employes;
    }
         
      
      public String getGrade(){
          String poste = "";
        switch (this.getPoste()) {
            case 1:
                poste = "ouvrier";
                break;
            case 2:
                poste = "senior";
                break;
            case 3:
                poste = "expert";
                break;
            default:
                poste = "";
                break;
        }
            return poste;  
      }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    public int getPoste() {
        return poste;
    }

    public void setPoste(int poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
         
    private int getAge(Date date) {
        LocalDate d1 = date.toLocalDate();
        LocalDate current = LocalDate.now();
        Period p = Period.between(d1, current);
        return p.getYears();
    }
    
}
