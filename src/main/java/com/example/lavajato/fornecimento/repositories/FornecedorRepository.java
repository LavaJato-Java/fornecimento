package com.example.lavajato.fornecimento.repositories;

import com.example.lavajato.fornecimento.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository  extends JpaRepository<Fornecedor, String> {
}