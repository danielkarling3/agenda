package br.ufpr.dao;

import static org.junit.Assert.*;

import java.time.ZonedDateTime;

import org.junit.Test;

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
		
	}

}
