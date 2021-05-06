package com.vinicius.hospedagem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter
@Setter
public class Hospedagem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteId")
    private Pessoa cliente;

    private Calendar checkIn;

    private Calendar checkOut;

    private boolean estacionamento;

}
