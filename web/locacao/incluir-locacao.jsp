<%-- 
    Document   : incluir-locacao.jsp
    Created on : 19/05/2016, 08:17:06
    Author     : christian
--%>

<%@page import="br.com.locadora.entidade.Cliente"%>
<%@page import="br.com.locadora.entidade.Disco"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>locação</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    </head>
    <body>
        <section class="col-sm-4">
        </section>
        <section class="col-sm-4 container">
            <h2>Locação</h2> 
            <form role="form" action="../incluirLocacao" method="post">
                <%
                    List<Cliente> clientes = (List<Cliente>) session.getAttribute("clientes");
                %>
                <label for="cliente">Cliente:</label>
                <select id="cliente" name="cliente" class="form-control">
                    <option>Selecione</option>
                    <c:forEach var="cliente" items="${clientes}">
                        <option value="${cliente.id}">${cliente.nome}</option>
                    </c:forEach>
                </select>
                <label for="dias">Dias:</label>
                <select id="dias" name="dias" class="form-control">
                    <option value="3">3</option>
                    <option value="5">5</option>
                    <option value="7">7</option>
                </select>
                <button type="submit" class="btn btn-default">Concluir</button>
            </form>
        </section>
        <section class="col-sm-4">
        </section>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>     
    </body>
</html>
