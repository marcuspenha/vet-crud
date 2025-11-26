package menus;

import controllers.ProprietarioController;
import models.Proprietario;

import java.util.List;
import java.util.Scanner;

public class MenuProprietario {

    private final Scanner sc = new Scanner(System.in);
    private final ProprietarioController proprietarioController;

    public MenuProprietario(ProprietarioController proprietarioController) {
        this.proprietarioController = proprietarioController;
    }

    public void mostrarMenuProprietario() {
        int opcao;

        do {
            System.out.println("\n=== Clinica Veterinária ===");
            System.out.println("--- Menu Proprietário ---");
            System.out.println("1. Listar Proprietários");
            System.out.println("2. Criar Proprietário");
            System.out.println("3. Deletar Proprietário");
            System.out.println("4. Atualizar Proprietário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    listarProprietarios();
                    break;
                case 2:
                    criarProprietario();
                    break;
                case 3:
                    deletarProprietario();
                    break;
                case 4:
                    atualizarProprietario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void listarProprietarios() {
        List<Proprietario> lista = proprietarioController.list();

        if (lista.isEmpty()) {
            System.out.println("\nNenhum proprietário cadastrado!");
        } else {
            System.out.println("\n=== Proprietários Cadastrados ===");
            for (Proprietario p : lista) {
                System.out.println(
                        "ID: " + p.getId() +
                                " | Nome: " + p.getNome() +
                                " | Telefone: " + p.getTelefone() +
                                " | Endereço: " + p.getEndereco()
                );
            }
            System.out.println("===================================");
        }
    }

    public Proprietario criarProprietario() {
        Proprietario proprietario = new Proprietario();

        System.out.println("\nCriar Proprietário:");
        System.out.print("Nome: ");
        proprietario.setNome(sc.nextLine());

        System.out.print("Telefone: ");
        proprietario.setTelefone(sc.nextLine());

        System.out.print("Endereço: ");
        proprietario.setEndereco(sc.nextLine());

        proprietarioController.create(proprietario);

        System.out.println("Proprietário Cadastrado!");
        return proprietario;
    }

    private void deletarProprietario() {
        System.out.print("\nInforme o ID do proprietário que deseja deletar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Proprietario p = proprietarioController.findById(id);

        if (p == null) {
            System.out.println("Proprietário não encontrado!");
            return;
        }

        System.out.println("Tem certeza que deseja deletar o proprietário '" + p.getNome() + "'? (s/n)");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("s")) {
            boolean sucesso = proprietarioController.delete(id);

            if (sucesso) {
                System.out.println("Proprietário deletado com sucesso!");
            } else {
                System.out.println("Erro ao deletar proprietário.");
            }
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private void atualizarProprietario() {
        System.out.println("\nAtualizar Proprietário");
        System.out.print("Informe o ID do proprietário: ");
        int id = sc.nextInt();
        sc.nextLine(); // limpar buffer

        Proprietario existente = proprietarioController.findById(id);

        if (existente == null) {
            System.out.println("Proprietário não encontrado!");
            return;
        }

        System.out.println("Novo nome (" + existente.getNome() + "): ");
        String novoNome = sc.nextLine();
        if (!novoNome.isEmpty()) existente.setNome(novoNome);

        System.out.println("Novo telefone (" + existente.getTelefone() + "): ");
        String novoTelefone = sc.nextLine();
        if (!novoTelefone.isEmpty()) existente.setTelefone(novoTelefone);

        System.out.println("Novo endereço (" + existente.getEndereco() + "): ");
        String novoEndereco = sc.nextLine();
        if (!novoEndereco.isEmpty()) existente.setEndereco(novoEndereco);

        proprietarioController.update(id, existente);

        System.out.println("Proprietário atualizado com sucesso!");
    }


}
