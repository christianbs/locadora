/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.controle.ControllerInterface.ReturnType;
import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.dados.impl.FilmeDAOImpl;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.utils.SessionUtilsFilme;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SalvarFilmeController implements ControllerInterface{
     private Filme filme;
    private long filmeId;
    private String pagina;
    private HttpServletRequest request;
    private ReturnType retorno;
    
    @Override
    public void init(HttpServletRequest request) {
        try {
            long id = Long.parseLong(request.getParameter("f_id"));
            filmeId = id;
            int ano = Integer.parseInt(request.getParameter("f_ano"));
            String  titulo = request.getParameter("f_titulo");
            String diretor = request.getParameter("f_diretor");
            String categoria = request.getParameter("f_categoria");
            filme = new Filme(id, ano, titulo, diretor, categoria);
        } catch (Exception e) {
            filme = null;
        } 
        
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            Conexao conexao = SessionUtilsFilme.getConexao(session);
            FilmeDAO dao = SessionUtilsFilme.getFilmeDao(conexao, session);
            dao = new FilmeDAOImpl(conexao);

            if (filme != null) {
                dao.atualizarFilme(filme);
                pagina = "FrontControllerServletFilme?controle=listar";
                retorno = ReturnType.REDIRECT;
            } 
            else {
                Filme f = dao.buscarPeloId(filmeId);
                request.setAttribute("msgErro", "Valor inválido!");
                request.setAttribute("filme", f);
                pagina = "editar_filme.jsp";
                retorno = ReturnType.FORWARD;
            }
        } catch (ExcecaoAcessoDados ex) {
            pagina = "erro.jsp";
            retorno = ReturnType.FORWARD;
        }
    }

    @Override
    public String getReturnPage() {
        return pagina;
    }

    @Override
    public ReturnType getReturnType() {
        return retorno;
    }
}
