package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeanCursoJsp;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;

	public DaoUsuario() {

		connection = SingleConnection.getConnection();
	}

	public void salvar(BeanCursoJsp usuario) {

		try {
			String sql = "insert into usuario(login, senha, nome, telefone)values(?, ?, ?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.setString(3, usuario.getNome());
			insert.setString(4, usuario.getTelefone());
			insert.execute();

			connection.commit();

		} catch (Exception e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<BeanCursoJsp> listar() throws Exception {

		List<BeanCursoJsp> listar = new ArrayList<BeanCursoJsp>();

		String sql = "select * from usuario";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultSet = select.executeQuery();

		while (resultSet.next()) {

			BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
			beanCursoJsp.setId(resultSet.getLong("id"));
			beanCursoJsp.setLogin(resultSet.getString("login"));
			beanCursoJsp.setSenha(resultSet.getString("senha"));
			beanCursoJsp.setNome(resultSet.getString("nome"));
			beanCursoJsp.setTelefone(resultSet.getString("telefone"));

			listar.add(beanCursoJsp);
		}

		return listar;
	}

	public void delete(String login) {

		try {

			String sql = "delete from usuario where login = '" + login + "'";
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();

			connection.commit();

		} catch (Exception e) {

			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

	public BeanCursoJsp consultar(String login) {

		try {
			String sql = "select * from usuario where login='" + login + "'";
			PreparedStatement update = connection.prepareStatement(sql);
			ResultSet resultSet = update.executeQuery();

			if (resultSet.next()) {

				BeanCursoJsp beanCursoJsp = new BeanCursoJsp();
				beanCursoJsp.setId(resultSet.getLong("id"));
				beanCursoJsp.setLogin(resultSet.getString("login"));
				beanCursoJsp.setSenha(resultSet.getString("senha"));
				beanCursoJsp.setNome(resultSet.getString("nome"));
				beanCursoJsp.setTelefone(resultSet.getString("telefone"));

				return beanCursoJsp;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	public boolean validarLogin(String login) {

		try {

			String sql = "select count(1) as qtd from usuario where login='" + login + "'";

			PreparedStatement update = connection.prepareStatement(sql);
			ResultSet resultSet = update.executeQuery();

			if (resultSet.next()) {

				return resultSet.getInt("qtd") <= 0; // Retorna true
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
	
	public boolean validarSenha(String senha) {

		try {

			String sql = "select count(1) as qtd from usuario where login='" + senha + "'";

			PreparedStatement update = connection.prepareStatement(sql);
			ResultSet resultSet = update.executeQuery();

			if (resultSet.next()) {

				return resultSet.getInt("qtd") <= 0; // Retorna true
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
	
	

	public void atualizar(BeanCursoJsp usuario) {

		try {
			String sql = "update usuario set login = ?, senha = ?, nome = ?, telefone = ? where id = " + usuario.getId();

			PreparedStatement up = connection.prepareStatement(sql);
			up.setString(1, usuario.getLogin());
			up.setString(2, usuario.getSenha());
			up.setString(3, usuario.getNome());
			up.setString(4,  usuario.getTelefone());
			up.executeUpdate();

			connection.commit();
		} catch (Exception e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
