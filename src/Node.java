public class Node {
    private int root, height;
    private Node left, right;

    public Node(int root) {
        this.root = root;
        left = null;
        right = null;
        height = 0;
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
