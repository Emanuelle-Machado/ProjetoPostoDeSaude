package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.MedicoRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

public class JPAMedicoDAO implements MedicoDAO {

	@Autowired
	MedicoRepository medicoRepository;
	
	@Override
	public String inserir(Medico medico) {
		medicoRepository.save(medico);
		return medico.getId();
	}

	@Override
	public void atualizar(String id, Medico medico) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medico> listarTodos() {
		List<Medico> listaMedicos = new ArrayList<Medico>();
		Iterable<Medico> medicos = medicoRepository.findAll();	
		medicos.forEach(listaMedicos::add);
		return listaMedicos;
	}

	@Override
	public Medico procurar(String crm) {
		return null;
	}

}
