package com.vinicius.hospedagem.model.dto;

import com.vinicius.hospedagem.model.Pessoa;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PessoaDto {
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "O campo CPF não pode ser vazio")
    private String cpf;

    public PessoaDto() {
    }

    public Pessoa converter() {
        return new Pessoa(this.nome, this.cpf);
    }
}
