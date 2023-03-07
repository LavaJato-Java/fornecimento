#LavaJata Application - Microservice Fornecimento

Microserviço que realiza um pedido de produtos para um fornecedor. 

Ele recebe uma Request com todos os dados do pedido, incluindo os dados do produto e do Fornecedor. 

Salva esses dados no seu Banco de Dados, e envia uma Request para o microserviço de Financeiro efetuar o 
pagamento desse pedido. 

Microserviço usando: 

. usando serviço de mensageria.

. usando Redis para Cache

. usando Padrão Saga Coreografado para conexão com os outros microserviços.

##Endpoints

### POST /realizarpedido/

Request 

{<br>
    String nome;<br>
    String marca;<br>
    int quantidade;<br>
    Double preco_compra<br>
    Fornecedor : { <br>
        String razaoSocial <br>
        String cnpj<br>
        } <br>
} <br> 

Response : void