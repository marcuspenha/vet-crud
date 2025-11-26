package menus;

import controllers.AnimalController;
import controllers.ConsultaController;
import models.Animal;
import models.Consulta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MenuConsulta {

    private final Scanner sc = new Scanner(System.in);

    private final ConsultaController consultaController;
    private final AnimalController animalController;

    // Construtor recebe os controllers já existentes
    public MenuConsulta(AnimalController animalController, ConsultaController consultaController) {
        this.animalController = animalController;
        this.consultaController = consultaController;
    }

    public void mostrarMenuConsulta() {
        int opcao;

        do {
            System.out.println("\n=== Menu de Consultas ===");
            System.out.println("--- Gerenciar Consulta ---");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Cancelar Consulta");
            System.out.println("3. Listar Consultas");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    agendarConsulta();
                    break;
                case 2:
                    cancelarConsulta();
                    break;
                case 3:
                    listarConsultas();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void agendarConsulta() {
        System.out.println("\n=== Agendar Consulta ===");

        // Lista os animais cadastrados para escolher
        List<Animal> animais = animalController.list();
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado. Cadastre antes de agendar.");
            return;
        }

        System.out.println("Animais disponíveis:");
        for (Animal a : animais) {
            System.out.println("ID: " + a.getId() + " | Nome: " + a.getNome());
        }

        System.out.print("Digite o ID do animal: ");
        int animalId = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o ID do veterinário: ");
        int vetId = sc.nextInt();
        sc.nextLine();

        System.out.print("Data da consulta (dd/MM/yyyy): ");
        String dataStr = sc.nextLine();
        LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        System.out.print("Valor da consulta: R$ ");
        double valor = sc.nextDouble();
        sc.nextLine();

        Consulta consulta = new Consulta(0, animalId, vetId, data, descricao, valor);
        consultaController.create(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    private void cancelarConsulta() {
        System.out.println("\n=== Cancelar Consulta ===");
        listarConsultas();

        System.out.print("Digite o ID da consulta a cancelar: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean sucesso = consultaController.delete(id);
        if (sucesso) {
            System.out.println("Consulta cancelada com sucesso!");
        } else {
            System.out.println("ID não encontrado.");
        }
    }

    private void listarConsultas() {
        System.out.println("\n=== Consultas Agendadas ===");
        List<Consulta> lista = consultaController.list();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
            return;
        }
        for (Consulta c : lista) {
            System.out.println(c);
        }
    }
}
