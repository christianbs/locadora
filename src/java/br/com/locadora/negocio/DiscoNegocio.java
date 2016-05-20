/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.dados.impl.DiscoDAOImpl;
import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.excessao.ExcecaoNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christian
 */
public class DiscoNegocio {

    private DiscoDAO dao;

    public DiscoNegocio() {
        dao = new DiscoDAOImpl();
    }

    public List<Disco> listarPorFilme(Filme filme) throws ExcecaoNegocio {
        try {
            return dao.listarPorFilme(filme);
        } catch (ExcecaoAcessoDados ex) {
            throw new ExcecaoNegocio(ex.getException());
        }
    }
    
    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setId(1);
        DiscoNegocio discoNegocio = new DiscoNegocio();
        try {
            List<Disco> discos = discoNegocio.listarPorFilme(filme);
            discos.stream().forEach((disco) -> {
                System.out.println(disco.getId());
            });
            
        } catch (ExcecaoNegocio ex) {
            ex.getException().printStackTrace();
        }
    }

}
