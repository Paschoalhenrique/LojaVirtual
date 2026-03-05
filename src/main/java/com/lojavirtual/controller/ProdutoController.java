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
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) {
        // O service busca no banco. Se não achar, o Spring retorna erro 404
        return service.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto dadosAtualizados) {
        // 1. Busca o produto original
        Produto produtoExistente = service.buscarPorId(id);

        // 2. Atualiza os campos (Certifique-se que o IntelliJ reconhece o setNome)
        produtoExistente.setNome(dadosAtualizados.getNome());
        produtoExistente.setDescricao(dadosAtualizados.getDescricao());
        produtoExistente.setPreco(dadosAtualizados.getPreco());
        produtoExistente.setQuantidade(dadosAtualizados.getQuantidade());

        // 3. Salva a entidade atualizada
        return service.salvar(produtoExistente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.deletar(id);
    }
}