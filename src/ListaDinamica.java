package src;

/**
 * Implementação de uma lista dinâmica encadeada simples.
 * Esta classe utiliza objetos da classe No para armazenar dados de forma
 * dinâmica na memória, permitindo crescimento sem tamanho fixo.
 * @author João Vitor Novaes, João Vitor Camargo e Henrique C. Barros
 * @version 2.0
 */
public class ListaDinamica implements ListaOperacoes {
    No inicio;

    /**
     * Construtor da lista. Inicializa a lista com um nó vazio (sentinela).
     */
    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista criada com sucesso!");
    }

    /**
     * Percorre a lista e exibe os conteúdos de todos os nós conectados.
     */
    public void exibir() {
        No aux = this.inicio;
        System.out.print("Lista atual: ");
        while (aux != null && aux.getConteudo() != null) {
            System.out.print(aux.getConteudo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    /**
     * Remove todos os nós que contenham o elemento especificado,
     * reajustando os ponteiros da lista.
     * * @param elemento O texto a ser buscado e removido.
     * @return O total de ocorrências removidas.
     */
    @Override
    public int removerTodas(String elemento) {
        int contador = 0;
        if (!existeInicio()) return 0;

        while (this.inicio != null && this.inicio.getConteudo() != null && this.inicio.getConteudo().equalsIgnoreCase(elemento)) {
            this.inicio = this.inicio.getProx();
            contador++;
        }

        No atual = this.inicio;
        while (atual != null && atual.getProx() != null) {
            if (atual.getProx().getConteudo() != null && atual.getProx().getConteudo().equalsIgnoreCase(elemento)) {
                atual.setProx(atual.getProx().getProx());
                contador++;
            } else {
                atual = atual.getProx();
            }
        }

        System.out.println("Foram removidas " + contador + " ocorrências de '" + elemento + "'.");
        exibir();
        return contador;
    }

    /**
     * Conta a quantidade de nós válidos (não nulos) na lista.
     * @return Total de elementos encontrados.
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
     * Busca o conteúdo de um nó baseado em seu índice lógico.
     * @param indice Posição desejada (começando em 0).
     * @return O valor da String no nó ou null se o índice for inválido.
     */
    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= contar()) {
            System.out.println("Erro: Índice " + indice + " fora dos limites.");
            return null;
        }
        No aux = this.inicio;
        for (int i = 0; i < indice; i++) {
            aux = aux.getProx();
        }
        return aux.getConteudo();
    }

    /**
     * Adiciona uma sequência de elementos ao final da lista encadeada.
     * @param elementos Array de Strings a serem inseridas.
     * @return Quantidade de elementos adicionados com sucesso.
     */
    @Override
    public int adicionarVarios(String[] elementos) {
        if (elementos == null || elementos.length == 0) return 0;

        int contador = 0;
        for (String s : elementos) {
            if (inserir(contar(), s)) contador++;
        }
        System.out.println(contador + " elementos adicionados.");
        exibir();
        return contador;
    }

    /**
     * Insere um novo nó em uma posição específica, ajustando as referências dos nós vizinhos.
     * @param indice Posição de inserção.
     * @param elemento Conteúdo do novo nó.
     * @return true se a operação foi concluída, false para índices inválidos.
     */
    @Override
    public boolean inserir(int indice, String elemento) {
        int totalElementos = contar();

        if (indice < 0 || indice > totalElementos) {
            System.out.println("Falha ao inserir: índice " + indice + " inválido.");
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
            System.out.println("Elemento '" + elemento + "' inserido no início.");
            exibir();
            return true;
        }

        No aux = this.inicio;
        for (int i = 0; i < indice - 1; i++) {
            aux = aux.getProx();
        }

        novo.setProx(aux.getProx());
        aux.setProx(novo);

        System.out.println("Elemento '" + elemento + "' inserido no índice " + indice + ".");
        exibir();
        return true;
    }

    /**
     * Desconecta um nó da lista em um índice específico e retorna seu valor.
     * @param indice Posição do nó a ser removido.
     * @return O conteúdo do nó removido ou null caso não exista.
     */
    @Override
    public String removerPorIndice(int indice) {
        int total = contar();

        if (indice < 0 || indice >= total) {
            System.out.println("Impossível remover: índice " + indice + " inexistente.");
            return null;
        }

        String elementoRemovido;

        if (indice == 0) {
            elementoRemovido = this.inicio.getConteudo();
            this.inicio = this.inicio.getProx();
            System.out.println("'" + elementoRemovido + "' removido da posição 0.");
            exibir();
            return elementoRemovido;
        }

        No anterior = this.inicio;
        for (int i = 0; i < indice - 1; i++) {
            anterior = anterior.getProx();
        }

        No alvo = anterior.getProx();
        elementoRemovido = alvo.getConteudo();
        anterior.setProx(alvo.getProx());

        System.out.println("'" + elementoRemovido + "' removido da posição " + indice + ".");
        exibir();
        return elementoRemovido;
    }

    /**
     * Reinicializa a lista, desconectando todos os nós existentes.
     */
    @Override
    public void limpar() {
        this.inicio = new No(null);
        System.out.println("Lista esvaziada.");
        exibir();
    }

    /**
     * Localiza o índice da última ocorrência de um elemento percorrendo os nós.
     * @param elemento O texto a ser buscado.
     * @return O índice da última ocorrência ou -1 se não encontrado.
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
        return ultimoIndice;
    }

    /**
     * Percorre a lista contando quantas vezes um elemento aparece.
     * @param elemento Termo de busca.
     * @return Total de ocorrências encontradas.
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
        return contador;
    }

    /**
     * Substitui o valor de todos os nós que contenham o termo antigo pelo novo termo.
     * @param antigo Valor a ser substituído.
     * @param novo Novo valor a ser gravado no nó.
     * @return Quantidade de alterações realizadas.
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
        System.out.println("Substituídas " + mudancas + " ocorrências de '" + antigo + "' por '" + novo + "'.");
        exibir();
        return mudancas;
    }

    /**
     * Valida se a lista possui ao menos um nó de dados inicializado.
     * @return true se o início não for nulo e contiver dados.
     */
    public boolean existeInicio() {
        return this.inicio != null && this.inicio.getConteudo() != null;
    }
}