package com.vinicius.hospedagem.util;

import java.util.List;

public interface BaseService <E> {

    public E inserir(E obj);
    public E alterar(Long id, E obj);
    public void excluir(Long id);
    public List<E> listar();
    public E selecionar(Long id);
    public void verificarExistencia(E obj);
    public void verificarExistencia(Long id);

}
