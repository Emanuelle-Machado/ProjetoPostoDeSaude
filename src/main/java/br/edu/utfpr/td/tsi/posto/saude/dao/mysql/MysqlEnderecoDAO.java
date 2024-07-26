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

import br.edu.utfpr.td.tsi.posto.saude.dao.EnderecoDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Endereco;

@Component
public class MysqlEnderecoDAO implements EnderecoDAO {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String inserir(Endereco e) {
		String sql = "insert into paciente (idEndereco, logradouro, numero, cep, idBairro) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, e.getId(), e.getLogradouro(), e.getNumero(), e.getCep(), e.getBairro().getId());
		return e.getId();
	}

	@Override
	public void atualizar(Endereco endereco) {
		
		String sql = "update endereco set logradouro = ?, numero = ?, cep = ?, idBairro = ? where idEndereco = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, endereco.getLogradouro());
			preparedStatement.setString(2, endereco.getNumero());
			preparedStatement.setString(3, endereco.getCep());
			preparedStatement.setString(4, endereco.getBairro().getId());
			preparedStatement.setString(5, endereco.getId());
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(String id) {
		
		String sql = "delete from endereco  where idEndereco = ?";
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
	public List<Endereco> listarTodos() {

		ArrayList<Endereco> enderecos = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idEndereco, logradouro, numero, cep from endereco");
			while (rs.next()) {
				String id = rs.getString(1);
				String logradouro = rs.getString(2);
				String numero = rs.getString(3);
				String cep = rs.getString(4);
				enderecos.add(new Endereco(id, logradouro, numero, cep));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return enderecos;
		
	}

	@Override
	public List<Endereco> procurar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
