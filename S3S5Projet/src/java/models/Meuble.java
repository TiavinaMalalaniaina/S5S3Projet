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
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author tiavi
 */
public class Meuble {
    int id;
    int styleId;
    int categorieId;
    List<Materiel> materiels;
    String styleNom;
    String categorieNom;
    double petit;
    double grand;
    double prix_petit;
    double prix_grand;

    private Meuble() {
       
    }

    public double getPrix_petit() {
        return prix_petit;
    }

    public void setPrix_petit(double prix_petit) {
        this.prix_petit = prix_petit;
    }

    public double getPrix_grand() {
        return prix_grand;
    }

    public void setPrix_grand(double prix_grand) {
        this.prix_grand = prix_grand;
    }

    public Meuble(int id, int styleId, int categorieId, List<Materiel> materiels, String styleNom, String categorieNom, double petit, double grand, double prix_petit, double prix_grand) {
        this.id = id;
        this.styleId = styleId;
        this.categorieId = categorieId;
        this.materiels = materiels;
        this.styleNom = styleNom;
        this.categorieNom = categorieNom;
        this.petit = petit;
        this.grand = grand;
        this.prix_petit = prix_petit;
        this.prix_grand = prix_grand;
    }
    
    
    
    public void save(Connection connection) throws SQLException {
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "INSERT INTO \"public\".meuble (id, style_id, categorie_id) VALUES (default,?,?) RETURNING id";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, this.getStyleId());
            stmt.setInt(2, this.getCategorieId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) this.setId(rs.getInt("id"));
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
    }
    
    public static List<Meuble> findAll(Connection connection) {
        return new ArrayList<>();
    }

    public static List<Meuble> findByMateriel(Connection connection, int materielId) throws SQLException {
        List<Meuble> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_meuble_materiel where materiel_id = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, materielId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Meuble model = new Meuble();
                model.setId(rs.getInt("meuble_id"));   // int
                model.setStyleNom(rs.getString("style_nom"));  // String
                model.setCategorieNom(rs.getString("categorie_nom"));  // String
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
    
    
     public void buildMeuble(int meubleId, double petit,double grand){
         
           Connection connection;
           List<MaterielStock> materielStock = new ArrayList<>();
           
        try {
            connection = DBConnection.getConnection();
               try {
                   List<MeubleMateriel> meubles =  MeubleMateriel.findByType(connection,meubleId);
                   for(MeubleMateriel m : meubles){
                     Materiel mat = Materiel.findQuantite(connection,m.getMeubleMaterielId());
                     double quantite = mat.getQuantite();
                     if(quantite <(petit * m.getPetit())+(grand * m.getGrand())){
                         
                     }
                     else{
                       MaterielStock ms = new MaterielStock(m.getId(),-((petit * m.getPetit())+(grand * m.getGrand())));
                       materielStock.add(ms);
                     }
                   }
                   
                   for(MaterielStock m :materielStock){
                        m.save(connection);
                   }
                   MeubleStock mb = new MeubleStock(meubleId,petit,grand);
                   mb.save(connection);
                   
               } catch (Exception ex) {
                   Logger.getLogger(Meuble.class.getName()).log(Level.SEVERE, null, ex);
               }
        } catch (SQLException ex) {
            Logger.getLogger(Meuble.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
     
     
        public List<Meuble> findAllWithQuantite(Connection connection) throws SQLException{
            List<Meuble> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "SELECT * FROM v_meuble_stock";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Meuble model = new Meuble();
                model.setId(rs.getInt("meuble_id"));
                model.setStyleNom(rs.getString("style_nom"));
                model.setCategorieNom(rs.getString("categorie_nom"));
                model.setPetit(rs.getDouble("quantite_petit"));
                model.setGrand(rs.getDouble("quantite_grand"));
                models.add(model);
            }
        } finally {
            if (!wasConnected) {
                connection.close();
            }
        } 
        return models;
       }
       
       
     public static List<Meuble> findByPrix(Connection connection,double prix_min,double prix_max) throws SQLException {
        List<Meuble> models = new ArrayList<>();
        boolean wasConnected = true;
        if (connection == null) {
            wasConnected = false;
            connection = DBConnection.getConnection();
        }
        String sql = "select * from v_meuble_prix where (prix_petit >= ? and  prix_petit =< ?) or(prix_grand =< ? and prix_grand >= ?);";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, prix_min);
            stmt.setDouble(2, prix_max);
            stmt.setDouble(3, prix_min);
            stmt.setDouble(4, prix_max);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Meuble model = new Meuble();
                model.setId(rs.getInt("meuble_id"));   // int
                model.setStyleNom(rs.getString("style_nom"));  // String
                model.setCategorieNom(rs.getString("categorie_nom"));  // String
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
    
     
     
       
       
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public String getStyleNom() {
        return styleNom;
    }

    public void setStyleNom(String styleNom) {
        this.styleNom = styleNom;
    }

    public String getCategorieNom() {
        return categorieNom;
    }

    public void setCategorieNom(String categorieNom) {
        this.categorieNom = categorieNom;
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
    
    
    
}
