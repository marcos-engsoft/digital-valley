package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Pessoa;
import model.Usuario;
import util.ConnectionFactory;

public class JDBCPessoaDAO implements PessoaDAO {

	private Connection connection;

	public JDBCPessoaDAO() {

		this.connection = ConnectionFactory.getConnection();

	}
	
	

	@Override
	public void cadastrar(Pessoa pessoa) {
		try {
			String SQL = "INSERT INTO pessoa_usuario (nome, cpf, email , data_nascimento) VALUES" + "(?,?,?,?)";

			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getEmail());
			ps.setDate(4, Date.valueOf(pessoa.getDataNascimento()));

			ps.executeUpdate();
			ps.close();

			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao cadastrar pessoa, erro: " +e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void editar(Pessoa pessoa) {
		try {
			String SQL = "UPDATE pessoa_usuario SET nome=?, cpf=?, email=?, data_nascimento = ? WHERE id_pessoa_usuario = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());
			ps.setString(3, pessoa.getEmail());
			ps.setDate(4, Date.valueOf(pessoa.getDataNascimento()));
			ps.setInt(5, pessoa.getId());

			ps.executeUpdate();
			ps.close();

		
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao editar pessoa, erro:" +e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void remover(int id) {

		try {
			String SQL = "DELETE FROM pessoa_usuario WHERE id_pessoa_usuario = ?";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao remover pessoa, erro: " +e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Pessoa buscarPorId(int id) {
		Pessoa pessoa = new Pessoa();
		Usuario usuario = new Usuario();
		pessoa.setUsuario(usuario);

		String SQL = "SELECT * FROM pessoa_usuario WHERE id_pessoa_usuario = ?";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();
			pessoa.setId(rs.getInt("id_pessoa_usuario"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setCpf(rs.getString("cpf"));
			pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
			pessoa.setEmail(rs.getString("email"));
			pessoa.getUsuario().setLogin(rs.getString("login"));
			pessoa.getUsuario().setSenha(rs.getString("senha"));
			pessoa.getUsuario().setNivel(rs.getInt("nivel"));
			pessoa.getUsuario().setPessoa(pessoa);
			ps.close();
			rs.close();
			
			return pessoa;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar registro de pessoa, erro: " +e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Pessoa buscarPorLogin(String login) {
		Pessoa pessoa = new Pessoa();
		Usuario usuario = new Usuario();
		pessoa.setUsuario(usuario);

		String SQL = "SELECT * FROM pessoa_usuario WHERE login = ?";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, login);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				pessoa.setId(rs.getInt("id_pessoa_usuario"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				pessoa.setEmail(rs.getString("email"));
				pessoa.getUsuario().setLogin(rs.getString("login"));
				pessoa.getUsuario().setSenha(rs.getString("senha"));
				pessoa.getUsuario().setNivel(rs.getInt("nivel"));
				pessoa.getUsuario().setPessoa(pessoa);
				ps.close();
				rs.close();
				return pessoa;
			} else {
				return null;
			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar registro de pessoa, erro: " +e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Pessoa buscarPorCpf(String cpf) {
		Pessoa pessoa = new Pessoa();
		Usuario usuario = new Usuario();
		pessoa.setUsuario(usuario);
		System.out.println(cpf);
		String SQL = "SELECT * FROM pessoa_usuario WHERE cpf = ?";
		try {

			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, cpf);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				pessoa.setId(rs.getInt("id_pessoa_usuario"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				pessoa.setEmail(rs.getString("email"));
				pessoa.getUsuario().setLogin(rs.getString("login"));
				pessoa.getUsuario().setSenha(rs.getString("senha"));
				pessoa.getUsuario().setNivel(rs.getInt("nivel"));
				pessoa.getUsuario().setPessoa(pessoa);
				ps.close();
				rs.close();
				return pessoa;
			} else {
				return null;
			}


		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar registro de pessoa, erro: " +e.getMessage());
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public List<Pessoa> listar() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			String SQL = "SELECT * FROM pessoa_usuario";
			PreparedStatement ps = connection.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				Usuario u = new Usuario();
				pessoa.setUsuario(u);
				pessoa.setId(rs.getInt("id_pessoa_usuario"));
				System.out.println("ID : " + pessoa.getId());
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setEmail(rs.getString("email"));
				pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				pessoa.getUsuario().setLogin(rs.getString("login"));
				pessoa.getUsuario().setSenha(rs.getString("senha"));
				pessoa.getUsuario().setNivel(rs.getInt("nivel"));
				pessoas.add(pessoa);

			}

			ps.close();
			rs.close();
			
			return pessoas;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao listar registro de pessoa, erro: " +e.getMessage());

		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Pessoa> buscarPorNome(String nome){
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			String SQL = "SELECT * FROM pessoa_usuario AS u WHERE  UPPER(u.nome) like UPPER(?)";
			
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, '%'+nome+'%');
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				Usuario usuario = new Usuario();
				pessoa.setId(rs.getInt("id_pessoa_usuario"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				pessoa.setDataNascimento(LocalDate.parse(rs.getString("data_nascimento")));
				pessoa.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNivel(rs.getInt("nivel"));
				pessoa.setUsuario(usuario);
				
				pessoas.add(pessoa);
			}
			rs.close();
			ps.close();
			return pessoas;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Falha ao buscar registro de pessoa, erro: " +e.getMessage());

		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
