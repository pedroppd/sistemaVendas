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
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_produtos")
@NamedQueries({@NamedQuery(name="Produto.listar", query="SELECT produto FROM Produto produto "),
@NamedQuery(name="Produto.buscarPorCodigo", query="SELECT produto FROM Produto produto WHERE produto.id = :id")
})
public class Produto {
	
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="prod_id")
	private Long id;
	
	
	@NotNull(message="preencha o campo descrição")
	@Column(name="prod_descricao", length=50, nullable=false)
	private String descricao;
	
	
	@NotNull(message="preencha o campo preço")
	@DecimalMin(value= "0.00", message="o valor não pode ser menor que 0 :(")
	@Column(name="prod_preco", nullable=false, scale=2, precision=7)
	private BigDecimal preco;
	
	
	@Min(value= 0, message="A quantidade não pode ser menor que 0 :(")
	@NotNull(message="preencha o campo quantidade")
	@Column(name="prod_qtd", nullable=false)
	private int qtd;
	
	
	//@NotEmpty(message="preencha o campo fornecedor")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tb_fornecedores_forn_id", referencedColumnName="forn_id", nullable=false)
	private Fornecedor fornecedor = new Fornecedor();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", qtd=" + qtd + ", fornecedor="
				+ fornecedor + "]";
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	

}
