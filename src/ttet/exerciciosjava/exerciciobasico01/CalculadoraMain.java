package ttet.exerciciosjava.exerciciobasico01;

import java.util.Scanner;

public class CalculadoraMain {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double a = 0;
        double b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite 1 para Adição, 2 para Subtração, 3 para Multiplicação, 4 para Divisão ou 5 para Sair: ");
        int num = sc.nextInt();
        switch (num){
            case 1:
                System.out.println("Adição");
                calculadora.adicionar(a,b);
            break;
            case 2:
                System.out.println("Subtração");
                calculadora.subtrair(a,b);
            break;
            case 3:
                System.out.println("Multiplicação");
                calculadora.multiplicar(a,b);
            break;
            case 4:
                System.out.println("Divisão");
                calculadora.dividir(a,b);
            break;
            case 5:
                System.out.println("Saindo...");
            break;
            default:
                System.out.println("Número inválido");
            break;
        }
    }
}
