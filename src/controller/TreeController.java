package controller;

import model.AVLTree;
import view.TreeViewer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TreeController {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        Scanner scanner = new Scanner(System.in);
        TreeViewer treeViewer = new TreeViewer();

        while(true) {
            try {
                treeViewer.printMenu();
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        treeViewer.printTree(avl);
                        break;
                    case 2:
                        System.out.println("Qual número você deseja buscar?");
                        System.out.println(avl.search(Integer.parseInt(scanner.nextLine())));
                        break;
                    case 3:
                        System.out.println("Qual número você deseja inserir?");
                        avl.insert(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Qual número você deseja remover?");
                        avl.delete(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        treeViewer.printOrdem();
                        int ordem = Integer.parseInt(scanner.nextLine());
                        switch (ordem) {
                            case 1:
                                avl.preOrder(avl.getRoot());
                                System.out.println();
                                break;
                            case 2:
                                avl.postOrder(avl.getRoot());
                                System.out.println();
                                break;
                            case 3:
                                avl.inOrder(avl.getRoot());
                                System.out.println();
                                break;
                            default: System.out.println("* OPCAO INVALIDA. TENTE NOVAMENTE!"); break;
                        }
                        break;
                    case 6: System.out.println("################## FINALIZANDO PROGRAMA ##################"); break;
                    default: System.out.println("* OPCAO INVALIDA. TENTE NOVAMENTE!"); break;
                }
                if (option == 6) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("* OPÇÃO INVALIDA. TENTE NOVAMENTE!");
            }
        }
    }
}