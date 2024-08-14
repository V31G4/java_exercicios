package ttet.exerciciosjava.exercicioavancado01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Biblioteca implements Gerenciavel {
    private final List<ItemBiblioteca> itens;

    public Biblioteca() {
        this.itens = new ArrayList<>();
    }

    @Override
    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
        System.out.println("Item '" + item.getTitulo() + "' adicionado à biblioteca.");
    }

    @Override
    public void removerItem(ItemBiblioteca item) throws ItemNaoEncontradoException {
        if (!itens.remove(item)) {
            throw new ItemNaoEncontradoException("O item '" + item.getTitulo() + "' não foi encontrado na biblioteca.");
        }
        System.out.println("Item '" + item.getTitulo() + "' removido da biblioteca.");
    }

    @Override
    public ItemBiblioteca buscarItem(String titulo) throws ItemNaoEncontradoException {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        throw new ItemNaoEncontradoException("O item com o título '" + titulo + "' não foi encontrado na biblioteca.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Item");
            System.out.println("2. Emprestar Item");
            System.out.println("3. Devolver Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Buscar Item");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o tipo de item (Livro/Periodico/MidiaDigital): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();

                    ItemBiblioteca item = null;
                    if (tipo.equalsIgnoreCase("Livro")) {
                        item = new Livro(titulo, autor);
                    } else if (tipo.equalsIgnoreCase("Periodico")) {
                        item = new Periodico(titulo, autor);
                    } else if (tipo.equalsIgnoreCase("MidiaDigital")) {
                        item = new MidiaDigital(titulo, autor);
                    }

                    if (item != null) {
                        biblioteca.adicionarItem(item);
                    } else {
                        System.out.println("Tipo de item inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o título do item a ser emprestado: ");
                    String tituloEmprestimo = scanner.nextLine();
                    try {
                        ItemBiblioteca itemEmprestimo = biblioteca.buscarItem(tituloEmprestimo);
                        itemEmprestimo.emprestar();
                    } catch (ItemNaoEncontradoException | ItemNaoDisponivelException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Digite o título do item a ser devolvido: ");
                    String tituloDevolucao = scanner.nextLine();
                    try {
                        ItemBiblioteca itemDevolucao = biblioteca.buscarItem(tituloDevolucao);
                        itemDevolucao.devolver();
                    } catch (ItemNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite o título do item a ser removido: ");
                    String tituloRemocao = scanner.nextLine();
                    try {
                        ItemBiblioteca itemRemocao = biblioteca.buscarItem(tituloRemocao);
                        biblioteca.removerItem(itemRemocao);
                    } catch (ItemNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Digite o título do item a ser buscado: ");
                    String tituloBusca = scanner.nextLine();
                    try {
                        ItemBiblioteca itemBusca = biblioteca.buscarItem(tituloBusca);
                        System.out.println("Item encontrado: " + itemBusca.getTitulo());
                    } catch (ItemNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    continuar = false;
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}