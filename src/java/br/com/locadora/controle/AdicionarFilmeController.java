/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.utils.SessionUtilsFilme;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdicionarFilmeController implements ControllerInterface{
     private String pagina;
    private Filme filme;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        int ano = Integer.parseInt(request.getParameter("ano"));
        String titulo = request.getParameter("titulo");
        String diretor = request.getParameter("diretor");
        String categoria = request.getParameter("categoria");
        filme = new Filme(0, ano, titulo, diretor, categoria);
        pagina = "adicionar_filme.html";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            Conexao conexao = SessionUtilsFilme.getConexao(session);
            FilmeDAO dao = SessionUtilsFilme.getFilmeDao(conexao, session);
            dao.inserirFilme(filme);
        } catch (ExcecaoAcessoDados ex) {
            pagina = "erro.jsp";
        }
    }

    @Override
    public String getReturnPage() {
        return pagina;
    }

    @Override
    public ControllerInterface.ReturnType getReturnType() {
        return ControllerInterface.ReturnType.REDIRECT;
    }
}
