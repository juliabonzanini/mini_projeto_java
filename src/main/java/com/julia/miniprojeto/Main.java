package com.julia.miniprojeto;

import java.util.ArrayList;
import java.util.Scanner;

// classe principal para instanciar a farmacia
public class Main {
    public static void main(String[] args) {

        // criacao da instancia da farmacia
        Farmacia farmacia = new Farmacia();

        // adicona medicamentos
        farmacia.adicionarMedicamento(new Medicamento("Paracetamol", 50, 10.0));
        farmacia.adicionarMedicamento(new Medicamento("Ibuprofeno", 30, 15.0));
        farmacia.adicionarMedicamento(new Medicamento("Cetoprofeno", 20, 20.0));
        farmacia.adicionarMedicamento(new Medicamento("Dipirona", 60, 12.5));
        farmacia.adicionarMedicamento(new Medicamento("Omeprazol", 40, 18.5));

        // adiciona funcionarios
        farmacia.adicionarFuncionario(new Funcionario("A"));
        farmacia.adicionarFuncionario(new Funcionario("B"));
        farmacia.adicionarFuncionario(new Funcionario("C"));
        farmacia.adicionarFuncionario(new Funcionario("D"));
        farmacia.adicionarFuncionario(new Funcionario("E"));


        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Listar medicamentos");
            System.out.println("2 - Listar funcionários");
            System.out.println("3 - Comprar medicamento");
            System.out.println("4 - Limpar tudo");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer de entrada

            switch (opcao) {
                case 1:
                    System.out.println("\nLista de medicamentos:");
                    farmacia.listarMedicamentos();
                    break;

                case 2:
                    System.out.println("\nLista de funcionarios:");
                    farmacia.listarFuncionarios();
                    break;

                case 3:
                    System.out.println("\nInforme o nome do medicamento:");
                    String nomeMedicamento = scanner.nextLine();

                    System.out.println("Informe o nome do funcionario:");
                    String nomeFuncionario = scanner.nextLine();

                    System.out.println("Informe a quantidade:");
                    int quantidade = scanner.nextInt();

                    farmacia.comprarMedicamento(nomeMedicamento, nomeFuncionario, quantidade);
                    break;

                case 4:
                    farmacia.limparTudo();
                    System.out.println("\nTodos os dados foram limpos.");
                    break;

                case 5:
                    System.out.println("\nSaindo do programa...");
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();

    }
}
