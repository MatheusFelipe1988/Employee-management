# Employee-management
  Sistema de gerenciamento de Funcionários que utiliza os métodos CRUD como criar, atualizar, deletar e ler os dados, mas tudo feito dentro de um front end que foi integrado ao nodeJS para conectar o back end Java que possui todas as operações e o banco de dados MySQL que armazena todos os funcionarios no sistema onde uma simples tablea demonstra todos inclusos.

## Back-End
  Desenvolvido em Java e Springboot o sistema que utiliza toda a lógica dos métodos CRUD e operações para se conectar ao front pelo Origin, conectar ao banco de dados MySQL e MySQL server para somente chamar pela URL e nele armazenar todos os dados dos funcionários cadastrados e manter outras operações como de deletar e atualizar dados na tabela de "employee", Swagger para documentar e ajudar outros desenvolvedores a identificar o que a lógica realiza e o que ocorrerá caso ocorra erro na operação.

## Front-End
  Desenvolvida em NodeJS que primeiramente foi encarregada pelo ViteJS usando o "npm install vite@latest", função do node para instalar um pacote pré pronto e nele escolhi ReactJS e Javascript para realizar a integração do meu sistema back-end com métodos de rotas como o "React-Router-Dom" para direcionar onde ficará cada operação CRUD nas URLS, construção da interface para melhor compreensão com uma tabela e 3 botões prontos do bootstrap, um de adicionar funcionario, deletar e atualizar o mesmo, uma tabela para visualizar todos os dados cadastrados no sistema de gerenciamento. Utilizando o comando "npm run dev" foi se possivel visualizar a tela de funcionários existentes no banco de dados.

## Stacks
#### Back-End
- Java 17
- MySQL 8.0
- Springboot 3.1.10
- Swagger 2.0.8

#### Front-End
- ReactJS 18.2.0
- Bootstrap 5.3.3
- NodeJS 20.12.2
