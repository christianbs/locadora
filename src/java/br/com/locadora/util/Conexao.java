package br.com.locadora.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;

/**
 *
 * @author christian
 */
public interface ConexaoInterface {
    Connection getConnection();
    void close();
}
