/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados;

import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import java.util.List;

/**
 *
 * @author christian
 */
public interface DiscoDAO {

    List<Disco> listarPorFilme(Filme filme) throws ExcecaoAcessoDados;
    void criar(Disco disco) throws ExcecaoAcessoDados;
    void atualizar(Disco disco) throws ExcecaoAcessoDados;
    List<Disco> listar() throws ExcecaoAcessoDados;
    void apagar(Disco disco) throws ExcecaoAcessoDados;
    Disco buscar(long id) throws ExcecaoAcessoDados;
}
