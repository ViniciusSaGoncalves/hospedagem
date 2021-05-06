package com.vinicius.hospedagem.service;

import com.vinicius.hospedagem.exception.ObjetoEncontradoException;
import com.vinicius.hospedagem.model.Hospedagem;
import com.vinicius.hospedagem.repository.HospedagemRepository;
import com.vinicius.hospedagem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HospedagemService implements BaseService<Hospedagem> {

    @Autowired
    HospedagemRepository hospedagemRepository;

    @Override
    public Hospedagem inserir(Hospedagem obj) {
        return obj = hospedagemRepository.save(obj);
    }

    @Override
    public Hospedagem alterar(Long id, Hospedagem obj) {
        verificarExistencia(id);
        obj.setId(id);
        return hospedagemRepository.save(obj);
    }

    @Override
    public void excluir(Long id) {
        verificarExistencia(id);
        hospedagemRepository.deleteById(id);
    }

    @Override
    public List<Hospedagem> listar() {
        return hospedagemRepository.findAll();
    }

    @Override
    public Hospedagem selecionar(Long id) {
        return null;
    }

    @Override
    public void verificarExistencia(Hospedagem obj) {
        if (obj == null){
            throw new ObjetoEncontradoException("Hospedagem não encontrada!");
        }
    }

    @Override
    public void verificarExistencia(Long id) {
        Hospedagem hospedagem = hospedagemRepository.findById(id).orElse(null);
        verificarExistencia(hospedagem);
    }
}
