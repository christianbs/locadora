/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.ClienteDAO;
import br.com.locadora.dados.impl.ClienteDAOImpl;

/**
 *
 * @author christian
 */
public class ClienteNegocio {

    private ClienteDAO dao;

    public ClienteNegocio() {
        dao = new ClienteDAOImpl();
    }

}
