<%-- 
    Document   : apagar_disco
    Created on : May 26, 2016, 1:35:39 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apagar Disco</title>
    </head>
    <body>
        <h1>Apagar Disco</h1>
        
        <p>Identificador: ${disco.id}</p>
        <p>Id do Filme: ${disco.idFilme}</p>
        <p>Estado do disco: ${d.estado}</p>
        <p>Disponibilidade: ${usuario.alocado}</p>
        <form method="POST" action="FrontControllerServlet">
            <input type="hidden" name="controle" value="remover" />
            <input type="hidden" name="id" value="${disco.id}"/>
            <p><input type="submit" value="Apagar"/></p>
        </form>
    </body>
</html>
