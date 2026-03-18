package Pilha;

public class PilhaDinamica {

    private No inicio;

    public PilhaDinamica(){
        this.inicio = null;
    }

    //Verifica se a pilha está vazia
    public boolean estaVazia(){
        return this.inicio == null;
    }

    //Empilha os números, porém seguindo a regra de first in last out.
    public void empilhar(String conteudo){
        No novo = new No(conteudo);
        novo.proximo = inicio;
        inicio = novo;
    }

    //Desempilha seguindo o raciocinio de first in last out
    public String desempilhar(){
        if(estaVazia()){
            return null;
        }

        String itemRemovido = inicio.conteudo;
        inicio = inicio.proximo;
        return itemRemovido;
    }

    public String consultarInicio(){
        if(estaVazia()){
            System.out.println("Pilha vazia!");
            return null;
        }
        return inicio.conteudo;
    }

    public void exibir(){
        if(estaVazia()){
            System.out.println("Pilha vazia!");
            return;
        }
        No atual = inicio;
        while(atual != null){
            System.out.println(atual.conteudo);
            atual = atual.proximo;
        }
    }
}
