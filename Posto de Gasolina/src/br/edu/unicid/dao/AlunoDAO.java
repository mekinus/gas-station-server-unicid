package br.edu.unicid.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.uncid.posto.bean;
import br.edu.unicid.util.ConnectionFactory;

public class AlunoDAO {
	private Connection conn;
	private PreparedStatement ps;

	public AlunoDAO() throws Exception {
		// chama a classe ConnectionFactory e estabele uma conexão
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	// método de salvar

	public void salvar(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO tbAluno (caAluno, "
					+ "nomeAluno, emailAluno, dtaNasc, "
					+ "endAluno) "
					+ "values (?, ?, ?, ?, ?)";

			ps = this.conn.prepareStatement(SQL);
			ps.setInt(1, aluno.getCaAluno());
			ps.setString(2, aluno.getNomeAluno());
			ps.setString(3, aluno.getEmailAluno());
			ps.setString(4, aluno.getDtaNasc());
			ps.setString(5, aluno.getEndAluno());
			ps.executeUpdate();
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}