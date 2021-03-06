package br.projeto.virtualdealer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "assinatura")
public class Assinatura {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAssinatura;
	
	private Date validade;
	
	@Size(min = 5, max = 255)
	private String operacao;
	
	private double preco;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToOne
	private PlanoAssinatura planoAssinatura;

	public Integer getIdAssinatura() {
		return idAssinatura;
	}

	public void setIdAssinatura(Integer idAssinatura) {
		this.idAssinatura = idAssinatura;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PlanoAssinatura getPlanoAssinatura() {
		return planoAssinatura;
	}

	public void setPlanoAssinatura(PlanoAssinatura planoAssinatura) {
		this.planoAssinatura = planoAssinatura;
	}

	@Override
	public String toString() {
		return "Assinatura [idAssinatura=" + idAssinatura + ", validade=" + validade + ", operacao=" + operacao
				+ ", preco=" + preco + ", cliente=" + cliente + ", planoAssinatura=" + planoAssinatura + "]";
	}
	
	
	
	
}
