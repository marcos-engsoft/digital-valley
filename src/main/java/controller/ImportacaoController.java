package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Constantes;

@MultipartConfig
public class ImportacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		int curso = Integer.valueOf(request.getParameter("curso"));
		String dados = request.getParameter("matriculas");
		dados = dados + "\n";
		String nome, matricula;
		String aux;
		String pagina;
		pagina = "importarAlunos.jsp?erro=1";
		HttpSession session = request.getSession();
		try {

			while(dados.length() >=6){
				
				matricula = dados.substring(0,6);
				nome = dados.substring(6,dados.indexOf("\n"));
				util.Facade.preCadastrarAluno(nome, matricula, curso);
				aux = dados.replace(matricula, "");
				dados = aux;
				aux = dados.replace(nome+"\n", "");
				dados = aux;
				
			}
			pagina = "importarAlunos.jsp?sucesso=1";
			
		} catch (Exception e) {
			session.setAttribute(Constantes.getSessionMsg(), e.getMessage());
			System.out.println(dados);
			
		}		
		
		response.sendRedirect(pagina);
	}
}
