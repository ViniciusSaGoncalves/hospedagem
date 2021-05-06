package com.vinicius.hospedagem.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface BaseResource <E, E1> {

    public ResponseEntity<E1> inserir(E obj, UriComponentsBuilder uriBuilder);
    public ResponseEntity<E1> alterar(Long id, E obj, UriComponentsBuilder uriBuilder);
    public void excluir(Long id);
    public List<E1> listar();
    public E1 selecionar(Long id);

}
