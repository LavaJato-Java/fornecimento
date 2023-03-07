package com.example.lavajato.fornecimento.client.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

@Data
public class ProdutoRequest {
    @NotEmpty(message = "O identificador do produto é requerido")
    private UUID id;
    private String nome;
}
