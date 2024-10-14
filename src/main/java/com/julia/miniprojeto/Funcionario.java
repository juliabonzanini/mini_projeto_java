package com.julia.miniprojeto;

// classe Funcionario representa um funcionario da farmacia com nome, bonus e salario base
public class Funcionario {
    private String nome;
    private int bonus;
    private double salarioBase;

    // construtor da classe Funcionario
    public Funcionario(String nome) {
        this.nome = nome;
        this.bonus = 0;
        this.salarioBase = 0.0;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    // aumenta o bonus do funcionario em 10 apos cada venda
    public void aumentarBonus() {
        this.bonus += 10;

        // a cada 30 de bonus, o salario base aumenta em 100 reais
        if (this.bonus % 30 == 0) {
            this.salarioBase += 100;
        }
    }

    // limpa o bonus do funcionario
    public void limparBonus() {
        this.bonus = 0;
    }

    // limpa o salario do funcionario
    public void limparSalario() {
        this.salarioBase = 0.0;
    }

}
