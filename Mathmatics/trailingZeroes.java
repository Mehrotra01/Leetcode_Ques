class Solution {
    public int trailingZeroes(int n) {
       int count = 0;
        while(n>=5){
            n/=5;
            count+=n;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int n=s.trailingZeroes(15);
        System.out.println(n);
    }
}

// The idea is we can count how many 2 & 5 pairs we have because
// of them trailing zeroes are coming
// Considering the fact that the number of 5 are less than the number of 2 we simply we can count the number of zeroes
// and even we have a benefit that we have a comlpexity of log(n)