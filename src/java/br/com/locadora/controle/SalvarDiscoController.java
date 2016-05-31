/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.constante.EstadoConservacao;
import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.dados.impl.DiscoDAOImpl;
import br.com.locadora.entidade.Disco;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.utils.SessionUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SalvarDiscoController implements ControllerInterface{
    private Disco disco;
    private long discoId;
    private String pagina;
    private HttpServletRequest request;
    private ReturnType retorno;
    
    @Override
    public void init(HttpServletRequest request) {
        try {
            long id = Long.parseLong(request.getParameter("d_id"));
            discoId = id;
            long idFilme = Long.parseLong(request.getParameter("d_idFilme"));
            EstadoConservacao estado = EstadoConservacao.recuperarEstadoConservacao(request.getParameter("d_estado"));
            boolean alocado = Boolean.parseBoolean(request.getParameter("d_alocado"));
            disco = new Disco(id, alocado, idFilme, estado);
             System.out.println("id do disco: " + disco.getId());
        } catch (Exception e) {
            disco = null;
        } 
        
        this.request = request;
    }

    @Override
    public void execute() {
        try {
            HttpSession session = request.getSession();
            Conexao conexao = SessionUtils.getConexao(session);
            DiscoDAO dao = SessionUtils.getDiscoDao(conexao, session);
            dao = new DiscoDAOImpl(conexao);

            if (disco != null) {
                dao.atualizar(disco);
                pagina = "FrontControllerServletDisco?controle=listar";
                retorno = ReturnType.REDIRECT;
            } 
            else {
                Disco d = dao.buscar(discoId);
                request.setAttribute("msgErro", "Valor inválido!");
                request.setAttribute("disco", d);
                pagina = "editar_disco.jsp";
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
