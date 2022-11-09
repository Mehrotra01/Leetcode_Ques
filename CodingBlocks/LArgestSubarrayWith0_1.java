package CodingBlocks;

import java.util.Scanner;

public class LArgestSubarrayWith0_1 {
    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        int t = hm.nextInt();
        for (int ab = 0; ab < t; ab++) {
            int n = hm.nextInt();
            int arr[] = new int[n];
            int count0 = 0;
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = hm.nextInt();
                if (arr[i] == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
            if(count0==0 || count1==0){
                System.out.println("None");
                continue;
            }
            
        }
        hm.close();
    }
}
