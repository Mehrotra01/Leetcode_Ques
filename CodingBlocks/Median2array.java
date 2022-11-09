package CodingBlocks;

import java.util.Scanner;

class Median2array {
    static Scanner hm = new Scanner(System.in);

    public static void main(String[] args) {
        int n = hm.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arrayInput(arr1, n);
        arrayInput(arr2, n);
        int[] arr = mergeArray(arr1, arr2);
        System.out.println(medianArr(arr, arr.length));
        
        hm.close();
    }

    static int medianArr(int[] arr, int n) {
        if (n % 2 != 0) {
            return arr[n / 2];
        }
        return (int) ((arr[(n - 1) / 2] + arr[n / 2]) / 2);

    }

    static int[] mergeArray(int[] arr1, int arr2[]) {
        int k = 0;
        int i = 0;
        int j = 0;
        int[] arr = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1.length) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr1.length) {
            arr[k] = arr2[j];
            j++;
            k++;
        }

        return arr;
    }

    static void arrayInput(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = hm.nextInt();
        }
    }
}
