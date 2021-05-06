package com.vinicius.hospedagem.repository;

import com.vinicius.hospedagem.model.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

}
