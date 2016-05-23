/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.controle;

import br.com.locadora.entidade.Cliente;
import br.com.locadora.entidade.Locacao;
import br.com.locadora.excessao.ExcecaoNegocio;
import br.com.locadora.negocio.LocacaoNegocio;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author christian
 */
@WebServlet("/incluirLocacao")
public class IncluirLocacao extends HttpServlet {

    private final LocacaoNegocio locacaoNegocio;

    public IncluirLocacao() {
        this.locacaoNegocio = new LocacaoNegocio();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long idDisco = (long) session.getAttribute("disco");

        long idCliente = Long.parseLong(req.getParameter("cliente"));
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);

        long dias = Long.parseLong(req.getParameter("dias"));
        Locacao locacao = new Locacao();
        locacao.setDataRetirada(Instant.now());
        locacao.setDataDevolucao(Instant.now().plusMillis(converterDiasEmMilissegundos(dias)));
        locacao.setCliente(cliente);
        locacao.setValor(recuperarValor(dias));
        try {
            locacaoNegocio.inserirLocacao(locacao, idDisco);
        } catch (ExcecaoNegocio ex) {

        }
        resp.sendRedirect("locacao/sucesso.jsp");
    }

    private long converterDiasEmMilissegundos(long dias) {
        long horas = dias * 24;
        long minutos = horas * 60;
        long segundos = minutos * 60;
        long milissegundos = segundos * 1000;
        return milissegundos;
    }

    private BigDecimal recuperarValor(long dias) {
        long valor = 5 * dias;
        return BigDecimal.valueOf(valor);
    }

}
