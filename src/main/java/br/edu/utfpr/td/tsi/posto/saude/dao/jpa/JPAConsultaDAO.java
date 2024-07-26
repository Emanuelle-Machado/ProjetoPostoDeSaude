package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.ConsultaDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.ConsultaRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

public class JPAConsultaDAO implements ConsultaDAO  {

	@Autowired
	ConsultaRepository consultaRepository;
	
	@Override
	public String inserir(Consulta consulta) {
		consultaRepository.save(consulta);
		return consulta.getId();
	}

	@Override
	public void atualizar(String id, Consulta consulta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Consulta> listarTodos() {
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		Iterable<Consulta> consultas = consultaRepository.findAll();	
		consultas.forEach(listaConsultas::add);
		return listaConsultas;
	}

	@Override
	public boolean procurar(String idPaciente) {
		return false;
	}

}
