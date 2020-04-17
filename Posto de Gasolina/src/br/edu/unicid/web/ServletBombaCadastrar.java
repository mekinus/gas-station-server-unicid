package br.edu.unicid.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import br.edu.unicid.dao.BombaDAO;
import br.edu.unicid.dao.FrentistaDAO;
import br.unicid.posto.bean.Bomba;
import br.unicid.posto.bean.Frentista;


@WebServlet("/incluir.bomba")

public class ServletBombaCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletBombaCadastrar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		

		try {
		
			Bomba bomba = new Bomba();
		
			BombaDAO BombaDAO = new BombaDAO();
		
	
		bomba.setQuantidadeDeCombustivel(Float.parseFloat(request.getParameter("quantidadeDeCombustivel")));
		bomba.setNumero(Integer.parseInt(request.getParameter("numero")));
		
					
			BombaDAO.salvar(bomba); 	


		} catch (Exception e) {
			e.printStackTrace();
		}
		

		request.setAttribute("menssagem", "Cadastrou Bomba "+request.getParameter("nome")); 
		RequestDispatcher rd = request.getRequestDispatcher("incluir.jsp"); 
		rd.forward(request, response); 
	}
}









