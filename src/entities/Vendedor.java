package entities;

import java.io.Serializable;

public class Vendedor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String cpf;
	private String nome;
	private String salario;
	
	public Vendedor() {
	}

	public Vendedor(String id, String cpf, String nome, String salario) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", cpf=" + cpf + ", vendedor=" + nome + ", salario=" + salario + "]";
	}

}
