package br.com.sistemaVendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_fornecedores")
@NamedQueries({@NamedQuery(name="Fornecedor.listar", query="SELECT fornecedor FROM Fornecedor fornecedor "),
@NamedQuery(name="Fornecedor.buscarPorCodigo", query="SELECT fornecedor FROM Fornecedor fornecedor WHERE fornecedor.id = :id")
})
public class Fornecedor {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="forn_id")
	private Long id;
	
	@NotEmpty(message="Insira a descrição")
	@Column(name="forn_descricao", length=50, nullable=false)
	private String descricao;

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

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", descricao=" + descricao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	
	
	
	

	
}
