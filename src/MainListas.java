package src;

public class MainListas {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples(1);
        lista.adicionarVarios(new String[] {
           "1"
        });
        lista.exibir();
        lista.removerTodas("4");
        lista.exibir();
        lista.removerPorIndice(0);
        lista.exibir();
        lista.limpar();
        lista.exibir();
    }
}
