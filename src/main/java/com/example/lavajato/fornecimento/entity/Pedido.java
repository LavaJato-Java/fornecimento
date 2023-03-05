package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Pedido")
public class Pedido {
    @Id
    private String id;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidoList;
}
