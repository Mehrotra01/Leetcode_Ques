package CodingBlocks;

import java.util.Scanner;

public class arrayBinarySeach {
    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        int n = hm.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = hm.nextInt();
        }
        int target = hm.nextInt();
        System.out.println(solve(arr, target));
        hm.close();
    }

    static int solve(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (end + (end - start)) / 2;
        while (start < end) {
            if (target == arr[mid]) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (end + (end - start)) / 2;
        }
        return -1;
    }
}
