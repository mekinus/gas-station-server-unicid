package br.edu.unicid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.unicid.posto.bean.Bomba;
import br.unicid.posto.bean.Frentista;
import br.edu.unicid.util.ConnectionFactory;

public class BombaDAO {
	private Connection conn;
	private PreparedStatement ps;

	public BombaDAO() throws Exception {
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	

	public void salvar(Bomba bomba) throws Exception {
		if (bomba == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tbbomba(quantidadeDeCombustivel, numero, valor)"
					+ "values (?, ?, ?)";

			ps = this.conn.prepareStatement(SQL);
			ps.setFloat(1, bomba.getQuantidadeDeCombustivel());
			ps.setInt(2, bomba.getNumero());
			ps.setFloat(3, bomba.getValor());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public List<Bomba> listar() throws Exception {
		List<Bomba> listaBombas = new ArrayList<Bomba>();
		try {
			String SQL = "Select * from tbbomba";
			
			ps = this.conn.prepareStatement(SQL);
			ResultSet dados = ps.executeQuery();
			while(dados.next()) {
				Bomba bomba = new Bomba();
				
				bomba.setNumero(dados.getInt("numero"));
				bomba.setQuantidadeDeCombustivel(dados.getFloat("quantidadeDeCombustivel"));
				bomba.setValor(dados.getFloat("valor"));
				
				
				listaBombas.add(bomba);
				
				System.out.print(bomba.toString());
				
			}
		
		}
		
		catch(Exception sqle)
		{
			throw new Exception ("erro ao consultar o banco " + sqle); 
		}
		
		finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
		return listaBombas;		
	}
	
	
	
}