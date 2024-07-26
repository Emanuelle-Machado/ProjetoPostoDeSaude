package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;
import br.edu.utfpr.td.tsi.posto.saude.service.EnderecoService;

@Controller
public class EnderecoController {
	
	/*
	@Autowired
	private EnderecoDAO enderecoDAO;
	*/
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping("/listarpacientes")
	public String vizualizar(Paciente paciente) {
		
		return "/listarenderecos";
	}

	@GetMapping(value = "/listarenderecos")
	public String listar(Model model, Paciente paciente) {

		List<Endereco> enderecos = enderecoService.listarTodos();
		
		model.addAttribute("enderecos", enderecos);	
		return "listarEnderecos";
	}
	
	@PostMapping("/procurarEnderecoPorCep")
	public String procurarEnderecoPorCep(String cepEndereco, Model model) {
		List<Endereco> enderecos = enderecoService.listarPorCep(cepEndereco);			
		model.addAttribute("enderecos", enderecos);		
		return "listarEnderecos";		
	}

}
