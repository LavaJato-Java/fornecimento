package com.example.lavajato.fornecimento.payloads;

import com.example.lavajato.fornecimento.entity.Pedido;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PedidoResponse {
    private UUID id;

    private FornecedorRequest fornecedor;

    private List<ItemPedidoResponse> itemsPedidos;

}
