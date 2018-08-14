package br.com.unisul.model.service;

import java.util.ArrayList;
import java.util.List;

import br.com.unisul.model.Fornecedor;

public class FornecedorService {
	
	
	
	private static List<Fornecedor> lista = new ArrayList<>();

	
	public void cadastrar(Fornecedor fornecedor) {
		lista.add(fornecedor);
	}
	
	
	public List<Fornecedor> getTodosFornecedores(){
		return lista;
	}
	
	public void excluir(int indice) {
		lista.remove(indice);
	}
	
}
