package matrix;

import java.util.Scanner;

public class inverse {
    static Scanner sc = new Scanner(System.in);

    public static int checkInitalInput() {
        boolean flag = true;
        int ans = 0;
        while (flag) {

            String userInput = sc.next().trim();
            if (isCmd(userInput)) {
                ans = Integer.parseInt(userInput);
                flag = false;
            } else {
                System.out.println("press a valid key between 1-5");
            }
        }
        return ans;
    }

    public static boolean isCmd(String str) {
        return str.matches("[0-5]");
    }

    public static int[][] takeInput() {

        boolean flag = true;
        int row = 0;
        int col = 0;
        while (flag) {

            System.out.println("Enter rows");
            int rows1 = sc.nextInt();
            System.out.println("Enter cols");
            int cols1 = sc.nextInt();
            if (rows1 == cols1) {
                flag = false;
                row = rows1;
                col = cols1;
            } else {
                System.out.println("We Cannot find the inverse of a matrix which is not a square matrix");
            }
        }
        int mat1[][] = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int z = 0; z < col; z++) {
                System.out.print("Enter element " + count++ + ": ");
                mat1[i][z] = sc.nextInt();
            }
        }
        return mat1;
    }

    public static void printMatrix(int[][] mat) {
        System.out.println("Your result matrix is");
        for (int i = 0; i < mat.length; i++) {
            for (int z = 0; z < mat[0].length; z++) {
                System.out.print(mat[i][z] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMatrix(float[][] mat) {
        System.out.println("Your result matrix is");
        for (int i = 0; i < mat.length; i++) {
            for (int z = 0; z < mat[0].length; z++) {
                System.out.printf("%.6f  ", mat[i][z]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static int Determinant(int a[][], int n) {
        int res = 0;
        if (n == 1) {
            return a[0][0];
        }
        int temp[][] = new int[n - 1][n - 1];
        int sign = 1;
        for (int i = 0; i < n; i++) {
            getCofactor(a, temp, n, 0, i);
            res += sign * a[0][i] * Determinant(temp, n - 1);
            sign = -sign;
        }
        return res;
    }

    static void getCofactor(int a[][], int temp[][], int n, int x, int y) {

        int xrow = 0;
        int xcol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != x && j != y) {
                    temp[xrow][xcol++] = a[i][j];

                    if (xcol == n - 1) {
                        xcol = 0;
                        xrow++;
                    }
                }
            }
        }
    }

    static void Adjoint(int[][] a, int[][] adj, int n) {
        if (n == 1) {
            adj[0][0] = 1;
            return;
        }
        int sign = 1;
        int[][] temp = new int[n][n];

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                getCofactor(a, temp, n, i, j);
                // sign= -sign;
                sign = ((i + j) % 2 == 0) ? 1 : -1; // sign of adj[j][i] positive if sum of row and column indexes is
                                                    // even.
                adj[j][i] = (sign) * (Determinant(temp, n - 1));// Interchanging rows and columns to get the transpose
                                                                // of the cofactor matrix

            }
        }
    }

    static boolean Inverse(int A[][], float[][] inverse, int n) {
        int det = Determinant(A, n);
        System.out.println("Determinant for the matrix: " + det);
        if (det == 0) {
            System.out.println("Singular matrix, can't find its inverse");
            return false;
        }
        int[][] adj = new int[n][n];
        Adjoint(A, adj, n);
        System.out.println("Adjoint of the matrix : ");
        printMatrix(adj);

        // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = adj[i][j] / (float) det;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter a command: ");
            System.out.println("1 to Determinant");
            System.out.println("2 to Cofactors");
            System.out.println("3 to Adjoint");
            System.out.println("4 to Inverse");
            System.out.println("5 to Exit");

            int userInput = checkInitalInput();

            if (userInput == 5) {
                System.out.println("Exiting program...");
                System.exit(0);
            }

            switch (userInput) {
                case 1:
                    System.out.println("Determinant");
                    System.out.println("Input matrix");
                    int[][] mat1 = takeInput();
                    System.out.println(Determinant(mat1, mat1.length) + " Determinant");
                    break;
                case 2:
                    System.out.println("Coffactors");
                    System.out.println("Input matrix");
                    int[][] cmat = takeInput();
                    int temp[][] = new int[cmat.length - 1][cmat.length - 1];
                    for (int i = 0; i < cmat.length; i++) {
                        getCofactor(cmat, temp, cmat.length, 0, i);
                        printMatrix(temp);
                    }
                    break;
                case 3:

                    System.out.println("Adjoint");
                    System.out.println("Input matrix");
                    int[][] mat2 = takeInput();
                    int n = mat2.length;
                    int[][] adj = new int[n][n];
                    Adjoint(mat2, adj, n);
                    printMatrix(adj);
                    break;
                case 4:
                    System.out.println("Inverse");
                    System.out.println("Input matrix");
                    int[][] mat3 = takeInput();
                    int n1 = mat3.length;
                    float[][] inverse = new float[n1][n1];
                    if (Inverse(mat3, inverse, mat3.length)) {
                        printMatrix(inverse);
                    }
                    break;
                default:
                    System.out.println("press a valid key between 1-4");
                    break;
            }

        }
    }
}
