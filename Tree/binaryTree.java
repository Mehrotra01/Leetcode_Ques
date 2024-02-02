package Tree;

import java.util.Scanner;

public class binaryTree {

    static Scanner sc = new Scanner(System.in);

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static Node root;

    public binaryTree() {
        root = null;
    }

    public static Node buildTree() {
        System.out.print("Enter the root value: ");
        int rootValue = sc.nextInt();
        root = new Node(rootValue);
        buildTreeHelper(root);
        return root;
    }

    private static void buildTreeHelper(Node currentNode) {
        System.out.print("Enter left child value for node " + currentNode.data + " (Enter -1 if no left child): ");
        int leftValue = sc.nextInt();

        if (leftValue != -1) {
            currentNode.left = new Node(leftValue);
            buildTreeHelper(currentNode.left);
        }

        System.out.print("Enter right child value for node " + currentNode.data + " (Enter -1 if no right child): ");
        int rightValue = sc.nextInt();
        if (rightValue != -1) {
            currentNode.right = new Node(rightValue);
            buildTreeHelper(currentNode.right);
        }
    }

    public void insert(int d) {
        root = insertRec(root, d);
    }

    private Node insertRec(Node root, int d) {

        if (root == null) {
            return root = new Node(d);
        }

        if (d < root.data) {
            root.left = insertRec(root.left, d);
        } else if (d > root.data) {
            root.right = insertRec(root.right, d);
        } else {
            System.out.println("Data " + d + " already exists in the tree.\nIgnoring insertion.");
        }
        return root;
    }

    public void search(int key) {
        if (searchRec(root, key)) {
            System.out.println("This element is present");
        } else {
            System.out.println("Not Found");
        }
    }

    private boolean searchRec(Node root, int key) {
        if (root == null || root.data == key) {
            return root != null;
        }

        if (key < root.data) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right
            // subtree)

            root.data = minValue(root.right);
            // Delete the inorder successor

            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inorderRec(root.left);
            inorderRec(root.right);
        }
    }

    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            inorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

}
