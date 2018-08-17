
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

		Fornecedor forn = new Fornecedor();
		String i = req.getParameter("i");
		String acao = req.getParameter("acao");
		
		if(i != null && i!="" && acao!=null && acao!="") {
			if(acao.equals("exc")){
				int indice = Integer.parseInt(i);
				fornecedorService.excluir(indice);

			}else if(acao.equals("edit")) {
				int indice = Integer.parseInt(i);
				forn = fornecedorService.buscarPorIndice(indice);
			}
		}
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("fornecedor.jsp");
		req.setAttribute("forn", forn);
		req.setAttribute("ifor", i);
		req.setAttribute("ifor", -1);
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
		
		forn = new Fornecedor();
		forn.setNome("");
		forn.setRazaoSocial("");
		forn.setCnpj("");

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
