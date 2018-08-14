<!DOCTYPE html>
<%@page import="br.com.unisul.model.Fornecedor" %>
<%@page import="java.util.List" %>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Fornecedor</title>
</head>
<body>

	<h1>Tela de cadastro de Fornecedor</h1>
	
	<form method="post" action="fornecedor">
		Nome Fornecedor: <input type="text" value="" name="nomeFornecedor"><br>
		Razão Social: <input type="text" value="" name="razaoSocialFornecedor"><br>
		CNPJ: <input type="text" value="" name="cnpjFornecedor"><br>
		<input type="submit" value="Salvar">
	
	</form>
	
<%
 List<Fornecedor> lista = (List<Fornecedor>)request.getAttribute("listaFornecedor");
for(Fornecedor forn: lista){
	out.print(forn.getNome()+"<br/>");
}
%>	
</body>
</html>