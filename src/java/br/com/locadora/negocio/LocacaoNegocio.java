/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.negocio;

import br.com.locadora.dados.DiscoLocacaoDAO;
import br.com.locadora.dados.LocacaoDAO;
import br.com.locadora.dados.impl.DiscoLocacaoDAOImpl;
import br.com.locadora.dados.impl.LocacaoDAOImpl;
import br.com.locadora.entidade.Cliente;
import br.com.locadora.entidade.Disco;
import br.com.locadora.entidade.DiscoLocacao;
import br.com.locadora.entidade.Locacao;
import br.com.locadora.excessao.ExcecaoAcessoDados;
import br.com.locadora.excessao.ExcecaoNegocio;
import java.math.BigDecimal;
import java.time.Instant;

/**
 *
 * @author christian
 */
public class LocacaoNegocio {
    
    private final LocacaoDAO locacaoDao;
    private final DiscoLocacaoDAO discoLocacaoDao;
    
    public LocacaoNegocio() {
        locacaoDao = new LocacaoDAOImpl();
        discoLocacaoDao = new DiscoLocacaoDAOImpl();
    }
    
    public void inserirLocacao(Locacao locacao, long idDisco) throws ExcecaoNegocio {
        try {
            long idLocacao = locacaoDao.inserirLocacao(locacao);
            locacao.setId(idLocacao);
            DiscoLocacao discoLocacao = new DiscoLocacao();
            Disco disco = new Disco();
            disco.setId(idDisco);
            discoLocacao.setDisco(disco);
            discoLocacao.setLocacao(locacao);
            discoLocacaoDao.inserirDiscoLocacao(discoLocacao);
        } catch (ExcecaoAcessoDados e) {
            throw new ExcecaoNegocio(e);
        }
    }
    
    public static void main(String[] args) {
        LocacaoNegocio negocio = new LocacaoNegocio();
        Cliente cliente = new Cliente();
        cliente.setId(1);
        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setDataRetirada(Instant.now());
        locacao.setValor(BigDecimal.valueOf(50.00));
        Instant devolucao = Instant.now();
        locacao.setDataDevolucao(devolucao);
        try {
            negocio.inserirLocacao(locacao, 3);
        } catch (ExcecaoNegocio ex) {
        }
    }
    
}
