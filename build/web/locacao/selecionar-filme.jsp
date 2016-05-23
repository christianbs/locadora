<%-- 
    Document   : selecionar-filme.jsp
    Created on : 19/05/2016, 08:17:06
    Author     : christian
--%>

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
        <jsp:useBean id="filmeControle" class="br.com.locadora.controle.FilmeControle"/>
        <section class="col-sm-4">
        </section>
        <section class="col-sm-4 container">
            <h2>Locação</h2>
            <form role="form" action="../selecionarFilme" method="post">            
                <div class="form-group">
                    <label for="filme" >Filme:</label>
                    <select name="filme" class="form-control">
                        <option>Selecione</option>
                        <c:forEach var="filme" items="${filmeControle.listarFilmes()}" >
                            <option value="${filme.id}">${filme.titulo}</option>
                        </c:forEach>
                    </select>
                </div>             
                <button type="submit" class="btn btn-default">Continuar</button>
            </form>
        </section>
        <section class="col-sm-4">
        </section>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>     
    </body>
</html>
