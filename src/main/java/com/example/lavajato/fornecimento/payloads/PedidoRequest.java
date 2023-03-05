package com.example.lavajato.fornecimento.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PedidoRequest {
    private String nome;
    private String marca;
    private int quantidade;

    @JsonProperty(value = "preco_compra")
    private Double precoCompra;

    private Double precoVenda;
    private FornecedorRequest fornecedor;

}
