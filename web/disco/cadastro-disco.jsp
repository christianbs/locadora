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
            <table>
                <tr><td><div><label>id do filme:</label></td><td><input type="text" name="id_filme"/></div></td>
                <tr><td><div><label>estado:</label></td><td><select name="estado"><option selected value="MUITO_NOVO">Muito Novo</option><option value="QUASE_NOVO">Quase Novo</option><option VALUE="POUCO_RISCADO">Pouco Riscado</option><option VALUE="MUITO_RISCADO">Muito Riscado</option></select></div></td></tr>  
                <tr><td><div><label>alocado</label></td><td><input type="radio" name="alocado" value=true selected >disponivel<input type="radio" name="alocado" value=false>Não disponivel</div></td></tr>
                <tr><td><input type="submit" value="Confirmar"</td></tr>
            </table>
        </form>
    </center>
</body>
</html>
