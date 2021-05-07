package com.vinicius.hospedagem.resources;

import com.vinicius.hospedagem.model.Pessoa;
import com.vinicius.hospedagem.model.dto.PessoaDto;
import com.vinicius.hospedagem.model.dto.PessoaRetornoDto;
import com.vinicius.hospedagem.service.PessoaService;
import com.vinicius.hospedagem.util.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResources implements BaseResource<PessoaDto, PessoaRetornoDto> {

    @Autowired
    private PessoaService pessoaService;

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<PessoaRetornoDto> inserir(@Valid @RequestBody PessoaDto obj, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaService.inserir(obj.converter());
        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaRetornoDto(pessoa));
    }

    @Transactional
    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<PessoaRetornoDto> alterar(@PathVariable Long id, @Valid @RequestBody PessoaDto obj, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaService.alterar(id, obj.converter());
        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaRetornoDto(pessoa));
    }

    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    @Override
    public void excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @Override
    public List<PessoaRetornoDto> listar() {
        return PessoaRetornoDto.converter(pessoaService.listar());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    @Override
    public PessoaRetornoDto selecionar(@PathVariable Long id) {
        return new PessoaRetornoDto(pessoaService.selecionar(id));
    }
}
