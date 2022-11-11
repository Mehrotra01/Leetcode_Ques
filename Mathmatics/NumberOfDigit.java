import java.util.Scanner;

public class NumberOfDigit {
    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        int n = hm.nextInt();
        System.out.println(solve(n));
        hm.close();
    }

    static int solve(int n) {
        return (int) Math.floor(Math.log10(n) + 1);
    }
}