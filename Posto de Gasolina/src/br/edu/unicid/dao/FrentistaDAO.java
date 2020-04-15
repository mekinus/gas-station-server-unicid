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
			String SQL = "INSERT INTO tbFrentista (nomeFrentista, salarioFrentista "
					+ "values (?, ?)";

			ps = this.conn.prepareStatement(SQL);
			ps.setFloat(1, frentista.getSalarioFrentista());
			ps.setString(2, frentista.getNomeFrentista());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}