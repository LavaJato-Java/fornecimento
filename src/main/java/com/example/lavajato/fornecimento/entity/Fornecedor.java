package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

//import javax.persistence.*;

@Data
@Entity
@Table(name="Fornecedor")
public class Fornecedor {

    private String cnpj;

    private String razaoSocial;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}
