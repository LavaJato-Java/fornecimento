package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Item_Pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoComposedKey itemPedidoComposedKey;

    @ManyToOne
    @JoinColumn(name = "id_produto", insertable = false, updatable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_pedido", insertable = false, updatable = false)
    private Pedido pedido;

    private double preco;
    private double quantidade;
}
