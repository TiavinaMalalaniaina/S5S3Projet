/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;
import models.Materiel;
import models.Meuble;
import models.Style;
import models.ViewModel;

/**
 *
 * @author tiavi
 */
@WebServlet(name = "FormMeubleMaterielServlet", urlPatterns = {"/FormMeubleMateriel"})
public class FormMeubleMaterielServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
           int meubleId = Integer.parseInt(request.getParameter("meuble"));
             try {
                 Meuble meuble = Meuble.findById(null, meubleId);
                 List<Materiel> materiels = Materiel.findByType(null, meuble.getStyleId());
                 ViewModel model = new ViewModel();
                 model.meuble = meuble;
                 model.materiels = materiels;
                 
                model.setError(request.getParameter("error"));
                request.setAttribute("viewName", "components/formMeubleMateriel.jsp");
                request.setAttribute("title", "MATERIEL");
                request.setAttribute("viewTitle", "Materiel pour meuble");
                request.setAttribute("model", model);
                RequestDispatcher dispatch = request.getRequestDispatcher("home.jsp");
                dispatch.forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(FormMaterielServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            
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
