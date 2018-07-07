package br.com.sistemaVendas.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaVendas.dao.Funcionariodao;
import br.com.sistemaVendas.dao.Produtodao;
import br.com.sistemaVendas.dao.Vendadao;
import br.com.sistemaVendas.domain.Funcionario;
import br.com.sistemaVendas.domain.Item;
import br.com.sistemaVendas.domain.Produto;
import br.com.sistemaVendas.domain.Venda;
import br.com.sistemaVendas.msg.JSFUtil;

@ManagedBean(name = "MBvendas")
@ViewScoped
public class vendaBean {

	private Produto produtos;
	private Venda venda;
	private List<Item> itens;
	private List<Item> itensFiltrados;
	
	private List<Produto> produto;
	private List<Produto> produtosFiltrados;
	
	
	
	
	

	
	
	public Venda getVenda() {
		if(venda==null) {
			venda = new Venda();
			venda.setValorTotal(new BigDecimal(0));
		}
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	public Produto getProdutos() {
		if(produtos == null) {
			produtos = new Produto();
		}
		return produtos;
	}


	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}


	


	public List<Item> getItens() {
		if(itens==null) {
			itens = new ArrayList<>();
		}
		return itens;
	}


	public void setItens(List<Item> itens) {
		this.itens = itens;
	}


	public List<Item> getItensFiltrados() {
		return itensFiltrados;
	}


	public void setItensFiltrados(List<Item> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}


	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}


	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}


	public void prepararPesquisa() {
		try {
			
			Produtodao dao = new Produtodao();
		
		     produto = (ArrayList<Produto>)dao.listar();
		
		
		}catch(RuntimeException ex) {
			throw ex;
		}
	}
	
	
	
	public void adicionar(Produto p) {
		
		
	int posicao = -1;
		
		for(int pos =0; pos<itens.size() && posicao<0; pos++) {
			Item itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(p)) {
				posicao = pos;
			}
			
		}
		
		Item item = new Item();
		
		
		item.setProduto(p);
		
		if(posicao < 0) {
			
			item.setQtd(1);
			item.setValor_parcial(p.getPreco());
			itens.add(item);
		}else {
			Item itemTemp = itens.get(posicao);
			item.setQtd(itemTemp.getQtd()+1);
			
			item.setValor_parcial(p.getPreco().multiply(new BigDecimal( item.getQtd())));
			itens.set(posicao, item);
		}
		
		venda.setValorTotal(venda.getValorTotal().add(item.getProduto().getPreco()));
	}
	
	
	public void remover(Item item) {
		
int posicao = -1;
		
		for(int pos =0; pos<itens.size() && posicao<0; pos++) {
			Item itemTemp = itens.get(pos);
			
			if(itemTemp.getProduto().equals(item.getProduto())) {
				posicao = pos;
			}
			
		}
		
		if(posicao > -1) {
			itens.remove(posicao);
			
			venda.setValorTotal(venda.getValorTotal().subtract(item.getValor_parcial()));
		}
	}
	
	public void carregarHorario() {
		venda.setHorario(new Date());
		
		Funcionariodao dao = new Funcionariodao();
		
		Funcionario f = dao.buscarPorCodigo(1L);
		
		venda.setFuncionario(f);
		
		
	}
	
	
	public void salvar() {
		try {
			Vendadao vdao = new Vendadao();
			
			vdao.salvar(venda);
			
			venda = new Venda();
			venda.setValorTotal(new BigDecimal(0));
			
			itens = new ArrayList<Item>();
			
			
			JSFUtil.adicionarMenssagemSucesso("Venda finalizada com sucesso !!");
		}catch(RuntimeException ex) {
			ex.printStackTrace();
		}
	}

	
	
	
	
	
	
	
	
}
