package com.julia.miniprojeto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarmaciaTest {

    private Farmacia farmacia;
    private Medicamento medicamento;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
        farmacia = new Farmacia();
        medicamento = new Medicamento("Paracetamol", 100, 5.50);
        funcionario = new Funcionario("A");
        farmacia.adicionarMedicamento(medicamento);
        farmacia.adicionarFuncionario(funcionario);
    }

    @Test
    void testAdicionarMedicamento() {
        assertEquals(1, farmacia.getMedicamentos().size());
        assertEquals("Paracetamol", farmacia.getMedicamentos().get(0).getNome());
    }

    @Test
    void testAdicionarFuncionario() {
        assertEquals(1, farmacia.getFuncionarios().size());
        assertEquals("A", farmacia.getFuncionarios().get(0).getNome());
    }

    @Test
    void testComprarMedicamentoComSucesso() {
        farmacia.comprarMedicamento("Paracetamol", "A", 5);

        assertEquals(95, medicamento.getQuantidadeEstoque()); // verifica se o estoque foi reduzido
        assertEquals(27.5, farmacia.getLucro()); // verifica o lucro
        assertEquals(10, funcionario.getBonus()); // verifica o bonus do funcionario
    }

    @Test
    public void testComprarMedicamentoSemEstoqueSuficiente() {
        farmacia.comprarMedicamento("Paracetamol", "A", 120); // tentativa de compra acima do estoque
        assertEquals(100, medicamento.getQuantidadeEstoque()); // o estoque nao deve mudar
        assertEquals(0.0, farmacia.getLucro()); // o lucro nao deve mudar
        assertEquals(0, funcionario.getBonus()); // o bonus do funcionario nao deve aumentar
    }

    @Test
    public void testComprarMedicamentoNaoEncontrado() {
        farmacia.comprarMedicamento("Aspirina", "A", 5); // tentativa de compra de medicamento que nao existe
        assertEquals(100, medicamento.getQuantidadeEstoque()); // o estoque do medicamento existente nao deve mudar
        assertEquals(0.0, farmacia.getLucro()); // o lucro nao deve mudar
        assertEquals(0, funcionario.getBonus()); // o bonus do funcionario nao deve aumentar
    }

    @Test
    void testLimparTudo() {
        funcionario.setBonus(50);
        funcionario.setSalarioBase(200);
        farmacia.setLucro(1000);

        farmacia.limparTudo();
        assertEquals(0.0, farmacia.getLucro());
        assertEquals(0, funcionario.getBonus());
        assertEquals(0.0, funcionario.getSalarioBase());
    }

}
