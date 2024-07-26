package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

public interface BairroDAO {

	public String inserir(Bairro bairro);

	public void atualizar(String id, Bairro bairro);

	public void remover(String id);

	public List<Bairro> listarTodos();
	
	public List<Bairro> procurar(String nome);

}
