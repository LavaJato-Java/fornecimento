package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    private String id;

    private long quantidade;

    private String marca;

    private String nome;

}
