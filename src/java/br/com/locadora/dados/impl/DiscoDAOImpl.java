/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.constante.EstadoConservacao;
import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<Disco> listarPorFilme(Filme filme) throws ExcecaoAcessoDados {
        List<Disco> discos = new ArrayList();
        String sql = "select * from disco where id_filme = ?";
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setLong(1, filme.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Disco disco = new Disco();
                disco.setId(rs.getLong("id"));
                disco.setFilme(filme);
                disco.setEstado(EstadoConservacao.recuperarEstadoConservacao(rs.getString("estado")));
                disco.setAlocado(rs.getBoolean("alocado"));
                discos.add(disco);
            }
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
        return discos;
    }
    @Override
    public void criar(Disco disco) throws ExcecaoAcessoDados{
        String sql = "INSERT INTO disco (id_filme, estado, alocado) VALUES (?,?,?)";
        try{
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            
            ps.setString(2, String.valueOf(disco.getEstado()));
            
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
    }
    
}
