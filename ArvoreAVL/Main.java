package ArvoreAVL;

class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        int[] conteudos = {10, 20, 30, 40, 50, 25};

        for (int conteudo : conteudos) {
            arvore.setRaiz(arvore.inserir(arvore.getRaiz(), conteudo));
        }

        System.out.println("Percurso em ordem da árvore AVL: ");
        arvore.percursoEmOrdem(arvore.getRaiz());
    }
}