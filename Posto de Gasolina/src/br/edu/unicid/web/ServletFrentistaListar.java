package br.edu.unicid.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unicid.dao.FrentistaDAO;
import br.unicid.posto.bean.Frentista;

/**

 */
@WebServlet("/frentista_listar.frentista")
public class ServletFrentistaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletFrentistaListar() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Frentista> jspListaFrentista = new ArrayList<Frentista>(); 
		List<Frentista> bdListaFrentista = new ArrayList<Frentista>(); 
		
		try {
			FrentistaDAO frentistaDAO = new FrentistaDAO();
			bdListaFrentista = frentistaDAO.listar();
		
		
			for(int i=0;i < bdListaFrentista.size();i++) {
				
				Frentista frentista = new Frentista();
				frentista = bdListaFrentista.get(i);
				
				for(int j = 0 ; j < bdListaFrentista.size() ; j++) 
				{
					jspListaFrentista.add(bdListaFrentista.get(j));
				}
				
			
				Map<String,String> frentistaMap = new HashMap<String,String>();
				 
				frentistaMap.put("nome", frentista.getNomeFrentista());
				frentistaMap.put("salario",String.valueOf(frentista.getSalarioFrentista()));
			
				jspListaFrentista.add(new Frentista(frentistaMap.get(i),500 + i));			
				System.out.println(jspListaFrentista.get(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("jspFrentistas", jspListaFrentista);
		RequestDispatcher rd = request.getRequestDispatcher("frentista_listar.jsp"); 
		rd.forward(request, response);
		
	}

}
