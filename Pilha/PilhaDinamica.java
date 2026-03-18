package Pilha;

import java.util.Stack;

public class PilhaDinamica implements PilhaOperacoes {
    No inicio;

    public void PilhaDinamica(){
        this.inicio = this.inicio;
    }

    public boolean estaVazia() {
        return !inicio.empty();
    }

    public void desempilhar(String[] elementos) {

        if (estaVazia()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        else if(!atual.conteudo().equals(null) || atual.conteudo().isBlank()) {
            for(String e : elementos){
                No novo = new No(atual);
                novo = inicio;
                atual = novo;
                System.out.println("Elemento removido da pilha: " + elementos.pop());
        }

        }



    }

    public void empilhar() {

    }

    public int temInicio(String[] elementos) {
        return elementos[inicio];
    }

    public void exibir(){
        for(int i = 0; i <= inicio; i++){
            System.out.println(" " + itens[i]);
        }
}
    public void UltimoIndice(){
        No atual = inicio.prox;
        No proximo = atual.prox;

        if(!atual.conteudo().equals(null) && proximo.conteudo.equals(null)){

        }
    }
}
