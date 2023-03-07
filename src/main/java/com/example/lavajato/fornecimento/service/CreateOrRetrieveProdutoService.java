package com.example.lavajato.fornecimento.service;

import com.example.lavajato.fornecimento.entity.Produto;
import com.example.lavajato.fornecimento.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOrRetrieveProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto execute(Produto produto){
        //produto.setId(UUID.randomUUID().toString());
        return produtoRepository.findByNomeAndMarcaAndQuantidade(produto.getNome(), produto.getMarca()
                , produto.getQuantidade()).orElse(produtoRepository.save(produto));
    }

}
