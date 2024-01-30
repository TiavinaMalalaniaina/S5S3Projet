/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author tiavi
 */
public class ViewModel {
    public final static String URLCONTEXT = "http://localhost:8080/S3S5Projet/";
    
    public List<Materiel> materiels = new ArrayList<>();
    public List<Style> meubleType = new ArrayList<>();
    public List<Style> styles = new ArrayList<>();
    public List<Categorie> categories = new ArrayList<>();
    public List<Meuble> meubles = new ArrayList<>();
    public List<VenteStat> venteStat = new ArrayList<>();
    public List<VenteStat> venteStatAll = new ArrayList<>();
    public List<TypeEmploye> typeEmployes = new ArrayList<>();
    public List<Employe> employes = new ArrayList<>();
    public int meubleId = 0;
    public List<Grade> grades = new ArrayList<>();
    public List<Client> clients = new ArrayList<>();
    
    String error;
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    public static String numberFormat(Number montant) {
        NumberFormat formatSansUnite = NumberFormat.getNumberInstance(Locale.getDefault());
        formatSansUnite.setMaximumFractionDigits(2);
        return formatSansUnite.format(montant);
    }
    
    public static String moneyFormat(Number montant) {
        NumberFormat formatMonetaire = NumberFormat.getCurrencyInstance(Locale.getDefault());
        return formatMonetaire.format(montant);
    }
    
    
}
