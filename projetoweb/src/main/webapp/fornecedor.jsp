<!DOCTYPE html>
<%@page import="br.com.unisul.model.Fornecedor"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="UTF-8">
<script>
	function confirma(pindece) {

		if (window.confirm("Tem certeza que deseja excluir ?")) {
			location.href = "fornecedor?i=" + pindece;
		}
	}
</script>

<title>Cadastro Fornecedor</title>
</head>
<body>

	<h1>Tela de cadastro de Fornecedor</h1>


	<div>

		<%
			Object msg = request.getAttribute("msg");
			if (msg != null) {
				String msgStr = (String) msg;
				out.print(msg);
			}
			
			
			Fornecedor forne = (Fornecedor)request.getAttribute("forn");
			Integer ifor = (Integer)request.getAttribute("ifor");
			
		%>

	</div>
	<form method="post" action="fornecedor">
	
		<input type="hidden" name="i" value="<%=ifor %>">
		
		Nome Fornecedor: 
		<input type="text" value="<%=forne.getNome() %>" name="nomeFornecedor"><br>
		Razao Social: 
		<input type="text" value="<%=forne.getRazaoSocial() %>"	name="razaoSocialFornecedor"><br> 
		CNPJ: 
		<input type="text" value="<%=forne.getCnpj() %>" name="cnpjFornecedor"><br> 
		
		<input type="submit" value="Salvar">

	</form>

	<%
		List<Fornecedor> lista = (List<Fornecedor>) request.getAttribute("listaFornecedor");
		int i = 0;
		for (Fornecedor forn : lista) {
	%>

	<%=forn.getNome()%>

	<a href="javascript:confirma(<%=i%>)"> Excluir </a> |
	<a href="fornecedor?i=<%=i%>"> Editar </a>
	<br/>

	<%
		i++;
		}
	%>





</body>
</html>