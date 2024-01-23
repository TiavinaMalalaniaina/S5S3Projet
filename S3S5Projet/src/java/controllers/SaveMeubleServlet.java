/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Meuble;

/**
 *
 * @author itu
 */
@WebServlet(name = "SaveMeubleServlet", urlPatterns = {"/SaveMeuble"})
public class SaveMeubleServlet extends HttpServlet {

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
         
        String styleId = request.getParameter("styleId");
        String categorieId = request.getParameter("categorieId");
        String prixPetit = request.getParameter("prix_vente_petit");
        String prixGrand = request.getParameter("prix_vente_grand");
        
        try {
            Meuble meuble = new Meuble();
            meuble.setStyleId(styleId);
            meuble.setCategorieId(categorieId);
            meuble.setPrix_petit(prixPetit);
            meuble.setPrix_grand(prixGrand);
            meuble.save(null);
            response.sendRedirect("FormMeubleMateriel?meuble=" + meuble.getId());
        } catch (Exception ex) {
            Logger.getLogger(SaveMeubleServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("FormMeuble?error=" + ex.getMessage());
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
