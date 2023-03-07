package com.example.lavajato.fornecimento.service;

import com.example.lavajato.fornecimento.entity.ItemPedido;
import com.example.lavajato.fornecimento.entity.ItemPedidoComposedKey;
import com.example.lavajato.fornecimento.entity.Pedido;
import com.example.lavajato.fornecimento.repositories.ItemPedidoRepository;
import com.example.lavajato.fornecimento.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    public Pedido execute(Pedido pedido, List<ItemPedido> itemPedidos){
        //pedido.setId(UUID.randomUUID().toString());
        Pedido savedPedido= pedidoRepository.save(pedido);
        itemPedidos
                .forEach(itemPedido ->
                        itemPedido.setItemPedidoComposedKey
                                (new ItemPedidoComposedKey(savedPedido.getId(),itemPedido.getProduto().getId())));
        itemPedidoRepository.saveAll(itemPedidos);
        savedPedido.setItemPedidoList(itemPedidos);
        return savedPedido;
    }
}