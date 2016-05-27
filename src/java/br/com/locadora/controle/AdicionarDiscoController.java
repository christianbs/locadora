/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.constante.EstadoConservacao;
import br.com.locadora.dados.DiscoDAO;

import br.com.locadora.entidade.Disco;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdicionarDiscoController implements ControllerInterface{
    private String pagina;
    private Disco disco;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        Long idFilme = Long.parseLong(request.getParameter("id_filme"));
        EstadoConservacao estado = EstadoConservacao.recuperarEstadoConservacao(request.getParameter("estado"));
        boolean alocado = Boolean.parseBoolean(request.getParameter("alocado"));
        disco = new Disco(0, alocado, idFilme, estado);
        pagina = "disco/adicionar_disco.html";
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            Conexao conexao = SessionUtils.getConexao(session);
            DiscoDAO dao = SessionUtils.getDiscoDao(conexao, session);
            dao.criar(disco);
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
        return ReturnType.REDIRECT;
    }
}
