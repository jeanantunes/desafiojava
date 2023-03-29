<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp"%>
<html>
<head>
</head>
<body>
<div class="p-2 text-center bg-light">
    <h4 class="mb-1">Atualizar Projeto</h4>
</div>
<form:form action="/save/${id}">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" path="id" name="id" id="id" value="${id}">
    <div class="form-row needs-validation">
    <div class="form-group col-md-8">
        <label for="nome">Nome:</label>
        <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${nome}" required/>
    </div>

        <div class="form-group col-md-12" style="margin-top: -20px;text-align: right;">
            <label for="risco">Risco:</label>
            <select class="select" path="risco" name="risco" class="form-control" id="risco" placeholder="Risco" value="${risco}" required>
                <option value="1">BAIXO</option>
                <option value="2">MEDIO</option>
                <option value="3">ALTO</option>
            </select>
            <!-- <input type="text" path="risco" name="risco" class="form-control" id="risco" placeholder="Risco" value="${risco}" required />-->
        </div>

    <div class="form-group" col-md-4>
        <label for="dataInicio">Data In&#237;cio</label>
        <input type="text" path="dataInicio" name="dataInicio" class="form-control" id="dataInicio" placeholder="00/00/0000"
               placeholder="dd/MM/yyyy" pattern="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"
               value = "<fmt:formatDate value="${dataInicio}" />" required/>

    </div>
    <div class="form-group" col-md-4>
        <label for="dataPrevisaoFim">Data Previs&#227;o Fim</label>
        <input type="text" path="dataPrevisaoFim" name="dataPrevisaoFim" class="form-control" id="dataPrevisaoFim" placeholder="00/00/0000"
               placeholder="dd/MM/yyyy" pattern="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"
               value = "<fmt:formatDate value="${dataPrevisaoFim}" pattern="dd/MM/yyyy" />" required />
    </div>
    <div class="form-group" col-md-4>
        <label for="dataFim">Data Fim</label>
        <input type="text" path="dataFim" name="dataFim" class="form-control" id="dataFim" placeholder="00/00/0000"
               placeholder="dd/MM/yyyy" pattern="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"
               value = "<fmt:formatDate value="${dataFim}" pattern="dd/MM/yyyy" />" required/>
    </div>

    <div class="form-group">
        <label for="descricao">Descri&#231;&#227;o:</label>
        <textarea type="textarea" maxlength="5000" path="descricao" name="descricao" class="form-control" id="descricao" placeholder="Descri&#231;&#227;o" required>
            ${descricao}
        </textarea>
    </div>
    <div class="form-group">
        <label for="status">Status:</label>
        <input type="text" path="status" name="status" class="form-control" id="status" placeholder="Status" value="${status}" required />
    </div>
    <div class="form-group">
        <label for="orcamento">Or&#231;amento:</label>
        <input type="number" path="orcamento" name="orcamento" class="form-control" id="orcamento" placeholder="R$" value="${orcamento}" pattern="^\$\d{1,3}(,\d{3})*(\.\d+)?$" min="0.00" required />
    </div>
    <!-- <div class="form-group">
        <label for="risco">Risco:</label>
        <input type="text" path="risco" name="risco" class="form-control" id="risco" placeholder="Risco" value="${risco}" required />
    </div>-->
    </div>
    <div class="text-center" style="margin:5px 5px 5px 5px;">
    <button type="submit" id="atualizar" class="btn btn-primary text">ATUALIZAR</button>
    </div>
</form:form>
<%@ include file="footer.jsp"%>
</body>
</html>
<script>
    $("#atualizar").click(function(){
        $.ajax({
            url : '/save/{id}',
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