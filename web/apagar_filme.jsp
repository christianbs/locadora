<%-- 
    Document   : apagar_filme
    Created on : Jun 1, 2016, 10:38:12 AM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apagar Filme</title>
    </head>
    <body>
        <h1>Apagar Filme</h1>
        <p>Identificador: ${filme.id}</p>
        <p>Titulo ${filme.titulo}</p>
        <p>Ano: ${filme.ano}</p>
        <p>Diretor ${filme.diretor}</p>
        <p>Categoria ${filme.categoria}</p>
        <form method="POST" action="FrontControllerServletFilme">
            <input type="hidden" name="controle" value="remover"/>
            <input type="hidden" name="id" value="${filme.id}"/>
            <p><input type="submit" value="Apagar"/></p>
        </form>
    </body>
</html>
