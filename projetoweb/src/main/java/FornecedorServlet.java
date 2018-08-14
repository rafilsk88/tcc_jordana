

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisul.model.Fornecedor;

@WebServlet(urlPatterns= {"/fornecedor", "/fornecedorServlet", "/fornecedorController"})
public class FornecedorServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	List<Fornecedor> lista = new ArrayList<>();
	
	public FornecedorServlet() {
		System.out.println("Construindo Servlet ...");
	}
	
	public void init() throws ServletException{
		System.out.println("Inicializando Servlet");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("fornecedor.jsp");
		
		req.setAttribute("listaFornecedor", lista);
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Recebemdo da tela html os dados
		String nome = req.getParameter("nomeFornecedor");
		String razaoSocial = req.getParameter("razaoSocialFornecedor");
		String cnpj = req.getParameter("cnpjFornecedor");
		
		
		//Colocando os atributos no objeto Fornecedor
		Fornecedor forn = new Fornecedor();
		forn.setNome(nome);
		forn.setRazaoSocial(razaoSocial);
		forn.setCnpj(cnpj);
		
		//Adicionando este objeto a uma lista
		lista.add(forn);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo no método POST com nome: " + nome + " e Razao Social: " + razaoSocial + " e CNPJ: " + cnpj);
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

}
