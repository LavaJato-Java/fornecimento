package com.example.lavajato.fornecimento.controllers;

import com.example.lavajato.fornecimento.payloads.PedidoRequest;
import com.example.lavajato.fornecimento.service.RealizarPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/realizarpedido")
@RequiredArgsConstructor
public class RealizarPedidoController {

    private final RealizarPedidoService realizarPedidoService;

    @PostMapping(path= "")
    public void realizarPedido(@RequestBody PedidoRequest pedidoRequest){
        realizarPedidoService.execute(pedidoRequest);
    }
}
