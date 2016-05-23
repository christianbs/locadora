/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.ClienteDAO;
import br.com.locadora.dados.impl.ClienteDAOImpl;
import br.com.locadora.entidade.Cliente;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.excessao.ExcecaoNegocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christian
 */
public class ClienteNegocio {

    private ClienteDAO dao;

    public ClienteNegocio() {
        dao = new ClienteDAOImpl();
    }

    public List<Cliente> listar() throws ExcecaoNegocio {
        List<Cliente> clientes;
        try {
            clientes = dao.listar();
        } catch (ExcecaoAcessoDados ex) {
            throw new ExcecaoNegocio(ex.getException());
        }
        return clientes;
    }

}
