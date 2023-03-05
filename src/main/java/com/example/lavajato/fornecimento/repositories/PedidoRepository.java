package com.example.lavajato.fornecimento.repositories;

import com.example.lavajato.fornecimento.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,String> {
}