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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ListarFilmeController implements ControllerInterface{
      private String pagina;
    private HttpServletRequest request;
    
    @Override
    public void init(HttpServletRequest request) {
        pagina = "lista_filmes.jsp";
        this.request = request;
    }

 @Override
 public void execute(){
     try{
         FilmeDAO dao;
         HttpSession session = request.getSession();
         Conexao conexao = SessionUtilsFilme.getConexao(session);
         dao = SessionUtilsFilme.getFilmeDao(conexao, session);
         List<Filme> lista;
         lista = dao.listar();
         request.setAttribute("lista_filmes", lista);
     }catch(ExcecaoAcessoDados ex){
         pagina = "erro.jsp";
         System.out.println(ex);
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
