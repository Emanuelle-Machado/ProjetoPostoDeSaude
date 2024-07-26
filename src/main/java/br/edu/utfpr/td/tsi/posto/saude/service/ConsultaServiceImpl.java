package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.utfpr.td.tsi.posto.saude.dao.ConsultaDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.ConsultaRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	ConsultaDAO consultaDAO;
	
	@Autowired
	MedicoDAO medicoDAO;
	
	@Autowired
	PacienteDAO pacienteDAO;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Transactional
	public void inserir(Consulta consulta) {
		
		List<Consulta> consultas = procurarPaciente(consulta.getPaciente().getId());
		for (Consulta c : consultas) {
			if(c.getStatus() == "agendada") {
				throw new RuntimeException("Paciente ja tem consulta cadastrada");
			}
		}
		
		String idconsulta =  UUID.randomUUID().toString();
		consulta.setId(idconsulta);
		consultaRepository.save(consulta);
		
	}

	@Override
	public void atualizar(String id, Consulta consulta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String id) {
		consultaRepository.deleteById(id);
	}

	@Override
	public List<Consulta> listarTodos() {

		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		Iterable<Consulta> consultas = consultaRepository.findAll();	
		consultas.forEach(listaConsultas::add);
		return listaConsultas;
		
	}


	@Override
	public List<Consulta> procurarPaciente(String idPaciente) {
		
		return consultaRepository.findAllByPaciente_Id(idPaciente);
	}

	@Override
	public List<Consulta> listarPorMedico(String idMedico) {
		
		return consultaRepository.findAllByMedico_Id(idMedico);
	}

	@Override
	public List<Consulta> listarPorStatus(String statusConsulta) {
		return consultaRepository.findAllByStatus(statusConsulta);
	}

	
	
}
