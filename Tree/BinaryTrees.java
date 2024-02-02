package Tree;

import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int value) {
        data = value;
        left = right = null;
    }
}

class BinaryTrees {
    static TreeNode root;

    private static Scanner sc = new Scanner(System.in);

    public void BinaryTrees() {
        System.out.println("\nLet's first build the Tree");
        // int rootValue = sc.nextInt();
        // root = new TreeNode(rootValue);
        System.out.println("Enter elements to insert into the tree (enter -1 to stop):");
        int input;
        while ((input = sc.nextInt()) != -1) {
            addNode(input);
        }
        // root = buildTree();
        System.out.println();
        printTreeStructure();
    }

    // public static TreeNode buildTree() {
    // System.out.print("Enter the root value: ");
    // int rootValue = sc.nextInt();
    // root = new TreeNode(rootValue);
    // buildTreeHelper(root);
    // return root;
    // }

    // private static void buildTreeHelper(TreeNode currentNode) {
    // System.out.print("Enter left child value for node " + currentNode.data + "
    // (Enter -1 if no left child): ");
    // int leftValue = sc.nextInt();

    // if (leftValue != -1) {
    // currentNode.left = new TreeNode(leftValue);
    // buildTreeHelper(currentNode.left);
    // }

    // System.out.print("Enter right child value for node " + currentNode.data + "
    // (Enter -1 if no right child): ");
    // int rightValue = sc.nextInt();
    // if (rightValue != -1) {
    // currentNode.right = new TreeNode(rightValue);
    // buildTreeHelper(currentNode.right);
    // }
    // }

    // private TreeNode addNodeRecursive(TreeNode root, int value) {
    // if (root == null) {
    // return new TreeNode(value);
    // }

    // if (value < root.data) {
    // root.left = addNodeRecursive(root.left, value);
    // } else if (value > root.data) {
    // root.right = addNodeRecursive(root.right, value);
    // }

    // return root;
    // }

    // Function to add a node to the binary tree
    public void addNode(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Function to delete a node from the binary tree
    public void deleteNode(int value) {
        root = deleteNodeRecursive(root, value);
    }

    private TreeNode deleteNodeRecursive(TreeNode root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = deleteNodeRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNodeRecursive(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            root.data = minValue(root.right);

            // Delete the in-order successor
            root.right = deleteNodeRecursive(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }



    // All Traversal's

    // Function to perform in-order traversal (topological sort)
    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }
    
    private void inOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRecursive(root.right);
        }
    }
    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }
    private void preOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inOrderTraversalRecursive(root.left);
            inOrderTraversalRecursive(root.right);
        }
    }
    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }
    private void postOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            inOrderTraversalRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void printTreeStructure() {
        System.out.println("Root\t2\t3\t4\t5\t6");
        System.out.println();
        printTreeStructure(root, 0);
    }

    private void printTreeStructure(TreeNode root, int level) {
        if (root != null) {
            printTreeStructure(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            System.out.println(root.data);
            printTreeStructure(root.left, level + 1);
        }
    }
}
