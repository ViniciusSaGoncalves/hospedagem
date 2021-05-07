package com.vinicius.hospedagem.resources;

import com.vinicius.hospedagem.model.Hospedagem;
import com.vinicius.hospedagem.model.dto.HospedagemDto;
import com.vinicius.hospedagem.model.dto.HospedagemRetornoDto;
import com.vinicius.hospedagem.service.HospedagemService;
import com.vinicius.hospedagem.service.PessoaService;
import com.vinicius.hospedagem.util.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

public class HospedagemResources implements BaseResource<HospedagemDto, HospedagemRetornoDto> {

    @Autowired
    private HospedagemService hospedagemService;

    @Autowired
    private PessoaService pessoaService;

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<HospedagemRetornoDto> inserir(HospedagemDto obj, UriComponentsBuilder uriBuilder) {
        Hospedagem hospedagem = obj.converter();
        hospedagem.setCliente(pessoaService.selecionar(obj.getClienteId()));
        hospedagem = hospedagemService.inserir(hospedagem);
        URI uri = uriBuilder.path("/hospedagens/{id}").buildAndExpand(hospedagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new HospedagemRetornoDto(hospedagem));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<HospedagemRetornoDto> alterar(Long id, HospedagemDto obj, UriComponentsBuilder uriBuilder) {
        Hospedagem hospedagem = hospedagemService.alterar(id, obj.converter());
        URI uri = uriBuilder.path("/hospedagens/{id}").buildAndExpand(hospedagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new HospedagemRetornoDto(hospedagem));
    }

    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    @Override
    public void excluir(Long id) {
        hospedagemService.excluir(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @Override
    public List<HospedagemRetornoDto> listar() {
        return HospedagemRetornoDto.converter(hospedagemService.listar());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @Override
    public HospedagemRetornoDto selecionar(Long id) {
        return new HospedagemRetornoDto(hospedagemService.selecionar(id));
    }
}
