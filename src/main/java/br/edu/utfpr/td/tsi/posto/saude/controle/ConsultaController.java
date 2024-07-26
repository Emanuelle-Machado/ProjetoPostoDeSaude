package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;
import br.edu.utfpr.td.tsi.posto.saude.service.ConsultaService;
import br.edu.utfpr.td.tsi.posto.saude.service.MedicoService;
import br.edu.utfpr.td.tsi.posto.saude.service.PacienteService;

@Controller
public class ConsultaController {

	/*
	@Autowired
	private PacienteDAO pacienteDAO;
	@Autowired
	private MedicoDAO medicoDAO;
	@Autowired
	private ConsultaDAO consultaDAO;*/
	
	@Autowired
	private PacienteService pacienteService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ConsultaService consultaService;

	@GetMapping(value = "/listarconsultas")
	public String listar(Model model) {
		
		List<Consulta> consultas = consultaService.listarTodos();
		model.addAttribute("consultas", consultas);	
	
		
		return "listarConsultas";
	}

	@GetMapping(value = "/cadastrarconsulta")
	public String exibirPaginaCadastro(Model model, Paciente p, Medico m) {
		
		
		List<Paciente> pacientes = pacienteService.listarTodos();
		model.addAttribute("pacientes", pacientes);
		
		List<Medico> medicos = medicoService.listarTodos();
		model.addAttribute("medicos", medicos);
		
		return "cadastrarConsulta";
	}

	@PostMapping("/cadastrarConsulta")
	public String cadastrar(Consulta c, Model model) {
		consultaService.inserir(c);
			
		return "redirect:/listarconsultas";
		
	}
	
	@PostMapping("/procurarConsultaPorStatus")
	public String procurarConsultaPorStatus(String statusConsulta, Model model) {
		List<Consulta> consultas = consultaService.listarPorStatus(statusConsulta);			
		model.addAttribute("consultas", consultas);		
		return "listarConsultas";		
	}
		
}
