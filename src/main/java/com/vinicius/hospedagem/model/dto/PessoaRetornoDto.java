package com.vinicius.hospedagem.model.dto;

import com.vinicius.hospedagem.model.Pessoa;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PessoaRetornoDto {

    private Long id;

    private String nome;

    private String cpf;

    public PessoaRetornoDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
    }

    public PessoaRetornoDto(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public static List<PessoaRetornoDto> converter(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaRetornoDto::new).collect(Collectors.toList());
    }

}
