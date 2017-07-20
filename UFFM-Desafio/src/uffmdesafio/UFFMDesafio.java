/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uffmdesafio;

import core.Aluno;
import java.util.ArrayList;
import java.util.Scanner;
import utils.CsvRW;

/**
 *
 * @author victor
 */
public class UFFMDesafio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matricula;
        Aluno aluno = new Aluno();
        ArrayList<Aluno> alunos = new ArrayList();

        alunos = CsvRW.csvR("alunos.csv");
        int size = alunos.size();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua matrícula");
        matricula = scanner.nextInt();

        aluno = CsvRW.query(matricula);

        if (aluno.getUffmail().equals("") && aluno.getStatus().equalsIgnoreCase("ativo")) {
            String[] nome = aluno.getNome().split(" ");
            System.out.println("Olá " + nome[0] + ", " + "por favor escolha uma das opções abaixo para o seu UFFMail:");
            
        }else{
            System.out.println("Não foi possível criar conta pois o usuário já possui um UFFMail.");
        }
    }

}
