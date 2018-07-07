package br.com.sistemaVendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name="tb_funcionarios")
@NamedQueries({@NamedQuery(name="Funcionario.listar", query="SELECT funcionario FROM Funcionario funcionario "),
@NamedQuery(name="Funcionario.buscarPorCodigo", query="SELECT funcionario FROM Funcionario funcionario WHERE funcionario.id = :id")
})
public class Funcionario {
    
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fun_id")
	private Long id;
	
	@NotEmpty(message="Preencha o campo nome")
	@Column(name="fun_nome", length=50, nullable=false)
    private String nome;
	
	@NotNull(message="CPF incorreto :(")
	@Column(name="fun_cpf", length=14, nullable=false, unique=true)
    private String cpf;
	
	@NotNull(message="Preencha o campo senha")
	@Size(min=5, max=10, message="Sua senha deve conter de 5 a 10 caracteres")
	@Column(name="fun_senha", length=50, nullable=false)
    private String senha;
	
	@NotNull(message="Insira um cargo :)")
	@Column(name="fun_funcao", length=50, nullable=false)
    private String funcao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", funcao=" + funcao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
    
    
	
	
}
