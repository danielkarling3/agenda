package br.ufpr.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufpr.jdbc.ConectionFactory;
import br.ufpr.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() {
	
		this.connection = new ConectionFactory().getConnection();
		
	}
	
	public void adiciona(Contato contato){
	
		String sql = "insert into contatos "+
				"(nome,email,endereco,dataNascimento)"+
				"values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());			
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().toEpochSecond()*1000));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
