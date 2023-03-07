package com.example.lavajato.fornecimento.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class ItemPedidoResponse {

    private UUID id;

    private String nome;
    private String marca;
    private int quantidade;

    @JsonProperty(value = "preco_compra")
    private Double precoCompra;

}
