package br.edu.unicid.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import br.edu.unicid.dao.FrentistaDAO;
import br.unicid.posto.bean.Frentista;


@WebServlet("/incluir.frentista")

public class ServletFrentistaCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletFrentistaCadastrar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		

		try {
		
			Frentista frentista = new Frentista();
		
			FrentistaDAO frentistaDAO = new FrentistaDAO();
		
	
		frentista.setSalarioFrentista(Integer.parseInt(request.getParameter("salario")));
		frentista.setNomeFrentista(request.getParameter("nome"));
		
					
			frentistaDAO.salvar(frentista); 	


		} catch (Exception e) {
			e.printStackTrace();
		}
		

		request.setAttribute("menssagem", "Cadastrou Aluno "+request.getParameter("nome")); 
		RequestDispatcher rd = request.getRequestDispatcher("incluir.jsp"); 
		rd.forward(request, response); 
	}
}









