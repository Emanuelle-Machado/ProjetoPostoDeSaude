package br.edu.utfpr.td.tsi.posto.saude.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.EnderecoRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void inserir(Endereco e) {
		String idendereco =  UUID.randomUUID().toString();
		e.setId(idendereco);
		enderecoRepository.save(e);
		
	}

	@Override
	public List<Endereco> listarTodos() {
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		Iterable<Endereco> enderecos = enderecoRepository.findAll();	
		enderecos.forEach(listaEnderecos::add);
		return listaEnderecos;
	}

	@Override
	public void remover(String idEndereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Endereco e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listarPorCep(String cepEndereco) {
		return enderecoRepository.findAllByCep(cepEndereco);
	}

}
