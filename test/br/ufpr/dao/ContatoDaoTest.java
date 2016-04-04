package br.ufpr.dao;

import static org.junit.Assert.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.ufpr.modelo.Contato;

public class ContatoDaoTest {

	@Test
	public void test() {
		
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato("Daniel Karling",
					"danielantoniokarling3@gmail.com",
					"Rua tom Jobim",
					ZonedDateTime.now());
		contatoDao.adiciona(contato);
		
		ContatoDao contatoDao2 = new ContatoDao();
		ArrayList<Contato> resultado = contatoDao2.getLista();
		for (Contato r : resultado) {
			  System.out.println("Nome: " + r.getNome());
			  System.out.println("Email: " + r.getEmail());
			  System.out.println("Endereço: " + r.getEndereco());
			  
			}
		
		
	}

}
