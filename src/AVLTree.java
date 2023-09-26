public class AVLTree {
    private Node root;

    public AVLTree() {

    }

    // SEARCH AN ELEMENT

    public Node search(int key) {
        return searchRecursive(key, root);
    }

    private Node searchRecursive(int key, Node node) {
        if(node == null) {
            return null;
        }
        if(key == node.getRoot()) {
            return node;
        } else if(key < node.getRoot()) {
            return searchRecursive(key, node.getLeft());
        } else {
            return searchRecursive(key, node.getRight());
        }
    }

    // INSERT AN ELEMENT

    public void insert(int key) {
        root = insertRecursive(key, root);
    }

    private Node insertRecursive(int key, Node node) {
        if(node == null) {
            node = new Node(key);
        } else if(key < node.getRoot()) {
            node.setLeft(insertRecursive(key, node.getLeft()));
        } else if(key > node.getRoot()) {
            node.setRight(insertRecursive(key, node.getRight()));
        } else {
            System.out.println("There is already an element with this key!");
        }

        return node;
    }

    // DELETE AN ELEMENT

    public void delete(int key) {
        root = deleteRecursive(key, root);
    }

    private Node deleteRecursive(int key, Node node) {
        if(node == null) {
            return null;
        }

        if(key < node.getRoot()) {
            node.setLeft(deleteRecursive(key, node.getLeft()));
        } else if(key > node.getRoot()) {
            node.setRight(deleteRecursive(key, node.getRight()));
        }

        // NO CHILDREN
        else if(node.getLeft() == null && node.getRight() == null) {
            node = null;
        }
        // ONE CHILDREN
        else if(node.getLeft() == null) {
            node.setRoot(node.getRight().getRoot());
        } else if(node.getRight() == null) {
            node.setRoot(node.getLeft().getRoot());
        }
        // TWO CHILDREN
        else {
            Node minimumRight = findMinimum(node.getRight());
            node.setRoot(minimumRight.getRoot());
            node.setRight(deleteRecursive(minimumRight.getRoot(), node.getRight()));
        }
        return node;
    }

    private Node findMinimum(Node node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
