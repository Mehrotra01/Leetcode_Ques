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
        System.out.println("6. Print Tree Structure");
        System.out.println("7. Print Root Value");
        System.out.println("0. Exit");

        binaryTree.BinaryTrees();
        int choice;
        do {
            System.out.print("\nEnter your choice: ");
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
                    System.out.println("Tree structure: ");
                    binaryTree.printTreeStructure();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Value of Root: " + BinaryTrees.root.data);
                    System.out.println();
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
