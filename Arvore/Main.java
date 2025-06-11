package Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        arvore.inserir("A");
        arvore.inserir("B");
        arvore.inserir("C");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("F");

        System.out.println("Árvore criada com sucesso!");

        System.out.println("\nContagem de nós: " + arvore.contarNosIterativo());

        System.out.println("\nNós em pré-ordem: ");
        arvore.preOrdemIterativo();

        System.out.println("\nNós em em-ordem: ");
        arvore.emOrdemIterativo();

        System.out.println("\nNós em pós-ordem: ");
        arvore.posOrdemIterativo();

        System.out.println("\nNós em nível: ");
        arvore.emNivel();

        System.out.println("\nNós folhas: " + arvore.contarNosFolha(arvore.getRaiz()));
        System.out.println("\nNós folhas iterativo: " + arvore.contarNosFolhaIterativo(arvore.getRaiz()));
    }
}