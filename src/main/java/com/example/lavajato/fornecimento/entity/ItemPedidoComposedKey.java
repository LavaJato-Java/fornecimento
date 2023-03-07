package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ItemPedidoComposedKey implements Serializable {

    @Column(name = "id_pedido")
    private UUID idPedido;
    @Column(name = "id_produto")
    private UUID idProduto;

    public ItemPedidoComposedKey(UUID idPedido, UUID idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }
}
