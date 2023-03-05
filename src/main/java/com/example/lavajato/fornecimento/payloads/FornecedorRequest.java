package com.example.lavajato.fornecimento.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FornecedorRequest{

        private String id;

        private String cnpj;

        @JsonProperty(value = "razao_social")
        private String razaoSocial;
        }
