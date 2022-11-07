
public class Most_words {
    public int mostWordsFound(String[] sentences) {
        int sum = 0;
        for (String s : sentences) {
            String[] words = s.split(" ");
            if (words.length > sum) {
                sum = words.length;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        
    }
}
