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
public class EmailGenerator {

    public static ArrayList<String> generator(String nome) {
        String dominio = "@id.uff.br";
        String conta = "";
        ArrayList<String> contas = new ArrayList();

        nome = nome.toLowerCase();
        nome = nome.replace(" da ", " ").replace(" do ", " ").replace(" dos ", " ").replace(" de ", " ").replace("'", "");

        String[] substrings = nome.split(" ");

        Random randNum = new Random();
        int size = substrings.length;
        int rand;

        for (int i = 0; i < 6; i++) {

            rand = randNum.nextInt(size - 1);
            conta = "";
            if (size >= 2) {
                switch (i) {
                    case 0:
                        conta += substrings[rand] + "_" + substrings[rand + 1];
                        break;
                    case 1:
                        conta += substrings[0] + substrings[size - 2].charAt(0) + substrings[size - 1].charAt(0);
                        break;
                    case 2:
                        conta += substrings[rand] + substrings[size - 1].charAt(0);
                        break;
                    case 3:
                        conta += substrings[rand].charAt(0) + substrings[size - 1];
                        break;
                    case 4:
                        conta += substrings[rand] + substrings[rand + 1];
                        break;
                    case 5:
                        conta += substrings[rand + 1] + substrings[rand];
                        break;
                }
                conta += dominio;
            } else {
                conta += substrings[rand];
            }
            contas.add(conta);
        }

        return contas;
    }

}
