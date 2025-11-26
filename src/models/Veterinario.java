package models;

/**
 * Representa a entidade Veterinario.
 * <p>
 * Esta é uma classe "Model" ou "POJO" (Plain Old Java Object) que
 * armazena dados. Seus atributos são privados (Encapsulamento).
 */
public class Veterinario {
    //Atributos da classe
    private int id;
    private String nome;
    private String telefone;
    private String crmv; // Conselho Regional de Medicina Veterinária

    /**
     * Construtor da classe Veterinario.
     *
     * @param id       O ID (gerenciado pelo Controller).
     * @param nome     O nome do profissional.
     * @param telefone O telefone de contato.
     * @param crmv     O registro profissional (ex: "CRMV-SP 12345").
     */
    public Veterinario(int id, String nome, String telefone, String crmv) { //
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.crmv = crmv;
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

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    /**
     * Sobrescreve o método toString() padrão.
     *
     * @return Uma representação textual (String) do objeto Veterinario.
     */
    @Override
    public String toString() {
        // Usando String.format para uma saída mais limpa
        return String.format(
                "ID: %-3d | Nome: %-20s | Telefone: %-15s | CRMV: %s",
                id,
                nome,
                telefone,
                crmv
        );
    }
}