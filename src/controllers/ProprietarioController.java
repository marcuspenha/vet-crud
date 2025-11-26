package controllers;

import models.Proprietario;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia as operações de CRUD (Criar, Ler, Atualizar, Deletar)
 * para a entidade {@link Proprietario}.
 * <p>
 * Esta classe simula um banco de dados em memória para os proprietários
 * dos animais.
 */
public class ProprietarioController {

    // Lista que simula o banco de dados, armazenando todos os proprietários.
    private List<Proprietario> proprietarios = new ArrayList<>();

    // Gerador de ID sequencial para garantir que cada proprietário tenha um ID único.
    private int contadorId = 1;

    /**
     * Adiciona um novo proprietário à lista.
     * O ID é gerado automaticamente pelo controller.
     *
     * @param p O objeto {@link Proprietario} a ser cadastrado (vindo da interface).
     * @return O {@link Proprietario} cadastrado, agora com o ID atribuído.
     */
    public Proprietario create(Proprietario p) {
        // Define o ID único e incrementa o contador para o próximo
        p.setId(contadorId++);
        proprietarios.add(p);
        return p;
    }

    /**
     * Retorna a lista completa de todos os proprietários cadastrados.
     *
     * @return Uma {@link List} de {@link Proprietario}.
     */
    public List<Proprietario> list() {
        return proprietarios;
    }

    /**
     * Busca um proprietário específico na lista pelo seu ID.
     * <p>
     * Este método é crucial para a interface validar se um
     * proprietário existe antes de vincular um animal a ele.
     *
     * @param id O ID do proprietário a ser procurado.
     * @return O objeto {@link Proprietario} encontrado ou {@code null} se não for encontrado.
     */
    public Proprietario findById(int id) {
        // Itera pela lista de proprietários
        for (Proprietario p : proprietarios) {
            if (p.getId() == id) {
                return p; // Retorna o objeto assim que encontrar
            }
        }
        return null; // Retorna null se o loop terminar sem encontrar
    }

    /**
     * Atualiza os dados de um proprietário existente com base no ID.
     *
     * @param id   O ID do proprietário a ser atualizado.
     * @param novo Um objeto {@link Proprietario} com os *novos* dados.
     * @return {@code true} se a atualização foi bem-sucedida,
     * {@code false} se o proprietário não foi encontrado.
     */
    public boolean update(int id, Proprietario novo) {
        // Reutiliza o findById para localizar o proprietário a ser editado
        Proprietario existente = findById(id);

        // Se for nulo, o proprietário não existe na lista
        if (existente == null) {
            return false;
        }

        // Atualiza os dados do objeto "existente" (que está na lista)
        existente.setNome(novo.getNome());
        existente.setTelefone(novo.getTelefone());
        existente.setEndereco(novo.getEndereco());

        return true;
    }

    /**
     * Remove um proprietário da lista com base no ID.
     * <p>
     * Atenção: No estado atual, isso NÃO remove os animais vinculados
     * a este proprietário, o que pode gerar inconsistência nos dados (animais órfãos).
     *
     * @param id O ID do proprietário a ser removido.
     * @return {@code true} se a remoção foi bem-sucedida,
     * {@code false} se o proprietário não foi encontrado.
     */
    public boolean delete(int id) {
        // Localiza o proprietário que deve ser removido
        Proprietario p = findById(id);

        if (p == null) {
            return false; // Não encontrou, não pode remover
        }

        // O método .remove(Object) do ArrayList retorna true se conseguiu remover
        return proprietarios.remove(p);
    }
}