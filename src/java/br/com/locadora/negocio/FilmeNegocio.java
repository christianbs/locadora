/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.dados.impl.FilmeDAOImpl;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.excessao.ExcecaoNegocio;
import java.util.List;

/**
 *
 * @author christian
 */
public class FilmeNegocio {

    private FilmeDAO dao;

    public FilmeNegocio() {
        dao = new FilmeDAOImpl();
    }

    public List<Filme> listar() throws ExcecaoNegocio {
        List<Filme> filmes;
        try {
            filmes = dao.listar();
            return filmes;
        } catch (ExcecaoAcessoDados ex) {
            throw new ExcecaoNegocio(ex.getException());
        }
    }

    public static void main(String[] args) {
        FilmeNegocio negocio = new FilmeNegocio();
        try {
            List<Filme> filmes = negocio.listar();
            filmes.stream().forEach((filme) -> {
                System.out.println(filme.getTitulo());
            });
        } catch (ExcecaoNegocio ex) {
            ex.getException().printStackTrace();
        }
    }

}
