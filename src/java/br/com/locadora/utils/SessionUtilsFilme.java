/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.utils;

import br.com.locadora.dados.impl.FilmeDAOImpl;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import javax.servlet.http.HttpSession;

public class SessionUtilsFilme {
    public static Conexao getConexao(HttpSession session) {
        Conexao conexao;
        conexao = (Conexao) session.getAttribute("conexaoSessao");
        if (conexao == null) {
            conexao = new ConexaoJavaDb("app", "app", "localhost", 1527, "LOCADORA");
            session.setAttribute("conexaoSessao", conexao);
        }
        return conexao;
    }
    
    public static FilmeDAOImpl getFilmeDao(Conexao conexao,
            HttpSession session) throws ExcecaoAcessoDados {
        FilmeDAOImpl dao;
        dao = (FilmeDAOImpl) session.getAttribute("filmeDaoSessao");
        if (dao == null) {
            dao = new FilmeDAOImpl(conexao);
            session.setAttribute("filmeDaoSessao", dao);
        }
        return dao;
    }
}
