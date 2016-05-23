/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoNegocio;
import br.com.locadora.negocio.DiscoNegocio;
import br.com.locadora.negocio.LocacaoNegocio;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/selecionarFilme")
public class SelecionarFilme extends HttpServlet {

    private LocacaoNegocio locacaoNegocio;

    private DiscoNegocio discoNegocio;

    public SelecionarFilme() {
        locacaoNegocio = new LocacaoNegocio();
        discoNegocio = new DiscoNegocio();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Filme filme = new Filme();
            filme.setId(Long.parseLong(req.getParameter("filme")));
            List<Disco> discos = discoNegocio.listarPorFilme(filme);
            HttpSession session = req.getSession();
            session.setAttribute("filme", filme);
            session.setAttribute("discos", discos);
            resp.sendRedirect("locacao/selecionar-disco.jsp");
        } catch (ExcecaoNegocio ex) {
            Logger.getLogger(SelecionarFilme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
