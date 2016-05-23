/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.util.ConexaoJavaDb;
import br.com.locadora.dados.LocacaoDAO;
import br.com.locadora.entidade.Locacao;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author christian
 */
public class LocacaoDAOImpl implements LocacaoDAO {

    private final Conexao conexao;

    public LocacaoDAOImpl() {
        conexao = new ConexaoJavaDb("root", "102030", "localhost", 1527, "locadora");
    }

    @Override
    public long inserirLocacao(Locacao locacao) throws ExcecaoAcessoDados {
        try {
            String sql = "insert into locacao(id_cliente, retirada, devolucao, valor, multa) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setLong(1, locacao.getCliente().getId());
            ps.setDate(2, new java.sql.Date(Date.from(locacao.getDataRetirada()).getTime()));
            ps.setDate(3, new java.sql.Date(Date.from(locacao.getDataDevolucao()).getTime()));
            ps.setBigDecimal(4, locacao.getValor());
            ps.setBigDecimal(5, locacao.getMulta());
            long id = ps.executeUpdate();
            return id;
        } catch (SQLException e) {
            throw new ExcecaoAcessoDados(e);
        }
    }

}
