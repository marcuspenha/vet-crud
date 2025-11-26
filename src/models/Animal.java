package models;

/**
 * Representa a **Abstração** de um Animal na clínica.
 * <p>
 * Esta é uma classe {@code abstract}, o que significa que não pode ser
 * instanciada diretamente (você não pode criar um "new Animal()").
 * <p>
 * Ela serve como a **Superclasse** (pilar da Herança) para classes mais
 * específicas como {@link Cachorro} e {@link Gato}, definindo os atributos e
 * comportamentos comuns a todos os animais.
 * <p>
 * Todos os atributos são privados, demonstrando o **Encapsulamento**.
 */
public abstract class Animal {

    // Atributos da Classe
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private float peso;
    private String especie;
    private String raca;
    /**
     * Adicionado ID do proprietário para criar o relacionamento.
     * Isso permite que um Animal "saiba" quem é seu dono.
     */
    private int proprietarioId;

    /**
     * Construtor da classe base Animal.
     * Chamado pelas subclasses (Cachorro, Gato) para inicializar os atributos comuns.
     *
     * @param id             O ID do animal (será gerenciado pelo Controller).
     * @param nome           O nome do animal.
     * @param idade          A idade do animal.
     * @param especie        A espécie.
     * @param proprietarioId O ID do {@link Proprietario} dono deste animal.
     */
    public Animal(int id, String nome, int idade, String sexo, float peso, String especie, String raca, int proprietarioId) { //
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.peso = peso;
        this.especie = especie;
        this.raca = raca;
        this.proprietarioId = proprietarioId; //
    }

    //Construtor Vazio.
    public Animal() {
    }

    // --- Métodos Especiais (Getters e Setters) ---

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public float getPeso (){
        return peso;
    }

    public void setPeso (float peso){
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String raca () {
        return raca;
    }

    public void setRaca (String raca) {
        this.raca = raca;
    }

    public int getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(int proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    // --- Métodos de Comportamento ---

    /**
     * Método abstrato para demonstrar **Polimorfismo**.
     * <p>
     * Alterado de 'void' para 'String'.
     * O model não deve imprimir no console (System.out).
     * Ele deve retornar o dado (o som) para a Interface decidir
     * o que fazer com ele.
     * <p>
     * Por ser {@code abstract}, este método *obriga* todas as subclasses
     * (Cachorro, Gato) a implementarem sua própria versão.
     *
     * @return Uma String representando o som do animal.
     */
    public abstract String emitirSom(); //

    /**
     * Sobrescreve o método toString() padrão.
     * Útil para a interface listar os animais de forma
     * formatada no console.
     *
     * @return Uma representação textual (String) do objeto Animal.
     */
    @Override
    public String toString() {
        //Usando String.format para uma saída mais limpa
        return String.format(
                "ID: %-3d | Espécie: %-8s | Nome: %-15s | Idade: %-2d | Dono (ID): %d",
                id,
                especie,
                nome,
                idade,
                proprietarioId
        );
    }
}