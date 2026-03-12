package src;

public class ListaDinamica implements ListaOperacoes{
    No inicio;


    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista criada com sucesso!");
    }

    public void exibir(){
        No aux = this.inicio;
        while(aux.getProx() != null){
            System.out.print(aux.getConteudo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }
    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    @Override
    public int contar() {
        if (!existeInicio()) return 0;

        int contador = 1;
        No aux = this.inicio;
        while(aux.getProx() != null){
            aux = aux.getProx();
            contador++;
        }

        return contador;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= contar()) return null;
        No aux = this.inicio;
        if (!existeInicio()) System.out.println("Lista não existe!");
        for (int i = 0; i < indice; i++) {
            aux = aux.getProx();
        }
        return "ListaDinamica[" + indice + "] : "+ aux.getConteudo();
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        if (elementos == null || elementos.length == 0) {
            return 0;
        }

        int contador = 0;
        int indiceInicial = 0;

        if (!this.existeInicio()) {
            this.inicio = new No(elementos[0]);
            contador++;
            indiceInicial = 1;
        }

        No aux = this.inicio;
        while (aux.getProx() != null) {
            aux = aux.getProx();
        }


        for (int i = indiceInicial; i < elementos.length; i++) {
            No novoNo = new No(elementos[i]); // Cria o novo nó
            aux.setProx(novoNo);              // Conecta o nó atual ao novo nó
            aux = novoNo;                     // Move o 'aux' para ser o novo último nó
            contador++;
        }

        return contador;
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        return "";
    }

    @Override
    public void limpar() {

    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        return 0;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        return 0;
    }

    @Override
    public int substituir(String antigo, String novo) {
        return 0;
    }

    public boolean existeInicio() {
        return this.inicio.getConteudo() != null;
    }
}
