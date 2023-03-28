<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="header.jsp"%>
<html>
<head>
    <style>
        #content{
            overflow: hidden;
            width:114px;
            height: 112px;
            display: -webkit-box;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
        }

        #content:hover{
            overflow: visible;
            white-space: normal;
            width: auto;
            position: absolute;
            background-color:#FFF;
        }
        #content:hover+div {
            margin-top:20px;
        }

    </style>
</head>
<body>
<div class="p-2 text-center bg-light">
    <h4 class="mb-1">Lista de Projetos</h4>
</div>
<div>
    <form method="post" action="/add-projetos">
        <input type="submit" class="btn btn-primary btn-md text" value="NOVO PROJETO">
    </form>
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
                    <th width="10%">Nome</th>
                    <th width="10%">Data Início</th>
                    <th width="15%">Data Previsão Fim</th>
                    <th width="10%">Data Fim</th>
                    <th width="10%">Descrição</th>
                    <th width="10%">Status</th>
                    <th width="10%">Orçamento</th>
                    <th width="10%">Risco</th>


                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr>
                        <td width="10%">${projeto.nome}</td>
                        <td width="10%"><fmt:formatDate value="${projeto.dataInicio}"
                                            pattern="dd/MM/yyyy" /></td>
                        <td width="15%"><fmt:formatDate value="${projeto.dataPrevisaoFim}"
                                            pattern="dd/MM/yyyy" /></td>
                        <td width="10%"><fmt:formatDate value="${projeto.dataFim}"
                                            pattern="dd/MM/yyyy" /></td>
                        <td width="10%" id="content">${projeto.descricao}</td>
                        <td width="10%">${projeto.status}</td>
                        <td width="10%">${projeto.orcamento}</td>
                        <td width="10%">${projeto.risco}</td>
                        <td width="20%"><a type="button" class="btn btn-success"
                               href="/update-projetos/${projeto.id}">Atualizar</a>
                            <a type="button" class="btn btn-warning"
                               href="/delete-projetos/${projeto.id}">Excluir</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>