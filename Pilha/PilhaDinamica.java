package Pilha;

public class PilhaDinamica implements PilhaOperacoes{
    No inicio;

    @Override
    public boolean estaVazia() {
        return inicio.prox == null;
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        No anterior = inicio;
        No atual = inicio.prox;
        //Enquanto o nó atual não for o ultimo da linha
        while (atual != null){
            //Verifica se o conteudo atual é nullo e verifica o se o elemento dado é igual ao conteudo que temos
            if(atual.conteudo != null && atual.conteudo.equals(elemento)){
                anterior.prox = atual.prox;
                removidos++;
            }
            else{
                atual = anterior;
            }
            atual = atual.prox;
        }
        return removidos;
    }

    @Override
    public int contar() {
        int total = 0;
        No atual = inicio.prox;
        //Verifica se o nó atual não é o ultimo da linha
        while( atual != null){
            total ++;
            atual = atual.prox;
        }
        return total;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int adicionados = 0;

        for(String s : elementos){
            if(s != null) {
                No novo = new No(s);
                novo.prox = inicio.prox;
                inicio.prox = novo;
                adicionados++;
            }
        }
        return adicionados;
    }

    @Override
    public String obter(int indice) {
        return "";
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        No anterior = inicio;

        for(int i = 0; i < indice;i++){
            if(anterior == null) return false;
            anterior = anterior.prox;
        }

        if(anterior == null) return false;

        No novo = new No(elemento);
        novo.prox = anterior.prox;
        anterior.prox = novo;
        return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        No anterior = inicio;

        for(int i = 0; i < indice; i++) {
            if (anterior.prox == null) return null;
            anterior = anterior.prox;
        }

        No alvo = anterior.prox;
        if(alvo == null) return null;

        String conteudo = alvo.conteudo;
        anterior.prox = alvo.prox;

        return conteudo;

    }

    @Override
    public void limpar() {

    }

    @Override
    public int ultimoIndiceDe(String elemento){
        int Ultimo = -1;
        int contador = 0;
        No atual = inicio.prox;

        while(atual != null){
            if(atual.conteudo != null && atual.conteudo.equals(elemento)){
                Ultimo = contador
            }
            atual = atual.prox;
            contador++;
        }
        return Ultimo;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        return 0;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int trocas = 0;
        No atual = inicio.prox;

        while(atual != null){
            if(atual.conteudo != null && atual.conteudo.equals(novo)){
                atual.conteudo = novo;
                trocas++;
            }
            atual = atual.prox;
        }
        return trocas;
    }
}
