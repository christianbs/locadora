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
        conexao = new ConexaoJavaDb("app", "app", "localhost", 1527, "LOCADORA");
    }
    public DiscoDAOImpl(Conexao conexao) throws ExcecaoAcessoDados{
        this.conexao = conexao;
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
            ps.setLong(1, disco.getIdFilme());
            ps.setString(2, String.valueOf(disco.getEstado()));
            ps.setBoolean(3, disco.isAlocado());
            System.out.println("valor de disco " + disco.getIdFilme());
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
    }
    
    @Override
    public void atualizar(Disco disco) throws ExcecaoAcessoDados {
                    String sql = "UPDATE DISCO set id_filme=?, estado=?, alocado=? where id=?";
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setLong(1, disco.getIdFilme());
            ps.setString(2, String.valueOf(disco.getEstado()));
            ps.setBoolean(3, disco.isAlocado());
            ps.setLong(4, disco.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
    }

    @Override
    public List<Disco> listar() throws ExcecaoAcessoDados {
        List<Disco> discos = new ArrayList<>();
        String sql = "SELECT * FROM disco";
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                long id = result.getLong("id");
                long idFilme = result.getLong("id_filme");
                EstadoConservacao estado = EstadoConservacao.recuperarEstadoConservacao(result.getString("estado"));
                boolean alocado = result.getBoolean("alocado");
                Disco d = new Disco(id, alocado, idFilme, estado);
                discos.add(d);
            }
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
        return discos;
    }

    @Override
    public void apagar(Disco disco) throws ExcecaoAcessoDados {
        String sql = "DELETE FROM disco where id = ?";
        try {
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
            ps.setLong(1, disco.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }    
    }
    @Override
    public Disco buscar(long id) throws ExcecaoAcessoDados{
        String sql = "SELECT * from disco where id=?";
        Disco d = null;
        try{
            PreparedStatement ps = conexao.getConnection().prepareStatement(sql);
                    ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                long idd = rs.getLong("id");
                long idFilme = rs.getLong("id_filme");
                EstadoConservacao estado = EstadoConservacao.recuperarEstadoConservacao(rs.getString("estado"));
                boolean alocado = rs.getBoolean("alocado");
                d = new Disco(idd, alocado, idFilme, estado);
            }
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
        return d;
    }
}
