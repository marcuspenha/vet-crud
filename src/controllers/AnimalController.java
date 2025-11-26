package controllers;

import models.Animal; // Importa a superclasse
import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia as operações de CRUD (Criar, Ler, Atualizar, Deletar)
 * para a entidade base {@link Animal} e suas subclasses (como {@link models.Cachorro} e {@link models.Gato}).
 * <p>
 * Esta classe demonstra polimorfismo ao armazenar diferentes tipos de animais
 * (Cachorro, Gato) em uma única lista de {@link Animal}.
 */
public class AnimalController {

    /**
     * Lista que simula o banco de dados, armazenando todos os animais (Cachorros, Gatos)
     * em memória.
     */
    private List<Animal> animais = new ArrayList<>();

    /**
     * Gerador de ID sequencial para garantir que cada animal tenha um ID único.
     */
    private int contadorId = 1;

    /**
     * Adiciona um novo animal (seja Cachorro ou Gato) à lista.
     * O ID é gerado automaticamente pelo controller.
     *
     * @param animal O objeto {@link Animal} (ou sua subclasse) a ser cadastrado.
     * @return O {@link Animal} cadastrado, agora com o ID atribuído.
     */
    public Animal create(Animal animal) {
        // Define o ID único e incrementa o contador para o próximo
        animal.setId(contadorId++);
        animais.add(animal);
        return animal;
    }

    /**
     * Retorna a lista completa de todos os animais cadastrados.
     *
     * @return Uma {@link List} de {@link Animal}.
     */
    public List<Animal> list() {
        return animais;
    }

    /**
     * Busca um animal específico na lista pelo seu ID.
     *
     * @param id O ID do animal a ser procurado.
     * @return O objeto {@link Animal} encontrado (pode ser um Cachorro ou Gato)
     * ou {@code null} se não for encontrado.
     */
    public Animal findById(int id) {
        // Loop "for-each" para percorrer a lista de animais
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a; // Retorna o objeto assim que encontrar
            }
        }
        return null; // Retorna null se o loop terminar sem encontrar
    }

    /**
     * Atualiza os dados de um animal existente com base no ID.
     * <p>
     * ALTERAÇÃO ESTRUTURAL:
     * Adicionado 'setProprietarioId' para refletir a mudança no model.
     * Isso permite que a interface possa alterar o dono de um animal.
     *
     * @param id         O ID do animal a ser atualizado.
     * @param novoAnimal Um objeto {@link Animal} com os *novos* dados.
     * @return {@code true} se a atualização foi bem-sucedida,
     * {@code false} se o animal não foi encontrado.
     */
    public boolean update(int id, Animal novoAnimal) {
        // Reutiliza o findById para localizar o animal a ser editado
        Animal existente = findById(id);

        // Se for nulo, o animal não existe na lista
        if (existente == null) {
            return false;
        }

        // Atualiza os dados do objeto "existente" (que está na lista)
        existente.setNome(novoAnimal.getNome());
        existente.setIdade(novoAnimal.getIdade());
        existente.setSexo(novoAnimal.getSexo());
        existente.setEspecie(novoAnimal.getEspecie());
        existente.setSexo(novoAnimal.getSexo());
        existente.setPeso(novoAnimal.getPeso());

        // Atualiza o ID do proprietário, permitindo a transferência do animal
        existente.setProprietarioId(novoAnimal.getProprietarioId());

        return true;
    }

    /**
     * Remove um animal da lista com base no ID.
     *
     * @param id O ID do animal a ser removido.
     * @return {@code true} se a remoção foi bem-sucedida,
     * {@code false} se o animal não foi encontrado.
     */
    public boolean delete(int id) {
        // Localiza o animal que deve ser removido
        Animal a = findById(id);

        if (a == null) {
            return false; // Não encontrou, não pode remover
        }

        // O método .remove(Object) do ArrayList retorna true se conseguiu remover
        return animais.remove(a);
    }
}