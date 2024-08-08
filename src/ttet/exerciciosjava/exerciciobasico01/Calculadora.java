package ttet.exerciciosjava.exerciciobasico01;

import java.util.Scanner;

public class Calculadora {

    public void adicionar(double a, double b){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a: ");
        a = sc.nextDouble();
        System.out.print("Digite b: ");
        b = sc.nextDouble();
        double resultado = a + b;
        System.out.println("O resultado é "+ resultado);
    }

    public void subtrair(double a, double b){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a: ");
        a = sc.nextDouble();
        System.out.print("Digite b: ");
        b = sc.nextDouble();
        double resultado = a - b;
        System.out.println("O resultado é "+ resultado);
    }

    public void multiplicar(double a, double b){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a: ");
        a = sc.nextDouble();
        System.out.print("Digite b: ");
        b = sc.nextDouble();
        double resultado = a * b;
        System.out.println("O resultado é: "+ resultado);
    }

    public void dividir(double a, double b){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a: ");
        a = sc.nextDouble();
        System.out.print("Digite b: ");
        b = sc.nextDouble();
        double resultado = a / b;
        System.out.println("O resultado é: "+ resultado);
    }

}
