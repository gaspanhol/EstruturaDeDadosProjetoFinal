/**
 * Testes da ListaEncadeada sem dependências externas (não exige JUnit).
 * Cada teste registra o nome, o valor esperado e o valor obtido.
 */
public class TestesListaEncadeada {

    private static int aprovados = 0;
    private static int falhas = 0;

    public static void main(String[] args) {
        // ---- Caso limite: lista vazia ----
        ListaEncadeada vazia = new ListaEncadeada();
        verificar("vazia: imprime null", "null", vazia.paraTexto());
        verificar("vazia: estaVazia", "true", String.valueOf(vazia.estaVazia()));
        verificar("vazia: remover não faz nada", "false", String.valueOf(vazia.remover(1)));
        verificar("vazia: contem é false", "false", String.valueOf(vazia.contem(1)));
        verificar("vazia: continua vazia", "null", vazia.paraTexto());

        // ---- Caso limite: inserção em lista vazia ----
        ListaEncadeada umNo = new ListaEncadeada();
        umNo.inserirNoInicio(7);
        verificar("inserir em vazia", "7 -> null", umNo.paraTexto());

        // ---- Caso normal: inserção no início ----
        ListaEncadeada lista = montar(20, 30);
        lista.inserirNoInicio(10);
        verificar("inserir no início", "10 -> 20 -> 30 -> null", lista.paraTexto());

        // ---- Caso normal: contém ----
        ListaEncadeada abc = montar(10, 20, 30);
        verificar("contem: início", "true", String.valueOf(abc.contem(10)));
        verificar("contem: meio", "true", String.valueOf(abc.contem(20)));
        verificar("contem: fim", "true", String.valueOf(abc.contem(30)));
        verificar("contem: ausente", "false", String.valueOf(abc.contem(99)));

        // ---- Remoção: head, meio, fim ----
        ListaEncadeada r1 = montar(10, 20, 30);
        verificar("remover head: retorno", "true", String.valueOf(r1.remover(10)));
        verificar("remover head: estado", "20 -> 30 -> null", r1.paraTexto());

        ListaEncadeada r2 = montar(10, 20, 30);
        verificar("remover meio: retorno", "true", String.valueOf(r2.remover(20)));
        verificar("remover meio: estado", "10 -> 30 -> null", r2.paraTexto());

        ListaEncadeada r3 = montar(10, 20, 30);
        verificar("remover fim: retorno", "true", String.valueOf(r3.remover(30)));
        verificar("remover fim: estado", "10 -> 20 -> null", r3.paraTexto());

        // ---- Caso limite: remover o único elemento ----
        ListaEncadeada unico = montar(10);
        verificar("remover único: retorno", "true", String.valueOf(unico.remover(10)));
        verificar("remover único: esvaziou", "true", String.valueOf(unico.estaVazia()));

        // ---- Valor ausente: não altera ----
        ListaEncadeada ausente = montar(10, 20, 30);
        verificar("ausente: retorno", "false", String.valueOf(ausente.remover(99)));
        verificar("ausente: estado inalterado", "10 -> 20 -> 30 -> null", ausente.paraTexto());

        // ---- Valor repetido: remove só a 1ª ocorrência ----
        ListaEncadeada repetido = montar(1, 2, 1, 3);
        verificar("repetido: remove 1ª ocorrência", "2 -> 1 -> 3 -> null",
                afterRemove(repetido, 1));

        // ---- Sequência: remover todos ----
        ListaEncadeada todos = montar(1, 2, 3);
        todos.remover(1);
        todos.remover(2);
        todos.remover(3);
        verificar("removendo todos: vazia", "null", todos.paraTexto());

        // ---- Resumo ----
        System.out.println();
        System.out.println("Resultado: " + aprovados + " aprovados, " + falhas + " falhas.");
        if (falhas > 0) {
            System.exit(1);
        }
    }

    /** Monta a lista na ordem dada, inserindo do último para o primeiro no início. */
    private static ListaEncadeada montar(int... valores) {
        ListaEncadeada l = new ListaEncadeada();
        for (int i = valores.length - 1; i >= 0; i--) {
            l.inserirNoInicio(valores[i]);
        }
        return l;
    }

    private static String afterRemove(ListaEncadeada l, int valor) {
        l.remover(valor);
        return l.paraTexto();
    }

    private static void verificar(String nome, String esperado, String obtido) {
        if (esperado.equals(obtido)) {
            aprovados++;
            System.out.println("[OK]    " + nome);
        } else {
            falhas++;
            System.out.println("[FALHA] " + nome
                    + " | esperado: " + esperado
                    + " | obtido: " + obtido);
        }
    }
}
