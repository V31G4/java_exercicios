package ttet.exerciciosjava.exerciciointermediario01;

import java.util.ArrayList;

public class ContaBancaria {
    String titular;
    int numeroConta;
    double saldo;

    static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public ContaBancaria(String titular, int numeroConta) {
        if (titular == null || titular.isEmpty()) {
            throw new IllegalArgumentException("Titular não pode ser vazio.");
        }
        if (numeroConta <= 0) {
            throw new IllegalArgumentException("Número da conta deve ser positivo.");
        }
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;

        contas.add(this);

        System.out.println("Conta criada com sucesso para " + titular);
    }

    public String getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
    }

    public double verificarSaldo() {
        return this.saldo;
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        if (this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    public static ContaBancaria buscarConta(int numeroConta) {
        for (ContaBancaria c : contas) {
            if (c.numeroConta == numeroConta) {
                return c;
            }
        }
        return null; // se não encontrar
    }
}
