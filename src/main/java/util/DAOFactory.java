package util;

import dao.AlunoDAO;
import dao.JDBCAlunoDAO;
import dao.JDBCModuloDAO;
import dao.JDBCPerfilDAO;
import dao.JDBCPessoaDAO;
import dao.JDBCProfessorDAO;
import dao.JDBCServidorDAO;
import dao.JDBCUsuarioDAO;
import dao.ModuloDAO;
import dao.PerfilDAO;
import dao.PessoaDAO;
import dao.ProfessorDAO;
import dao.ServidorDAO;
import dao.UsuarioDAO;

public class DAOFactory {
	public static PessoaDAO criarPessoaDAO(){
		return new JDBCPessoaDAO();
	}	
	
	public static UsuarioDAO criarUsuarioDAO(){
		return new JDBCUsuarioDAO();
	}
	
	public static AlunoDAO criarAlunoDAO(){
		return new JDBCAlunoDAO();
	}
	
	public static ModuloDAO criarModuloDAO(){
		return new JDBCModuloDAO();
	}
	
	public static ServidorDAO criarServidorDAO(){
		return new JDBCServidorDAO();
	}
	
	public static ProfessorDAO criarProfessorDAO(){
		return new JDBCProfessorDAO();
	}
	
	public static PerfilDAO criarPerfilDAO(){
		return new JDBCPerfilDAO();
	}
}