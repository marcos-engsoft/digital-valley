package dao;

import model.Modulo;
import model.Pessoa;
import util.DAOFactory;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ModuloDAOTest {

	private Modulo modulo = new Modulo();
	@Ignore
	@Test
	public void salvar() {
		modulo.setTitulo("Solicitação de Recorreção de prova");
		modulo.setUrl("Controle_de_Acesso/view/telaInicial.jsp");
		modulo.setImagem("../assets2/img/new_logo.png");
		ModuloDAO md = DAOFactory.criarModuloDAO();

		md.cadastrar(modulo);
	}
	@Test
	public void editar() {
		modulo.setId(4);
		modulo.setTitulo("Solicitação de Recorreção de prova");
		modulo.setUrl("Controle_de_Acesso/view/telaInicial.jsp");
		modulo.setImagem("../assets2/img/Revisao-de-Prova.jpg");
		ModuloDAO md = DAOFactory.criarModuloDAO();

		md.editar(modulo);
	}
	@Ignore
	@Test
	public void remover() {
		modulo.setId(1);
		ModuloDAO md = DAOFactory.criarModuloDAO();
		md.remover(modulo.getId());
	}
	@Ignore
	@Test
	public void buscar() {
		ModuloDAO md = DAOFactory.criarModuloDAO();
		modulo.setId(3);

		Assert.assertTrue(md.buscar(modulo.getId()) != null);
	}
	@Ignore
	@Test
	public void listarPorPessoa() {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId(5);
		ModuloDAO md = DAOFactory.criarModuloDAO();
		List<Modulo> modulos = md.buscar(pessoa);
		System.out.println("Listar por pessoa: "+modulos.size());
		for(Modulo m: modulos){
			System.out.println("id "+m.getId());
			System.out.println("titulo "+m.getTitulo());
		}
		Assert.assertTrue(modulos != null);

	}
	@Ignore
	@Test
	public void listar() {
		ModuloDAO md = DAOFactory.criarModuloDAO();
		List<Modulo> modulos = md.listar();
		Assert.assertTrue(modulos != null);

	}
}
