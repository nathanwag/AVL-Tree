package view;

import model.AVLTree;
import model.Node;

public class TreeViewer {
    public void printTree(AVLTree avlTree) {
        printTreeRecursive(avlTree.getRoot(), 0, 10);
    }

    private void printTreeRecursive(Node root, int space, int incrementer) {
        if(root == null) {
            return;
        }
        space += incrementer;

        printTreeRecursive(root.getRight(), space, incrementer);

        for(int i = incrementer; i < space; i++) {
            System.out.print(" ");
        }
        System.out.println(root.getRoot());
        printTreeRecursive(root.getLeft(), space, incrementer);
    }

}
