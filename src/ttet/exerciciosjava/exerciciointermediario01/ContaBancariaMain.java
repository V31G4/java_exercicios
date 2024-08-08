package ttet.exerciciosjava.exerciciointermediario01;

import java.util.Scanner;

public class ContaBancariaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Criar Conta");
            System.out.println("2. Buscar Conta");
            System.out.println("3. Verificar Saldo");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Transferir");
            System.out.println("7. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    // Criar nova conta
                    sc.nextLine(); // Limpa o buffer do scanner
                    System.out.print("Digite o nome do titular: ");
                    String titular = sc.nextLine();

                    System.out.print("Digite o número da conta: ");
                    int numeroConta = sc.nextInt();

                    ContaBancaria novaConta = new ContaBancaria(titular, numeroConta);
                    System.out.println("Conta criada com sucesso para " + titular);
                    break;

                case 2:
                    // Buscar conta
                    System.out.print("Digite o número da conta: ");
                    int numeroContaBusca = sc.nextInt();

                    ContaBancaria contaEncontrada = ContaBancaria.buscarConta(numeroContaBusca);
                    if (contaEncontrada != null) {
                        System.out.println("Conta encontrada: " + contaEncontrada.getTitular());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    // Verificar Saldo
                    System.out.print("Digite o número da conta: ");
                    int numeroContaSaldo = sc.nextInt();

                    ContaBancaria contaSaldo = ContaBancaria.buscarConta(numeroContaSaldo);
                    if (contaSaldo != null) {
                        System.out.println("Saldo atual: " + contaSaldo.verificarSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    // Depositar
                    System.out.print("Digite o número da conta: ");
                    int numeroContaDeposito = sc.nextInt();

                    ContaBancaria contaDeposito = ContaBancaria.buscarConta(numeroContaDeposito);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor do depósito: ");
                        double valorDeposito = sc.nextDouble();
                        contaDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    // Sacar
                    System.out.print("Digite o número da conta: ");
                    int numeroContaSaque = sc.nextInt();

                    ContaBancaria contaSaque = ContaBancaria.buscarConta(numeroContaSaque);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor do saque: ");
                        double valorSaque = sc.nextDouble();
                        contaSaque.sacar(valorSaque);
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 6:
                    // Transferir
                    System.out.print("Digite o número da conta de origem: ");
                    int numeroContaOrigem = sc.nextInt();

                    ContaBancaria contaOrigem = ContaBancaria.buscarConta(numeroContaOrigem);
                    if (contaOrigem != null) {
                        System.out.print("Digite o número da conta de destino: ");
                        int numeroContaDestino = sc.nextInt();

                        ContaBancaria contaDestino = ContaBancaria.buscarConta(numeroContaDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor da transferência: ");
                            double valorTransferencia = sc.nextDouble();
                            contaOrigem.transferir(contaDestino, valorTransferencia);
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Conta de destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta de origem não encontrada.");
                    }
                    break;

                case 7:
                    // Sair
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);

        sc.close();
    }
}