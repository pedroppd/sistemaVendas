package br.com.sistemaVendas.dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistemaVendas.domain.Produto;
import br.com.sistemaVendas.util.HibernateUtil;

public class Produtodao {
	
	public void salvar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); // Conectando com o banco

		Transaction transicao = null;

		try {
			transicao = sessao.beginTransaction(); // abrindo transação

			sessao.save(produto);

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
	public ArrayList<Produto> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ArrayList<Produto> produto = null;
		
		try {
			Query consulta= sessao.getNamedQuery("Produto.listar");
			produto = (ArrayList<Produto>) consulta.list();
			
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return produto;
	}
	
	public Produto buscarPorCodigo(Long id) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Produto produto = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("id", id);
			produto = (Produto) consulta.uniqueResult();
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		
		return produto;
	}
	
	
	public void excluir(Produto p) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
	
		
		try{
			
			transacao = sessao.beginTransaction();
			
			
			
			
			sessao.delete(p);
			
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
	
	
	public void editar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			
			sessao.update(produto);
			
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
