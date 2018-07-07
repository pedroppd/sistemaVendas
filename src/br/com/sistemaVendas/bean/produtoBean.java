package br.com.sistemaVendas.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaVendas.dao.Fornecedordao;
import br.com.sistemaVendas.dao.Produtodao;
import br.com.sistemaVendas.domain.Fornecedor;
import br.com.sistemaVendas.domain.Produto;
import br.com.sistemaVendas.msg.JSFUtil;

@ManagedBean(name = "MBprodutos")
@ViewScoped
public class produtoBean {
	
	private Produto produtos;
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	private String acao;
	private Long codigo;
	private List<Fornecedor>listaFornecedores;
	
	
	
	
	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}
	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}
	public Produto getProdutos() {
		return produtos;
	}
	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Produto> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	
	public void prepararPesquisa() {
		try {
			Produtodao dao = new Produtodao();
		
		itens = (ArrayList<Produto>)dao.listar();
		
		
		}catch(RuntimeException ex) {
			throw ex;
		}
	}
	
	public void carregarCadastro() {
		try {
			
			
			
			if(codigo!= null) {
				
				
				Produtodao dao = new Produtodao();
				
				produtos = dao.buscarPorCodigo(codigo);
			}else {
				produtos = new Produto();
			}
			
			Fornecedordao dao = new Fornecedordao();
			
			listaFornecedores = dao.listar();
			
		}catch(RuntimeException ex) {
			throw  ex;
			
		}
	}
	
	
	public void novo() {
		
		produtos = new Produto();
	}
	
	

	public void salvar() {

		try {
			
			Produtodao dao = new Produtodao();

			dao.salvar(produtos);
			
			produtos = new Produto();
			

			JSFUtil.adicionarMenssagemSucesso("Produto Salvo Com Sucesso!");

		} catch (RuntimeException ex) {

			JSFUtil.adicionarMenssagemErro("ERRO ao cadastrar :(");
            throw ex;
		}
	}
	
	public void excluir() {
		
	try {	
		
		
		Produtodao dao = new Produtodao();
		
		dao.excluir(produtos);
		
		JSFUtil.adicionarMenssagemSucesso("Produto excluido com sucesso!!");
		
	}catch(RuntimeException ex) {
		
		throw ex;
		
	}
		
		
	}
	
	
 public void editar() {
	
	 try {
	 
	Produtodao dao = new Produtodao();
	 
	 dao.editar(produtos);
	 
	 JSFUtil.adicionarMenssagemSucesso("Produto editado com sucesso!!");
	 
	 }catch(RuntimeException ex) {
		 throw ex;
	 }
 }

}
