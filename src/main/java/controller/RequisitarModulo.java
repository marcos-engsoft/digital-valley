package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Usuario;
import util.Constantes;
import util.Facade;

public class RequisitarModulo extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		Usuario userObjectToJSON = Facade.buscarPorLogin(user.getLogin());
		HttpSession session = request.getSession();
		userObjectToJSON.getPessoa().setUsuario(null);
		userObjectToJSON.setSenha("******");
		String url = request.getParameter("url")+"autentica";
		Gson gson = new Gson();
		String json = gson.toJson(userObjectToJSON);
		int status = Facade.executeHTTPRequestToModule(url, json);
		Usuario userToken = Facade.buscarPorLogin(user.getLogin());
		if(status != 200){
			session.setAttribute(Constantes.getSessionMsg(), "Acesso negado!");
			response.sendRedirect("/Controle_de_Acesso/login.jsp");
		}else{
			response.sendRedirect(request.getParameter("url")+"telaInicial.jsp"+"?id="+userToken.getPessoa().getId()+"&token="+userToken.getTokenUsuario());
		}
	}
}
