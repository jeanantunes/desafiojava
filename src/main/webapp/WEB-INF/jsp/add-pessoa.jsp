<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ include file="header.jsp"%>
<html>
<head>
</head>
<body>
<div class="p-2 text-center bg-light">
    <h4 class="mb-1">Novo Cargo</h4>
</div>
<div id="alerta" name="alerta" path="alerta">${alerta}</div>
<form:form action="/add-pessoa">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" path="id" name="id" id="id" value="${lastPessoaId}">
    <div class="form-row needs-validation">
        <div class="form-group col-md-12">
            <label for="nome">Nome:</label>
            <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${nome}" required/>
        </div>
        <div class="form-group col-md-12">
            <label for="dataNascimento">Data Nascimento:</label>
            <input type="text" path="dataNascimento" name="dataNascimento" class="form-control" id="dataNascimento"
                   placeholder="dd/MM/yyyy" pattern="^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"
                   value = "<fmt:formatDate value="${dataNascimento}" />" required/>
        </div>
        <div class="form-group col-md-12">
            <label for="cpf">Cpf:</label>
            <input type="text" path="cpf" name="cpf" class="form-control" id="cpf"
                   placeholder="000.000.000-00" pattern="([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})"
                   value="${cpf}" required/>
        </div>

        <div class="form-group col-md-12">
            <label for="funcionario">Funcionario:</label>
            <select class="select" path="funcionario" name="funcionario" class="form-control" id="funcionario" placeholder="Funcionario" value="${funcionario}" required>
                <option value="1">SIM</option>
                <option value="0">NAO</option>
            </select>
        </div>

    </div>
    <div class="text-center" style="margin:10px 10px 10px 10px;">
        <button type="submit" id="salvar" class="btn btn-primary text">SALVAR</button>
    </div>
</form:form>
<%@ include file="footer.jsp"%>
</body>
</html>