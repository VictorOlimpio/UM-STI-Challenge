/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Random;
import sun.misc.VM;

/**
 *
 * @author victor
 */
public class GeradorDeEmail {

    /**
     * 
     * @param nome
     *              Nome do aluno.
     * @param alunos
     *              Lista de alunos.
     * @return 
     *              Retorna uma lista de opções válidas de uffmail.
     */
    public static ArrayList<String> gerador(String nome, ArrayList<Aluno> alunos) {
        String dominio = "@id.uff.br";
        String conta = "";
        ArrayList<String> contas = new ArrayList();

        nome = nome.toLowerCase();
        // retira preposições e caracteres especiais, comuns em alguns nomes.
        nome = nome.replace(" da ", " ").replace(" do ", " ").replace(" dos ", " ").replace(" de ", " ").replace("'", "");

        String[] substrings = nome.split(" ");

        Random randNum = new Random();
        
        int tamanho = substrings.length;
        int rand;
        
        if (alunos == null){
            return null;
        }
        
        for (int i = 0; i < 6; i++) {
            //escolha pseudo aleatoria para indice dentro do número de elementos do vetor substrings
            rand = randNum.nextInt(tamanho - 1);
            conta = "";
            
            if (tamanho >= 2) {
                switch (i) {
                    case 0:
                        conta += substrings[rand] + "_" + substrings[rand + 1];
                        break;
                    case 1:
                        conta += substrings[0] + substrings[tamanho - 2].charAt(0) + substrings[tamanho - 1].charAt(0);
                        break;
                    case 2:
                        conta += substrings[rand] + substrings[tamanho - 1].charAt(0);
                        break;
                    case 3:
                        conta += substrings[rand].charAt(0) + substrings[tamanho - 1];
                        break;
                    case 4:
                        conta += substrings[rand] + substrings[rand + 1];
                        break;
                    case 5:
                        conta += substrings[rand + 1] + substrings[rand];
                        break;
                }
                
            } else {
                conta += substrings[0];
            }
            conta += dominio;
            if (checagemDeEmailGerado(conta, alunos)) {
                contas.add(conta);
            }
        }

        return contas;
    }

    /**
     * 
     * @param conta
     *             Conta a ser comparada 
     * @param alunos
     *             Lista de alunos
     * @return 
     *             Retorna verdadeiro se o email não é igual a nenhuma outra conta de uffmail já existente, falso caso contrário.
     */
    public static boolean checagemDeEmailGerado(String conta, ArrayList<Aluno> alunos) {
        boolean notEqual = true;
        if(alunos == null){
            return false;
        }
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getUffmail().equalsIgnoreCase(conta)) {
                return notEqual = false;
            }
        }
        return true;
    }

}
