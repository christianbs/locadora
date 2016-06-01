/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.utils.SessionUtilsFilme;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditarFilmeController implements ControllerInterface{
    private long id;
    private String pagina;
    private HttpServletRequest request;

    @Override
    public void init(HttpServletRequest request) {
        id = Long.parseLong(request.getParameter("id"));
        pagina = "editar_filme.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            Conexao conexao = SessionUtilsFilme.getConexao(session);
            FilmeDAO dao = SessionUtilsFilme.getFilmeDao(conexao, session);
            Filme f = dao.buscarPeloId(id);
            request.setAttribute("filme", f);
        } catch (ExcecaoAcessoDados ex){
            pagina = "erro.jsp";
        }
    }

    @Override
    public String getReturnPage() {
        return pagina;
    }

    @Override
    public ReturnType getReturnType() {
        return ReturnType.FORWARD;
    }
}
