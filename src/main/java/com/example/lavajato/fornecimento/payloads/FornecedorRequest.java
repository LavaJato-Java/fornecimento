package com.example.lavajato.fornecimento.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class FornecedorRequest{

        private UUID id;

        private String cnpj;

        @JsonProperty(value = "razao_social")
        private String razaoSocial;
        }
