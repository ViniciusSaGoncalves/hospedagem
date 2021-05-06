package com.vinicius.hospedagem.model.dto;

import com.vinicius.hospedagem.model.Hospedagem;
import lombok.Getter;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class HospedagemRetornoDto {

    private long id;

    private String nomeCliente;

    private String cpf;

    private Calendar checkIn;

    private Calendar checkOut;

    private boolean estacionamento;

    public HospedagemRetornoDto(Hospedagem hospedagem) {
        this.id = hospedagem.getId();
        this.nomeCliente = hospedagem.getCliente().getNome();
        this.cpf = hospedagem.getCliente().getCpf();
        this.checkIn = hospedagem.getCheckIn();
        this.checkOut = hospedagem.getCheckOut();
    }

    public HospedagemRetornoDto(long id, String nomeCliente, String cpf, Calendar checkIn, Calendar checkOut, boolean estacionamento) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.estacionamento = estacionamento;
    }

    public static List<HospedagemRetornoDto> converter(List<Hospedagem> hospedagens) {
        return hospedagens.stream().map(HospedagemRetornoDto::new).collect(Collectors.toList());
    }
}
