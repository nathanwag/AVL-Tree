package controller;

import model.AVLTree;
import view.TreeViewer;

public class Main {
    public static void main(String[] args) {
        AVLTree avl = new AVLTree();

        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.insert(8);
        avl.insert(9);
        avl.insert(10);
        avl.insert(11);
        avl.insert(12);
        avl.insert(13);
        avl.insert(14);
        avl.insert(15);
        avl.insert(16);
        avl.insert(17);
        avl.insert(18);
        avl.insert(19);
        avl.insert(20);

        new TreeViewer().printTree(avl);
    }
}