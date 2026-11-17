/**
 * Demonstração da lista encadeada.
 * Antes de cada passo, preveja a saída. Os comentários indicam o resultado esperado.
 */
public class Demo {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        System.out.print("Lista inicial: ");
        lista.imprimir();                                   // previsão: null

        lista.inserirNoInicio(30);
        lista.inserirNoInicio(20);
        lista.inserirNoInicio(10);
        System.out.print("Após inserir 30, 20, 10: ");
        lista.imprimir();                                   // previsão: 10 -> 20 -> 30 -> null

        lista.inserirNoInicio(5);
        System.out.print("Após inserir 5 no início: ");
        lista.imprimir();                                   // previsão: 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Contém 20? " + lista.contem(20)); // previsão: true

        System.out.println("Remover 20 (meio): " + lista.remover(20)); // previsão: true
        System.out.print("Estado: ");
        lista.imprimir();                                   // previsão: 5 -> 10 -> 30 -> null

        System.out.println("Remover 5 (head): " + lista.remover(5)); // previsão: true
        System.out.print("Estado: ");
        lista.imprimir();                                   // previsão: 10 -> 30 -> null

        System.out.println("Remover 99 (ausente): " + lista.remover(99)); // previsão: false
        System.out.print("Estado: ");
        lista.imprimir();                                   // previsão: 10 -> 30 -> null
    }
}
