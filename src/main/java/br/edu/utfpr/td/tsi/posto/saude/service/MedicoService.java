package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.List;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public interface MedicoService {
	
	public void inserir(Medico m);
	
	public List<Medico> listarTodos();
	
	public void remover(String idMedico);
	
	public void alterar(Medico m);
	
	public List<Medico> listarPorCrm(String crmMedico);

}
