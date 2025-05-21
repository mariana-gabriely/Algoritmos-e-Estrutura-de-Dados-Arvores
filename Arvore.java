public class Arvore {
    private No raiz;
    private int qtdNos;

    public Arvore() {
        this.raiz = null;
    }


    public void inserir(Integer conteudo) {
        if (raiz == null) {
            raiz = new No(conteudo);
        } else {
            raiz.inserir(conteudo);
        }
        qtdNos++;
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public int getQtdNos() {
        return qtdNos;
    }

    public void setQtdNos(int qtdNos) {
        this.qtdNos = qtdNos;
    }

    public void contarNos() {
        if (raiz == null) {
            System.out.println("A árvore está vazia.");
        } else {
            System.out.println("Número de nós: " + qtdNos);
        }
        
    }

}