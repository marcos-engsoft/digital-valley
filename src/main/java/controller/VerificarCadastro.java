package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AlunoDAO;
import dao.ServidorDAO;
import model.Aluno;
import model.Servidor;
import util.DAOFactory;
import util.Facade;

public class VerificarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String matricula = request.getParameter("matricula");
		String siape = request.getParameter("siape");
		String nomeA = request.getParameter("nomeA");
		String nomeS = request.getParameter("nomeS");
		String pagina = "verificacaoCadastro.jsp?erroVerificacao=1";
		HttpSession session = request.getSession();
		System.out.println("servlet");
		try {
			if (matricula != null) {
				if(util.Facade.verificacaoAluno(matricula, nomeA)){
					pagina = "cadastro/cadastrarUsuario.jsp";
					session.setAttribute("preCadastro", "ok");
					System.out.println("entrou");
				}else{
					AlunoDAO aDAO = DAOFactory.criarAlunoDAO();
					Aluno aluno = aDAO.buscarPorMatricula(matricula);
					if(aluno != null){
						System.out.println("cadastrado");
						throw new Exception("Erro, Aluno(a) " + aluno.getNome() + " já possui cadastro");
					}else{
						System.out.println("nada");
						throw new Exception("Erro, Pre cadastro não identificado");
					}
				}
				
				
			}else if(siape != null){
				if(util.Facade.verificacaoServidor(siape, nomeS)){
					pagina = "cadastro/cadastrarUsuario.jsp";
					session.setAttribute("preCadastro", "ok");
					System.out.println("entrou");
				}else{
					ServidorDAO sDAO = DAOFactory.criarServidorDAO();
					Servidor servidor = sDAO.buscar(siape);
					if(servidor != null){
						System.out.println("cadastrado");
						throw new Exception("Erro, Servidor(a) " + servidor.getNome() + " já possui cadastro");
					}else{
						System.out.println("nada");
						throw new Exception("Erro, Pre cadastro não identificado");
					}
				}
				
			}
		} catch (Exception e) {
			session.setAttribute("excecao", e.getMessage());
			System.out.println("excecao : " + e.getMessage());
		}

		response.sendRedirect(pagina);

	}

}
