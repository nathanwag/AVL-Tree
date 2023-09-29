package model;

public class Node {
    private int root, height;
    private Node left, right;

    public Node(int root) {
        this.root = root;
    }

    @Override
    public String toString() {
        if(left == null && right == null) {
            return "Raiz: " + root + ", Elemento esquerda e direita: nulo nulo, Altura: " + height;
        } else if(left == null) {
            return "Raiz: " + root + ", Elemento esquerda e direita: nulo " + right.root + ", Altura: " + height;
        } else if(right == null) {
            return "Raiz: " + root + ", Elemento esquerda e direita: " + left.root + " nulo, Altura: " + height;
        } else {
            return "Raiz: " + root + ", Elemento esquerda e direita: " + left.root + " " + right.root + ", Altura: " + height;
        }
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
