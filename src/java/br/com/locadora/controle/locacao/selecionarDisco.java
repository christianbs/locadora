/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle.locacao;

import br.com.locadora.entidade.Cliente;
import br.com.locadora.excessao.ExcecaoNegocio;
import br.com.locadora.negocio.ClienteNegocio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian
 */
@WebServlet("/selecionarDisco")
public class selecionarDisco extends HttpServlet {

    private final ClienteNegocio clienteNegocio;

    public selecionarDisco() {
        clienteNegocio = new ClienteNegocio();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idDisco = Long.parseLong(req.getParameter("disco"));
        HttpSession session = req.getSession();
        try {
            List<Cliente> clientes = clienteNegocio.listar();
            session.setAttribute("clientes", clientes);
            session.setAttribute("disco", idDisco);
            resp.sendRedirect("locacao/incluir-locacao.jsp");
        } catch (ExcecaoNegocio ex) {

        }
    }

}
