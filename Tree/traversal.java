package Tree;

import java.util.Scanner;

public class traversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTrees binaryTree = new BinaryTrees();
        System.out.println("Binary Tree Operations");
        System.out.println("1. Add Node");
        System.out.println("2. Delete Node");
        System.out.println("3. Print In-order Traversal ");
        System.out.println("4. Print Pre-order Traversal");
        System.out.println("5. Print Post-order Traversal");
        System.out.println("6. Print Level-order Traversal");
        System.out.println("7. Print Reverse Level-order Traversal:");
        System.out.println("8. Print Tree Structure");
        System.out.println("9. Print Number of leaf Node");
        System.out.println("10. Print Height of the tree");
        System.out.println("11. Print Root Value");
        System.out.println("12. Print Diameter of the Tree");
        System.out.println("0. Exit");

        binaryTree.BinaryTrees();
        int choice;
        do {
            System.out.print("\nEnter the no. of Operation: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to add: ");
                    int addValue = scanner.nextInt();
                    binaryTree.addNode(addValue);
                    break;
                case 2:
                    System.out.print("Enter the value to delete: ");
                    int deleteValue = scanner.nextInt();
                    binaryTree.deleteNode(deleteValue);
                    break;
                case 3:
                    System.out.println("In-order Traversal: ");
                    binaryTree.inOrderTraversal();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Pre-order Traversal: ");
                    binaryTree.preOrderTraversal();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Post-order Traversal: ");
                    binaryTree.postOrderTraversal();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Level-order Traversal: ");
                    binaryTree.levelOrderTraversal();
                    break;
                case 7:
                    System.out.println("Reverse Level-order Traversal: ");
                    binaryTree.reverseLevelOrder();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Tree structure: ");
                    binaryTree.printTreeStructure();
                    System.out.println();
                    break;
                case 9:
                    System.out.print("Number of leaf Node: ");
                    binaryTree.countLeafNode();
                    break;
                case 10:
                    System.out.print(" Height of the tree: ");
                    binaryTree.heightOfTree();
                    break;
                case 11:
                    System.out.println("Value of Root Node: " + BinaryTrees.root.data);
                    break;
                case 12:
                    System.out.print("Diameter of the Tree: ");
                    binaryTree.diameterOfTree();
                    break;

                case 0:
                    System.out.println("Exiting program....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

}
