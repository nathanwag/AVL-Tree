package view;

import model.AVLTree;
import model.Node;

public class TreeViewer {
    public void printTree(AVLTree avlTree) {
        printTreeRecursive(avlTree.getRoot(), 0, 10,"┌ ");
    }

    private void printTreeRecursive(Node root, int space, int incrementer, String pos) {
        if(root == null) {
            return;
        }
        space += incrementer;

        printTreeRecursive(root.getRight(), space, incrementer,"┌ ");

        for(int i = incrementer; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(pos+root.getRoot());
        printTreeRecursive(root.getLeft(), space, incrementer,"┌ ");
    }

    public void printMenu() {
        System.out.println("+-------------- ESCOLHA A MANIPULÇÃO DESEJADA ---------------+");
        System.out.println("| * [1] - Imprimir árvore;                                   |");
        System.out.println("| * [2] - Buscar elemento na árvore;                         |");
        System.out.println("| * [3] - Inserir elemento na árvore;                        |");
        System.out.println("| * [4] - Remover elemento da árvore;                        |");
        System.out.println("| * [5] - Pré-ordem, Pós-ordem ou Em-ordem;                  |");
        System.out.println("| * [6] - Sair;                                              |");
        System.out.println("+------------------------------------------------------------+");
    }

    public void printOrdem() {
        System.out.println("+--------------- ESCOLHA IMPRESSÃO DE ÁRVORE ----------------+");
        System.out.println("| * [1] - Imprimir árvore em Pré-ordem;                      |");
        System.out.println("| * [2] - Imprimir árvore em Pós-ordem;                      |");
        System.out.println("| * [3] - Imprimir árvore Em-ordem;                          |");
        System.out.println("+------------------------------------------------------------+");
    }
}
