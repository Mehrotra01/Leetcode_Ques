package matrix;

import java.util.Scanner;

public class matrixMultiplication {

    public static int[][] takeInput(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int rows1 = sc.nextInt();
        System.out.println("Enter cols");
        int cols1 = sc.nextInt();
        
        int mat1[][] = new int[rows1][cols1];
        int count =0;
        for(int i=0;i<rows1;i++){
            for( int z=0;z<cols1;z++){
                System.out.print("Enter element "+count++  +": ");
                mat1[i][z]=sc.nextInt();
            }
            }
        return mat1;
    }
    
    public static void printMatrix(int[][] mat){
        System.out.println("Your result matrix is");
        for(int i=0;i<mat.length;i++){
            for( int z=0;z<mat[0].length;z++){
                System.out.print(mat[i][z]+" ");
            }
            System.out.println();
        }

    }
    
    public static void main(String[] args) {
        System.out.println("Input first matrix");
        int[][] mat1 = takeInput();
        System.out.println("Input 2nd matrix");
        int[][] mat2 = takeInput();
        
        int mat[][] = new int[mat1.length][mat2[0].length];
        if(mat1[0].length==mat2.length){
            for(int i=0;i<mat1.length;i++){
                for( int z=0;z<mat2[0].length;z++){

                    mat[i][z]=00;

                    for(int y=0;y<mat2.length;y++){
                        mat[i][z]+=mat1[i][y]*mat2[y][z];
                    }
                    
                }
            }
            printMatrix(mat);

        }else{
            System.out.println("these matrix can't be multipled");
        }
    }
}
