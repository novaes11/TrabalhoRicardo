package Pilha;

public class PilhaDinamica implements PilhaOperacoes {
    No inicio;

    public void PilhaDinamica(){
        this.inicio = this.inicio;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public class PilhaDinamica implements PilhaOperacoes {
        No inicio;

        public PilhaDinamica() {
            this.inicio = null;
        }

        public boolean estaVazia() {
            return inicio == null;
        }

        public Object desempilhar() {
            if (estaVazia()) {
                System.out.println("A pilha está vazia!");
                return null;
            }

            Object conteudoRemovido = inicio.getConteudo();
            inicio = inicio.prox;

            return conteudoRemovido;
        }
    }



    }

    public void empilhar() {

    }

    public boolean temInicio() {
        No atual = inicio.prox;

        if (!atual.conteudo().equals(null)) {
            return true;
        } else {
            return false;
        }
    }

    public void UltimoIndice(){
        No atual = inicio.prox;
        No proximo = atual.prox;

        if(!atual.conteudo().equals(null) && proximo.conteudo.equals(null)){

        }
    }
}
