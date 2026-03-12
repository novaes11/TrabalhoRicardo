package src;

import java.util.Arrays;


public class ListaSimples implements ListaOperacoes{
    private String[] lista;

    public ListaSimples(int tamanho) {
        if (tamanho <= 0) throw new IllegalArgumentException();
        this.lista = new String[tamanho];
    }

    public void exibir(){
        String [] aux;
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

        exibir();
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
                    break;
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
    
    /**
     * Verificação se o indice existe dentro da lista.
     * Um for que garante que quando adicionado, os números se deslocaram para a direita.
     *
     * 
     * @author: Henrique C. Barros
     * @version: 2.0
     */
    @Override
    public String removerPorIndice(int indice) {
        String[] aux = this.lista;

        if(lista[indice] == null){
            System.out.println("Indice não encontrado.");
            return null;
        }
        String elementoRemovido = this.lista[indice];


        if (this.lista.length - 1 - indice >= 0)
            System.arraycopy(aux, indice, this.lista, indice + 1, this.lista.length - 1 - indice);
        //Remove o número duplicado 
        this.lista[indice] = null;

        return elementoRemovido;
    }
    /**
     * Verificação se lista possui elementos para limpar.
     * 
     * @author: Henrique C. Barros
     * @version: 1.0
     */
    @Override
    public void limpar() {
        if(this.lista.length <= 0){
            System.out.println("Lista já está limpa.");
        }
        else{
            System.out.println("Lista esvaziada!");
            Arrays.fill(this.lista, null);
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int aux = 0;
        if(contarOcorrencias(elemento) == 0){
            return -1;
        }
        for(int i = 0; i < this.lista.length; i++){
            if(this.lista[i].equalsIgnoreCase(elemento)){
                aux = i;
            }

        }
        return aux;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int contador = 0;
        for (String lista : this.lista) {
            if (lista.equalsIgnoreCase(elemento)) {
                contador++;
            }
        }

        return contador;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int contador = 0;
        if(contarOcorrencias(antigo) == 0) return -1;
        for(String lista : this.lista){
            if(lista.equalsIgnoreCase(antigo)) {
                contador++;
                lista = novo;
            }
        }
        exibir();
        return contador;


    }

    public boolean estaCheio(){
        for (String elemento : this.lista) {
            if (elemento != null) return true;
        }
        return false;
    }
}
