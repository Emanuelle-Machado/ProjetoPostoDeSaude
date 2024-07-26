package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.MedicoRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public void inserir(Medico m) {
		String idmedico =  UUID.randomUUID().toString();
		m.setId(idmedico);
		medicoRepository.save(m);		
		
	}

	@Override
	public List<Medico> listarTodos() {
		
		List<Medico> listaMedicos = new ArrayList<Medico>();
		Iterable<Medico> medicos = medicoRepository.findAll();	
		medicos.forEach(listaMedicos::add);
		return listaMedicos;
	}

	@Override
	public void remover(String idMedico) {

		
	}

	@Override
	public void alterar(Medico m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Medico> listarPorCrm(String crmMedico) {
		return medicoRepository.findAllByCrm(crmMedico);
	}

}
