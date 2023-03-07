package com.example.lavajato.fornecimento.repositories;

import com.example.lavajato.fornecimento.entity.Fornecedor;
import com.example.lavajato.fornecimento.entity.Pedido;
import com.example.lavajato.fornecimento.payloads.PedidoResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido,String> {

    List<Pedido> findByFornecedor(UUID idFornecedor);

    PedidoResponse findById(UUID idPedido);
}