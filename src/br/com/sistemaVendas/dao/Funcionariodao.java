package br.com.sistemaVendas.dao;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sistemaVendas.domain.Funcionario;
import br.com.sistemaVendas.util.HibernateUtil;

public class Funcionariodao {

	
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession(); // Conectando com o banco

		Transaction transicao = null;

		try {
			transicao = sessao.beginTransaction(); // abrindo transação

			sessao.save(funcionario);

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
	public ArrayList<Funcionario> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		ArrayList<Funcionario> funcionario = null;
		
		try {
			Query consulta= sessao.getNamedQuery("Funcionario.listar");
			funcionario = (ArrayList<Funcionario>) consulta.list();
			
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		return funcionario;
	}
	
	public Funcionario buscarPorCodigo(Long id) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Funcionario funcionario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("id", id);
			funcionario = (Funcionario) consulta.uniqueResult();
			
		}catch(RuntimeException ex) {
			throw ex;
		}finally {
			sessao.close();
		}
		
		return funcionario;
	}
	
	
	public void excluir(Funcionario f) {
		
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
	
	
	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			
			sessao.update(funcionario);
			
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
