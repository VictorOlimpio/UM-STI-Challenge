Descrição
=========

Projeto desenvolvido em Java, destinado a solucionar o Desafio 1 proposto pelo STI, cujo objetivo:

Implementar a criação de contas de e-mail para alunos da UFF. Para isso, será necessário ler o arquivo csv que contém os dados dos alunos e, de acordo com o nome e o status do aluno oferecer um conjunto de opções de e-mail para ele escolher. Ao final do processo, o aluno recebe uma mensagem informando que sua conta será criada nos próximos minutos e que ele receberá um SMS com sua primeira senha de acesso.

Seguindo os requisitos abaixo:

	.Apenas alunos ativos podem criar um UFFMail
	.As opções de UFFMail devem ser geradas de acordo com o nome do aluno
	.Um aluno só pode ter um UFFMail

Ambiente de desenvlvimento
==========================
	-NetBeans IDE 8.2
	-JDK version "1.8.0_131"
	-JDK Runtime Environment (build 1.8.0_131-b11)
	-JDK 64-Bit Server VM (build 25.131-b11, mixed mode)

Para executar o projeto
=======================

-Abra o projeto no NetBeans.

-Adicione a biblioteca javacsv.jar que se encontra dentro da pasta "dependencies" ao projeto:

	.Clique com o botão direito encima do projeto aberto no NetBeans;
	.Vá em propriedades;
	.Em seguida clique em Bibliotecas;
	.Clique em adicionar JAR/Pasta;
	.Abra a pasta dependencies e clique no arquivo javacsv.jar;
  
-Execute a classe main que se encontra no pacote uffmdesafio.

-A entrada de dados se dá como exemplificado no Desafio.

-Testes de unidade
==================

-Use o atalho ALT + F6.
