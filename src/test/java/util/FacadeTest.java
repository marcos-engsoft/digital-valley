package util;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.Aluno;
import model.EnumNivel;
import model.Modulo;
import model.Perfil;
import model.Pessoa;
import model.Usuario;

public class FacadeTest {
	
	Pessoa pessoa = new Pessoa();
	Usuario usuario = new Usuario();
	@Ignore
	@Test
	public void cadatrarPessoaTest(){
		pessoa.setNome("Fachada Test");
		pessoa.setCpf("12345378145");
		pessoa.setEmail("fachada31@email.com");
		pessoa.setDataNascimento("01/02/1990");
		usuario.setLogin("Login1s");
		usuario.setSenha("Senha123");
		usuario.setNivel(EnumNivel.ADMINISTRADOR);
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
	
		util.Facade.cadastrarPessoa(pessoa, usuario);
		
		
	}
	@Ignore
	@Test
	public void editarPessoaTest(){
		pessoa.setNome("Fachada Test 2");
		pessoa.setCpf("12345678999");
		pessoa.setEmail("fachada2@email.com");
		pessoa.setDataNascimento("02/02/1990");
		pessoa.setId(3);
		usuario.setLogin("Login2");
		usuario.setSenha("Senha1234");
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
		
		util.Facade.editarPessoa(pessoa, usuario);
		
	}
	@Ignore
	@Test
	public void testVerificacao(){
		Assert.assertTrue(util.Facade.verificacaoAluno("370178", "Deyvison Nogueira"));
	}
	@Ignore
	@Test
	public void cadastrarAlunoTest(){
				
		pessoa.setNome("LUAN DHARLIN LEMOS DA SILVA");
		pessoa.setCpf("99941176948");
		pessoa.setEmail("alo@teste.com");
		pessoa.setDataNascimento("22/08/1998");
		usuario.setLogin("reprov");
		usuario.setSenha("hbbbbbbbbbbbb");
		usuario.setNivel(EnumNivel.COMUM);
		pessoa.setUsuario(usuario);
		usuario.setPessoa(pessoa);
		
		Aluno aluno = new Aluno();
		aluno.setMatricula("370174");
		aluno.setSemestreIngresso("2016.1");
		
		util.Facade.cadastrarAluno(usuario,aluno);
		
	}
	@Ignore
	@Test
	public void cadastrarModuloTest(){
		Modulo modulo = new Modulo();
		modulo.setTitulo("Modulo Teste");
		modulo.setImagem("aaaaaa/bbbbbbb/vvvv");
		modulo.setUrl("/testando");
		
		util.Facade.cadastrarModulo(modulo);
	}
	
	@Ignore
	@Test
	public void testAssociarModuloPerfil(){
		
		util.Facade.adicionarModulosParaPerfil(3, 10);
		
	}
	@Ignore
	@Test
	public void testListarAluno(){
		List<Aluno> alunos = util.Facade.buscarAlunos();
		for(Aluno a:alunos){
			System.out.println(a.getNome());
			System.out.println(a.getUsuario().getLogin());
			System.out.println(a.getUsuario().getNivel());
		}
	}
	
	@Ignore
	@Test
	public void testBuscarPerfil(){
		Perfil p = new Perfil();
		p.setNome("Aluno");
		p.setId(1);
		List<Modulo> modulos = util.Facade.buscarModulosPorPerfil(p);
		
		for(Modulo m: modulos){
			System.out.println(m.getTitulo());
		}
	}
	
	@Test
	public void testLerEmail(){
		String []email = util.Facade.lerArquivoEmail();
		System.out.println(email[0]);
		System.out.println(email[1]);
	}
	
	
}