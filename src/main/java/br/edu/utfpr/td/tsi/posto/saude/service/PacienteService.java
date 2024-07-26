package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface PacienteService {
	
	public void inserir(Paciente p);
	
	public List<Paciente> listarTodos();
	
	public void remover(String idPaciente);
	
	public void alterar(Paciente p);
	
	public List<Paciente> listarPorCpf(String cpfPaciente);

}
