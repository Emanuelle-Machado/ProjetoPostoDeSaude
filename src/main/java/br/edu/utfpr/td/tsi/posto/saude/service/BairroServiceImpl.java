package br.edu.utfpr.td.tsi.posto.saude.service;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.BairroRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Service
public class BairroServiceImpl implements BairroService {

	@Autowired
	BairroRepository bairroRepository;
	
	@Override
	public void inserir(Bairro b) {
		String idbairro =  UUID.randomUUID().toString();
		b.setId(idbairro);
		bairroRepository.save(b);
	}

	@Override
	public List<Bairro> listarTodos() {
		List<Bairro> listaBairros = new ArrayList<Bairro>();
		Iterable<Bairro> bairros = bairroRepository.findAll();	
		bairros.forEach(listaBairros::add);
		return listaBairros;
	}

	@Override
	public void remover(String idBairro) {

	bairroRepository.deleteById(idBairro);
		
	}

	@Override
	public void alterar(Bairro b) {
		
	}

	@Override
	public List<Bairro> listarPorNome(String nomeBairro) {
		return bairroRepository.findAllByNome(nomeBairro);
	}

	
	
}
