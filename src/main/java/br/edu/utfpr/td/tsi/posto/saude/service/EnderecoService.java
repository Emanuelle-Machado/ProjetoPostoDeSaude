package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

public interface EnderecoService {
	
	public void inserir(Endereco e);
	
	public List<Endereco> listarTodos();
	
	public void remover(String idEndereco);
	
	public void alterar(Endereco e);
	
	public List<Endereco> listarPorCep(String cepEndereco);

}
