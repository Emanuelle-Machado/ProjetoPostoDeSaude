package br.edu.utfpr.td.tsi.posto.saude.dao.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public interface MedicoRepository extends CrudRepository<Medico, String> {

	public List<Medico> findAllByCrm(String crm);
	
}
