package br.edu.utfpr.td.tsi.posto.saude.dao.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

public interface BairroRepository extends CrudRepository<Bairro, String> {
	
	public List<Bairro> findAllByNome(String nome);

}
