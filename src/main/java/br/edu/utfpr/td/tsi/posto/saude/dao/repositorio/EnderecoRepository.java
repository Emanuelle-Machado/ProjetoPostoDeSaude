package br.edu.utfpr.td.tsi.posto.saude.dao.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, String> {

	public List<Endereco> findAllByCep(String cep);
	
}
