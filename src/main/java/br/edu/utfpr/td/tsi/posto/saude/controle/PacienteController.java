package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;
import br.edu.utfpr.td.tsi.posto.saude.service.BairroService;
import br.edu.utfpr.td.tsi.posto.saude.service.PacienteService;

@Controller
public class PacienteController {
/*
	@Autowired
	private PacienteDAO pacienteDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;

	@Autowired
	private BairroDAO bairroDAO;
	*/
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private BairroService bairroService;

	@GetMapping(value = "/listarpacientes")
	public String listar(Model model) {
		List<Paciente> pacientes = pacienteService.listarTodos();
		model.addAttribute("pacientes", pacientes);	
		return "listarPacientes";
	}

	@GetMapping(value = "/cadastrarpaciente")
	public String exibirPaginaCadastro(Model model) {
		Iterable<Bairro> bairros = bairroService.listarTodos();
		model.addAttribute("bairros", bairros);
		return "cadastrarPaciente";
	}

	@PostMapping("/cadastrarPaciente")
	public String cadastrar(Paciente paciente) {
		pacienteService.inserir(paciente);
		return "redirect:/listarpacientes";
	}
	
	@PostMapping("/procurarPacientePorCpf")
	public String procurarPacientePorCpf(String cpfPaciente, Model model) {
		List<Paciente> pacientes = pacienteService.listarPorCpf(cpfPaciente);			
		model.addAttribute("pacientes", pacientes);		
		return "listarPacientes";		
	}
	
}
