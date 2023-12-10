/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Model;

/**
 *
 * @author tiavi
 */
@WebServlet(name = "CheckServlet", urlPatterns = {"/CheckServlet"})
public class CheckServlet extends HttpServlet {

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
            try {
                String id = request.getParameter("id");
                String nom = request.getParameter("nom");
                String genre = request.getParameter("genre");
                String dtn = request.getParameter("dtn");
                String salaire = request.getParameter("salaire");
                String heure = request.getParameter("heure");
                String dateHeure = request.getParameter("dateHeure");
                String[] marie = request.getParameterValues("marie");
                String research = request.getParameter("research-select");
                String[] multiple = request.getParameterValues("multiple-select");
                
                Model model = new Model();
                model.setDtn(dtn);

                out.println("ID : " + id + "<br>");
                out.println("Nom : " + nom + "<br>");
                out.println("Genre : " + genre + "<br>");
                out.println("Date de naissance : " + dtn + "<br>");
                out.println("Salaire : " + salaire + "<br>");
                out.println("Heure : " + heure + "<br>");
                out.println("Date et Heure : " + dateHeure + "<br>");

                if (marie != null) {
                    out.println("Marié : ");
                    for (String status : marie) {
                        out.println(status + " ");
                    }
                    out.println("<br>");
                }

                out.println("Recherche : " + research + "<br>");

                if (multiple != null) {
                    out.println("Options multiples sélectionnées : ");
                    for (String option : multiple) {
                        out.println(option + " ");
                    }
                    out.println("<br>");
                }
            } catch (Exception ex) {
                response.sendRedirect("/S3S5Projet/FormServlet?error=" + ex.getMessage());
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
