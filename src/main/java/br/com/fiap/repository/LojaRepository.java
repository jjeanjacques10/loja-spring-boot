package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.LojaModel;

@Repository
public interface LojaRepository extends JpaRepository<LojaModel, Long> {

}
