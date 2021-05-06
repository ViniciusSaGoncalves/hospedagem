package com.vinicius.hospedagem.service;

import com.vinicius.hospedagem.exception.ObjetoEncontradoException;
import com.vinicius.hospedagem.model.Pessoa;
import com.vinicius.hospedagem.repository.PessoaRepository;
import com.vinicius.hospedagem.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements BaseService<Pessoa> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa inserir(Pessoa obj) {
        return obj = pessoaRepository.save(obj);
    }

    @Override
    public Pessoa alterar(Long id, Pessoa obj) {
        verificarExistencia(id);
        obj.setId(id);
        return pessoaRepository.save(obj);
    }

    @Override
    public void excluir(Long id) {
        verificarExistencia(id);
        pessoaRepository.deleteById(id);
    }

    @Override
    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa selecionar(Long id) {
        verificarExistencia(id);
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        return pessoa;
    }

    @Override
    public void verificarExistencia(Pessoa obj) {
        if(obj == null){
            throw new ObjetoEncontradoException("Pessoa não encontrada!");
        }
    }

    @Override
    public void verificarExistencia(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
        verificarExistencia(pessoa);
    }
}
