package br.com.sistemaVendas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_itens")
@NamedQueries({@NamedQuery(name="Item.listar", query="SELECT item FROM Item item "),
@NamedQuery(name="Item.buscarPorCodigo", query="SELECT item FROM Item item WHERE item.id = :id")
})
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")
	private Long id;
	
	@Column(name="item_qtd")
	private int qtd;
	
	
	@Column(name="item_valor_parcial", nullable=false, scale=2, precision=7)
	private BigDecimal valor_parcial;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tb_produtos_prod_id", referencedColumnName="prod_id")
	private Produto produto = new Produto();
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tb_vendas_ven_id", referencedColumnName="ven_id")
	private Venda venda;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getQtd() {
		return qtd;
	}


	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


	public BigDecimal getValor_parcial() {
		return valor_parcial;
	}


	public void setValor_parcial(BigDecimal valor_parcial) {
		this.valor_parcial = valor_parcial;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Venda getVenda() {
		return venda;
	}


	public void setVenda(Venda venda) {
		this.venda = venda;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", qtd=" + qtd + ", valor_parcial=" + valor_parcial + ", produto=" + produto
				+ ", venda=" + venda + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
