<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/list-projetos">Projetos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/list-pessoa"  >Pessoas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/membros">Membros</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-pessoa">NOVO PESSOA</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>Lista de Pessoa</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="60%">Nome</th>
                    <th width="20%">ID_GERENTE</th>

                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pessoa}" var="pessoa">
                    <tr>
                        <td width="60%">${pessoa.nome}</td>
                        <td width="20%">${pessoa.pessoaCol}</td>
                        <td width="20%"><a type="button" class="btn btn-success"
                                           href="/update-pessoa?id=${pessoa}">Atualizar</a>
                            <a type="button" class="btn btn-warning"
                               href="/delete-pessoa?id=${pessoa}">Excluir</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>