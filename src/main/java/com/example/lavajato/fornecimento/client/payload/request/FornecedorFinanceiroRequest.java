package com.example.lavajato.fornecimento.client.payload.request;

import lombok.Data;

@Data
public class FornecedorFinanceiroRequest {

    private String cnpj;
    private String razaoSocial;

    private String id;
}