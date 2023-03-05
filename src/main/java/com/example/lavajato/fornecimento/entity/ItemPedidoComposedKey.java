package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ItemPedidoComposedKey implements Serializable {

    @Column(name = "id_pedido")
    private String idPedido;
    @Column(name = "id_produto")
    private String idProduto;

    public ItemPedidoComposedKey(String idPedido, String idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
    }
}
