/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.DiscoDAO;
import br.com.locadora.dados.impl.DiscoDAOImpl;

/**
 *
 * @author christian
 */
public class DiscoNegocio {

    private DiscoDAO dao;

    public DiscoNegocio() {
        dao = new DiscoDAOImpl();
    }

}
