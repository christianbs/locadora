<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <h1>Cadastro de disco</h1>
        <form method="POST" action="/CadDiscoServlet">
            <div><label>id do filme:</label><input type="text" name="id_filme"/></div>
            <div><label>estado:</label><select name="estado"><option selected>Novo</option><option>Semi-novo</option></select></div>
            <div><label>alocado</label><input type="radio" name="alocado" value=true>disponivel<input type="radio" name="alocado" value=false>Não disponivel</div>

        </form>
    </center>
</body>
</html>
