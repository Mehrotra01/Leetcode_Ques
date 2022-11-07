import java.util.Scanner;

public class max69Number {
    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        int num = hm.nextInt();
        String numString = "" + num;
        System.out.println( Integer.parseInt(numString.replaceFirst("6", "9")));        hm.close();
    }
    
}
