public class AVLTree {

    private class Node {
        private int value;
        private int height;
        private Node left,right;
        private Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }
    private Node root;

    public void add(int value) {
        this.root = add(this.root, value);
    }
    private Node add(Node node, int value) {
        if(node == null) {
            Node newNode = new Node(value);
            return newNode;
        }
        else if(value < node.value) {
            node.left = add(node.left, value);
        }
        else if(value > node.value) {
            node.right = add(node.right, value);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);

        // LL rotation
        if(balanceFactor > 1 && value < node.left.value)
            return rightRotate(node);
        // RR rotation
        else if(balanceFactor < -1 && value > node.right.value)
            return leftRotate(node);
        // LR rotation
        else if(balanceFactor > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL rotation
        else if(balanceFactor < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private int getHeight(Node node) {
        if(node == null) 
            return 0;
        return node.height;
    }
    private int getBalanceFactor(Node node) {
        if(node == null) 
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        return y;
    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }
    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
}
