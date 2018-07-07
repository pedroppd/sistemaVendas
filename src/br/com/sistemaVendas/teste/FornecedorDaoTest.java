package br.com.sistemaVendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemaVendas.dao.Fornecedordao;
import br.com.sistemaVendas.domain.Fornecedor;

public class FornecedorDaoTest {
	
	@Test
	@Ignore
	public void salvar() {
		Fornecedor d = new Fornecedor();
		d.setDescricao("Teste 08");
		
		Fornecedordao dao = new Fornecedordao();
		
		dao.salvar(d);
	}
	
	@Test
	@Ignore
	public void listar() {
		Fornecedordao dao = new Fornecedordao();
		
		List<Fornecedor>fornecedores = dao.listar();
		
		for(Fornecedor fornecedor: fornecedores) {
			
		
			System.out.println(fornecedor);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Fornecedordao dao = new Fornecedordao();
		
		Fornecedor f1 = dao.buscarPorCodigo(2L);
		
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		
		
	
		
		
	}
	
	@Test
	@Ignore	
	public void editar() {
		Fornecedor f = new Fornecedor();
		
		f.setId(5L);
		f.setDescricao("Pedro Dantas");
		
		Fornecedordao dao = new Fornecedordao();
		
		dao.editar(f);
	}
	
	
	
	
	
	

}
