/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.Filme;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import java.util.List;

/**
 *
 * @author christian
 */
public class DiscoDAOImpl implements DiscoDAO {

    private final Conexao conexao;

    public DiscoDAOImpl() {
        conexao = new ConexaoJavaDb("root", "102030", "localhost", 1527, "locadora");
    }

    @Override
    public List<Disco> listarPorFilme(Filme filme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
