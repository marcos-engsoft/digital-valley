package dao;

import java.util.List;

import model.Modulo;
import model.Pessoa;

public interface ModuloDAO {
	
	public void cadastrar(Modulo modulo);
	
	public void editar(Modulo modulo);
	
	public void remover(int id);
	
	public Modulo buscar(int id);
	
	public Modulo buscarPorNome(String nome);
	
	public List<Modulo> buscar(Pessoa pessoa);
	
	public List<Modulo> listar();
	
	public void associarUsuarioModulo(int idUsuario, int idModulo);
	
	public void associarPerfilModulo (int idPerfil, int idModulo);

}