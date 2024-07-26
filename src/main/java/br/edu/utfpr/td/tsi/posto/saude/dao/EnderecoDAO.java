package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;


import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

public interface EnderecoDAO {

	public String inserir(Endereco endereco);

	public void atualizar(Endereco endereco);

	public void remover(String idEndereco);

	public List<Endereco> listarTodos();
	
	public List<Endereco> procurar(String idEndereco);

}
