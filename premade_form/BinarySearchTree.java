class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (root.key > key) {
            root.left = insertRec(root.left, key);
        } else if (root.key < key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (root.key > key) {
            root.left = deleteRec(root.left, key);
        } else if (root.key < key) {
            root.right = deleteRec(root.right, key);
        } else {
            // When key matches
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
        }
        return root;
    }

    int minValue(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        tree.inorder();

        System.out.println("delete 20");
        tree.delete(20);
        tree.delete(20);
        tree.inorder();
    }
}