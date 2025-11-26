package menus;

//Importando Controllers
import controllers.AnimalController;
import controllers.ProprietarioController;

//Importando Models
import models.Animal;
import models.Cachorro;
import models.Gato;
import models.Proprietario;

//Outras importações
import java.util.List;
import java.util.Scanner;

//Objeto Menu da Interface animais
public class MenuAnimal {
    //Criando objeto scanner para entrada de dados(teclado)
    private final Scanner sc = new Scanner(System.in);

    private final AnimalController animalController;
    private final ProprietarioController proprietarioController;
    private final MenuProprietario menuProprietario;

    // Construtor recebendo controllers
    public MenuAnimal(AnimalController animalController, ProprietarioController proprietarioController) {
        this.animalController = animalController;
        this.proprietarioController = proprietarioController;
        this.menuProprietario = new MenuProprietario(proprietarioController);
    }

    //Métodos
    public void mostrarMenuAnimal() {
        int opcao;
        do {
            System.out.println("\n=== Clinica Veterinária ===");
            System.out.println("---- Gerenciar Animais ----");
            System.out.println("1. Listar Animais");
            System.out.println("2. Adicionar Animais");
            System.out.println("3. Atualizar Animais");
            System.out.println("4. Deletar Animais");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    listarAnimais();
                    break;
                case 2:
                    menuAdicionarAnimais();
                    break;
                case 3:
                    atualizarAnimal();
                    break;
                case 4:
                    deletarAnimal();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    //Método de listagem de animais cadas
    private void listarAnimais() {


        List<Animal> lista = animalController.list();

        //Verifica se a lista de animais está vazia.
        if (lista.isEmpty()) {
            System.out.println("\nNão há nenhum animal cadastrado!");
        } else {
            System.out.println("\n=================== Animais Cadastrados ====================");
            for (Animal a : lista) {
                System.out.println(
                        "ID: " + a.getId() +
                                " | Espécie: " + a.getClass().getSimpleName() +
                                " | Nome: " + a.getNome() +
                                " | Idade: " + a.getIdade() +
                                " | Dono (ID): " + a.getProprietarioId()
                );
            }
            System.out.println("===================================================================");
        }


    }


    public void menuAdicionarAnimais() {
        int opcao2;
        do {
            System.out.println("\n=== Adicionar Animais ===");
            System.out.println("1. Adicionar Cachorro");
            System.out.println("2. Adicionar Gato");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao2 = sc.nextInt();
            sc.nextLine();

            switch (opcao2) {
                case 1:
                    adicionarCachorro();
                    break;
                case 2:
                    adicionarGato();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao2 != 0);
    }

    public void adicionarCachorro() {
        System.out.println("\n=== Adicionar Cachorro ===");
        Cachorro cachorro = new Cachorro();

        System.out.print("Nome: ");
        cachorro.setNome(sc.nextLine());

        System.out.print("Idade: ");
        while (!sc.hasNextInt()) {
            System.out.print("Digite uma idade válida: ");
            sc.next();
        }
        cachorro.setIdade(sc.nextInt());
        sc.nextLine();

        System.out.print("Sexo: ");
        cachorro.setSexo(sc.nextLine());

        System.out.print("Raça: ");
        cachorro.setRaca(sc.nextLine());

        // Cria ou seleciona proprietário
        Proprietario proprietario = menuProprietario.criarProprietario();
        cachorro.setProprietarioId(proprietario.getId());

        animalController.create(cachorro);
        System.out.println("Animal Cadastrado Com Sucesso!");
    }

    public void adicionarGato() {
        System.out.println("\n=== Adicionar Gato ===");
        Gato gato = new Gato();

        System.out.print("Nome: ");
        gato.setNome(sc.nextLine());

        System.out.print("Idade: ");
        while (!sc.hasNextInt()) {
            System.out.print("Digite uma idade válida: ");
            sc.next();
        }
        gato.setIdade(sc.nextInt());
        sc.nextLine();

        System.out.print("Sexo: ");
        gato.setSexo(sc.nextLine());

        System.out.print("Raça: ");
        gato.setRaca(sc.nextLine());

        Proprietario proprietario = menuProprietario.criarProprietario();
        gato.setProprietarioId(proprietario.getId());

        animalController.create(gato);
        System.out.println("Animal Cadastrado Com Sucesso!");
    }

    public void atualizarAnimal() {

        System.out.println("\n=== Atualizar Animal ===");

        System.out.print("Digite o ID do animal que deseja atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Animal animal = animalController.findById(id);

        if (animal == null) {
            System.out.println("Nenhum animal encontrado com esse ID!");
            return;
        }

        System.out.println("\nAnimal encontrado:");
        System.out.println(
                "ID: " + animal.getId() +
                        " | Espécie: " + animal.getClass().getSimpleName() +
                        " | Nome: " + animal.getNome() +
                        " | Idade: " + animal.getIdade() +
                        " | Dono (ID): " + animal.getProprietarioId()
        );

        boolean modificou = false;

        //Atualizar Nome
        System.out.print("Novo nome (ou ENTER para não alterar): ");
        String novoNome = sc.nextLine();
        if (!novoNome.trim().isEmpty()) {
            animal.setNome(novoNome);
            modificou = true;
        }

        //Atualizar Idade
        System.out.print("Nova idade (ou ENTER para não alterar): ");
        String idadeStr = sc.nextLine();
        if (!idadeStr.trim().isEmpty()) {
            try {
                int novaIdade = Integer.parseInt(idadeStr);
                animal.setIdade(novaIdade);
                modificou = true;
            } catch (NumberFormatException e) {
                System.out.println("Idade inválida. Ignorando alteração de idade.");
            }
        }

        //Atualizar Sexo
        System.out.print("Novo sexo (ou ENTER para não alterar): ");
        String novoSexo = sc.nextLine();
        if (!novoSexo.trim().isEmpty()) {
            animal.setSexo(novoSexo);
            modificou = true;
        }

        //Atualizar Raça
        System.out.print("Nova raça (ou ENTER para não alterar): ");
        String novaRaca = sc.nextLine();
        if (!novaRaca.trim().isEmpty()) {
            if (animal instanceof Cachorro) {
                ((Cachorro) animal).setRaca(novaRaca);
                modificou = true;
            } else if (animal instanceof Gato) {
                ((Gato) animal).setRaca(novaRaca);
                modificou = true;
            }
        }

        //Atualizar Proprietário
        System.out.print("Deseja atualizar o proprietário? (s/n): ");
        String attProp = sc.nextLine();

        if (attProp.equalsIgnoreCase("s")) {
            Proprietario novoProp = menuProprietario.criarProprietario();
            animal.setProprietarioId(novoProp.getId());
            modificou = true;
        }

        if (!modificou) {
            System.out.println("\nNenhuma alteração foi realizada!");
            return;
        }

        //Atualiza no controller
        animalController.update(animal.getId(), animal);
        System.out.println("\nAnimal atualizado com sucesso!");
    }

    public void deletarAnimal() {

        System.out.println("\n=== Deletar Animal ===");

        System.out.print("Digite o ID do animal que deseja deletar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Animal animal = animalController.findById(id);

        if (animal == null) {
            System.out.println("Nenhum animal encontrado com esse ID!");
            return;
        }

        System.out.println("\nAnimal encontrado:");
        System.out.println(
                "ID: " + animal.getId() +
                        " | Espécie: " + animal.getClass().getSimpleName() +
                        " | Nome: " + animal.getNome() +
                        " | Idade: " + animal.getIdade() +
                        " | Dono (ID): " + animal.getProprietarioId()
        );

        System.out.print("\nTem certeza que deseja deletar este animal? (s/n): ");
        String confirm = sc.nextLine();

        if (!confirm.equalsIgnoreCase("s")) {
            System.out.println("Operação cancelada.");
            return;
        }

        animalController.delete(id);
        System.out.println("Animal deletado com sucesso!");
    }

}
