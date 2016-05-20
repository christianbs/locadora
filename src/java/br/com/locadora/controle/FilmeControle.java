/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.entidade.Filme;
import br.com.locadora.excessao.ExcecaoNegocio;
import br.com.locadora.negocio.FilmeNegocio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author christian
 */
public class FilmeControle {

    private FilmeNegocio filmeNegocio;

    public FilmeControle() {
        filmeNegocio = new FilmeNegocio();
    }

    public List<Filme> listarFilmes() {
        try {
            return filmeNegocio.listar();
        } catch (ExcecaoNegocio ex) {
            return new ArrayList();
        }
    }

}
