package com.example.lavajato.fornecimento.repositories;

import com.example.lavajato.fornecimento.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FornecedorRepository  extends JpaRepository<Fornecedor, UUID> {
}