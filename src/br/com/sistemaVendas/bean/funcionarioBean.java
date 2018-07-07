package br.com.sistemaVendas.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sistemaVendas.dao.Funcionariodao;
import br.com.sistemaVendas.domain.Funcionario;
import br.com.sistemaVendas.msg.JSFUtil;

@ManagedBean(name = "MBfuncionarios")
@ViewScoped
public class funcionarioBean {
	
	private Funcionario funcionarios;
	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;
	private String acao;
	private Long codigo;

	public Funcionario getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Funcionario funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
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
		Funcionariodao dao = new Funcionariodao();
		
		itens = (ArrayList<Funcionario>)dao.listar();
		
		
		}catch(RuntimeException ex) {
			throw ex;
		}
	}
	
	public void carregarCadastro() {
		try {
			
			
			
			if(codigo!= null) {
				
				
				Funcionariodao dao = new Funcionariodao();
				
				funcionarios = dao.buscarPorCodigo(codigo);
			}else {
				funcionarios = new Funcionario();
			}
			
		}catch(RuntimeException ex) {
			throw  ex;
			
		}
	}
	
	
	public void novo() {
		
		funcionarios = new Funcionario();
	}
	
	

	public void salvar() {

		try {
			
			Funcionariodao dao = new Funcionariodao();

			dao.salvar(funcionarios);
			
			funcionarios = new Funcionario();
			

			JSFUtil.adicionarMenssagemSucesso("Funcionario Salvo Com Sucesso!");

		} catch (RuntimeException ex) {

			JSFUtil.adicionarMenssagemErro("ERRO ao cadastrar :(");
            throw ex;
		}
	}
	
	public void excluir() {
		
	try {	
		
		
		Funcionariodao dao = new Funcionariodao();
		
		dao.excluir(funcionarios);
		
		JSFUtil.adicionarMenssagemSucesso("Funcionario excluido com sucesso!!");
		
	}catch(RuntimeException ex) {
		
		throw ex;
		
	}
		
		
	}
	
	
 public void editar() {
	
	 try {
	 
	Funcionariodao dao = new Funcionariodao();
	 
	 dao.editar(funcionarios);
	 
	 JSFUtil.adicionarMenssagemSucesso("funcionario editado com sucesso!!");
	 
	 }catch(RuntimeException ex) {
		 throw ex;
	 }
 }


}
