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

import br.edu.utfpr.td.tsi.posto.saude.dao.BairroDAO;
import br.edu.utfpr.td.tsi.posto.saude.modelo.Bairro;

@Component
public class MysqlBairroDAO implements BairroDAO {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String inserir(Bairro bairro) {
		String sql = "insert into paciente (idBairro, nome) values (?, ?)";
		jdbcTemplate.update(sql, bairro.getId(), bairro.getNome());
		return bairro.getId();
	}

	@Override
	public void atualizar(String id, Bairro bairro) {
		String sql = "update bairro set nome = ? where idBairro = ?";
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setString(1, bairro.getNome());
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();

			conn.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remover(String id) {
		String sql = "delete from bairro  where idBairro = ?";
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
	public List<Bairro> listarTodos() {
		ArrayList<Bairro> bairros = new ArrayList<>();
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select idBairro, nome from bairro");
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				bairros.add(new Bairro(id, nome));
			}
			conn.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bairros;
	}

	@Override
	public List<Bairro> procurar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

