package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

public interface PacienteDAO {
	
	public String inserir(Paciente paciente, String idEndereco);

	public void atualizar(String id, Paciente paciente);

	public void remover(String id);

	public List<Paciente> listarTodos();
	
	public Paciente procurar(String cpf);
}
