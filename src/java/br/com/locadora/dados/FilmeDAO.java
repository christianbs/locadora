/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.dados;

import br.com.locadora.entidade.Filme;
import java.util.List;

/**
 *
 * @author christian
 */
public interface FilmeDAO {

    List<Filme> listar();

}
