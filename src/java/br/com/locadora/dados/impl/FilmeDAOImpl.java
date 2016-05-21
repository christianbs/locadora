/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    public List<Filme> listar() throws ExcecaoAcessoDados {
        try {
            List<Filme> filmes = new ArrayList();
            String sql = "select * from filme";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Filme filme = new Filme();
                filme.setAno(rs.getDate("ano").getYear());
                filme.setCategoria(rs.getString("categoria"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setId(rs.getLong("id"));
                filme.setTitulo(rs.getString("titulo"));
                filmes.add(filme);
            }
            return filmes;
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
    }
    @Override
    public Filme buscarPeloId(long id) throws ExcecaoAcessoDados {
        Filme filme = null;
        try{
            String sql = "select * from filme WHERE id=?";
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            filme.setId(rs.getLong("id"));
            filme.setAno(rs.getDate("ano").getYear());
            filme.setCategoria(rs.getString("categoria"));
            filme.setDiretor(rs.getString("diretor"));
            filme.setTitulo(rs.getString("titulo"));
        return filme;
        }catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
    }

}
