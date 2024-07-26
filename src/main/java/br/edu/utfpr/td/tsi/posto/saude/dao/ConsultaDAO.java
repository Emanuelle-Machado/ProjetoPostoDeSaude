package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

public interface ConsultaDAO {
	
	public String inserir(Consulta consulta);

	public void atualizar(String id, Consulta consulta);

	public void remover(String id);

	public List<Consulta> listarTodos();
	
	public boolean procurar(String idPaciente);

	
}
