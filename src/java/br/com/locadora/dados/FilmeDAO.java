/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados;

import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import java.util.List;

/**
 *
 * @author christian
 */
public interface FilmeDAO {

    List<Filme> listar() throws ExcecaoAcessoDados;
    Filme buscarPeloId(long id) throws ExcecaoAcessoDados;
    public void inserirFilme(Filme filme) throws ExcecaoAcessoDados;

}
