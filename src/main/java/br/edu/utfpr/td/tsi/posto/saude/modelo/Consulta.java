package br.edu.utfpr.td.tsi.posto.saude.modelo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "consulta", schema = "postodesaude")
public class Consulta {
	
	@Id
	@Column(name = "idconsulta")
	private String id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd" )
	@Column(name = "data_nascimento", nullable = false, length = 100)
	private LocalDate dataHora;
	
	@Column(nullable = false, length = 100)
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idpaciente", referencedColumnName = "idpaciente")
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idmedico", referencedColumnName = "idmedico")
	private Medico medico;
	
	public Consulta() {
		super();
	}

	public Consulta(String id, LocalDate dataHora, String status) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public LocalDate getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDate dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
