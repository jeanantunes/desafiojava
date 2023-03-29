<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <style>
        #content {
            overflow: hidden;
            width: 114px;
            height: 112px;
            display: -webkit-box;
            -webkit-line-clamp: 4;
            -webkit-box-orient: vertical;
        }

        #content:hover {
            overflow: visible;
            white-space: normal;
            width: auto;
            position: absolute;
            background-color: #FFF;
        }

        #content:hover + div {
            margin-top: 20px;
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
            <table class="table table-striped" id="pTabela">
                <thead>
                <tr>
                    <th width="10%">Nome</th>
                    <th width="10%">Data In&#237;cio</th>
                    <th width="15%">Data Previs&#227;o Fim</th>
                    <th width="10%">Data Fim</th>
                    <th width="10%">Descri&#231;&#227;o</th>
                    <th width="10%">Status</th>
                    <th width="10%">Or&#231;amento</th>
                    <th width="10%">Risco</th>


                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr>
                        <td width="10%">${projeto.nome}</td>
                        <td width="10%"><fmt:formatDate value="${projeto.dataInicio}"
                                                        pattern="dd/MM/yyyy"/></td>
                        <td width="15%"><fmt:formatDate value="${projeto.dataPrevisaoFim}"
                                                        pattern="dd/MM/yyyy"/></td>
                        <td width="10%"><fmt:formatDate value="${projeto.dataFim}"
                                                        pattern="dd/MM/yyyy"/></td>
                        <td width="10%" id="content">${projeto.descricao}</td>
                        <td width="10%" id="status">${projeto.status}</td>
                        <td width="10%">${projeto.orcamento}</td>
                        <td width="10%">${projeto.risco}</td>
                        <td width="20%"><a type="button" class="btn btn-success" href="/update-projetos/${projeto.id}">Atualizar</a>
                            <a type="button" id="btnDisabled" class="btn btn-warning btnDelete" href="/delete-projetos/${projeto.id}">Excluir</a>
                        </td>
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
<script>
    $(document).ready(function(){
        let btn = document.querySelector('#btnDisabled');
        $(".btnDelete").on('click',function(){
            var currentRow=$(this).closest("tr");
            var col=currentRow.find("td:eq(5)").html();
            if(col == 4){
                btn.disabled = true;
                alert("O status INICIADO nao permite exclusao.");
                return false;
            }
            if(col == 6){
                btn.disabled = true;
                alert("O status EM ANDAMENTO nao permite exclusao.");
                return false;
            }
            if(col == 7){
                btn.disabled = true;
                alert("O status ENCERRADO nao permite exclusao.");
                return false;
            }
        });
    });
</script>