import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {

    Node root;

    // Insert into BST
    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    public void insert(int val) {
        root = insert(root, val);
    }

    // Inorder Traversal
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void inorder() {
        inorder(root);
    }

    // Preorder Traversal
    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void preorder() {
        preorder(root);
    }

    // Postorder Traversal
    public void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void postorder() {
        postorder(root);
    }

    // Search in BST
    public boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public boolean search(int key) {
        return search(root, key);
    }

    // Find Minimum
    public int findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root.data;
    }

    public int findMin() {
        return findMin(root);
    }

    // Find Maximum
    public int findMax(Node root) {
        while (root.right != null)
            root = root.right;
        return root.data;
    }

    public int findMax() {
        return findMax(root);
    }

    // Height of BST
    public int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int height() {
        return height(root);
    }

    // Delete node
    public Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: get inorder successor
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    // Main method
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder: ");
        tree.inorder();
        System.out.println();

        System.out.print("Preorder: ");
        tree.preorder();
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder();
        System.out.println();

        System.out.println("Search 40: " + tree.search(40));
        System.out.println("Minimum: " + tree.findMin());
        System.out.println("Maximum: " + tree.findMax());
        System.out.println("Height: " + tree.height());

        tree.delete(70);
        System.out.print("Inorder after deleting 70: ");
        tree.inorder();
        System.out.println();
    }
}
