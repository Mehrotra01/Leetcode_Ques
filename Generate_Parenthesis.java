import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generate_Parenthesis {

    public static void main(String[] args) {
        Scanner hm = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        int n = hm.nextInt();
        solve(0, 0, n, res, new String());
        System.out.println(res);
        hm.close();
    }

    static void solve(int open, int close, int n, List<String> res, String ans) {
        if(open ==n && close ==n){
            res.add(new String(ans));
            return;
        }

        if(open<n){
            solve(open+1, close, n, res, ans+"(");
        }
        if(close<open){
            solve(open, close+1, n, res, ans+")");
        }
    }
}
