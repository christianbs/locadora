<%-- 
    Document   : editar_disco
    Created on : May 26, 2016, 1:41:17 PM
    Author     : Murilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar disco</title>
    </head>
    <body>
        <h1>Edição de informações do disco:</h1>
        <form method="POST" action="FrontControllerServletDisco">
            <input type="hidden" name="controle" value="salvar" />
            <p>Identificação: ${disco.id}</p>
            <input type="hidden" name="d_id" value="${disco.id}" />
            <p>Id do filme: <input type="text" name="d_idFilme" value="${disco.idFilme}" /></p>
            <p>Estado: <select name="d_estado"><option selected value="MUITO_NOVO">Muito Novo</option><option value="QUASE_NOVO">Quase Novo</option><option VALUE="POUCO_RISCADO">Pouco Riscado</option><option VALUE="MUITO_RISCADO">Muito Riscado</option></select></p>
            <p>Disponibilibidade <input type="radio" name="d_alocado" value=true checked>disponivel<input type="radio" name="alocado" value=false>Não disponivel</p>
            <p><input type="submit" value="Salvar" /></p>
        </form>
    <c:if test="${msgErro != null}">
        <p>Erro: ${msgErro}</p>
    </c:if>
    </body>
</html>
