package br.edu.utfpr.td.tsi.posto.saude.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.posto.saude.dao.EnderecoDAO;
import br.edu.utfpr.td.tsi.posto.saude.dao.repositorio.EnderecoRepository;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

public class JPAEnderecoDAO implements EnderecoDAO {

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Override
	public String inserir(Endereco endereco) {
		enderecoRepository.save(endereco);
		return endereco.getId();
	}

	@Override
	public void atualizar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String idEndereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> listarTodos() {
		List<Endereco> listaEnderecos = new ArrayList<Endereco>();
		Iterable<Endereco> enderecos = enderecoRepository.findAll();	
		enderecos.forEach(listaEnderecos::add);
		return listaEnderecos;
	}

	@Override
	public List<Endereco> procurar(String idEndereco) {
		return null;
	}

}
