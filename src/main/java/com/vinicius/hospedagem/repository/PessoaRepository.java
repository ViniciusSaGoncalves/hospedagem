package com.vinicius.hospedagem.repository;

import com.vinicius.hospedagem.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
