package br.com.fiap.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.fiap.model.LojaModel;
import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.ProdutoRepository;

@Component
public class ProdutoConsumer {

	@Autowired
	public ProdutoRepository repository;

	@KafkaListener(topics = "fiap.produto", groupId = "fiap-group-a")
	public void consume(ConsumerRecord<String, String> record) {
		System.out.println(record.key());
		System.out.println(record.value());
		
		LojaModel loja = new LojaModel();
		loja.setIdLoja(1);
		
		ProdutoModel produtoModel = new ProdutoModel();
		produtoModel.setSku(record.key().toString());
		produtoModel.setNome(record.value().toString());
		produtoModel.setLoja(loja);
		
		repository.save(produtoModel);

	}
}
