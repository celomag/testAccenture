package entities;

import java.io.Serializable;

public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String cnpj;
	private String nome;
	private String business;
	
	public Cliente() {
	}

	public Cliente(String id, String cnpj, String nome, String business) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.business = business;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cnpj=" + cnpj + ", nome=" + nome + ", business=" + business + "]";
	}
	
	
	
}
