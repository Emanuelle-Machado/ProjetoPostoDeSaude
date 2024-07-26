package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

public interface ConsultaService {

	public void inserir(Consulta consulta);

	public void atualizar(String id, Consulta consulta);

	public void remover(String id);

	public List<Consulta> listarTodos();
	
	public List<Consulta> procurarPaciente(String idPaciente);
	
	public List<Consulta> listarPorMedico(String idMedico);
	
	public List<Consulta> listarPorStatus(String statusConsulta);
	
}
