/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Materiel;
import models.MeubleMateriel;

/**
 *
 * @author itu
 */
@WebServlet(name = "SaveMeubleMaterielServlet", urlPatterns = {"/SaveMeubleMateriel"})
public class SaveMeubleMaterielServlet extends HttpServlet {

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
         
        int meubleId = Integer.parseInt(request.getParameter("meubleId"));
        int materielId = Integer.parseInt(request.getParameter("materielId"));
        double petit = Double.parseDouble(request.getParameter("petit"));
        double grand = Double.parseDouble(request.getParameter("grand"));
       
        MeubleMateriel model = new MeubleMateriel();
        model.setMaterielId(materielId);
        model.setMeubleId(meubleId);
        model.setPetit(petit);
        model.setGrand(grand);
        try {
            model.save(null);
            response.sendRedirect("FormMeubleMateriel?meuble=" + meubleId);
        } catch (SQLException ex) {
            Logger.getLogger(SaveMeubleMaterielServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("FormMeubleMateriel?error=" + ex.getMessage());
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
