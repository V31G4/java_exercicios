package ttet.exerciciosjava.exercicioavancado02;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Usuário");
            System.out.println("2. Buscar Usuário por Nome");
            System.out.println("3. Buscar Usuário por Email");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();

                Usuario usuario = new Usuario(id, nome, email, idade);
                try {
                    usuarioService.adicionarUsuario(usuario);
                    System.out.println("Usuário adicionado com sucesso!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro ao adicionar usuário: " + e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.print("Digite o nome do usuário: ");
                String nome = scanner.nextLine();
                Optional<Usuario> usuario = usuarioService.buscarUsuarioPorNome(nome);
                usuario.ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuário não encontrado ou nome inválido.")
                );
            } else if (opcao == 3) {
                System.out.print("Digite o email do usuário: ");
                String email = scanner.nextLine();
                Optional<Usuario> usuario = usuarioService.buscarUsuarioPorEmail(email);
                usuario.ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Usuário não encontrado.")
                );
            } else if (opcao == 4) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
