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
<form:form action="/add-pessoa">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" path="id" name="id" id="id" value="${lastPessoaId}">
    <div class="form-row needs-validation">
        <div class="form-group col-md-12">
            <label for="nome">Cargo:</label>
            <input type="text" path="nome" name="nome" class="form-control" id="nome" placeholder="Nome" value="${nome}" required>
        </div>
    </div>
    <div class="text-center" style="margin:10px 10px 10px 10px;">
        <button type="submit" id="salvar" class="btn btn-primary text">SALVAR</button>
    </div>
</form:form>
<%@ include file="footer.jsp"%>
</body>
</html>