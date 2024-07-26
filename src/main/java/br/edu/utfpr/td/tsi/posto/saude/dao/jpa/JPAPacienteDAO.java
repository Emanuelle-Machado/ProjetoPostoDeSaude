package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.PacienteRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;
import br.edu.utfpr.td.tsi.posto.saude.service.EnderecoService;

public class JPAPacienteDAO implements PacienteDAO {

	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Override
	public String inserir(Paciente paciente, String idEndereco) {
		pacienteRepository.save(paciente);
		enderecoService.inserir(paciente.getEndereco());
		return paciente.getId();
	}

	@Override
	public void atualizar(String id, Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Paciente> listarTodos() {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		Iterable<Paciente> pacientes = pacienteRepository.findAll();	
		pacientes.forEach(listaPacientes::add);
		return listaPacientes;
	}

	@Override
	public Paciente procurar(String cpf) {
		return null;
	}

}
