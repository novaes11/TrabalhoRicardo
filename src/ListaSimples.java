package src;

import java.util.Arrays;


public class ListaSimples implements ListaOperacoes{
    private String[] lista;

    public ListaSimples(int tamanho) {
        if (tamanho <= 0) throw new IllegalArgumentException();
        this.lista = new String[tamanho];
    }
    /**
     * Remove TODAS as ocorrências de um determinado elemento da lista.
     *
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana", "Pedro"]
     * removerTodas("Ana")
     * Resultado: ["Carlos", "Pedro"]
     *
     * @param elemento Elemento que deverá ter todas as ocorrências removidas.
     * @return Quantidade total de elementos removidos.
     */
    @Override
    public int removerTodas(String elemento) {
        int contador = 0;
        for (int i = 0; i < lista.length; i++) {
            if (this.lista[i].equalsIgnoreCase(elemento)) {
                lista[i] = null;
                contador++;
            }
        }
        return contador;
    }

    @Override
    public int contar() {
        int contador = 0;
        for (String elemento : this.lista) {
            if (elemento != null) contador++;
        }
        return contador;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int contador = 0;
        for (String elemento : elementos) {
            for (int j = 0; j < this.lista.length; j++) {
                if (this.lista[j] == null) {
                    this.lista[j] = elemento;
                    contador++;
                }
                if (j == this.lista.length - 1) {
                    return contador;
                }
            }
        }
        return contador;
    }

    @Override
    public String obter(int indice) {
        return "Lista[" + indice + "] :" + this.lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if(contar() < this.lista.length) {
            for (int i = indice; i < this.lista.length; i++) {
                if (i < this.lista.length - 1) {
                    this.lista[i + 1] = this.lista[i];
                }
            }
            this.lista[indice] = elemento;
            return true;
        }
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

    public boolean estaCheio(){
        for (String elemento : this.lista) {
            if (elemento != null) return true;
        }
        return false;
    }
}
