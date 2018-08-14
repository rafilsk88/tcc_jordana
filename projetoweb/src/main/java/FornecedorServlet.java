
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
import br.com.unisul.model.service.FornecedorService;

@WebServlet(urlPatterns = { "/fornecedor", "/fornecedorServlet", "/fornecedorController" })
public class FornecedorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	FornecedorService fornecedorService;

	public FornecedorServlet() {
		System.out.println("Construindo Servlet ...");
	}

	public void init() throws ServletException {
		fornecedorService = new FornecedorService();
		System.out.println("Inicializando Servlet");
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String i = req.getParameter("i");
		if (i != null && i!="") {
			fornecedorService.excluir(Integer.parseInt(i));

		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("fornecedor.jsp");

		req.setAttribute("listaFornecedor", fornecedorService.getTodosFornecedores());

		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Recebemdo da tela html os dados
		String nome = req.getParameter("nomeFornecedor");
		String razaoSocial = req.getParameter("razaoSocialFornecedor");
		String cnpj = req.getParameter("cnpjFornecedor");

		// Colocando os atributos no objeto Fornecedor
		Fornecedor forn = new Fornecedor();
		forn.setNome(nome);
		forn.setRazaoSocial(razaoSocial);
		forn.setCnpj(cnpj);

		// Adicionando este objeto a uma lista

		fornecedorService.cadastrar(forn);

		RequestDispatcher dispatcher = req.getRequestDispatcher("fornecedor.jsp");
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("listaFornecedor", fornecedorService.getTodosFornecedores());
		dispatcher.forward(req, resp);

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
