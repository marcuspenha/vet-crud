package controllers;

import models.Animal;
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
        for (Animal a : animais) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
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
        Animal existente = findById(id);

        if (existente == null) {
            return false;
        }

        existente.setNome(novoAnimal.getNome());
        existente.setIdade(novoAnimal.getIdade());
        existente.setSexo(novoAnimal.getSexo());
        existente.setEspecie(novoAnimal.getEspecie());
        existente.setSexo(novoAnimal.getSexo());
        existente.setPeso(novoAnimal.getPeso());
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
        Animal a = findById(id);

        if (a == null) {
            return false;
        }

        return animais.remove(a);
    }
}
