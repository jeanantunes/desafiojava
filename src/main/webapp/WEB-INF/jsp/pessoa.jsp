<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Desafio Java</title>

    <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
          rel="stylesheet">

</head>
<body>
<div class="p-2 text-center bg-light">
    <h4 class="mb-1">Lista</h4>
</div>
<div>
<!--
    <form method="post" action="/add-pessoa">
        <input type="submit" class="btn btn-primary btn-md text" value="NOVO PESSOA">
    </form>
-->
</div>

<div class="container">
    <div class="text-left" style="margin:5px 5px 5px 5px;">
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="20%">ID</th>
                    <th width="60%">Nome</th>
                    <!--<th width="20%"></th>-->
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pessoa}" var="pessoa">
                    <tr>
                        <td width="20%">${pessoa.pessoaCol}</td>
                        <td width="80%">${pessoa.nome}</td>
                        <!--<td width="20%"><a type="button" class="btn btn-success"
                                           href="/update-pessoa/${pessoa.id}">Atualizar</a>
                            <a type="button" class="btn btn-warning"
                               href="/delete-pessoa/${pessoa.id}">Excluir</a></td>-->
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>