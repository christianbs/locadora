/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.constante;

/**
 *
 * @author christian
 */
public enum EstadoConservacao {
    MUITO_RISCADO("MUITO_RISCADO"), POUCO_RISCADO("POUCO_RISCADO"), QUASE_NOVO("QUASE_NOVO"), MUITO_NOVO("MUITO_NOVO");

    private String estadoConcervacao;

    private EstadoConservacao(String estadoConcervacao) {
        this.estadoConcervacao = estadoConcervacao;
    }

    public static EstadoConservacao recuperarEstadoConservacao(String estadoConservacao) {
        switch (estadoConservacao) {
            case "MUITO_RISCADO":
                return EstadoConservacao.MUITO_RISCADO;
            case "POUCO_RISCADO":
                return EstadoConservacao.POUCO_RISCADO;
            case "QUASE_NOVO":
                return EstadoConservacao.QUASE_NOVO;
            case "MUITO_NOVO":
                return EstadoConservacao.MUITO_NOVO;
            default:
                return null;
        }
    }
}
