package br.projeto.virtualdealer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "oferta")
public class Oferta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOferta;
	
	@Size(min = 2, max = 15)
	private String veiculo;
	
	@Size(min = 3, max = 10)
	private String cor;
	
	@NotNull
	@Pattern(regexp="[A-Z]{3}\\d{4}.")
	private String placa;
	
	private String chassi;
	
	@NotNull
	private boolean importado;
	
	@NotNull
	private String estado;
	
	@NotNull
	private String combustivel;
	
	private double valor;
	
	private String descricao;
	
	@ManyToOne
	private Concessionaria concessionaria;
	

	public Integer getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(Integer idOferta) {
		this.idOferta = idOferta;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public boolean isImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}
	

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Oferta [idOferta=" + idOferta + ", veiculo=" + veiculo + ", cor=" + cor + ", placa=" + placa
				+ ", chassi=" + chassi + ", importado=" + importado + ", estado=" + estado + ", combustivel="
				+ combustivel + ", concessionaria=" + concessionaria + "]";
	}	
	
}
