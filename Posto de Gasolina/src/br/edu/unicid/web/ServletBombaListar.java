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

import br.edu.unicid.dao.BombaDAO;
import br.edu.unicid.dao.FrentistaDAO;
import br.unicid.posto.bean.Bomba;
import br.unicid.posto.bean.Frentista;

/**

 */
@WebServlet("/bomba_listar.bomba")
public class ServletBombaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletBombaListar() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Bomba> jspListaBomba = new ArrayList<Bomba>(); 
		List<Bomba> bdListaBomba = new ArrayList<Bomba>(); 
		
		try {
			BombaDAO bombaDAO = new BombaDAO();
			bdListaBomba = bombaDAO.listar();
		
		
			for(int i=0;i < bdListaBomba.size();i++) {
				
				Bomba bomba = new Bomba();
				bomba = bdListaBomba.get(i);
				
				for(int j = 0 ; j < bdListaBomba.size() ; j++) 
				{
					jspListaBomba.add(bdListaBomba.get(j));
				}
				
			
				Map<String,String> bombaMap = new HashMap<String,String>();
				 
				bombaMap.put("numero", String.valueOf(bomba.getNumero()));
				bombaMap.put("quantidadeDeCombustivel",String.valueOf(bomba.getQuantidadeDeCombustivel()));
				bombaMap.put("valor",String.valueOf(bomba.getValor()));
				
			    
				
				jspListaBomba.add(new Bomba(Integer.parseInt(bombaMap.get("numero")),Float.parseFloat(bombaMap.get("quantidadeDeCombustivel")),Float.parseFloat(bombaMap.get("valor"))));			
				System.out.println(jspListaBomba.get(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("jspBombas", jspListaBomba);
		RequestDispatcher rd = request.getRequestDispatcher("bomba_listar.jsp"); 
		rd.forward(request, response);
		
	}

}
