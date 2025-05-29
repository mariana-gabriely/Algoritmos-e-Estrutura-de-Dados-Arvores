import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(Integer conteudo) {
        if (raiz == null) {
            raiz = new No(conteudo);
        } else {
            raiz.inserir(conteudo);
        }
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int contarNos(No no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contarNos(no.getFilhoEsquerdo()) + contarNos(no.getFilhoDireito());
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

    public int contarNosFolhaIterativo() {
        if (raiz == null) return 0;

        int count = 0;
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();

            if (atual.getFilhoEsquerdo() == null && atual.getFilhoDireito() == null) {
                count++;
            }

            if (atual.getFilhoDireito() != null) {
                pilha.push(atual.getFilhoDireito());
            }
            
            if (atual.getFilhoEsquerdo() != null) {
                pilha.push(atual.getFilhoEsquerdo());
            }
        }

        return count;
    }

}