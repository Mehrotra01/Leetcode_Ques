import java.util.concurrent.atomic.AtomicInteger; 
class Solution {
    public int minCut(String s) {
         AtomicInteger  minCut = new AtomicInteger(Integer.MAX_VALUE);
    solve(s,new String(),0,minCut); 
        return minCut.intValue()-1;
    }
    static void solve(String ques,String ans,int count,AtomicInteger  minCut){
        if(ques.length()==0){
            if(count<minCut.get()){
                minCut.set(count); //Got TLE int the solution but the try was worth it
                count=0;
                return ;
            }
        }
        
        for(int i=1;i<=ques.length();i++){
            String s = ques.substring(0,i);
            if(isPalindrome(s)){
                count=count+1;
                solve(ques.substring(i),s,count,minCut);
                count=count-1;
            }
        }
    }
    static boolean isPalindrome(String s){
        int start=0;
        int end = s.length()-1;
            while(start<end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                    
                }
                start++;
                end--;
            }
        return true;
    }
}
