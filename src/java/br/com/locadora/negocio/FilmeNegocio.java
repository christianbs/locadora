/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.FilmeDAO;
import br.com.locadora.dados.impl.FilmeDAOImpl;

/**
 *
 * @author christian
 */
public class FilmeNegocio {

    private FilmeDAO dao;

    public FilmeNegocio() {
        dao = new FilmeDAOImpl();
    }

}
