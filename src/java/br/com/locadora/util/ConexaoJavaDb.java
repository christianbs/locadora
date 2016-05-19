package br.com.locadora.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author christian
 */
public class ConexaoJavaDb implements Conexao {

    private final String usuario;
    private final String senha;
    private final String hostname;
    private final int porta;
    private final String nomeBancoDeDados;
    private Connection conexao;

    public ConexaoJavaDb(String usuario, String senha, String hostname, int porta, String nomeBancoDeDados) {
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.nomeBancoDeDados = nomeBancoDeDados;
    }

    @Override
    public Connection getConnection() {
        if (conexao == null) {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname + ":" + porta + "/" + nomeBancoDeDados;
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conexao;
    }

    @Override
    public void close() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conexao = null;
    }

}
