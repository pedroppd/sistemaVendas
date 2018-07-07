package br.com.sistemaVendas.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sistemaVendas.dao.Funcionariodao;
import br.com.sistemaVendas.domain.Funcionario;

public class FuncionarioDaoTest {

	@Test
	@Ignore
	public void salvar() {
		Funcionario d = new Funcionario();
		
		d.setFuncao("Direito");
		d.setCpf("192.168.0.1");
		d.setNome("Pedro Dantas");
		d.setSenha("Op !10120121997");
	
		
		Funcionariodao dao = new Funcionariodao();
		
		dao.salvar(d);
	}
	
	@Test
	@Ignore
	public void listar() {
		Funcionariodao dao = new Funcionariodao();
		
		List<Funcionario>funcionario = dao.listar();
		
		for(Funcionario funcionarioo: funcionario) {
			
		
			System.out.println(funcionarioo);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		Funcionariodao dao = new Funcionariodao();
		
		Funcionario f1 = dao.buscarPorCodigo(1L);
		
		System.out.println(f1);
	}
	
	
	
	@Test
	@Ignore
	public void editar() {
	 Funcionariodao dao = new Funcionariodao();
	 
		Funcionario f = dao.buscarPorCodigo(7L);
		
		f.setFuncao("Diretor");
		
		dao.editar(f);
	}
}
