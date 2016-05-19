/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.entidade.Filme;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import java.util.List;

/**
 *
 * @author christian
 */
public class FilmeDAOImpl implements FilmeDAO {

    private final Conexao conexao;

    public FilmeDAOImpl() {
        conexao = new ConexaoJavaDb("root", "102030", "localhost", 1527, "locadora");
    }

    @Override
    public List<Filme> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
