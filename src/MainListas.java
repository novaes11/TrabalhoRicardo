package src;

/**
 * Classe principal para execução de testes e comparação de desempenho entre
 * as implementações de listas estáticas e dinâmicas.
 * * Esta classe utiliza o polimorfismo para aplicar o mesmo conjunto de testes
 * em diferentes estruturas de dados que assinam o contrato ListaOperacoes.
 * @author João Vitor Novaes, João Vitor Camargo e Henrique C. Barros
 * @version 2.0
 */
public class MainListas {

    /**
     * Ponto de entrada do programa.
     * Instancia as listas Simples (vetor) e Dinâmica (nós) para demonstração.
     * * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        ListaOperacoes listaSimples = new ListaSimples(10);
        ListaOperacoes listaDinamica = new ListaDinamica();

        System.out.println("====================================================");
        System.out.println("   COMPARAÇÃO DAS LISTAS");
        System.out.println("====================================================");

        System.out.println("\n==LISTA SIMPLES==");
        testar(listaSimples);

        System.out.println("\n== LISTA DINÂMICA ==");
        testar(listaDinamica);

        System.out.println("\n====================================================");
        System.out.println("   FIM DOS TESTES");
        System.out.println("====================================================");
    }

    /**
     * Executa uma bateria de testes padronizada em uma implementação de lista.
     * * O fluxo inclui adição em massa, inserção indexada, contagem de ocorrências,
     * substituição de valores, busca de índices e limpeza de dados.
     * * @param lista Objeto que implementa a interface ListaOperacoes a ser testado.
     */
    public static void testar(ListaOperacoes lista) {
        // 1. Adicionar Vários
        String[] nomes = {"Ana", "Carlos", "Alberto", "Ana", "Pedro"};
        System.out.println("--- Adicionando elementos iniciais ---");
        lista.adicionarVarios(nomes);

        // 2. Inserir em posição específica
        System.out.println("\n--- Inserindo 'Zeca' no índice 2 ---");
        lista.inserir(2, "Zeca");

        // 3. Contar Ocorrências
        System.out.println("\n--- Verificando duplicatas ---");
        int qtdAna = lista.contarOcorrencias("Ana");
        System.out.println("Ocorrências de 'Ana': " + qtdAna);

        // 4. Substituir
        System.out.println("\n--- Substituindo 'Ana' por 'Maria' ---");
        lista.substituir("Ana", "Maria");

        // 5. Último Índice
        System.out.println("\n--- Localizando última 'Maria' ---");
        int ultimo_indice = lista.ultimoIndiceDe("Maria");
        System.out.println("Último índice encontrado: " + ultimo_indice);

        // 6. Remover por Índice
        System.out.println("\n--- Removendo elemento do índice 3 ---");
        lista.removerPorIndice(3);

        // 7. Obter
        System.out.println("\n--- Consultando índice 0 ---");
        System.out.println("Conteúdo: " + lista.obter(0));

        // 8. Limpar
        System.out.println("\n--- Resetando lista ---");
        lista.limpar();
        System.out.println("Total após limpar: " + lista.contar());
    }
}