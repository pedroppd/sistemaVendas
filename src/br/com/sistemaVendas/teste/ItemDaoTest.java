package br.com.sistemaVendas.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemaVendas.dao.Itemdao;
import br.com.sistemaVendas.dao.Produtodao;
import br.com.sistemaVendas.dao.Vendadao;
import br.com.sistemaVendas.domain.Item;
import br.com.sistemaVendas.domain.Produto;
import br.com.sistemaVendas.domain.Venda;

public class ItemDaoTest {
	
	@Test
	@Ignore
	public void salvar() {
		Produtodao dao = new Produtodao();
			Produto p = dao.buscarPorCodigo(3L);
		Vendadao daov = new Vendadao();
		    Venda v = daov.buscarPorCodigo(1L);
		
		Item i = new Item();
		
		i.setProduto(p);
		i.setQtd(4);
		i.setValor_parcial(new BigDecimal(3000.00));
		i.setVenda(v);
		
		Itemdao daoo = new Itemdao();
		
		daoo.salvar(i);
				
	}
	
	@Test
	@Ignore
	public void listar() {
		Itemdao dao = new Itemdao();
		
		List<Item>item = dao.listar();
		
		for(Item fornecedor: item) {
			
		
			System.out.println(fornecedor);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Itemdao dao = new Itemdao();
		
	Item f1 = dao.buscarPorCodigo(2L);
		
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		
		
		
		Itemdao dao = new Itemdao();
		
		
		
		dao.excluir(4L);
		
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		Itemdao dao = new Itemdao();
		
		Item f = dao.buscarPorCodigo(1L); 
		
		f.setValor_parcial(new BigDecimal(1000.00));
		
		
		
		
		dao.editar(f);
	}
	

}
