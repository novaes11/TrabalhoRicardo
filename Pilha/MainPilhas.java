package Pilha;

public class MainPilhas {

    static void main() {


        PilhaDinamica pd = new PilhaDinamica();


        pd.empilhar("a");
        pd.empilhar("c");
        pd.empilhar("b");
        pd.desempilhar();
        pd.empilhar("d");
        pd.exibir();

    }

}
