import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public void inserir(String elemento) {
        No novo = new No(elemento);
        if (raiz == null) {
            raiz = novo;
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (atual.getFilhoEsquerdo() == null) {
                atual.setFilhoEsquerdo(novo);
                return;
            } else {
                fila.add(atual.getFilhoEsquerdo());
            }

            if (atual.getFilhoDireito() == null) {
                atual.setFilhoDireito(novo);
                return;
            } else {
                fila.add(atual.getFilhoDireito());
            }
        }
    }

    public int contaNos(No no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contaNos(no.getFilhoEsquerdo()) + contaNos(no.getFilhoDireito());
        }
    }

    public int contarNosIterativo() {
        if (raiz == null) return 0;

        int count = 0;
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            count++;

            if (atual.getFilhoDireito() != null) {
                pilha.push(atual.getFilhoDireito());
            }
            if (atual.getFilhoEsquerdo() != null) {
                pilha.push(atual.getFilhoEsquerdo());
            }
        }

        return count;
    }


    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            preOrdem(no.getFilhoEsquerdo());
            preOrdem(no.getFilhoDireito());
        }
    }

    public void preOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.getConteudo() + " ");

            if (atual.getFilhoDireito() != null) {
                pilha.push(atual.getFilhoDireito());
            }
            if (atual.getFilhoEsquerdo() != null) {
                pilha.push(atual.getFilhoEsquerdo());
            }
        }
    }

    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.getFilhoEsquerdo());
            System.out.print(no.getConteudo() + " ");
            emOrdem(no.getFilhoDireito());
        }
    }

    public void emOrdemIterativo() {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.getFilhoEsquerdo();
            }

            atual = pilha.pop();
            System.out.print(atual.getConteudo() + " ");
            atual = atual.getFilhoDireito();
        }
    }


    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.getFilhoEsquerdo());
            posOrdem(no.getFilhoDireito());
            System.out.print(no.getConteudo() + " ");
        }
    }

    public void posOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();
        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.getFilhoEsquerdo() != null) {
                pilha1.push(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                pilha1.push(atual.getFilhoDireito());
            }
        }

        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().getConteudo() + " ");
        }
    }

    public void emNivel() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            System.out.print(noAtual.getConteudo() + " ");
            if (noAtual.getFilhoEsquerdo() != null) {
                fila.add(noAtual.getFilhoEsquerdo());
            }
            if (noAtual.getFilhoDireito() != null) {
                fila.add(noAtual.getFilhoDireito());
            }
        }
    }

    public int contarNosFolha(No no) {
        if (no == null) {
            return 0;
        }
        if (no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null) {
            return 1;
        }
        return contarNosFolha(no.getFilhoEsquerdo()) + contarNosFolha(no.getFilhoDireito());
    }

    public int contarNosFolhaIterativo(No no) {
        if (no == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(no);

        int contadorNoFolha = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            if (atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null) {
                contadorNoFolha++;
            }
            if (atual.getFilhoDireito() != null) {
                pilha.push(atual.getFilhoDireito());
            }
            if (atual.getFilhoEsquerdo() != null) {
                pilha.push(atual.getFilhoEsquerdo());
            }
        }
        return contadorNoFolha;
    }


    // Método de exclusão corrigido
    public void excluirNo(String elemento) {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        No noParaExcluir = null;
        No ultimoNo = null;
        No paiDoUltimoNo = null;

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (atual.getConteudo().equals(elemento)) {
                noParaExcluir = atual;
            }

            if (atual.getFilhoEsquerdo() != null) {
                paiDoUltimoNo = atual;
                fila.add(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                paiDoUltimoNo = atual;
                fila.add(atual.getFilhoDireito());
            }

            ultimoNo = atual;
        }

        if (noParaExcluir != null) {
            // Substitui conteúdo
            noParaExcluir.setConteudo(ultimoNo.getConteudo());

            // Remove o último nó da árvore
            if (paiDoUltimoNo != null) {
                if (paiDoUltimoNo.getFilhoDireito() == ultimoNo) {
                    paiDoUltimoNo.setFilhoDireito(null);
                } else if (paiDoUltimoNo.getFilhoEsquerdo() == ultimoNo) {
                    paiDoUltimoNo.setFilhoEsquerdo(null);
                }
            } else {
                // Se o único nó é a raiz
                raiz = null;
            }
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }


    public void buscarNo(String elemento) {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            if (atual.getConteudo().equals(elemento)) {
                System.out.println("Elemento encontrado: " + atual.getConteudo());
                return;
            }

            if (atual.getFilhoEsquerdo() != null) {
                fila.add(atual.getFilhoEsquerdo());
            }
            if (atual.getFilhoDireito() != null) {
                fila.add(atual.getFilhoDireito());
            }
        }

        System.out.println("Elemento não encontrado.");
    }

    public void rotacaoLL() {
        if (raiz == null || raiz.getFilhoEsquerdo() == null) {
            System.out.println("Rotação LL não é possível.");
            return;
        }

        No novoRaiz = raiz.getFilhoEsquerdo();
        raiz.setFilhoEsquerdo(novoRaiz.getFilhoDireito());
        novoRaiz.setFilhoDireito(raiz);
        raiz = novoRaiz;
    }

    public void rotacaoRR() {
        if (raiz == null || raiz.getFilhoDireito() == null) {
            System.out.println("Rotação RR não é possível.");
            return;
        }

        No novoRaiz = raiz.getFilhoDireito();
        raiz.setFilhoDireito(novoRaiz.getFilhoEsquerdo());
        novoRaiz.setFilhoEsquerdo(raiz);
        raiz = novoRaiz;
    }

    public void rotacaoLR() {
        if (raiz == null || raiz.getFilhoEsquerdo() == null || raiz.getFilhoEsquerdo().getFilhoDireito() == null) {
            System.out.println("Rotação LR não é possível.");
            return;
        }

        No novoRaiz = raiz.getFilhoEsquerdo().getFilhoDireito();
        raiz.getFilhoEsquerdo().setFilhoDireito(novoRaiz.getFilhoEsquerdo());
        novoRaiz.setFilhoEsquerdo(raiz.getFilhoEsquerdo());
        raiz.setFilhoEsquerdo(novoRaiz.getFilhoDireito());
        novoRaiz.setFilhoDireito(raiz);
        raiz = novoRaiz;
    }

    public void rotacaoRL() {
        if (raiz == null || raiz.getFilhoDireito() == null || raiz.getFilhoDireito().getFilhoEsquerdo() == null) {
            System.out.println("Rotação RL não é possível.");
            return;
        }

        No novoRaiz = raiz.getFilhoDireito().getFilhoEsquerdo();
        raiz.getFilhoDireito().setFilhoEsquerdo(novoRaiz.getFilhoDireito());
        novoRaiz.setFilhoDireito(raiz.getFilhoDireito());
        raiz.setFilhoDireito(novoRaiz.getFilhoEsquerdo());
        novoRaiz.setFilhoEsquerdo(raiz);
        raiz = novoRaiz;
    }
}
