/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Meuble;
import models.MeubleStock;
import models.Vente;
import util.DBConnection;

/**
 *
 * @author tiavi
 */
@WebServlet(name = "SaveVenteServlet", urlPatterns = {"/SaveVente"})
public class SaveVenteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection connection = DBConnection.getConnection();
        

            try {
                String meubleId = request.getParameter("meubleId");
                String clientId = request.getParameter("clientId");
                String quantite = request.getParameter("quantite");
                String taille = request.getParameter("taille");

                connection.setAutoCommit(false);
                Vente vente = new Vente();
                vente.setMeuble_id(meubleId);
                vente.setClient_id(clientId);
                vente.setQuantite(quantite);
                vente.setTaille(taille);
                vente.save(connection);
                MeubleStock meubleStock = new MeubleStock();
                meubleStock.setMeuble_id(meubleId);
                Meuble meuble = Meuble.findWithQuantite(Integer.parseInt(meubleId), connection);
                int quantite_i = Integer.parseInt(quantite);
                switch (Integer.parseInt(taille)) {
                    case 1:
                        if (meuble.getPetit() < quantite_i) throw new Exception("Quantite insuffisante");
                        meubleStock.setQuantite_petit(-quantite_i);
                        meubleStock.setQuantite_grand(0);
                        break;
                    case 2:
                        if (meuble.getGrand() < quantite_i) throw new Exception("Quantite insuffisante");
                        meubleStock.setQuantite_petit(0);
                        meubleStock.setQuantite_grand(-quantite_i);
                        break;
                    default:
                        throw new Exception("Taille non définie");
                }
                meubleStock.save(null);
                connection.commit();
                connection.close();
                response.sendRedirect("FormVente");
            } catch (Exception ex) {
                connection.rollback();
                connection.close();
                Logger.getLogger(SaveMeubleEmployeServlet.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("FormVente?error=" + ex.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
