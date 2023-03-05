package com.example.lavajato.fornecimento.repositories;

import com.example.lavajato.fornecimento.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Optional<Produto> findByNomeAndMarcaAndQuantidade(String nome, String marca, long quantidade);
}
