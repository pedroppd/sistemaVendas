package br.com.sistemaVendas.domain;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_vendas")
@NamedQueries({@NamedQuery(name="Venda.listar", query="SELECT venda FROM Venda venda "),
@NamedQuery(name="Venda.buscarPorCodigo", query="SELECT venda FROM Venda venda WHERE venda.id = :id")
})
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ven_id")
	private Long id;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ven_horario", length=50, nullable=false)
	private Date horario;
	
	@Column(name="ven_valor_total", nullable=false, scale=2, precision=7)
	private BigDecimal valorTotal;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tb_funcionarios_fun_id", referencedColumnName="fun_id", nullable=false)
	private Funcionario funcionario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getHorario() {
		return horario;
	}


	public void setHorario(Date horario) {
		this.horario = horario;
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	@Override
	public String toString() {
		return "Venda [id=" + id + ", horario=" + horario + ", valorTotal=" + valorTotal + ", funcionario="
				+ funcionario + "]";
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	
	
	
	
	
	
	
	
	
}
