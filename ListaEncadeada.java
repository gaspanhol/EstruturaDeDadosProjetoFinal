/**
 * Lista simplesmente encadeada de inteiros.
 * A única referência guardada pela lista é 'head' (o primeiro nó).
 * O último nó aponta para null, sinalizando o fim da lista.
 */
public class ListaEncadeada {

    private No head;

    /** Lista vazia quando head == null. */
    public boolean estaVazia() {
        return head == null;
    }

    /**
     * Insere um valor no início da lista.
     * Custo: O(1), sempre os mesmos 2 passos.
     * A ORDEM IMPORTA: ligar o novo nó ao antigo início ANTES de mover head.
     */
    public void inserirNoInicio(int valor) {
        No novo = new No(valor);
        novo.proximo = head; // 1º: novo aponta para o antigo início
        head = novo;         // 2º: head passa a apontar para o novo nó
    }

    /**
     * Verifica se o valor existe na lista.
     * Custo: O(n), pois é preciso percorrer os nós até encontrar (ou não).
     */
    public boolean contem(int valor) {
        No atual = head;
        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    /**
     * Remove a PRIMEIRA ocorrência do valor.
     * Retorna true se removeu, false se o valor não existe.
     * Custo: O(n) para achar o nó; O(1) para religar as referências.
     *
     * Casos:
     *  - lista vazia            -> não faz nada
     *  - valor no head          -> head = head.proximo
     *  - valor no meio ou fim   -> anterior.proximo = atual.proximo
     *  - valor ausente          -> percorre tudo e não altera
     */
    public boolean remover(int valor) {
        if (head == null) {
            return false;
        }

        if (head.valor == valor) {
            head = head.proximo;
            return true;
        }

        No anterior = head;
        No atual = head.proximo;
        while (atual != null) {
            if (atual.valor == valor) {
                anterior.proximo = atual.proximo; // religa, pulando o atual
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }

    /**
     * Representação textual no formato usado nos slides: "10 -> 20 -> 30 -> null".
     * Lista vazia: "null".
     */
    public String paraTexto() {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        No atual = head;
        while (atual != null) {
            sb.append(atual.valor).append(" -> ");
            atual = atual.proximo;
        }
        sb.append("null");
        return sb.toString();
    }

    /** Imprime a lista. Custo: O(n). */
    public void imprimir() {
        System.out.println(paraTexto());
    }
}
