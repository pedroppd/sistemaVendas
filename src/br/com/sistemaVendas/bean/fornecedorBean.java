package br.com.sistemaVendas.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaVendas.dao.Fornecedordao;
import br.com.sistemaVendas.domain.Fornecedor;
import br.com.sistemaVendas.msg.JSFUtil;

@ManagedBean(name = "MBfornecedores")
@ViewScoped
public class fornecedorBean {
	// Atributos
	private Fornecedor fornecedores;
	private ArrayList<Fornecedor> itens;
	private ArrayList<Fornecedor> itensFiltrados;
	private String acao;
	private Long codigo;

	// Metodos acessores
	
	
	
	
	
	public Fornecedor getFornecedores() {
		
		return fornecedores;
	}

 

	public Long getCodigo() {
		return codigo;
	}



	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public String getAcao() {
		return acao;
	}



	public void setAcao(String acao) {
		this.acao = acao;
	}



	public ArrayList<Fornecedor> getItens() {
		return itens;
	}



	public void setItens(ArrayList<Fornecedor> itens) {
		this.itens = itens;
	}



	public ArrayList<Fornecedor> getItensFiltrados() {
		return itensFiltrados;
	}



	public void setItensFiltrados(ArrayList<Fornecedor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}



	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}

	// Metodos
	
	//@PostConstruct
	public void prepararPesquisa() {
		try {
		Fornecedordao dao = new Fornecedordao();
		
		itens = (ArrayList<Fornecedor>) dao.listar();
		
		
		}catch(RuntimeException ex) {
			throw ex;
		}
	}
	
	public void carregarCadastro() {
		try {
			
			
			
			if(codigo!= null) {
				
				
				Fornecedordao dao = new Fornecedordao();
				
				fornecedores = dao.buscarPorCodigo(codigo);
			}else {
				fornecedores = new Fornecedor();
			}
			
		}catch(RuntimeException ex) {
			throw ex;
		}
	}
	
	
	public void novo() {
		
		fornecedores = new Fornecedor();
	}
	
	

	public void salvar() {

		try {
			
			
			Fornecedordao dao = new Fornecedordao();

			dao.salvar(fornecedores);
			
			fornecedores = new Fornecedor();

			JSFUtil.adicionarMenssagemSucesso("Fornecedor Salvo Com Sucesso !!");

		} catch (RuntimeException ex) {

			JSFUtil.adicionarMenssagemErro("ERRO ao cadastrar :(");

			ex.printStackTrace();
		}
	}
	
	public void excluir() {
		
	try {	
		
		
		Fornecedordao dao = new Fornecedordao();
		
		dao.excluir(fornecedores);
		
		JSFUtil.adicionarMenssagemSucesso("Fornecedor excluido com sucesso!!");
		
	}catch(RuntimeException ex) {
		
		throw ex;
		
	}
		
		
	}
	
	
 public void editar() {
	
	 try {
	 
	 Fornecedordao dao = new Fornecedordao();
	 
	 dao.editar(fornecedores);
	 
	 JSFUtil.adicionarMenssagemSucesso("fornecedor editado com sucesso!!");
	 
	 }catch(RuntimeException ex) {
		 throw ex;
	 }
 }

}
