package src;

import java.util.Arrays;

/**
 * Implementação de uma lista linear baseada em um vetor (array) estático.
 * Esta classe gerencia Strings e realiza operações de deslocamento manual
 * para inserções e remoções.
 * @author João Vitor Novaes, João Vitor Camargo e Henrique C. Barros
 * @version 2.0
 */
public class ListaSimples implements ListaOperacoes {
    private String[] lista;

    /**
     * Construtor que define o tamanho máximo da lista.
     * @param tamanho Capacidade máxima de elementos.
     * @throws IllegalArgumentException se o tamanho for menor ou igual a zero.
     */
    public ListaSimples(int tamanho) {
        if (tamanho <= 0) throw new IllegalArgumentException();
        this.lista = new String[tamanho];
    }

    /**
     * Exibe no console o estado atual da lista, omitindo posições nulas.
     */
    public void exibir() {
        String[] aux;
        aux = new String[contar()];
        for (String s : lista) {
            for (int j = 0; j < aux.length; j++) {
                if (s != null && aux[j] == null) {
                    aux[j] = s;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(aux));
    }

    /**
     * Remove todas as ocorrências de um elemento específico no vetor.
     * @param elemento O texto a ser removido.
     * @return A quantidade total de itens que foram removidos.
     */
    @Override
    public int removerTodas(String elemento) {
        int contador = 0;
        for (int i = 0; i < lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equalsIgnoreCase(elemento)) {
                lista[i] = null;
                contador++;
            }
        }
        exibir();
        return contador;
    }

    /**
     * Realiza a contagem de elementos não nulos na lista.
     * @return O número total de elementos presentes.
     */
    @Override
    public int contar() {
        int contador = 0;
        for (String elemento : this.lista) {
            if (elemento != null) contador++;
        }
        return contador;
    }

    /**
     * Adiciona vários elementos sequencialmente nas próximas posições livres.
     * @param elementos Array de Strings com os novos dados.
     * @return Total de elementos adicionados antes da lista lotar.
     */
    @Override
    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for (String elemento : elementos) {
            for (int j = 0; j < this.lista.length; j++) {
                if (this.lista[j] == null) {
                    this.lista[j] = elemento;
                    contador++;
                    break;
                }
                if (j == this.lista.length - 1) {
                    exibir();
                    return contador;
                }
            }
        }
        exibir();
        return contador;
    }

    /**
     * Obtém o conteúdo de uma posição específica.
     * @param indice Posição do elemento.
     * @return Representação textual da posição ou null para índice inválido.
     */
    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= this.lista.length) return null;
        return "Lista[" + indice + "] :" + this.lista[indice];
    }

    /**
     * Insere um elemento em um índice específico, deslocando os sucessores para a direita.
     * @param indice Posição desejada.
     * @param elemento Texto a ser inserido.
     * @return true se a inserção foi bem-sucedida, false se a lista estiver cheia ou índice for inválido.
     */
    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= this.lista.length || contar() >= this.lista.length) {
            System.out.println("Elemento não inserido! (Lista cheia ou índice inválido)");
            exibir();
            return false;
        }

        for (int i = this.lista.length - 1; i > indice; i--) {
            this.lista[i] = this.lista[i - 1];
        }

        this.lista[indice] = elemento;
        System.out.println("Elemento '" + elemento + "' inserido com sucesso no índice " + indice + "!");
        exibir();
        return true;
    }

    /**
     * Remove o elemento de um índice específico e desloca os sucessores para a esquerda.
     * @param indice Posição do alvo.
     * @return O conteúdo removido ou null se o índice for inválido ou vazio.
     */
    @Override
    public String removerPorIndice(int indice) {
        if (indice < 0 || indice >= this.lista.length || this.lista[indice] == null) {
            System.out.println("Índice " + indice + " não encontrado ou está vazio.");
            return null;
        }

        String elementoRemovido = this.lista[indice];

        for (int i = indice; i < this.lista.length - 1; i++) {
            this.lista[i] = this.lista[i + 1];
        }

        this.lista[this.lista.length - 1] = null;
        System.out.println("Elemento '" + elementoRemovido + "' removido com sucesso.");
        exibir();
        return elementoRemovido;
    }

    /**
     * Remove todos os elementos da lista, preenchendo o vetor com null.
     */
    @Override
    public void limpar() {
        if (this.lista.length <= 0) {
            System.out.println("Lista já está limpa.");
        } else {
            Arrays.fill(this.lista, null);
            System.out.println("Lista esvaziada!");
        }
    }

    /**
     * Encontra a última posição de um determinado elemento.
     * @param elemento Texto a ser buscado.
     * @return O maior índice encontrado ou -1 caso não exista.
     */
    @Override
    public int ultimoIndiceDe(String elemento) {
        if (elemento == null) return -1;

        for (int i = this.lista.length - 1; i >= 0; i--) {
            if (this.lista[i] != null && this.lista[i].equalsIgnoreCase(elemento)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Conta quantas vezes um elemento aparece no vetor.
     * @param elemento Termo para comparação.
     * @return Frequência do elemento na lista.
     */
    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
        if (elemento == null) return 0;

        for (String item : this.lista) {
            if (item != null && item.equalsIgnoreCase(elemento)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Substitui todas as ocorrências de um termo antigo por um novo conteúdo.
     * @param antigo Termo a ser localizado.
     * @param novo Novo texto a ser gravado.
     * @return Quantidade de substituições ou -1 se o termo antigo não for encontrado.
     */
    @Override
    public int substituir(String antigo, String novo) {
        if (contarOcorrencias(antigo) == 0) return -1;

        int contador = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equalsIgnoreCase(antigo)) {
                this.lista[i] = novo;
                contador++;
            }
        }
        exibir();
        return contador;
    }

    /**
     * Verifica se existe ao menos um elemento não nulo na lista.
     * @return true se a lista contiver dados, false caso contrário.
     */
    public boolean estaCheio() {
        for (String elemento : this.lista) {
            if (elemento != null) return true;
        }
        return false;
    }
}