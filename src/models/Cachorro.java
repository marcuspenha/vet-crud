package models;

/**
 * Representa a subclasse "Cachorro", demonstrando o pilar da
 * **HERANÇA**.
 * <p>
 * Esta classe {@code extends} (herda) todos os atributos e métodos
 * da superclasse {@link Animal}.
 */
public class Cachorro extends Animal { //

    /**
     * Construtor da classe Cachorro.
     * <p>
     * ALTERAÇÃO ESTRUTURAL:
     * Agora recebe o 'proprietarioId' e o repassa para o construtor
     * da superclasse 'Animal' (usando {@code super()}).
     *
     * @param id             O ID do animal (gerenciado pelo Controller).
     * @param nome           O nome do cachorro.
     * @param idade          A idade do cachorro.
     * @param proprietarioId O ID do {@link Proprietario} dono deste cachorro.
     */
    public Cachorro(int id, String nome, int idade, String sexo, float peso, String raca, int proprietarioId) {
        // Chama o construtor de Animal(id, nome, idade, especie, proprietarioId)
        super(id, nome, idade, sexo, peso, "Cachorro", raca, proprietarioId); //
    }

    public Cachorro() {
        super();
    }

    /**
     * Implementação concreta do método abstrato da superclasse.
     * Isto é um exemplo claro de **POLIMORFISMO**.
     * <p>
     * ALTERAÇÃO ESTRUTURAL:
     * Agora retorna "Au Au!" em vez de imprimir no console,
     * respeitando a separação de responsabilidades.
     *
     * @return A String que representa o som do cachorro.
     */
    @Override
    public String emitirSom() {
        return "Au Au!"; //
    }

    /**
     * Sobrescreve o método toString() para fornecer uma representação
     * textual específica para Cachorro.
     *
     * @return Uma String formatada para exibição em listas/relatórios.
     */
    @Override
    public String toString() {
        // Usa os getters (getId(), getNome()) herdados da classe Animal
        return String.format(
                "ID: %-3d | Espécie: Cachorro | Nome: %-15s | Idade: %-2d | Dono (ID): %d",
                getId(),
                getNome(),
                getIdade(),
                getProprietarioId()
        );
    }
}