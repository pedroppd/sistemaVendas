package br.com.sistemaVendas.dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistemaVendas.domain.Venda;
import br.com.sistemaVendas.util.HibernateUtil;

public class Vendadao {

	public Long salvar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); // Conectando com o banco

		Transaction transicao = null;
        
		Long codigo = null;
		
		try {
			transicao = sessao.beginTransaction(); // abrindo transação

			codigo = (Long)sessao.save(venda);

			transicao.commit(); // verificando transação

		} catch (RuntimeException ex) {

			if (transicao != null) {
				transicao.rollback();
			}

		} finally {
			sessao.close();
		}
		
		return codigo;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Venda> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ArrayList<Venda> venda = null;
		
		try {
			
			Query consulta= sessao.getNamedQuery("Venda.listar");
			venda = (ArrayList<Venda>) consulta.list();
			
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return venda;
	}
	
	public Venda buscarPorCodigo(Long id) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Venda venda = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("id", id);
			venda = (Venda) consulta.uniqueResult();
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		
		return venda;
	}
	
	
	public void excluir(Venda v) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
	
		
		try{
			
			transacao = sessao.beginTransaction();
			
		
			
			
			sessao.delete(v);
			
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
	
	
	public void editar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			
			sessao.update(venda);
			
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
