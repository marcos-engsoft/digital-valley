package dao;

import model.Usuario;

public interface UsuarioDAO {
	
	
	public void cadastrar(Usuario usuario);
	
	public void editar(Usuario usuario);
	
	public boolean autenticar(String login, String senha);
	
	public void editarNivel(Usuario usuario);

	public Usuario buscar(int id);
	
	public void salvarToken(String token, int id_usuario);

}