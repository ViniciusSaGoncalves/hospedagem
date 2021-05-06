package com.vinicius.hospedagem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long id;
    private String nome;
    private String cpf;

}
