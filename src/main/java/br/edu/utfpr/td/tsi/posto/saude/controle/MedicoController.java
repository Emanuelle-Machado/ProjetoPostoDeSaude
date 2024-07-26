package br.edu.utfpr.td.tsi.posto.saude.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;
import br.edu.utfpr.td.tsi.posto.saude.service.MedicoService;

@Controller
public class MedicoController {
	/*
	@Autowired
	MedicoDAO medicoDAO;*/

	@Autowired
	private MedicoService medicoService;
	
	@GetMapping(value = "/listarmedicos")
	public String listar(Model model) {
		List<Medico> medicos = medicoService.listarTodos();
		model.addAttribute("medicos", medicos);	
		return "listarMedicos";
	}

	
	@GetMapping(value = "/cadastrarmedico")
	public String exibirPaginaCadastro() {
		return "cadastrarMedico";
	}

	
	@PostMapping("/cadastrarMedico")
	public String cadastrar(Medico medico) {
		medicoService.inserir(medico);
		return "redirect:/listarmedicos";
	}

	@PostMapping("/procurarMedicoPorCrm")
	public String procurarMedicoPorCrm(String crmMedico, Model model) {
		List<Medico> medicos = medicoService.listarPorCrm(crmMedico);			
		model.addAttribute("medicos", medicos);		
		return "listarMedicos";		
	}
}
