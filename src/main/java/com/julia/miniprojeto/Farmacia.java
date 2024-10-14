package com.julia.miniprojeto;

import java.util.ArrayList;

// classe Farmacia representa uma farmacia com lucro, lista de medicamentos e lista de funcionarios
public class Farmacia {
    private double lucro;
    private ArrayList<Medicamento> medicamentos;
    private ArrayList<Funcionario> funcionarios;

    // construtor da classe Farmacia
    public Farmacia() {
        this.lucro = 0.0;
        this.medicamentos = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
    }

    // getters e setters
    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    // adiciona medicamentos a farmacia
    public void adicionarMedicamento(Medicamento medicamento) {
        this.medicamentos.add(medicamento);
    }

    // adiciona funcionarios a farmacia
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    // funcao para comprar um medicamento, removendo do estoque e atualizando o lucro
    public void comprarMedicamento(String nomeMedicamento, String nomeFuncionario, int quantidade) {
        Medicamento medicamentoEncontrado = null;
        Funcionario funcionarioEncontrado = null;
        int i = 0;
        int j = 0;

        // procura o medicamento pelo nome
        while (i < medicamentos.size() && medicamentoEncontrado == null) {
            if (medicamentos.get(i).getNome().equals(nomeMedicamento)) {
                medicamentoEncontrado = medicamentos.get(i); // armazena o objeto Medicamento encontrado
            }
            i++;
        }

        // procura o funcionario pelo nome
        while (j < funcionarios.size() && funcionarioEncontrado == null) {
            if (funcionarios.get(j).getNome().equals(nomeFuncionario)) {
                funcionarioEncontrado = funcionarios.get(j); // armazena o objeto Funcionario encontrado
            }
            j++;
        }

        // verifica se o medicamento foi encontrado e se ha estoque suficiente
        if (medicamentoEncontrado != null && medicamentoEncontrado.getQuantidadeEstoque() >= quantidade) {
            // atualiza o estoque do medicamento
            medicamentoEncontrado.setQuantidadeEstoque(medicamentoEncontrado.getQuantidadeEstoque() - quantidade);
            // adiciona o valor da compra ao lucro da farmacia
            this.lucro += medicamentoEncontrado.getPreco() * quantidade;
            // aumenta o bonus do funcionario em 10
            funcionarioEncontrado.aumentarBonus();
            System.out.println("\nCompra realizada com sucesso.");
        } else {
            // medicamento nao encontrado ou sem estoque suficiente
            System.out.println("\nMedicamento nao encontrado ou estoque insuficiente.");
        }
    }

    // funcao para listar todos os medicamentos e seus precos
    public void listarMedicamentos() {
        for (int i = 0; i < medicamentos.size(); i++) {
            Medicamento medicamento = medicamentos.get(i);
            System.out.println("Medicamento: " + medicamento.getNome() + " - Preço: R$ " + medicamento.getPreco());
        }
    }

    // funcao para listar todos os funcionarios e seus bonus
    public void listarFuncionarios() {
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            System.out.println("Funcionário: " + funcionario.getNome() + " - Bônus: " + funcionario.getBonus() + " - Salário Base: R$ " + funcionario.getSalarioBase());
        }
    }

    // funcao para limpar o bonus de todos os funcionarios e o lucro da farmacia
    public void limparTudo() {

        // limpa o lucro da farmacia
        this.lucro = 0.0;

        // limpa o bonus e o salario de todos os funcionarios
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            funcionario.limparBonus();
            funcionario.limparSalario();
        }
    }

}
