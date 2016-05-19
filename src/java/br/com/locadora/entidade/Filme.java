
package br.com.locadora.entidade;

public class Filme {
    private String titulo;
    private String diretor;
    private int ano;
    private String categoria;
    
    public Filme (){};
    
    public Filme (String titulo, String diretor, int ano, String categoria){
        this.titulo = titulo;
        this.diretor = diretor;
        this.ano = ano;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}