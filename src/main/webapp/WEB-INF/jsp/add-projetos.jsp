<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <script>
        $(document).ready(function(){
            $('#dataInicio').mask('00/00/0000');
            $('#dataPrevisaoFim').mask('00/00/0000');
            $('#dataFim').mask('00/00/0000');
            $('#orcamento').mask('^\$\d{1,3}(,\d{3})*(\.\d+)?$');
        });
    </script>
</head>
<body>
<div class="p-2 text-center bg-light">
    <h4 class="mb-1">Novo Projeto</h4>
</div>
<form:form action="/add-projetos">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" path="id" name="id" id="id" value="${lastId}">
    <div class="form-row">
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${nome}">
        </div>

        <div class="form-group" col-md-4>
            <label for="dataInicio">Data Início</label>
            <input type="text" path="dataInicio" name="dataInicio" class="form-control" id="dataInicio" placeholder="00/00/0000"
                   value = "<fmt:formatDate value="${dataInicio}" pattern="dd/MM/yyyy" />"/>
        </div>
        <div class="form-group" col-md-4>
            <label for="dataPrevisaoFim">Data Previsão Fim</label>
            <input type="text" path="dataPrevisaoFim" name="dataPrevisaoFim" class="form-control" id="dataPrevisaoFim" placeholder="00/00/0000"
                   value = "<fmt:formatDate value="${dataPrevisaoFim}" pattern="dd/MM/yyyy" />"/>
        </div>
        <div class="form-group" col-md-4>
            <label for="dataFim">Data Fim</label>
            <input type="text" path="dataFim" name="dataFim" class="form-control" id="dataFim" placeholder="00/00/0000"
                   value = "<fmt:formatDate value="${dataFim}" pattern="dd/MM/yyyy" />"/>
        </div>

        <div class="form-group">
            <label for="descricao">Descrição:</label>
            <textarea type="textarea" maxlength="5000" path="descricao" name="descricao" class="form-control" id="descricao" placeholder="Descrição">
                    ${descricao}
            </textarea>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <input type="text" path="status" name="status" class="form-control" id="status" placeholder="Status" value="${status}">
        </div>
        <div class="form-group">
            <label for="orcamento">Orçamento:</label>
            <input type="number" path="orcamento" name="orcamento" class="form-control" id="orcamento" placeholder="R$" value="${orcamento}" pattern="^\$\d{1,3}(,\d{3})*(\.\d+)?$" min="0.00">
        </div>
        <div class="form-group">
            <label for="risco">Risco:</label>
            <input type="text" path="risco" name="risco" class="form-control" id="risco" placeholder="Risco" value="${risco}">
        </div>
    </div>
    <div class="text-center" style="margin:5px 5px 5px 5px;">
        <button type="submit" id="salvar" class="btn btn-primary text">SALVAR</button>
    </div>
</form:form>
<%@ include file="footer.jsp"%>
</body>
</html>
<script>
    $("#salvar").click(function(){
        $.ajax({
            url : '/add-projetos',
            method : 'PUT',
            contentType: "application/json",
            data: JSON.stringify({ nome: nome, dataInicio: dataInicio, dataFim: dataFim, dataPrevisaoFim: dataPrevisaoFim, descricao:descricao, status: status, orcamento: orcamento, risco: risco }),
            async : false,
            complete : function(data) {
                console.log(data);
            }
        });

    });
</script>