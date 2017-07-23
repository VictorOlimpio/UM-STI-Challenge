/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import core.Aluno;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor
 */
public class CsvRWTest {
    
    public CsvRWTest() {
    }
    
    /**
     * Test of csvR method, of class CsvRW.
     */
    @Test
    public void testCsvR() {
        System.out.println("csvR");
        String caminho = "";
        ArrayList<Aluno> expResult = null;
        ArrayList<Aluno> result = CsvRW.csvR(caminho);
        assertEquals(expResult, result);
    }

    /**
     * Test of csvW method, of class CsvRW.
     */
    @Test
    public void testCsvW() {
        System.out.println("csvW");
        String caminho = "";
        ArrayList<Aluno> alunos = null;
        CsvRW.csvW(caminho, alunos);
    }

    /**
     * Test of consulta method, of class CsvRW.
     */
    @Test
    public void testConsulta() {
        System.out.println("consulta");
        int matricula = 0;
        ArrayList<Aluno> alunos = null;
        Aluno expResult = null;
        Aluno result = CsvRW.consulta(matricula, alunos);
        assertEquals(expResult, result);
    }

    /**
     * Test of atualizaAluno method, of class CsvRW.
     */
    @Test
    public void testAtualizaAluno() {
        System.out.println("atualizaAluno");
        int matricula = 0;
        ArrayList<Aluno> alunos = null;
        String uffm = "";
        CsvRW.atualizaAluno(matricula, alunos, uffm);
    }
    
}
