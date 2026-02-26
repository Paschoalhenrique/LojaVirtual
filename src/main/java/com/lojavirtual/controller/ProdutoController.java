package com.lojavirtual.controller;


import com.lojavirtual.model.Produto;
import com.lojavirtual.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() { return service.listarTodos(); }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) { return service.salvar(produto); }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) { service.deletar(id); }
}
