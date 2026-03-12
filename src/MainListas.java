package src;

public class MainListas {
    public static void main(String[] args) {
        // 1. Instanciação das duas listas
        // A simples com limite de 10, a dinâmica começa vazia.
        ListaOperacoes listaSimples = new ListaSimples(10);
        ListaOperacoes listaDinamica = new ListaDinamica();

        System.out.println("====================================================");
        System.out.println("   COMPARAÇÃO DAS LISTAS");
        System.out.println("====================================================");

        // Executando testes na Lista Simples (Vetor)
        System.out.println("\n==LISTA SIMPLES==");
        testar(listaSimples);


        // Executando testes na Lista Dinâmica (Nós)
        System.out.println("\n== LISTA DINÂMICA ==");
        testar(listaDinamica);

        System.out.println("\n====================================================");
        System.out.println("   FIM DOS TESTES");
        System.out.println("====================================================");
    }

    /**
     * Este metodo recebe as duas classe que implementam ListaOperacoes.
     * Isso permite testar ambas as listas com o exato mesmo fluxo.
     */
    public static void testar(ListaOperacoes lista) {
        // 1. Adicionar Vários
        String[] nomes = {"Ana", "Carlos", "Alberto", "Ana", "Pedro"};
        System.out.println("--- Adicionando elementos iniciais ---");
        lista.adicionarVarios(nomes);
        imprimirEstado(lista);

        // 2. Inserir em posição específica
        System.out.println("\n--- Inserindo 'Zeca' no índice 2 ---");
        lista.inserir(2, "Zeca");
        imprimirEstado(lista);

        // 3. Contar Ocorrências
        System.out.println("\n--- Verificando duplicatas ---");
        int qtdAna = lista.contarOcorrencias("Ana");
        System.out.println("Ocorrências de 'Ana': " + qtdAna);

        // 4. Substituir
        System.out.println("\n--- Substituindo 'Ana' por 'Maria' ---");
        lista.substituir("Ana", "Maria");
        imprimirEstado(lista);

        // 5. Último Índice
        System.out.println("\n--- Localizando última 'Maria' ---");
        int ultimo_indice = lista.ultimoIndiceDe("Maria");
        System.out.println("Último índice encontrado: " + ultimo_indice);

        // 6. Remover por Índice
        System.out.println("\n--- Removendo elemento do índice 3 ---");
        lista.removerPorIndice(3);
        imprimirEstado(lista);

        // 7. Obter
        System.out.println("\n--- Consultando índice 0 ---");
        System.out.println("Conteúdo: " + lista.obter(0));

        // 8. Limpar
        System.out.println("\n--- Resetando lista ---");
        lista.limpar();
        System.out.println("Total após limpar: " + lista.contar());
    }

    /**
     * Método auxiliar para exibir o conteúdo atual e o total de itens.
     */
    public static void imprimirEstado(ListaOperacoes lista) {
        // Tenta fazer o cast para chamar o método exibir() que não está na interface
        if (lista instanceof ListaSimples) {
            ((ListaSimples) lista).exibir();
        } else if (lista instanceof ListaDinamica) {
            ((ListaDinamica) lista).exibir();
        }
        System.out.println("Total de elementos: " + lista.contar());
    }
}