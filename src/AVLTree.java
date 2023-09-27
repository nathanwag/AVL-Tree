public class AVLTree {
    private Node root;

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

        updateHeight(node);
        return balance(node);
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

        updateHeight(node);
        return balance(node);
    }

    private Node findMinimum(Node node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    // BALANCE FACTOR

    private int calculateHeight(Node node) {
        return node != null ? node.getHeight() : -1;
    }

    private int balanceFactor(Node node) {
        return calculateHeight(node.getLeft()) - calculateHeight(node.getRight());
    }

    private void updateHeight(Node node) {
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        node.setHeight(leftHeight - rightHeight + 1);
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.getLeft();

        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.getRight();

        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private Node balance(Node node) {
        int balanceFactor = balanceFactor(node);

        if(balanceFactor > 1) {
            if(balanceFactor(node.getLeft()) <= 0) {
                // ROTATE RIGHT
                node = rotateRight(node);
            } else {
                // ROTATE RIGHT-LEFT
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }

        if(balanceFactor < -1) {
            if(balanceFactor(node.getRight()) >= 0) {
                // ROTATE LEFT
                node = rotateLeft(node);
            } else {
                // ROTATE LEFT-RIGHT
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }

        return node;
    }
}
