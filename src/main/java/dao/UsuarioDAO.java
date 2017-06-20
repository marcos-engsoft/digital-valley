package dao;

import model.Usuario;

public interface UsuarioDAO {
	
	
	public void cadastrar(Usuario usuario);
	
	public void editar(Usuario usuario);
	
	public boolean autenticar(String login, String senha);

}