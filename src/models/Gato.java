package models;

/**
 * Representa a subclasse "Gato", demonstrando o pilar da
 * **HERANÇA**.
 * <p>
 * Esta classe {@code extends} (herda) todos os atributos e métodos
 * da superclasse {@link Animal}.
 */
public class Gato extends Animal { //

    /**
     * Construtor da classe Gato.
     * <p>
     * ALTERAÇÃO ESTRUTURAL:
     * Agora recebe o 'proprietarioId' e o repassa para o construtor
     * da superclasse 'Animal' (usando {@code super()}).
     *
     * @param id             O ID do animal (gerenciado pelo Controller).
     * @param nome           O nome do gato.
     * @param idade          A idade do gato.
     * @param proprietarioId O ID do {@link Proprietario} dono deste gato.
     */
    public Gato(int id, String nome, int idade, String sexo, float peso,  String raca, int proprietarioId) {
        // Chama o construtor de Animal(id, nome, idade, especie, proprietarioId)
        super(id, nome, idade, sexo, peso, "Gato", raca, proprietarioId); //
    }

    //Construtor Vazio.
    public Gato() {
    }

    /**
     * Implementação concreta do método abstrato da superclasse.
     * Isto é um exemplo claro de **POLIMORFISMO**.
     * <p>
     * Agora retorna "Miau!" em vez de imprimir no console,
     * respeitando a separação de responsabilidades.
     *
     * @return A String que representa o som do gato.
     */
    @Override
    public String emitirSom() {
        return "Miau!"; //
    }

    /**
     * Sobrescreve o método toString() para fornecer uma representação
     * textual específica para Gato.
     *
     * @return Uma String formatada para exibição em listas/relatórios.
     */
    @Override
    public String toString() {
        // Usa os getters (getId(), getNome()) herdados da classe Animal
        return String.format(
                "ID: %-3d | Espécie: Gato     | Nome: %-15s | Idade: %-2d | Dono (ID): %d",
                getId(),
                getNome(),
                getIdade(),
                getProprietarioId()
        );
    }
}