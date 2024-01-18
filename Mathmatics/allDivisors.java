import java.util.Scanner;

class allDivisors{
    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        int n = hm.nextInt();
        solve(n);
        hm.close();
    }
    static void solve(int n){
        int i=0;
        for ( i = 1; i * i<n; i++) {
            if(n%i==0){
                System.out.println(i);
            }
        }
        for (; i>0; i--) {
            if(n%i==0){
                System.out.println(n/i);
            }
        }
    }
}