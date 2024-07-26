package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.PacienteRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Transactional
	public void inserir(Paciente p) {
		String idpaciente =  UUID.randomUUID().toString();
		p.setId(idpaciente);	
		pacienteRepository.save(p);
	}

	@Override
	public List<Paciente> listarTodos() {

		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		Iterable<Paciente> pacientes = pacienteRepository.findAll();	
		pacientes.forEach(listaPacientes::add);
		return listaPacientes;
		 
	}

	@Override
	public void remover(String idPaciente) {

		pacienteRepository.deleteById(idPaciente);
		
	}

	@Override
	public void alterar(Paciente p) {
		
		
		
	}

	@Override
	public List<Paciente> listarPorCpf(String cpfPaciente) {
		return pacienteRepository.findAllByCpf(cpfPaciente);
	}

}
