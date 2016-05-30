/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.utils;

import br.com.locadora.util.*;
import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.dados.impl.DiscoDAOImpl;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import javax.servlet.http.HttpSession;
public class SessionUtils {
     public static Conexao getConexao(HttpSession session) {
        Conexao conexao;
        conexao = (Conexao) session.getAttribute("conexaoSessao");
        if (conexao == null) {
            conexao = new ConexaoJavaDb("app", "app", "localhost", 1527, "LOCADORA");
            session.setAttribute("conexaoSessao", conexao);
        }
        return conexao;
    }
    
    public static DiscoDAOImpl getDiscoDao(Conexao conexao,
            HttpSession session) throws ExcecaoAcessoDados {
        DiscoDAOImpl dao;
        dao = (DiscoDAOImpl) session.getAttribute("usuarioDaoSessao");
        if (dao == null) {
            dao = new DiscoDAOImpl(conexao);
            session.setAttribute("usuarioDaoSessao", dao);
        }
        return dao;
    }
}
