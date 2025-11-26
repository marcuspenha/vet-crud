package controllers;

import models.Consulta;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerencia as operações de CRUD (Criar, Ler, Atualizar, Deletar)
 * para a entidade {@link Consulta}.
 * <p>
 * Esta classe simula um banco de dados em memória usando uma {@link ArrayList},
 */
public class ConsultaController {

    // Simula o "banco de dados" de consultas, armazenando-as em memória.
    private List<Consulta> consultas = new ArrayList<>();

    // Gerador de ID sequencial para garantir que cada consulta tenha um ID único.
    private int contadorId = 1;

    /**
     * Adiciona uma nova consulta à lista.
     * O ID da consulta é gerado automaticamente por este método.
     *
     * @param c O objeto {@link Consulta} a ser cadastrado (vindo da interface).
     * @return A {@link Consulta} cadastrada, agora com o ID atribuído.
     */
    public Consulta create(Consulta c) {
        // Atribui o ID único e incrementa o contador global para a próxima
        c.setId(contadorId++);
        consultas.add(c);
        return c;
    }

    /**
     * Retorna a lista completa de todas as consultas cadastradas.
     *
     * @return Uma {@link List} de {@link Consulta}. Se nenhuma consulta for
     * cadastrada, retorna uma lista vazia.
     */
    public List<Consulta> list() {
        // A interface usará isso para exibir os relatórios.
        return consultas;
    }

    /**
     * Busca uma consulta específica pelo seu ID.
     *
     * @param id O ID da consulta a ser procurada.
     * @return O objeto {@link Consulta} encontrado ou {@code null} se não for encontrado.
     */
    public Consulta findById(int id) {
        // Itera pela lista para encontrar o item
        for (Consulta c : consultas) {
            if (c.getId() == id) {
                return c;
            }
        }
        // Retorna null se o loop terminar sem encontrar a consulta
        return null;
    }

    /**
     * Atualiza os dados de uma consulta existente com base no ID.
     *
     * @param id   O ID da consulta a ser atualizada.
     * @param nova Um objeto {@link Consulta} com os *novos* dados que
     * substituirão os antigos.
     * @return {@code true} se a atualização foi bem-sucedida,
     * {@code false} se a consulta não foi encontrada (ID inválido).
     */
    public boolean update(int id, Consulta nova) {
        // Reutiliza o método findById para localizar a consulta no "banco"
        Consulta existente = findById(id);

        // Validação: Se findById retornou null, a consulta não existe.
        if (existente == null) {
            return false;
        }

        // Atualiza os dados do objeto "existente" (que está na lista)
        // com os dados do objeto "nova" (que veio da interface).
        existente.setAnimalId(nova.getAnimalId());
        existente.setVeterinarioId(nova.getVeterinarioId());
        existente.setData(nova.getData());
        existente.setDescricao(nova.getDescricao());
        existente.setValor(nova.getValor());

        return true;
    }

    /**
     * Remove uma consulta da lista com base no ID.
     *
     * @param id O ID da consulta a ser removida.
     * @return {@code true} se a remoção foi bem-sucedida,
     * {@code false} se a consulta não foi encontrada.
     */
    public boolean delete(int id) {
        // Localiza a consulta que deve ser removida
        Consulta c = findById(id);

        // Se for nula, não há o que remover
        if (c == null) {
            return false;
        }

        // Usa o método .remove(Object) do ArrayList,
        // que retorna true se o objeto foi encontrado e removido.
        return consultas.remove(c);
    }
}