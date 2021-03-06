package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import dao.PessoaDAO;
import model.EnumNivel;
import model.Perfil;
import model.Pessoa;
import util.Constantes;

/**
 * Servlet implementation class AtribuirModulos
 */
public class AtribuirModulos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// paginacao de pessoas
		Integer paginaAtual = request.getParameter("pagina") != null ? Integer.valueOf(request.getParameter("pagina"))
				: 1;
		Integer fim = Constantes.getNumberOfRowsPerPage() * paginaAtual;
		Integer inicio = fim - Constantes.getNumberOfRowsPerPage();
		// pegar dados de pessoas
		String nomePessoa = request.getParameter("nome") != null ? (String) request.getParameter("nome") : "";
		Integer nivelComum = EnumNivel.COMUM.getValorNivel();
		PessoaDAO pessoaDAO = DAOFactory.criarPessoaDAO();
		HttpSession session = request.getSession();
		try {
			// listagem de perfis
			// enviar dados
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("atribuicaoDeModulos.jsp");
			request.setAttribute("url", Constantes.getAdmUrl());
			request.setAttribute("pessoas", pessoaDAO.buscarPorNomeENivel(nomePessoa, nivelComum, inicio, fim));
			request.setAttribute("perfis", DAOFactory.criarPerfilDAO().Listar());
			request.setAttribute("quantidadeDePaginas", pessoaDAO.getQuantidadePorNomeENivel(nomePessoa, nivelComum) /  (fim - inicio));
			request.setAttribute("paginaAtual", paginaAtual);
			request.setAttribute("nomePessoa", nomePessoa);
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
		}

	}

}
