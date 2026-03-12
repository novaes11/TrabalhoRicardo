package src;

public class ListaDinamica implements ListaOperacoes{
    No inicio;


    public ListaDinamica(No inicio) {
        this.inicio = new No(null);
        System.out.println("Lista criada com sucesso!");
    }

    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    @Override
    public int contar() {
        return 0;
    }

    @Override
    public String obter(int indice) {
        return "";
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        if(!existeInicio()){

        }
        return 0;
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
