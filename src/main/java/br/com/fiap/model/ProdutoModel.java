package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_LOJA_PRODUTO")
public class ProdutoModel {
	private long idProduto;
	private String sku;
	private String nome;
	private LojaModel loja;
	
	public ProdutoModel() {
		super();
	}

	public ProdutoModel(long idProduto, String sku, String nome, LojaModel loja) {
		super();
		this.idProduto = idProduto;
		this.sku = sku;
		this.nome = nome;
		this.loja = loja;
	}

	@Id
	@Column(name = "ID_PRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_PROD_SEQ")
	@SequenceGenerator(name = "LOJA_PROD_SEQ", sequenceName = "LOJA_PROD_SEQ", allocationSize = 1)
	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_LOJA", nullable = false)
	public LojaModel getLoja() {
		return loja;
	}

	public void setLoja(LojaModel loja) {
		this.loja = loja;
	}

}
