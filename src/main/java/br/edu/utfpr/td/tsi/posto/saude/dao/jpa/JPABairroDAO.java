package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.BairroRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;


public class JPABairroDAO implements BairroDAO {

	@Autowired
	BairroRepository bairroRepository;
	
	@Override
	public String inserir(Bairro bairro) {
		bairroRepository.save(bairro);
		return bairro.getId();
	}

	@Override
	public void atualizar(String id, Bairro bairro) {
		bairroRepository.findById(id);
		bairroRepository.save(bairro);
	}

	@Override
	public void remover(String id) {
		bairroRepository.deleteById(id);
		
	}

	@Override
	public List<Bairro> listarTodos() {
		List<Bairro> listaBairros = new ArrayList<Bairro>();
		Iterable<Bairro> bairros = bairroRepository.findAll();	
		bairros.forEach(listaBairros::add);
		return listaBairros;
	}

	@Override
	public List<Bairro> procurar(String nome) {
		return bairroRepository.findAllByNome(nome);
	}

}
