/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

/**
 *
 * @author ricardo
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DadosPessoais dados = new DadosPessoais();
        OperacoesBancarias conta = new OperacoesBancarias();

        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Informar dados pessoais");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Realizar retirada");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    dados.informarDadosPessoais(scanner);
                    break;
                case 2:
                    conta.consultarSaldo();
                    break;
                case 3:
                    System.out.print("Informe o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.realizarDeposito(valorDeposito);
                    break;
                case 4:
                    System.out.print("Informe o valor da retirada: ");
                    double valorRetirada = scanner.nextDouble();
                    conta.realizarRetirada(valorRetirada);
                    break;
                case 5:
                    System.out.println("Saindo da aplicação. Adeus!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}

class DadosPessoais {
    private String nome;
    private String sobrenome;
    private String cpf;

    public void informarDadosPessoais(Scanner scanner) {
        System.out.print("Informe o nome: ");
        nome = scanner.next();
        System.out.print("Informe o sobrenome: ");
        sobrenome = scanner.next();
        System.out.print("Informe o CPF: ");
        cpf = scanner.next();
    }
}

class OperacoesBancarias {
    private double saldo;

    public OperacoesBancarias() {
        saldo = 0.0;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public void realizarDeposito(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    public void realizarRetirada(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para a retirada.");
        }
    }
}
