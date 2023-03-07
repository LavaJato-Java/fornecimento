package com.example.lavajato.fornecimento.service;

import com.example.lavajato.fornecimento.entity.Pedido;
import com.example.lavajato.fornecimento.payloads.FornecedorRequest;
import com.example.lavajato.fornecimento.payloads.PedidoRequest;
import com.example.lavajato.fornecimento.payloads.PedidoResponse;
import com.example.lavajato.fornecimento.payloads.RelatorioFornecedorResponse;
import com.example.lavajato.fornecimento.repositories.FornecedorRepository;
import com.example.lavajato.fornecimento.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class VisualizarPedidoService {
    private final PedidoRepository pedidoRepository;

    private final FornecedorRepository fornecedorRepository;

    @Cacheable(cacheNames = "rlpedido", key ="#idPedido" )
    public PedidoResponse execute(UUID idPedido){

        PedidoResponse pedido = pedidoRepository.findById(idPedido);
        return pedido;
    }
}