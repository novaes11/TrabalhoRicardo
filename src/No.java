package src;

/**
 * Representa a unidade básica (nó) de uma lista encadeada.
 * Cada objeto desta classe armazena um dado textual e uma referência
 * para o próximo nó na sequência.
 * @author João Vitor Novaes, João Vitor Camargo e Henrique C. Barros
 * @version 1.0
 */
public class No {
    No prox;
    String conteudo;

    /**
     * Construtor que inicializa o nó com um conteúdo específico.
     * Por padrão, o ponteiro para o próximo nó é definido como nulo.
     * * @param conteudo O texto a ser armazenado no nó.
     */
    public No(String conteudo) {
        this.prox = null;
        this.conteudo = conteudo;
    }

    /**
     * Recupera a referência para o próximo nó da lista.
     * * @return O objeto No que sucede este na lista, ou null se for o último.
     */
    public No getProx() {
        return prox;
    }

    /**
     * Define ou altera a referência para o próximo nó, estabelecendo o encadeamento.
     * * @param prox O objeto No que deve vir após este.
     */
    public void setProx(No prox) {
        this.prox = prox;
    }

    /**
     * Recupera o valor textual armazenado neste nó.
     * * @return A String contida no nó.
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Altera o conteúdo textual armazenado neste nó.
     * * @param conteudo O novo texto a ser armazenado.
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}