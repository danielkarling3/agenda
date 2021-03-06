package br.ufpr.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotated;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Annotation;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleType;
import com.sun.xml.internal.txw2.Document;
import com.sun.xml.internal.txw2.TypedXmlWriter;

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
	
	public ArrayList<Contato> getLista(){
		ArrayList<Contato> listaContatos = new ArrayList<Contato>() ;
		
		String sql = "select * from contatos ";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet select = stmt.executeQuery();
			while (select.next()) {
				Contato contato = new Contato();
				contato.setNome(select.getString("nome"));
				contato.setEmail(select.getString("email"));
				contato.setEndereco(select.getString("endereco"));
				//contato.setDataNascimento(select.getString("dataNascimento"));
				listaContatos.add(contato);
			}
			
			select.close();
			//stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		return listaContatos;
		
	}
	
}
