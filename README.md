# Membros do grupo
Gabriel Spanhol
Gustavo Rocha
Louise Bertipaglia
Lucas Pacheco

# Listas Encadeadas em Java

Implementação de uma lista simplesmente encadeada de inteiros, usada na apresentação da Equipe 1 (Estrutura de Dados, IFSC São José).

## Versão usada

- Java 17 ou superior (testado com JDK 17). Não há dependências externas.

## Arquivos

| Arquivo | Conteúdo |
|---|---|
| `No.java` | Nó: campo `valor` e referência `proximo`. |
| `ListaEncadeada.java` | Lista com `head` e os métodos `inserirNoInicio`, `remover`, `contem`, `paraTexto`/`imprimir`. |
| `Demo.java` | Demonstração usada no seminário (classe principal da apresentação). |
| `TestesListaEncadeada.java` | Testes de caso normal, limites, valor ausente, valor repetido e remoção de head, meio e fim. |

## Como compilar e executar

No diretório com os arquivos `.java`:

```bash
javac -encoding UTF-8 *.java
java -Dfile.encoding=UTF-8 Demo          # demonstração
java -Dfile.encoding=UTF-8 TestesListaEncadeada   # testes
```

Se os acentos aparecerem como `?` no console, use a codificação UTF-8 indicada acima (no Windows, rode `chcp 65001` antes).

No Windows (PowerShell), use `javac *.java` e depois `java Demo` do mesmo jeito.

## Saída esperada

Demonstração (`java Demo`):

```
Lista inicial: null
Após inserir 30, 20, 10: 10 -> 20 -> 30 -> null
Após inserir 5 no início: 5 -> 10 -> 20 -> 30 -> null
Contém 20? true
Remover 20 (meio): true
Estado: 5 -> 10 -> 30 -> null
Remover 5 (head): true
Estado: 10 -> 30 -> null
Remover 99 (ausente): false
Estado: 10 -> 30 -> null
```

Testes (`java TestesListaEncadeada`): todas as linhas devem começar com `[OK]` e o resumo final deve ser `0 falhas`.

## Decisões de projeto

- **Inserção no início (O(1))**: primeiro `novo.proximo = head`, depois `head = novo`. Invertendo a ordem, a lista se perde.
- **Remoção por valor (O(n))**: remove apenas a primeira ocorrência. Lista vazia e valor ausente não alteram a estrutura.
- **Sem tamanho guardado**: a lista não mantém contador; `estaVazia()` verifica `head == null`.