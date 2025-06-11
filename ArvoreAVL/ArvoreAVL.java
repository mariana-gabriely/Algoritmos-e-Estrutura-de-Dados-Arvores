package ArvoreAVL;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class ArvoreAVL {
    No raiz;

    ArvoreAVL() {
        this.raiz = null;
    }

    No getRaiz() {
        return raiz;
    }

    void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    int altura(No no) {
        if (no == null) 
            return 0;
        return no.getAltura();
    }

    int fatorBalanceamento(No no) {
        if (no == null) return 0;
        return altura(no.getFilhoEsquerdo()) - altura(no.getFilhoDireito());
    }

    No rotacaoDireita(No y) {
        No x = y.getFilhoEsquerdo();
        No T2 = x.getFilhoDireito();

        x.setFilhoDireito(y);
        y.setFilhoEsquerdo(T2);

        y.setAltura(Math.max(altura(y.getFilhoEsquerdo()), altura(y.getFilhoDireito())) + 1);
        x.setAltura(Math.max(altura(x.getFilhoEsquerdo()), altura(x.getFilhoDireito())) + 1);

        return x;
    }

    No rotacaoEsquerda(No x) {
        No y = x.getFilhoDireito();
        No T2 = y.getFilhoEsquerdo();

        y.setFilhoEsquerdo(x);
        x.setFilhoDireito(T2);

        x.setAltura(Math.max(altura(x.getFilhoEsquerdo()), altura(x.getFilhoDireito())) + 1);
        y.setAltura(Math.max(altura(y.getFilhoEsquerdo()), altura(y.getFilhoDireito())) + 1);

        return y;
    }

    No inserir(No no, int conteudo) {
        if(no == null){ 
            return new No(conteudo);
        }

        if (conteudo < no.getConteudo()){
            no.setFilhoEsquerdo(inserir(no.getFilhoEsquerdo(), conteudo));
        } else if (conteudo > no.getConteudo()) {
            no.setFilhoDireito(inserir(no.getFilhoDireito(), conteudo));
        } else {
            return no;
        }

        no.setAltura(1 + Math.max(altura(no.getFilhoEsquerdo()), altura(no.getFilhoDireito())));
        
        int balanceamento = fatorBalanceamento(no);

        if(balanceamento > 1 && conteudo < no.getFilhoEsquerdo().getConteudo()){
            return rotacaoDireita(no);
        }

        if(balanceamento > -1 && conteudo > no.getFilhoDireito().getConteudo()){
            return rotacaoDireita(no);
        }

        if(balanceamento > 1 && conteudo < no.getFilhoEsquerdo().getConteudo()){
            no.setFilhoEsquerdo(rotacaoEsquerda(no.getFilhoEsquerdo()));
            return rotacaoDireita(no);
        }

        if(balanceamento > -1 && conteudo < no.getFilhoDireito().getConteudo()){
            no.setFilhoDireito(no.getFilhoDireito());
            return rotacaoEsquerda(no);
        }

        return no;

    }

    void percursoEmOrdem(No no) {
        if (no != null) {
            percursoEmOrdem(no.getFilhoEsquerdo());
            System.out.println(no.getConteudo() + " ");
            percursoEmOrdem(no.getFilhoDireito());
        }
    }


    int contaNos(No no) {
        if (no == null) {
            return 0;
        } else {
            return 1 + contaNos(no.getFilhoEsquerdo()) + contaNos(no.getFilhoDireito());
        }
    }

    int contarNosIterativo() {
        if (raiz == null)
            return 0;

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

    void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.getConteudo() + " ");
            preOrdem(no.getFilhoEsquerdo());
            preOrdem(no.getFilhoDireito());
        }
    }

    void preOrdemIterativo() {
        if (raiz == null)
            return;

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

    void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.getFilhoEsquerdo());
            System.out.print(no.getConteudo() + " ");
            emOrdem(no.getFilhoDireito());
        }
    }

    void emOrdemIterativo() {
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

    void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.getFilhoEsquerdo());
            posOrdem(no.getFilhoDireito());
            System.out.print(no.getConteudo() + " ");
        }
    }

    void posOrdemIterativo() {
        if (raiz == null)
            return;

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

    void emNivel() {
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

    int contarNosFolha(No no) {
        if (no == null) {
            return 0;
        }
        if (no.getFilhoEsquerdo() == null && no.getFilhoDireito() == null) {
            return 1;
        }
        return contarNosFolha(no.getFilhoEsquerdo()) + contarNosFolha(no.getFilhoDireito());
    }

    int contarNosFolhaIterativo(No no) {
        if (no == null)
            return 0;

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
}