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
			String SQL = "INSERT INTO tbBomba(quantidadeDeCombustivel, numero "
					+ "values (?, ?)";

			ps = this.conn.prepareStatement(SQL);
			ps.setFloat(1, bomba.getQuantidadeDeCombustivel());
			ps.setInt(2, bomba.getNumero());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}