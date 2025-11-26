package menus;

import controllers.AnimalController;
import controllers.ProprietarioController;
import controllers.ConsultaController;
import controllers.VeterinarioController;
import models.Animal;
import models.Consulta;
import models.Proprietario;
import models.Veterinario;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner sc = new Scanner(System.in);

    // Criação dos Controllers
    private final AnimalController animalController = new AnimalController();
    private final ProprietarioController proprietarioController = new ProprietarioController();
    private final ConsultaController consultaController = new ConsultaController();
    private final VeterinarioController veterinarioController = new VeterinarioController();

    // Criação dos Menus, passando os controllers
    private final MenuProprietario menuProprietario = new MenuProprietario(proprietarioController);
    private final MenuAnimal menuAnimal = new MenuAnimal(animalController, proprietarioController);
    private final MenuConsulta menuConsulta = new MenuConsulta(animalController, consultaController);
    private final MenuVeterinario menuVeterinario = new MenuVeterinario(veterinarioController);

    public void mostrarMenuPrincipal() {
        int opcao;

        do {
            System.out.println("\n=== Clinica Veterinária ===");
            System.out.println("1. Menu Animal");
            System.out.println("2. Menu Consulta");
            System.out.println("3. Menu Proprietário");
            System.out.println("4. Menu Veterinário");
            System.out.println("5. Imprimir Relatório");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    //Chama o método mostrarMenuAnimal da classe MenuAnimal.
                    menuAnimal.mostrarMenuAnimal();
                    break;
                case 2:
                    //Chama o método mostrarMenuConsulta da classe MenuConsulta.
                    menuConsulta.mostrarMenuConsulta();
                    break;
                case 3:
                    //Chama o método mostrarMenuProprietario da classe MenuProprietario.
                    menuProprietario.mostrarMenuProprietario();
                    break;
                case 4:
                    //Chama o método mostrarVeterinario da classe MenuVeterinario.
                    menuVeterinario.mostrarMenuVeterinario();
                    break;
                case 5:
                    //Chama o método imprimirRelatorio.
                    imprimirRelatorioGeral();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    private void imprimirRelatorioGeral() {
        System.out.println("\n===================== RELATÓRIO GERAL =====================");

        //PROPRIETÁRIOS
        System.out.println("\n--- Proprietários Cadastrados ---");
        List<Proprietario> proprietarios = proprietarioController.list();
        if (proprietarios.isEmpty()) {
            System.out.println("Nenhum proprietário cadastrado.");
        } else {
            for (Proprietario p : proprietarios) {
                System.out.println(
                        "ID: " + p.getId() +
                                " | Nome: " + p.getNome() +
                                " | Telefone: " + p.getTelefone() +
                                " | Endereço: " + p.getEndereco()
                );
            }
        }

        //VETERINÁRIOS
        System.out.println("\n--- Veterinários Cadastrados ---");
        List<Veterinario> vets = veterinarioController.list();
        if (vets.isEmpty()) {
            System.out.println("Nenhum veterinário cadastrado.");
        } else {
            for (Veterinario v : vets) {
                System.out.println(
                        "ID: " + v.getId() +
                                " | Nome: " + v.getNome() +
                                " | Telefone: " + v.getTelefone() +
                                " | CRMV: " + v.getCrmv()
                );
            }
        }

        //ANIMAIS
        System.out.println("\n--- Animais Cadastrados ---");
        List<Animal> animais = animalController.list();
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal a : animais) {
                System.out.println(
                        "ID: " + a.getId() +
                                " | Espécie: " + a.getClass().getSimpleName() +
                                " | Nome: " + a.getNome() +
                                " | Idade: " + a.getIdade() +
                                " | Dono (ID): " + a.getProprietarioId()
                );
            }
        }

        //CONSULTAS
        System.out.println("\n--- Consultas Cadastradas ---");
        List<Consulta> consultas = consultaController.list();
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada.");
        } else {
            for (Consulta c : consultas) {
                System.out.println(
                        "ID: " + c.getId() +
                                " | Animal ID: " + c.getAnimalId() +
                                " | Veterinário ID: " + c.getVeterinarioId() +
                                " | Data: " + c.getData()
                               );
            }
        }

        System.out.println("\n===========================================================");
    }

}
