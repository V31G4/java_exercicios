package ttet.exerciciosjava.exerciciointermediario02;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FormularioMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Formulario formulario = new Formulario();
        List<String> dadosCadastrais = new ArrayList<>();

        String nome;
        do {
            System.out.print("Digite seu Nome: ");
            nome = scanner.nextLine();
            if (!formulario.verificarNome(nome)) {
                System.out.println("Nome inválido. Por favor, insira um nome válido.");
            }
        } while (!formulario.verificarNome(nome));
        dadosCadastrais.add("Nome: " + nome);

        String sobrenome;
        do {
            System.out.print("Digite seu Sobrenome: ");
            sobrenome = scanner.nextLine();
            if (!formulario.verificarSobrenome(sobrenome)) {
                System.out.println("Sobrenome inválido. Por favor, insira um sobrenome válido.");
            }
        } while (!formulario.verificarSobrenome(sobrenome));
        dadosCadastrais.add("Sobrenome: " + sobrenome);

        String cpf;
        do {
            System.out.print("Digite seu CPF (xxx.xxx.xxx-xx): ");
            cpf = scanner.nextLine();
            if (!formulario.verificarCPF(cpf)) {
                System.out.println("CPF inválido. Por favor, insira um CPF válido no formato xxx.xxx.xxx-xx.");
            }
        } while (!formulario.verificarCPF(cpf));
        dadosCadastrais.add("CPF: " + cpf);

        String email;
        do {
            System.out.print("Digite seu Email: ");
            email = scanner.nextLine();
            if (!formulario.verificarEmail(email)) {
                System.out.println("Email inválido. Por favor, insira um email válido.");
            }
        } while (!formulario.verificarEmail(email));
        dadosCadastrais.add("Email: " + email);

        System.out.println("\nDados Cadastrais:");
        for (String dado : dadosCadastrais) {
            System.out.println(dado);
        }

        scanner.close();
    }
}
