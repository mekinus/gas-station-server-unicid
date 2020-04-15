package br.edu.unicid.web;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import br.edu.unicid.bean.Aluno;
import br.edu.unicid.dao.AlunoDAO;


@WebServlet("/incluir.aluno")

public class ServletAlunoCadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ServletAlunoCadastrar() {
		super();
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		//criando o objeto aluno

		try {
		
			Aluno aluno = new Aluno();
		
			AlunoDAO alunoDAO = new AlunoDAO();
		
		//aluno sets valores
		aluno.setCaAluno(Integer.parseInt(request.getParameter("ca")));
		aluno.setNomeAluno(request.getParameter("nome"));
		aluno.setEmailAluno(request.getParameter("email"));
		aluno.setDtaNasc(request.getParameter("dt_nasc"));
		aluno.setEndAluno(request.getParameter("endereco"));
					
			alunoDAO.salvar(aluno); 	


		} catch (Exception e) {
			e.printStackTrace();
		}
		

		request.setAttribute("menssagem", "Cadastrou Aluno "+request.getParameter("nome")); 
		RequestDispatcher rd = request.getRequestDispatcher("incluir.jsp"); 
		rd.forward(request, response); 
	}
}









