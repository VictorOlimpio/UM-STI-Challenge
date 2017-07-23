/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import core.Aluno;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class CsvRW {

    //Lista contendo cada instância de aluno dentro do arquivo
    private static ArrayList<Aluno> listaAlunos = new ArrayList();

    /**
     *
     * @param caminho nome ou caminho do arquivo
     * @return retorna a lista contendo todos os alunos dentro do arquivo
     */
    public static ArrayList<Aluno> csvR(String caminho) {
        try {
            //Abrindo arquivo csv
            CsvReader alunos = new CsvReader(caminho);
            //Lê o cabeçalho
            alunos.readHeaders();
            //enquanto ainda é possivel ler do arquivo executa as linhas abaixo
            while (alunos.readRecord()) {

                Aluno aluno = new Aluno();

                aluno.setNome(alunos.get("nome"));
                aluno.setMatricula(Integer.parseInt(alunos.get("matricula")));
                aluno.setTelefone(alunos.get("telefone"));
                aluno.setEmail(alunos.get("email"));
                aluno.setUffmail(alunos.get("uffmail"));
                aluno.setStatus(alunos.get("status"));

                listaAlunos.add(aluno);
            }

            alunos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return listaAlunos;
    }

    /**
     *
     * @param caminho nome ou caminho do arquivo
     * @param alunos lista de alunos a ser escrita no arquivo.
     */
    public static void csvW(String caminho, ArrayList<Aluno> alunos) {

        // antes de abrir o arquivo, checa se ele já existe.
        boolean alreadyExists = new File(caminho).exists();

        try {
            // usa o construtor do FileWriter que especifica que está aberto para escrita.
            CsvWriter csvOutput = new CsvWriter(new FileWriter(caminho, true), ',');

            // se o arquivo não existe, escreve a linha do cabeçalho.
            if (!alreadyExists) {
                csvOutput.write("nome");
                csvOutput.write("matricula");
                csvOutput.write("telefone");
                csvOutput.write("email");
                csvOutput.write("uffmail");
                csvOutput.write("status");
                csvOutput.endRecord();
            }
            // caso contrário assume que o arquivo existe.
            Aluno aluno;
            // escreve todos os elementos da lista no arquivo.
            for (int i = 0; i < alunos.size(); i++) {
                aluno = alunos.get(i);
                csvOutput.write(aluno.getNome());
                csvOutput.write(Integer.toString(aluno.getMatricula()));
                csvOutput.write(aluno.getTelefone());
                csvOutput.write(aluno.getEmail());
                csvOutput.write(aluno.getUffmail());
                csvOutput.write(aluno.getStatus());
                csvOutput.endRecord();
            }
            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param matricula matricula do aluno a ser buscado.
     * @param alunos lista de alunos a ser consultada.
     * @return retorna aluno da lista de alunos com a matrícula informada.
     *
     */
    public static Aluno consulta(int matricula, ArrayList<Aluno> alunos) {
        
        if (alunos == null){
            return null;
        }
        
        int tamanho = alunos.size();
        Aluno aluno;
        for (int i = 0; i < tamanho; i++) {
            aluno = alunos.get(i);
            if (matricula == aluno.getMatricula()) {
                return aluno;
            }
        }
        return null;
    }

    /**
     *
     * @param matricula matricula do aluno a ser atualizado.
     * @param alunos lista de alunos a ser atualizada
     * @param uffm novo uffmail a ser adicionado ao aluno dentro da lista
     * @return retorna lista de alunos atualizada com o aluno com o novo uffmail
     */
    public static void atualizaAluno(int matricula, ArrayList<Aluno> alunos, String uffm) {

        if (alunos != null) {
            int tamanho = alunos.size();

            for (int i = 0; i < tamanho; i++) {
                if (matricula == alunos.get(i).getMatricula()) {
                    alunos.get(i).setUffmail(uffm);
                }
            }
        }
    }
}
