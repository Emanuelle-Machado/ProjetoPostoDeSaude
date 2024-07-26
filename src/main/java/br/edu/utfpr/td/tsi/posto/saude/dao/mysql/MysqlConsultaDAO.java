package br.edu.utfpr.td.tsi.posto.saude.dao.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.dao.ConsultaDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Consulta;

@Component
public class MysqlConsultaDAO implements ConsultaDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String inserir(Consulta consulta) {
		
		String sql = "insert into consulta (idConsulta, dataHora, status, idPaciente, idMedico) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, consulta.getId(), consulta.getDataHora(), consulta.getStatus(), 
				consulta.getPaciente().getId(), consulta.getMedico().getId());
	
		return consulta.getId(); 
	}

	@Override
	public void atualizar(String id, Consulta consulta) {
		
		String sql = "update consulta set dataHora = ?, status = ?, idPaciente = ?, idMedico = ? where idConsulta = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setDate(1, Date.valueOf(consulta.getDataHora()));
			preparedStatement.setString(2, consulta.getStatus());
			preparedStatement.setString(3, consulta.getPaciente().getId());
			preparedStatement.setString(4, consulta.getMedico().getId());
			preparedStatement.setString(5, id);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(String id) {

		String sql = "delete from consulta where idConsulta = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Consulta> listarTodos() {
		ArrayList<Consulta> consultas = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idConsulta, dataHora, status from consulta");
			while (rs.next()) {
				String id = rs.getString(1);
				LocalDate dataHora = rs.getDate(2).toLocalDate();
				String status = rs.getString(3);
				consultas.add(new Consulta(id, dataHora, status));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultas;
	}

	/*BUSCA POR CONSULTA COM ID DE UM PACIENTE, 
	UTILIZADA PARA GARANTIR QUE NÃO HAJA DUAS CONSULTAS AGENDADAS COM O MESMO PACIENTE*/
	@Override
	public boolean procurar(String idPaciente) {
		Consulta consulta = null;
		boolean agendado = false;
		
		try {
			 //conexão com o banco de dados
        	Connection conn = dataSource.getConnection();
			
			//consulta SQL para buscar o paciente por CPF
            String sql = "SELECT idConsulta, dataHora, status FROM consulta WHERE idPaciente = ?";

            //instrução preparada com o SQL
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, idPaciente);
            
            //Executa consulta
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                //dados do resultado
            	String idConsulta = rs.getString("idConsulta");
                LocalDate dataHora = rs.getDate("dataHora").toLocalDate();
                String status = rs.getString("status");
                //outras informações necessárias

                //Paciente com os dados recuperados
                consulta = new Consulta(idConsulta, dataHora, status);
            }
            
            //se consulta for nulo, não há agendamento com esse paciente. então false
            if(consulta == null) {
    			agendado = false;
    			
    		//se não for nulo, verifica se o status está como agendado, se sim true
    		} else {
    			if(consulta.getStatus().equalsIgnoreCase("agendada")) {
    				agendado = true;
    			}
    		}
			
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		return agendado;
	}

	
}
