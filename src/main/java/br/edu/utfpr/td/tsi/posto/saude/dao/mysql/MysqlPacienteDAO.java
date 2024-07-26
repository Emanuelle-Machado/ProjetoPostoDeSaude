package br.edu.utfpr.td.tsi.posto.saude.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.dao.PacienteDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Paciente;

@Component
public class MysqlPacienteDAO implements PacienteDAO{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String inserir(Paciente p, String e) {
		String sql = "insert into paciente (idPaciente, nome, sobrenome, data_nascimento) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, p.getId(), p.getNome(), p.getSobrenome(), p.getTelefone(), p.getEmail(), p.getCpf(), p.getEndereco().getId());
		return p.getId();
	}


	@Override
	public void atualizar(String id, Paciente paciente) {
		String sql = "update paciente set nome = ?, sobrenome = ?, telefone = ?, email = ?, cpf = ? where idPaciente = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getSobrenome());
			preparedStatement.setString(3, paciente.getTelefone());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getCpf());
			preparedStatement.setString(5, paciente.getEndereco().getId());
			preparedStatement.setString(7, id);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(String id) {
		String sql = "delete from paciente  where idPaciente = ?";
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
	public List<Paciente> listarTodos() {
		ArrayList<Paciente> pacientes = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idPaciente, nome, sobrenome, telefone, email, cpf from paciente");
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String telefone = rs.getString(4);
				String email = rs.getString(5);
				String cpf = rs.getString(6);
				pacientes.add(new Paciente(id, nome, sobrenome, telefone, email, cpf));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pacientes;
	}

	@Override
	public Paciente procurar(String cpf){
	        Paciente paciente = null;

	        try {
	            //conexão com o banco de dados
	        	Connection conn = dataSource.getConnection();

	            //consulta SQL para buscar o paciente por CPF
	            String sql = "SELECT id, nome, sobrenome, telefone, email, cpf FROM paciente WHERE cpf = ?";

	            //instrução preparada com o SQL
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, cpf);

	            //Executa consulta
	            ResultSet rs = stmt.executeQuery(sql);

	            //Verifica se há um resultado
	            if (rs.next()) {
	                // Recupere os dados do resultado
	            	String id = rs.getString("id");
	                String nome = rs.getString("nome");
	                String sobrenome = rs.getString("sobrenome");
	                String telefone = rs.getString("telefone");
	                String email = rs.getString("email");
	                // Recupere outras informações necessárias

	                // Crie um objeto Paciente com os dados recuperados
	                paciente = new Paciente(id, nome, sobrenome, telefone, email, cpf);
	            }
	            conn.close();
				stmt.close();
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        }

	        return paciente;
	}
	
	

}
