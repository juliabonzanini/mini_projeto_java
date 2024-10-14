package com.julia.miniprojeto;

// classe Medicamento representa um medicamento com nome, quantidade em estoque e preco
public class Medicamento {
    private String nome;
    private int quantidadeEstoque;
    private double preco;

    // construtor da classe Medicamento
    public Medicamento(String nome, int quantidadeEstoque, double preco) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
