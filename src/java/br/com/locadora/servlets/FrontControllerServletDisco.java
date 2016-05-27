/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.servlets;

import br.com.locadora.controle.AdicionarDiscoController;
import br.com.locadora.controle.ConfirmarRemoverDiscoController;
import br.com.locadora.controle.ControllerInterface;
import br.com.locadora.controle.ControllerInterface.ReturnType;
import br.com.locadora.controle.EditarDiscoController;
import br.com.locadora.controle.ListarDiscoController;
import br.com.locadora.controle.RemoverDiscoController;
import br.com.locadora.controle.SalvarDiscoController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Murilo
 */
@WebServlet(name = "FrontControllerServletDisco", urlPatterns = {"/FrontControllerServletDisco"})
public class FrontControllerServletDisco extends HttpServlet {

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
        switch (nomeControle) {
            case "adicionar":
                System.out.print("teste add");
                controle = new AdicionarDiscoController();
                break;
            case "confirma_remover":
                controle = new ConfirmarRemoverDiscoController();
                break;
            case "listar":
                System.out.print("teste lista");
                controle = new ListarDiscoController();
                break;
            case "editar":
                controle = new EditarDiscoController();
                break;
            case "remover":
                controle = new RemoverDiscoController();
                break;
            case "salvar":
                controle = new SalvarDiscoController();
                break;
        }

        // inicialização
        controle.init(request);

        // execução
        controle.execute();

        // encaminhamento ou redirecionamento para uma página
        if (controle.getReturnType() == ReturnType.FORWARD) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher(controle.getReturnPage());
            rd.forward(request, response);
        } else if (controle.getReturnType() == ReturnType.REDIRECT) {
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
