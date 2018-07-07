package br.com.sistemaVendas.teste;

import org.junit.Test;

import br.com.sistemaVendas.util.HibernateUtil;

public class GerarTabela {

	
	@Test	
	public void gerarTabela() {	
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	
	}
	

}
