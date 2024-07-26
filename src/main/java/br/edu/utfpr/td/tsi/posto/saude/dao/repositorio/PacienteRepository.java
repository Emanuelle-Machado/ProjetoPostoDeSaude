package br.edu.utfpr.td.tsi.posto.saude.dao.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, String> {

	public List<Paciente> findAllByCpf(String cpf);
	
}
