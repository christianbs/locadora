/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.servlets;

import br.com.locadora.controle.AdicionarFilmeController;
import br.com.locadora.controle.ConfirmarRemoverFilmeController;
import br.com.locadora.controle.ControllerInterface;
import br.com.locadora.controle.EditarFilmeController;
import br.com.locadora.controle.ListarFilmeController;
import br.com.locadora.controle.RemoverFilmeController;
import br.com.locadora.controle.SalvarFilmeController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class FrontControllerServletFilme extends HttpServlet {

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
        ControllerInterface controle = null;
        String nomeControle = request.getParameter("controle");
        System.out.println("Controle: " + nomeControle);
        switch (nomeControle) {
            case "adicionar":
                controle = new AdicionarFilmeController();
                break;
            case "confirma_remover":
                controle = new ConfirmarRemoverFilmeController();
                break;
            case "listar":
                controle = new ListarFilmeController();
                break;
            case "editar":
                controle = new EditarFilmeController();
                break;
            case "remover":
                controle = new RemoverFilmeController();
                break;
            case "salvar":
                controle = new SalvarFilmeController();
                break;
        }

        controle.init(request);
        controle.execute();

        if (controle.getReturnType() == ControllerInterface.ReturnType.FORWARD) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher(controle.getReturnPage());
            rd.forward(request, response);
        } else if (controle.getReturnType() == ControllerInterface.ReturnType.REDIRECT) {
            response.sendRedirect(controle.getReturnPage());
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
