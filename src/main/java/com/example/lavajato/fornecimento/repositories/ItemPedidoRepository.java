package com.example.lavajato.fornecimento.repositories;

import com.example.lavajato.fornecimento.entity.ItemPedido;
import com.example.lavajato.fornecimento.entity.ItemPedidoComposedKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoComposedKey> {
}