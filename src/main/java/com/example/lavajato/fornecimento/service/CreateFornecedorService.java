package com.example.lavajato.fornecimento.service;

import com.example.lavajato.fornecimento.entity.Fornecedor;
import com.example.lavajato.fornecimento.repositories.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateFornecedorService {

    private final FornecedorRepository fornecedorRepository;
    public Fornecedor execute(Fornecedor fornecedor){
        fornecedor.setId(UUID.randomUUID().toString());
        log.info("Fornecedor de ID {}",fornecedor.getId());
        return fornecedorRepository.findById(fornecedor.getCnpj())
                .orElse(fornecedorRepository.save(fornecedor));

    }
}