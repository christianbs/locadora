/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.excessao;

/**
 *
 * @author christian
 */
public class ExcecaoAcessoDados extends Exception {

    private Exception exception;

    public ExcecaoAcessoDados(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
