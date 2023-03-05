package com.example.lavajato.fornecimento.client.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProdutoRequest {
    @NotEmpty(message = "O identificador do produto é requerido")
    private String id;
    private String nome;
}
