package menus;

import controllers.VeterinarioController;
import models.Proprietario;
import models.Veterinario;

import java.util.List;
import java.util.Scanner;

public class MenuVeterinario {

    //Criação do obejetos:
    private final Scanner sc = new Scanner(System.in);
    private final VeterinarioController veterinarioController;

    //Construtor
    public MenuVeterinario(VeterinarioController veterinarioController) {
        this.veterinarioController = veterinarioController;
    }

    //Método principal --> Menu que será chamado dentro da MAIN.
    public void mostrarMenuVeterinario() {
        int opcao;

        do {
            System.out.println("\n=== Clinica Veterinária ===");
            System.out.println("--- Menu Veterinário ---");
            System.out.println("1. Listar Veterinários");
            System.out.println("2. Criar Veterinário");
            System.out.println("3. Atualizar Veterinário");
            System.out.println("4. Deletar Veterinário");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    listarVeterinarios();
                    break;
                case 2:
                    criarVeterinario();
                    break;
                case 3:
                    atualizarVeterinario();
                    break;
                case 4:
                    deletarVeterinario();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }


    /**
     * Métodos do Menu Veterinário: Ações do sistema, integrado com os Controlles e Models
     * para dar vida ao sistema CRUD, Criar, Ler, Atualizar e Deletar.
     */

    //Listar Veterinários Cadastrados
    private void listarVeterinarios() {
        List<Veterinario> lista = veterinarioController.list();

        if (lista.isEmpty()) {
            System.out.println("\nNenhum veterinário cadastrado!");
            return;
        }

        System.out.println("\n=== Veterinários Cadastrados ===");
        for (Veterinario v : lista) {
            System.out.println(
                    "ID: " + v.getId() +
                            " | Nome: " + v.getNome() +
                            " | Telefone: " + v.getTelefone() +
                            " | CRMV: " + v.getCrmv()
            );
        }
        System.out.println("=================================");
    }

    //Criar Veterinários Cadastrados
    private void criarVeterinario() {

        System.out.println("\nCriar Veterinário:");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("CRMV: ");
        String crmv = sc.nextLine();


        Veterinario v = new Veterinario(0, nome, telefone, crmv);

        veterinarioController.create(v);

        System.out.println("Veterinário cadastrado com sucesso!");
    }

    //Atualizar Veterinários Cadastrados
    private void atualizarVeterinario() {

        System.out.println("\nAtualizar Veterinário");
        System.out.print("Informe o ID do veterinário: ");

        int id = sc.nextInt();
        sc.nextLine(); // -> Limpar Buffer(evita bugs).

        Veterinario existente = veterinarioController.findById(id);

        //Verifica se o ID digitado existe no sistema(Checagem de segurança para evitar erros).
        if (existente == null) {
            System.out.println("Veterinário não encontrado!");
            return;
        }

        System.out.println("Novo nome (" + existente.getNome() + "): ");
        String novoNome = sc.nextLine();
        if (!novoNome.isEmpty()) {
            existente.setNome(novoNome);
        }

        System.out.println("Novo telefone (" + existente.getTelefone() + "): ");
        String novoTelefone = sc.nextLine();
        if (!novoTelefone.isEmpty()) {
            existente.setTelefone(novoTelefone);
        }

        System.out.println("Novo CRMV (" + existente.getCrmv() + "): ");
        String novoCrmv = sc.nextLine();
        if (!novoCrmv.isEmpty()) {
            existente.setCrmv(novoCrmv);
        }

        veterinarioController.update(id, existente);

        System.out.println("Veterinário atualizado com sucesso!");
    }

    //Deletar Veterinários Cadastrados.
    private void deletarVeterinario() {

        System.out.println("\n=== Deletar Veterinário ===");
        System.out.print("ID do veterinário para deletar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Veterinario v = veterinarioController.findById(id);

        if (v == null) {
            System.out.println("Nenhum veterinário encontrado!");
            return;
        }

        /**
         * Parte de Confimação da exclusão do objeto.
         */
        System.out.print("Confirmar exclusão? (s/n): ");
        String c = sc.nextLine();

        //Condição que verifica se o usuário digitou "s".
        if (c.equalsIgnoreCase("s")) {
            veterinarioController.delete(id);
            System.out.println("Veterinário deletado!");
        } else {
            System.out.println("Operação cancelada!");
        }
    }
}
