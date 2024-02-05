package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

    protected TreeNode insertRec(TreeNode root, int data) {
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

    protected TreeNode deleteNodeRecursive(TreeNode root, int value) {
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

    protected int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public void countLeafNode() {
        System.out.println(countLeafNode(root));
    }

    protected int countLeafNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeafNode(root.right) + countLeafNode(root.left);
    }

    public void heightOfTree() {
        System.out.println(
                heightOfTree(root) + " (or it can be " + (heightOfTree(root) - 1) + " upon how you consider)");
    }

    protected int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }

    class treeHeight {
        static int h;
    }

    public void diameterOfTree() {
        // System.out.println(diameterOfTree(root));
        if (root.left == null && root.right == null) {
            System.out.println(1);
            return;
        }
        treeHeight h = new treeHeight();
        System.out.println(diameterOfTree(root, h));
        return;
    }

    // protected int diameterOfTree(TreeNode root) {
    // if(root ==null){return 0;}

    // int op1= diameterOfTree(root.left);
    // int op2 =diameterOfTree(root.right);
    // int op3 =heightOfTree(root.left)+1+heightOfTree(root.right);
    // int diameter = Math.max(op1,Math.max(op2,op3));
    // return diameter;
    // } //but complexity of it's is n^2 cause we are calling height function as
    // well

    protected int diameterOfTree(TreeNode root, treeHeight h) {
        treeHeight leftHeight = new treeHeight();
        treeHeight rightHeight = new treeHeight();
        if (root == null) {
            treeHeight.h = 0;
            return 0;
        }

        int op1 = diameterOfTree(root.left, leftHeight);
        int op2 = diameterOfTree(root.right, rightHeight);

        treeHeight.h = Math.max(leftHeight.h, rightHeight.h) + 1;
        return Math.max(leftHeight.h + rightHeight.h + 1, Math.max(op1, op2));

    } // this have a complexity of o(n)
      // All Traversal's

    // Function to perform in-order traversal (topological sort)
    public void inOrderTraversal() {
        System.out.println("L N R");
        inOrderTraversalRecursive(root);
    }

    protected void inOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            System.out.print(root.data + " ");
            inOrderTraversalRecursive(root.right);
        }
    }

    public void preOrderTraversal() {
        System.out.println("N L R");
        preOrderTraversalRecursive(root);
    }

    protected void preOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inOrderTraversalRecursive(root.left);
            inOrderTraversalRecursive(root.right);
        }
    }

    public void postOrderTraversal() {
        System.out.println("L R N");
        postOrderTraversalRecursive(root);
    }

    protected void postOrderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inOrderTraversalRecursive(root.left);
            inOrderTraversalRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    protected void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(node);
        que.add(null); // to show it like a traingle or tree

        while (!que.isEmpty()) {
            TreeNode temp = que.poll();

            if (temp == null) {
                System.out.println();
                if (!que.isEmpty()) {
                    que.add(null);
                }
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
            }
        }
    }

    public void reverseLevelOrder() {
        reverseLevelOrder(root);
    }

    protected void reverseLevelOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                stack.push(null);
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                stack.push(current);
                if (current.right != null)
                    queue.add(current.right);
                if (current.left != null)
                    queue.add(current.left);
            }
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                System.out.println();
            } else {
                System.out.print(node.data + " ");
            }
        }
    }

    public void printTreeStructure() {
        System.out.println("Root\t2\t3\t4\t5\t6");
        System.out.println();
        printTreeStructure(root, 0);
    }

    protected void printTreeStructure(TreeNode root, int level) {
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
