package br.edu.utfpr.td.tsi.posto.saude.dao.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, String>{

	//buscar consulta
	public List<Consulta> findAllByStatus(String status);
	
	//achar o paciente por id
	public List<Consulta> findAllByPaciente_Id(String idPaciente);
	
	//achar o medico por id
	public List<Consulta> findAllByMedico_Id(String idMedico);
	
	
	
}
