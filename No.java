/**
 * Nó de uma lista simplesmente encadeada.
 * Guarda um dado (valor) e uma referência para o próximo nó.
 */
public class No {
    int valor;
    No proximo;

    No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}
