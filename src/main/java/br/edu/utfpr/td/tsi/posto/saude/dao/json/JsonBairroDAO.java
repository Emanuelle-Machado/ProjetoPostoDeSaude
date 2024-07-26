package br.edu.utfpr.td.tsi.posto.saude.dao.json;

import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Component
public class JsonBairroDAO implements BairroDAO {

	@Override
	public String inserir(Bairro bairro) {
		System.out.println("Persistindo dados em JSON");
		return null;
	}

	@Override
	public void atualizar(String id, Bairro bairro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bairro> listarTodos() {
		System.out.println("Listando em Json");
		return null;
	}

	@Override
	public List<Bairro> procurar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
