package br.com.sistemaVendas.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemaVendas.dao.Fornecedordao;
import br.com.sistemaVendas.dao.Produtodao;
import br.com.sistemaVendas.domain.Fornecedor;
import br.com.sistemaVendas.domain.Produto;

public class ProdutoDaoTest {
	
	@Test
	@Ignore
	public void salvar() {
		Fornecedordao dao = new Fornecedordao();
		
		Fornecedor f = dao.buscarPorCodigo(7L);
		
		Produto p = new Produto();
		
		p.setDescricao("AirFryer");
		p.setQtd(3);
		p.setPreco(new BigDecimal(300.00));
		p.setFornecedor(f);
		
		Produtodao dao1 = new Produtodao();
		
		dao1.salvar(p);
		
	}
	
	@Test
    @Ignore
	public void listar() {
		Produtodao dao = new Produtodao();
		
		List<Produto>produto = dao.listar();
		
		for(Produto p : produto) {
			
		
			System.out.println(p);
		}
	}
	
	@Test
    @Ignore
	public void buscarPorCodigo() {
		Produtodao dao = new Produtodao();
		
		Produto p = dao.buscarPorCodigo(1L);
		
		System.out.println(p);
	}
	
	@Test
    @Ignore
	public void excluir() {
		
		
		
		
	}
	
	@Test
	@Ignore
	public void editar() {
	 Produtodao dao = new Produtodao();
	 
		Produto p = dao.buscarPorCodigo(2L);
		
		p.setQtd(20);
		
		dao.editar(p);
	}

}
