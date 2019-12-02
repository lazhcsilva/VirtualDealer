package br.projeto.virtualdealer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEndereco;
	
	@NotBlank(message="Digite o nome da rua/avenida")
	@Size(min = 5, max = 40)
	private String logadouro;
	
	@NotBlank(message="Digite o número")
	private int numero;
	
	@Size(min = 5, max = 40)
	private String complemento;
	
	@NotBlank(message="Digite o bairro")
	private String bairro;
	
	@NotBlank(message="Digite a cidade")
	@Size(min = 5, max = 40)
	private String cidade;
	
	@NotBlank(message="Digite o estado")
	@Size(min = 5, max = 12)
	private String estado;
	
	@NotBlank(message="Digite um CEP válido")
	private String cep;
	
	@OneToOne
	private Concessionaria concessionaria;
	
	@OneToOne
	private Cliente cliente;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", logadouro=" + logadouro + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", cep=" + cep + ", concessionaria=" + concessionaria + ", cliente=" + cliente + "]";
	}
	
}
