package br.com.sistemaVendas.dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistemaVendas.domain.Fornecedor;
import br.com.sistemaVendas.util.HibernateUtil;

public class Fornecedordao {

	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); // Conectando com o banco

		Transaction transicao = null;

		try {
			transicao = sessao.beginTransaction(); // abrindo transação

			sessao.save(fornecedor);

			transicao.commit(); // verificando transação

		} catch (RuntimeException ex) {

			if (transicao != null) {
				transicao.rollback();
			}

		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Fornecedor> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ArrayList<Fornecedor> fornecedor = null;
		
		try {
			Query consulta= sessao.getNamedQuery("Fornecedor.listar");
			fornecedor = (ArrayList<Fornecedor>) consulta.list();
			
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return fornecedor;
	}
	
	public Fornecedor buscarPorCodigo(Long id) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Fornecedor fornecedor = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("id", id);
			fornecedor = (Fornecedor) consulta.uniqueResult();
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		
		return fornecedor;
	}
	
	
	public void excluir(Fornecedor f) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
	
		
		try{
			
			transacao = sessao.beginTransaction();
			
		
		   sessao.delete(f);
			
			transacao.commit();
			
		}catch(Exception ex) {
			
			if(transacao != null) {
			   transacao.rollback();
			}
			throw ex;
		}finally {
			sessao.close();
		}
	}
	
	
	public void editar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			
			sessao.update(fornecedor);
			
			transacao.commit();
			
			
			
		}catch(RuntimeException ex) {
			
			if(transacao != null) {
				transacao.rollback();
			}
			throw ex;
		}finally {
			sessao.close();
		}
	}
	
	

}
