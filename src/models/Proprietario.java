package models;

/**
 * Representa a entidade Proprietario.
 * <p>
 * Esta é uma classe "Model" ou "POJO" (Plain Old Java Object) que
 * armazena dados. Seus atributos são privados (Encapsulamento).
 */
public class Proprietario {

    private int id;
    private String nome;
    private String telefone;
    private String endereco;

    /**
     * Construtor da classe Proprietario.
     *
     * @param id       O ID (gerenciado pelo Controller).
     * @param nome     O nome do proprietário.
     * @param telefone O telefone de contato.
     * @param endereco O endereço do proprietário.
     */
    public Proprietario(int id, String nome, String telefone, String endereco) { //
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    //Construtor Vazio.
    public Proprietario() {
    }
    // --- Getters e Setters ---

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Sobrescreve o método toString() padrão.
     *
     * @return Uma representação textual (String) do objeto Proprietario.
     */
    @Override
    public String toString() {
        // Usando String.format para uma saída mais limpa
        return String.format(
                "ID: %-3d | Nome: %-20s | Telefone: %-15s | Endereço: %s",
                id,
                nome,
                telefone,
                endereco
        );
    }
}