# AutomationAPI-Petstore

Desafio automação<br />
1- Implementar os seguintes casos de teste para a seguinte API: https://petstore.swagger.io/<br />

Você deverá:<br />
Cadastrar novo pedido de pet com sucesso (POST /store/order)<br />
Pesquisar por um pet inexistente (GET /pet/{petId})<br />
Atualizar dados de um pet existente (PUT /pet)<br />
Pesquisar por pets com status “pending” (GET /pet/findByStatus)<br />

# Ferramentas utilizadas<br />
Eclipse, <br />
JAVA, <br />
Rest-Assured, <br />
JUnit e Maven Dependencies<br />

# Descrição do Projeto<br />
Este projeto contém testes automatizados que validam a API da Petstore. Os testes abrangem cenários de cadastro, consulta, atualização e listagem de pets, garantindo que a API opere conforme esperado.<br />

# Estrutura do Projeto<br />
AutomationAPI-Petstore └── src └── test └── java └── project.testapi_petstore └── ApiPetstoreTest.java

# Como Executar os Testes<br />
1. Clone o repositório:<br />
```bash<br />
git clone https://github.com/seuusuario/AutomationAPI-Petstore.git<br />
```<br />
2. Importe o projeto no Eclipse como um projeto Maven.<br />
3. Execute os testes via JUnit (Run As > JUnit Test).<br />

# Considerações Finais<br />
Projeto desenvolvido como parte de um desafio de automação utilizando Java e Rest-Assured. Contribuições e feedback são bem-vindos!<br />
