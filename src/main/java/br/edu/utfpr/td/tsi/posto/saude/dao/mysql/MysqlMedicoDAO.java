package br.edu.utfpr.td.tsi.posto.saude.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.posto.saude.dao.MedicoDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Medico;

@Component
public class MysqlMedicoDAO implements MedicoDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String inserir(Medico m) {
		String sql = "insert into consulta (idMedico, nome, sobrenome, telefone, crm) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, m.getId(), m.getNome(), m.getSobrenome(), m.getTelefone(), m.getCrm());
		return m.getId();
	}

	@Override
	public void atualizar(String id, Medico medico) {
		
		String sql = "update medico set nome = ?, sobrenome = ?, telefone = ?, crm = ? where idMedico = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, medico.getNome());
			preparedStatement.setString(2, medico.getSobrenome());
			preparedStatement.setString(3, medico.getTelefone());
			preparedStatement.setString(4, medico.getCrm());
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
		
		String sql = "delete from medico  where idMedico = ?";
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
	public List<Medico> listarTodos() {
		ArrayList<Medico> medicos = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idMedico, nome , sobrenome, telefone, crm from medico");
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String sobrenome = rs.getString(3);
				String telefone = rs.getString(4);
				String crm = rs.getString(5);
				medicos.add(new Medico(id, nome, sobrenome, telefone, crm));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicos;
	}

	@Override
	public Medico procurar(String crm) {
		
		Medico medico = null;
		
		try {
			//conexão com o banco de dados
        	Connection conn = dataSource.getConnection();

            //consulta SQL para buscar o paciente por CPF
            String sql = "SELECT id, nome, sobrenome, telefone, crm FROM medico WHERE crm = ?";

            //instrução preparada com o SQL
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, crm);
            
            ResultSet rs = stmt.executeQuery(sql);
            
			while (rs.next()) {
				
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String telefone = rs.getString("telefone");
				
				medico = new Medico(id, nome, sobrenome, telefone, crm);
			}
			
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return medico;
	}

}
