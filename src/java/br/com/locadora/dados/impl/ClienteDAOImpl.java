/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados.impl;

import br.com.locadora.dados.ClienteDAO;
import br.com.locadora.entidade.Cliente;
import br.com.locadora.entidade.Endereco;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.util.Conexao;
import br.com.locadora.util.ConexaoJavaDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christian
 */
public class ClienteDAOImpl implements ClienteDAO {
    
    private final Conexao conexao;
    
    public ClienteDAOImpl() {
        conexao = new ConexaoJavaDb("root", "102030", "localhost", 1527, "locadora");
    }
    
    @Override
    public List<Cliente> listar() throws ExcecaoAcessoDados {
        List<Cliente> clientes = new ArrayList();
        String sql = "select * from cliente";
        try {
            Statement st = conexao.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId(Long.parseLong(rs.getString("id_endereco")));
                Cliente cliente = new Cliente();
                cliente.setEndereco(endereco);
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setRg(rs.getString("rg"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setId(rs.getLong("id"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            throw new ExcecaoAcessoDados(ex);
        }
    }
    
}
