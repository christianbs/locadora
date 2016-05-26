<%-- 
    Document   : lista_discos
    Created on : May 26, 2016, 12:51:41 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Discos</title>
    </head>
    <body>
        <h1>Lista de discos</h1>
         <p><a href="adicionar_disco.html">Adicionar Disco</a></p>
        <table border="1">
            <tr>
                <td>Id do filme</td>
                <td>Estado</td>
                <td>Alocação</td>
            </tr>
            <c:forEach var="d" items="${lista_discos}">
            <tr>
                <td>${d.id_filme}</td>
                <td>${d.estado}</td>
                <td>${d.alocado}</td>
                
                <c:url value="FrontControllerServlet" var="editarUrl">
                    <c:param name="controle" value="editar"/>
                    <c:param name="id" value="${d.id}"/>
                </c:url>
                <td><a href="${editarUrl}">Editar</a></td>
                
                <c:url value="FrontControllerServlet" var="apagarUrl">
                    <c:param name="controle" value="confirma_remover"/>
                    <c:param name="id" value="${d.id}"/>
                </c:url>
                <td><a href="${apagarUrl}">Apagar</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
