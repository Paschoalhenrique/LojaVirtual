package com.lojavirtual.service;

import com.lojavirtual.model.Produto;
import com.lojavirtual.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
@Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() { return repository.findAll(); }
    public Produto salvar(Produto produto) { return repository.save(produto); }
    public void deletar(Long id) { repository.deleteById(id); }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

}
