# LavaJato Application - Microserviço Fornecimento

Microserviço que realiza um pedido de produto para um fornecedor. 

Ele recebe uma Request com todos os dados do pedido, incluindo os dados do produto e do Fornecedor. 

Salva esses dados no seu Banco de Dados, e envia uma Request para o microserviço de Financeiro efetuar o 
pagamento desse pedido. 

Microserviço usando: 

. serviço de mensageria.

. Redis para Cache

. Padrão Saga Coreografado para conexão com os outros microserviços.

## Endpoints

### POST /realizarpedido/

Request 
```java
{
	String nome;
	String marca;
	int quantidade;
	Double preco_compra;
	Fornecedor : {
		            String razaoSocial;
		            String cnpj;
                  };
}
```

Response : void

### GET /realizarpedido/pedido/{idPedido}

Response 
```java
{
	UUID id;
	Fornecedor : {
                UUID id;
                String razaoSocial;
                String cnpj;
                  };
        List<ItensPedidos> : [
                UUID id;
                String nome;
                String marca;
                int quantidade;
                Double precoCompra;
    ];
}
```


### GET /realizarpedido/relatorio/{idFornecedor}

Response 
```java
{
	UUID id;
	Fornecedor : {
                UUID id;
                String razaoSocial;
                String cnpj;
                  };
        List<Pedido> : [
                {
                UUID id;
                  List<ItensPedidos> : [
                        UUID id;
                        String nome;
                        String marca;
                        int quantidade;
                        Double precoCompra;
                            ];
                },
                   {
                UUID id;
                  List<ItensPedidos> : [
                        UUID id;
                        String nome;
                        String marca;
                        int quantidade;
                        Double precoCompra;
                            ];
                },
    ];
}
```
