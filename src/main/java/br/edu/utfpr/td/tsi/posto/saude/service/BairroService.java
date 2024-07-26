package br.edu.utfpr.td.tsi.posto.saude.service;



import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;


public interface BairroService {
	
	public void inserir(Bairro b);
	
	public List<Bairro> listarTodos();
	
	public void remover(String idBairro);
	
	public void alterar(Bairro b);
	
	public List<Bairro> listarPorNome(String nomeBairro);

}
