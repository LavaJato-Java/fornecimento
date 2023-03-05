package com.example.lavajato.fornecimento.service;

import com.example.lavajato.fornecimento.client.FinanceiroClient;
import com.example.lavajato.fornecimento.client.payload.request.FornecedorFinanceiroRequest;
import com.example.lavajato.fornecimento.client.payload.request.ItemRequest;
import com.example.lavajato.fornecimento.client.payload.request.ProdutoRequest;
import com.example.lavajato.fornecimento.client.payload.request.RealizarPagamentoFinanceiro;
import com.example.lavajato.fornecimento.entity.*;
import com.example.lavajato.fornecimento.jms.out.PagamentoFornecedorFinanceiroProducer;
import com.example.lavajato.fornecimento.payloads.PedidoRequest;
import com.example.lavajato.fornecimento.queue.out.PagarFornecedorMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RealizarPedidoService {

    //private final FinanceiroClient financeiroClient;
    //private final PagarFornecedorMessageSender pagarFornecedorMessageSender;


    private final CreateFornecedorService createFornecedorService;
    private final CreateOrRetrieveProdutoService createOrRetrieveProdutoService;
    private final CreatePedidoService createPedidoService;

    private final PagamentoFornecedorFinanceiroProducer pagamentoFornecedorFinanceiroProducer;


    public void execute(PedidoRequest pedidoRequest){

        Fornecedor fornecedor = saveFornecedor(pedidoRequest);
        Produto produto = saveProduto(pedidoRequest);
        Pedido pedido = savePedido(pedidoRequest, produto, fornecedor);

        sendPedidoToFinanceiro(fornecedor, produto, pedido);
    }

    private void sendPedidoToFinanceiro(Fornecedor fornecedor, Produto produto, Pedido pedido){
        RealizarPagamentoFinanceiro realizarPagamentoFinanceiro = new RealizarPagamentoFinanceiro();

        FornecedorFinanceiroRequest fornecedorFinanceiroRequest = new FornecedorFinanceiroRequest();
        fornecedorFinanceiroRequest.setRazaoSocial(fornecedorFinanceiroRequest.getRazaoSocial());
        fornecedorFinanceiroRequest.setCnpj(fornecedorFinanceiroRequest.getCnpj());
        fornecedorFinanceiroRequest.setId(fornecedorFinanceiroRequest.getId());
        realizarPagamentoFinanceiro.setFornecedor(fornecedorFinanceiroRequest);

        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setPreco(pedido.getItemPedidoList().iterator().next().getPreco());
        itemRequest.setQuantidade(((Double) pedido.getItemPedidoList()
                .iterator().next().getQuantidade()).intValue());

        ProdutoRequest produtoRequest = new ProdutoRequest();
        produtoRequest.setNome(produto.getNome());
        produtoRequest.setId(produto.getId());


        itemRequest.setProduto(produtoRequest);
        realizarPagamentoFinanceiro.setItems(List.of(itemRequest));

        //financeiroClient.realizarPagamento(realizarPagamentoFinanceiro);
        //pagarFornecedorMessageSender.send(realizarPagamentoFinanceiro);
        pagamentoFornecedorFinanceiroProducer.send(realizarPagamentoFinanceiro);
    }

    private Pedido savePedido(PedidoRequest pedidoRequest, Produto produto, Fornecedor fornecedor) {
        Pedido pedido = new Pedido();
        pedido.setFornecedor(fornecedor);


        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(pedidoRequest.getQuantidade());
        itemPedido.setPreco(pedidoRequest.getPrecoCompra());
        itemPedido.setProduto(produto);
        return createPedidoService.execute(pedido, List.of(itemPedido));


    }

    private Produto saveProduto(PedidoRequest pedidoRequest) {
        Produto produto = new Produto();
        produto.setMarca(pedidoRequest.getMarca());
        produto.setNome(pedidoRequest.getNome());
        return createOrRetrieveProdutoService.execute(produto);
    }
    private Fornecedor saveFornecedor(PedidoRequest pedidoRequest) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setRazaoSocial(pedidoRequest.getFornecedor().getRazaoSocial());
        fornecedor.setCnpj(pedidoRequest.getFornecedor().getCnpj());
        return createFornecedorService.execute(fornecedor);
    }
}
