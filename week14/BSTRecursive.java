import java.util.LinkedList;
import java.util.Queue;
class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}
public class BSTRecursive {
    private Node root;

    // Insert
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insertRec(root.left, value);
        else
            root.right = insertRec(root.right, value);

        return root;
    }

    // Search
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (value < root.value) return searchRec(root.left, value);
        else return searchRec(root.right, value);
    }

    // Delete
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) return null;

        if (value < root.value)
            root.left = deleteRec(root.left, value);
        else if (value > root.value)
            root.right = deleteRec(root.right, value);
        else {
            // No child
            if (root.left == null && root.right == null) return null;
            // One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // Two children
            int successorValue = findMin(root.right);
            root.value = successorValue;
            root.right = deleteRec(root.right, successorValue);
        }
        return root;
    }

    private int findMin(Node root) {
        if (root.left == null) return root.value;
        return findMin(root.left);
    }

    // Count total nodes
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) return 0;
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    // Count leaf nodes
    public int countLeafNodes() {
        return countLeafRec(root);
    }

    private int countLeafRec(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafRec(root.left) + countLeafRec(root.right);
    }
    // Validate BST
    public boolean isValidBST() {
        return isValidBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBSTRec(Node root, int min, int max) {
        if (root == null) return true;
        if (root.value <= min || root.value >= max) return false;
        return isValidBSTRec(root.left, min, root.value) &&
                isValidBSTRec(root.right, root.value, max);
    }
    // Level Order Traversal
    public void levelOrderTraversal() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.value + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BSTRecursive tree = new BSTRecursive();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Total Nodes: " + tree.countNodes());
        System.out.println("Leaf Nodes: " + tree.countLeafNodes());
        System.out.println("Valid BST: " + tree.isValidBST());

        System.out.println("Level Order Traversal:");
        tree.levelOrderTraversal();

        tree.delete(50);
        System.out.println("After Deleting 50:");
        tree.levelOrderTraversal();
    }
}
