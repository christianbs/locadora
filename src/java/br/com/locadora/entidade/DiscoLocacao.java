/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.entidade;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author christian
 */
public class DiscoLocacao implements Serializable {

    private Disco disco;
    private Locacao locacao;

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.disco);
        hash = 29 * hash + Objects.hashCode(this.locacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiscoLocacao other = (DiscoLocacao) obj;
        if (!Objects.equals(this.disco, other.disco)) {
            return false;
        }
        if (!Objects.equals(this.locacao, other.locacao)) {
            return false;
        }
        return true;
    }

}
