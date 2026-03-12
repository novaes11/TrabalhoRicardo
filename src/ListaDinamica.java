package src;

/**
 * Implementação de uma Lista Dinâmica Encadeada Simples.
 * * @author Henrique C. Barros
 * @version 1.0
 */
public class ListaDinamica implements ListaOperacoes {
    No inicio;

    /**
     * Construtor da lista. Inicializa a lista com um nó vazio (sentinela).
     */
    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("[INFO] Lista criada com sucesso!");
    }

    /**
     * Exibe todos os elementos da lista no console.
     */
    public void exibir() {
        No aux = this.inicio;
        System.out.print("[LISTA] ");
        while (aux != null && aux.getConteudo() != null) {
            System.out.print(aux.getConteudo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    /**
     * Remove todas as ocorrências de um elemento específico.
     * @param elemento O texto a ser removido.
     * @return A quantidade de elementos removidos.
     */
    @Override
    public int removerTodas(String elemento) {
        // Implementação futura
        return 0;
    }

    /**
     * Conta o total de elementos presentes na lista.
     * @return O número total de nós com conteúdo.
     */
    @Override
    public int contar() {
        if (!existeInicio()) return 0;

        int contador = 1;
        No aux = this.inicio;
        while (aux.getProx() != null) {
            aux = aux.getProx();
            contador++;
        }
        return contador;
    }

    /**
     * Recupera o conteúdo de um nó em uma posição específica.
     * @param indice A posição desejada.
     * @return O conteúdo ou null se o índice for inválido.
     */
    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= contar()) {
            System.out.println("[ERRO] Índice " + indice + " fora dos limites.");
            return null;
        }
        No aux = this.inicio;
        for (int i = 0; i < indice; i++) {
            aux = aux.getProx();
        }
        return aux.getConteudo();
    }

    /**
     * Adiciona múltiplos elementos ao final da lista.
     * @param elementos Array de Strings a serem adicionadas.
     * @return Quantidade de elementos adicionados com sucesso.
     */
    @Override
    public int adicionarVarios(String[] elementos) {
        if (elementos == null || elementos.length == 0) return 0;

        int contador = 0;
        for (String s : elementos) {
            // Reaproveitando a lógica de inserir no final para simplificar
            if (inserir(contar(), s)) contador++;
        }
        System.out.println("[INFO] " + contador + " elementos adicionados.");
        return contador;
    }

    /**
     * Insere um novo elemento em qualquer posição da lista.
     * @param indice Posição de inserção.
     * @param elemento Conteúdo a ser inserido.
     * @return true se inserido com sucesso.
     */
    @Override
    public boolean inserir(int indice, String elemento) {
        int totalElementos = contar();

        if (indice < 0 || indice > totalElementos) {
            System.out.println("[ERRO] Falha ao inserir: índice " + indice + " inválido.");
            return false;
        }

        No novo = new No(elemento);

        if (indice == 0) {
            if (!existeInicio()) {
                this.inicio = novo;
            } else {
                novo.setProx(this.inicio);
                this.inicio = novo;
            }
            System.out.println("[OK] Elemento '" + elemento + "' inserido no início.");
            return true;
        }

        No aux = this.inicio;
        for (int i = 0; i < indice - 1; i++) {
            aux = aux.getProx();
        }

        novo.setProx(aux.getProx());
        aux.setProx(novo);

        System.out.println("[OK] Elemento '" + elemento + "' inserido no índice " + indice + ".");
        return true;
    }

    /**
     * Remove um elemento de uma posição específica.
     * @param indice Posição do alvo.
     * @return O conteúdo que foi removido.
     */
    @Override
    public String removerPorIndice(int indice) {
        int total = contar();

        if (indice < 0 || indice >= total) {
            System.out.println("[ERRO] Impossível remover: índice " + indice + " inexistente.");
            return null;
        }

        String elementoRemovido;

        if (indice == 0) {
            elementoRemovido = this.inicio.getConteudo();
            this.inicio = this.inicio.getProx();
            System.out.println("[REMOVE] '" + elementoRemovido + "' removido da posição 0.");
            return elementoRemovido;
        }

        No anterior = this.inicio;
        for (int i = 0; i < indice - 1; i++) {
            anterior = anterior.getProx();
        }

        No alvo = anterior.getProx();
        elementoRemovido = alvo.getConteudo();
        anterior.setProx(alvo.getProx());

        System.out.println("[REMOVE] '" + elementoRemovido + "' removido da posição " + indice + ".");
        return elementoRemovido;
    }

    /**
     * Limpa a lista completamente.
     */
    @Override
    public void limpar() {
        this.inicio = new No(null);
        System.out.println("[INFO] Lista esvaziada.");
    }

    /**
     * Busca a última ocorrência de um elemento na lista.
     * @param elemento Conteúdo a ser buscado.
     * @return O último índice encontrado ou -1.
     */
    @Override
    public int ultimoIndiceDe(String elemento) {
        No aux = this.inicio;
        int indiceAtual = 0;
        int ultimoIndice = -1;

        while (aux != null && aux.getConteudo() != null) {
            if (aux.getConteudo().equals(elemento)) {
                ultimoIndice = indiceAtual;
            }
            aux = aux.getProx();
            indiceAtual++;
        }
        System.out.println("[BUSCA] Última ocorrência de '" + elemento + "' está no índice: " + ultimoIndice);
        return ultimoIndice;
    }

    /**
     * Conta quantas vezes um elemento aparece na lista.
     * @param elemento O conteúdo alvo.
     * @return Total de ocorrências.
     */
    @Override
    public int contarOcorrencias(String elemento) {
        No aux = this.inicio;
        int contador = 0;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(elemento)) {
                contador++;
            }
            aux = aux.getProx();
        }
        System.out.println("[COUNT] O elemento '" + elemento + "' aparece " + contador + " vezes.");
        return contador;
    }

    /**
     * Substitui o conteúdo de todas as ocorrências de um termo por outro.
     * @param antigo Termo a ser substituído.
     * @param novo Novo conteúdo.
     * @return Quantidade de substituições realizadas.
     */
    @Override
    public int substituir(String antigo, String novo) {
        No aux = this.inicio;
        int mudancas = 0;
        while (aux != null) {
            if (aux.getConteudo() != null && aux.getConteudo().equals(antigo)) {
                aux.setConteudo(novo);
                mudancas++;
            }
            aux = aux.getProx();
        }
        System.out.println("[SUBST] Substituídas " + mudancas + " ocorrências de '" + antigo + "' por '" + novo + "'.");
        return mudancas;
    }

    /**
     * Verifica se o primeiro nó da lista possui conteúdo.
     * @return true se o início existe e não é nulo.
     */
    public boolean existeInicio() {
        return this.inicio != null && this.inicio.getConteudo() != null;
    }
}