package com.example.lavajato.fornecimento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//import javax.persistence.*;

@Data
@Entity
@Table(name="Fornecedor")
public class Fornecedor {

    @Id
    private String cnpj;

    private String razaoSocial;

    private String id;
}
