package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_LOJA")
public class LojaModel {

	private long idLoja;
	private String nomeLoja;
	private String urlLoja;

	public LojaModel() {
	}

	public LojaModel(long idLoja, String nomeLoja, String urlLoja) {
		super();
		this.idLoja = idLoja;
		this.nomeLoja = nomeLoja;
		this.urlLoja = urlLoja;
	}

	@Id
	@Column(name = "ID_LOJA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	@SequenceGenerator(name = "LOJA_SEQ", sequenceName = "LOJA_SEQ", allocationSize = 1)
	public long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(long idLoja) {
		this.idLoja = idLoja;
	}

	@Column(name = "NOME_LOJA")
	@NotNull(message = "Nome Obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 50 caracteres")
	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	@Column(name = "URL_LOJA")
	@NotNull(message = "URL é Obrigatória")
	@Size(min = 2, max = 150, message = "URL deve ser entre 2 e 150 caracteres")
	public String getUrlLoja() {
		return urlLoja;
	}

	public void setUrlLoja(String urlLoja) {
		this.urlLoja = urlLoja;
	}

	

}
