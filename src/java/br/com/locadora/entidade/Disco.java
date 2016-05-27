/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.entidade;

import br.com.locadora.constante.EstadoConservacao;
import java.util.Objects;

/**
 *
 * @author 31446760
 */
public class Disco {

    private long id;
    private boolean alocado;
    private Filme filme;
    private EstadoConservacao estado;
    private long idFilme;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Disco(){
        
    }

    public Disco(boolean alocado, Filme filme, EstadoConservacao estado) {
        this.alocado = alocado;
        this.filme = filme;
        this.estado = estado;
    }
    public Disco(long id, boolean alocado, long idFilme, EstadoConservacao estado){
        this.alocado = alocado;
        this.idFilme = idFilme;
        this.estado = estado;
    }

    public boolean isAlocado() {
        return alocado;
    }

    public void setAlocado(boolean alocado) {
        this.alocado = alocado;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public EstadoConservacao getEstado() {
        return estado;
    }

    public void setEstado(EstadoConservacao estado) {
        this.estado = estado;
    }

    public long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(long idFilme) {
        this.idFilme = idFilme;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + (this.alocado ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.filme);
        hash = 89 * hash + Objects.hashCode(this.estado);
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
        final Disco other = (Disco) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.alocado != other.alocado) {
            return false;
        }
        if (!Objects.equals(this.filme, other.filme)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return true;
    }
    

}
