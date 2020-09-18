package br.com.fiap.business;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.exception.ReponseBusinessException;
import br.com.fiap.model.LojaModel;
import br.com.fiap.repository.LojaRepository;

@Component
public class LojaBusiness {

	@Autowired
	private LojaRepository lojaRepository;

	public LojaModel applyBusiness(LojaModel lojaModel) throws ReponseBusinessException {

		String url = changeUrlToLowerCase(lojaModel.getUrlLoja());
		lojaModel.setUrlLoja(url);

		url = checkUrlPattern(lojaModel.getUrlLoja());
		lojaModel.setUrlLoja(url);

		return lojaModel;
	}

	private String checkUrlPattern(String urlLoja) throws ReponseBusinessException {
		if (urlLoja.startsWith("http://www") || urlLoja.startsWith("https://www")) {
			return urlLoja;
		}

		throw new ReponseBusinessException("A URL deve iniciar com 'http://www' ou 'https://www'");
	}

	private String changeUrlToLowerCase(String urlLoja) {
		return urlLoja.toLowerCase();
	}

}
