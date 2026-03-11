package src;

public class MainListas {
    public static void main(String[] args) {
        ListaSimples lista = new ListaSimples(5);
        lista.adicionarVarios(new String[] {
           "1", "4", "3", "4", "5"
        });
        lista.exibir();
        lista.removerTodas("4");
        lista.exibir();

    }
}
