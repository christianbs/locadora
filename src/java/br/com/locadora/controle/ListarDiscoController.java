/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.entidade.Disco;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.utils.SessionUtils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ListarDiscoController implements ControllerInterface {
      private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        pagina = "disco/lista_discos.jsp";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            DiscoDAO dao;
            HttpSession session = request.getSession();
            Conexao conexao = SessionUtils.getConexao(session);
            dao = SessionUtils.getDiscoDao(conexao, session);
            List<Disco> lista;
            lista = dao.listar();
            request.setAttribute("lista_discos", lista);
        } catch (ExcecaoAcessoDados ex) {
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
