/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import core.Aluno;
import core.GeradorDeEmail;
import java.util.ArrayList;
import java.util.Scanner;
import utils.CsvRW;

/**
 *
 * @author victor
 */
public class AdministradorUFFMail {
    public static String ATIVO = "ativo";

    public static void gerenciar() {

        Aluno aluno = new Aluno();
        ArrayList<Aluno> alunos = new ArrayList();
        ArrayList<String> opcoesDeEmail = new ArrayList();
        
        String conta;
        
        Scanner scanner = new Scanner(System.in);

        boolean rightAnswer = false;
        
        int matricula;
        int opcao = 0;
        int indice;
        int tamanho = alunos.size();

        alunos = CsvRW.csvR("archives/alunos.csv");

        System.out.println("Digite sua matrícula");
        matricula = scanner.nextInt();

        aluno = CsvRW.consulta(matricula, alunos);
        //Verifica se o aluno está ativo e se não possui uffmail.
        if (aluno.getUffmail().equals("") && aluno.getStatus().equalsIgnoreCase(ATIVO)) {

            String[] nome = aluno.getNome().split(" ");
            
            do {
                System.out.println("\nOlá " + nome[0] + ", " + "por favor escolha uma das opções abaixo para o seu UFFMail:\n");

                opcoesDeEmail = GeradorDeEmail.gerador(aluno.getNome(), alunos);

                for (int i = 1; i <= opcoesDeEmail.size(); i++) {
                    System.out.println(i + "." + opcoesDeEmail.get(i - 1));
                }
                System.out.println("");

                opcao = scanner.nextInt();
                indice = opcao - 1;
                
                if (indice < opcoesDeEmail.size()) {
                    rightAnswer = true;
                } else {
                    System.out.println("Opção inválida.");
                }

            } while (!rightAnswer);
            
            conta = opcoesDeEmail.get(indice);
            
            System.out.println("\nA criação de seu e-mail (" + conta + ") será feita nos próximos minutos.\n"
                    + "Um SMS foi enviado para " + aluno.getTelefone() + " com a sua senha de acesso.");
            CsvRW.atualizaAluno(matricula, alunos, conta);
            
            CsvRW.csvW("archives/alunosAtualizados.csv", alunos);

        } else {
            System.out.println("Não foi possível criar conta pois o usuário já possui um UFFMail, ou está inativo.");
        }
    }

}
