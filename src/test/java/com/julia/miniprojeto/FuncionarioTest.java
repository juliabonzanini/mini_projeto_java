package com.julia.miniprojeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        funcionario = new Funcionario("A");
    }

    @Test
    void testAumentarBonus() {
        funcionario.aumentarBonus();
        assertEquals(10, funcionario.getBonus());
        funcionario.aumentarBonus();
        assertEquals(20, funcionario.getBonus());
        funcionario.aumentarBonus();
        assertEquals(30, funcionario.getBonus());
        assertEquals(100, funcionario.getSalarioBase()); // verifica se o salario aumentou
    }

    @Test
    void testLimparBonus() {
        funcionario.setBonus(50);
        funcionario.limparBonus();
        assertEquals(0, funcionario.getBonus()); // verifica se limpou o bonus
    }

    @Test
    void testLimparSalario() {
        funcionario.setSalarioBase(200);
        funcionario.limparSalario();
        assertEquals(0.0, funcionario.getSalarioBase()); // verifica se limpou o salario
    }

}