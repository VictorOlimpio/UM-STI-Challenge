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
    private static ArrayList<Aluno> alunosList = new ArrayList();

    public static ArrayList<Aluno> csvR(String path) {
        try {
            //Abrindo arquivo csv usando a biblioteca Csv Reader
            CsvReader alunos = new CsvReader(path);

            alunos.readHeaders();

            while (alunos.readRecord()) {
                Aluno aluno = new Aluno();
                aluno.setNome(alunos.get("nome"));
                aluno.setMatricula(Integer.parseInt(alunos.get("matricula")));
                aluno.setTelefone(alunos.get("telefone"));
                aluno.setEmail(alunos.get("email"));
                aluno.setUffmail(alunos.get("uffmail"));
                aluno.setStatus(alunos.get("status"));
                
                alunosList.add(aluno);
            }
            
            alunos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alunosList;
    }

    public static void csvW(String path) {

        // before we open the file check to see if it already exists
        boolean alreadyExists = new File(path).exists();

        try {
            // use FileWriter constructor that specifies open for appending
            CsvWriter csvOutput = new CsvWriter(new FileWriter(path, true), ',');

            // if the file didn't already exist then we need to write out the header line
            if (!alreadyExists) {
                csvOutput.write("id");
                csvOutput.write("name");
                csvOutput.endRecord();
            }
            // else assume that the file already has the correct header line

            // write out a few records
            csvOutput.write("1");
            csvOutput.write("Bruce");
            csvOutput.endRecord();

            csvOutput.write("2");
            csvOutput.write("John");
            csvOutput.endRecord();

            csvOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print() {
        System.out.println(alunosList.size());
        for (int i = 0; i < alunosList.size(); i++) {
            System.out.println(alunosList.get(i).toString());
        }
    }
    
    public static Aluno query(int matricula){
        int size = alunosList.size();
        Aluno aluno;
        for (int i = 0; i < size; i++) {
            aluno = alunosList.get(i);
            if(matricula == aluno.getMatricula()){
                return aluno;
            }
        }
        return null;
    }
}
