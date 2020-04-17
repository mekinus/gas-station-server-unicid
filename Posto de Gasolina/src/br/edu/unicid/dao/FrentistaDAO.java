package br.edu.unicid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.unicid.posto.bean.Frentista;
import br.edu.unicid.util.ConnectionFactory;

public class FrentistaDAO {
	private Connection conn;
	private PreparedStatement ps;

	public FrentistaDAO() throws Exception {
		
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	

	public void salvar(Frentista frentista) throws Exception {
		if (frentista == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tbfrentista (nomeFrentista, salarioFrentista)" + "values (?, ?)";

			ps = this.conn.prepareStatement(SQL);
			ps.setString(1, frentista.getNomeFrentista());
			ps.setFloat(2, frentista.getSalarioFrentista());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}


	public List<Frentista> listar() throws Exception {
		List<Frentista> listaFrentistas = new ArrayList<Frentista>();
		try {
			String SQL = "Select * from tbfrentista";
			
			ps = this.conn.prepareStatement(SQL);
			ResultSet dados = ps.executeQuery();
			while(dados.next()) {
				Frentista frentista = new Frentista();
				
				frentista.setNomeFrentista(dados.getString("nomeFrentista"));
				frentista.setSalarioFrentista(dados.getInt("salarioFrentista"));
			    
				
				
				listaFrentistas.add(frentista);
				
			}
			
		}
		
		catch(Exception sqle)
		{
			throw new Exception ("erro ao consultar o banco " + sqle); 
		}
		
		finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		
		return listaFrentistas;		
	}
}