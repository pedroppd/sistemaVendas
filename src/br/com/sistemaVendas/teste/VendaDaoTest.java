package br.com.sistemaVendas.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemaVendas.dao.Funcionariodao;
import br.com.sistemaVendas.dao.Vendadao;
import br.com.sistemaVendas.domain.Funcionario;
import br.com.sistemaVendas.domain.Venda;

public class VendaDaoTest {
    @Ignore
	@Test
	public void salvar() {
		Funcionariodao daof = new Funcionariodao();
		
		Funcionario f = daof.buscarPorCodigo(7L);
		
		
		Venda v = new Venda();
		
		v.setHorario(new Date());
		v.setFuncionario(f);
		v.setValorTotal(new BigDecimal(4000.00));	
		
		Vendadao dao = new Vendadao();
		
		dao.salvar(v);
	}
	
	@Test
	@Ignore
	public void listar() {
		Vendadao dao = new Vendadao();
		
		List<Venda>venda = dao.listar();
		
		for(Venda fornecedor: venda) {
			
		
			System.out.println(fornecedor);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Vendadao dao = new Vendadao();
		
		Venda f1 = dao.buscarPorCodigo(2L);
		
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		
		
		Vendadao dao = new Vendadao();
		
		
		
		
		
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		
	Vendadao dao = new Vendadao();
	Venda v = dao.buscarPorCodigo(1L);
	v.setValorTotal(new BigDecimal(7000.00));
	
	
	
		dao.editar(v);
	}
	
}
