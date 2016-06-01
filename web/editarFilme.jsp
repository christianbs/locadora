<%-- 
    Document   : editarFilme
    Created on : Jun 1, 2016, 10:46:58 AM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar disco</title>
    </head>
    <body>
        <h1>Edição de informações do disco:</h1>
        <form method="POST" action="FrontControllerServletFilme">
            <input type="hidden" name="controle" value="salvar"/>
            <p>Identificação: ${filme.id}</p>
            <input type="hidden" name="f_id" value="${filme.id}"/>
            <p>Titulo: <input type="text" name="f_titulo" value="${filme.titulo}"/></p>
            <p>Ano: <input type="text" name="f_ano" value="${filme.ano}"/></p>
            <p>Diretor <input type="text" name="f_diretor" value="${filme.diretor}"/></p>
            <p>Categoria: <input type="text" name="f_categoria" value="${filme.categoria}"/></p>
            <p><input type="submit" value="Salvar"/></p>
        </form>
        <c:if test="${msgErro != null}">
            <p>Erro: ${msgErro}</p>
        </c:if>
    </body>
</html>
