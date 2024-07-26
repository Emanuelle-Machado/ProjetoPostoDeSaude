package br.edu.utfpr.td.tsi.posto.saude.dao;

import java.util.List;


import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public interface MedicoDAO {
	
	public String inserir(Medico medico);

	public void atualizar(String id, Medico medico);

	public void remover(String id);

	public List<Medico> listarTodos();
	
	public Medico procurar(String crm);

}
