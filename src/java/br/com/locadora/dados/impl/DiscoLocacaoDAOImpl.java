/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.dados.DiscoLocacaoDAO;
import br.com.locadora.entidade.DiscoLocacao;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author christian
 */
public class DiscoLocacaoDAOImpl implements DiscoLocacaoDAO {

    private final Conexao conexao;

    public DiscoLocacaoDAOImpl() {
        conexao = new ConexaoJavaDb("root", "102030", "localhost", 1527, "locadora");
    }

    @Override
    public void inserirDiscoLocacao(DiscoLocacao discoLocacao) throws ExcecaoAcessoDados {
        try {
            String sql = "insert into disco_locacao(id_disco, id_locacao) values(?, ?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setLong(1, discoLocacao.getDisco().getId());
            ps.setLong(2, discoLocacao.getLocacao().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ExcecaoAcessoDados(e);
        }
    }

}
