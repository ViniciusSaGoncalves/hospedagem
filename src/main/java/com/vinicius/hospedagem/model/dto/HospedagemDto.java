package com.vinicius.hospedagem.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

public class HospedagemDto {

    @NotBlank(message="O campo cliente nao pode ser nulo")
    private Long clienteId;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo checkin não pode ser nulo")
    private Calendar checkIn;

    @NotNull(message = "O campo estacionamento não pode ser nulo")
    private boolean estacionamento;
}
