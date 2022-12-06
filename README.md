# desafio-db

# Cenário de Negócio

Todo dia útil por volta das 6 horas da manhã um colaborador da retaguarda do Sicredi recebe e organiza as informações de
contas para enviar ao Banco Central. Todas agencias e cooperativas enviam arquivos Excel à Retaguarda. Hoje o Sicredi
já possiu mais de 4 milhões de contas ativas.
Esse usuário da retaguarda exporta manualmente os dados em um arquivo CSV para ser enviada para a Receita Federal,
antes as 10:00 da manhã na abertura das agências.

# Solução:

Foi desenvolvido uma api que realiza a leitura de um arquivo csv, trata os dados e faz o mapeamento para um objeto java, faz a validação na api da receita e retorna um novo arquivo com os dados atualizados.

# Tecnologias

- Java 8
- Spring Boot
- Junit 5
- Open CSV

# Executar o projeto

Para executar o projeto será necessário o seguinte comando:

- java -jar SincronizacaoReceita <input-file>

Quando executar, será gerado um arquivo com o com os dados mais o resultado no arquivo.
