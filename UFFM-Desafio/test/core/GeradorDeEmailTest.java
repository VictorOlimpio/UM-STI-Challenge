/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor
 */
public class GeradorDeEmailTest {
    
    public GeradorDeEmailTest() {
    }
    
    /**
     * Test of gerador method, of class GeradorDeEmail.
     */
    @Test
    public void testGerador() {
        System.out.println("gerador");
        String nome = "";
        ArrayList<Aluno> alunos = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = GeradorDeEmail.gerador(nome, alunos);
        assertEquals(expResult, result);
    }

    /**
     * Test of checagemDeEmailGerado method, of class GeradorDeEmail.
     */
    @Test
    public void testChecagemDeEmailGerado() {
        System.out.println("checagemDeEmailGerado");
        String conta = "";
        ArrayList<Aluno> alunos = null;
        boolean expResult = false;
        boolean result = GeradorDeEmail.checagemDeEmailGerado(conta, alunos);
        assertEquals(expResult, result);
    }
    
}
