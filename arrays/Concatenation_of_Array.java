package leetcode.arrays;

public class Concatenation_of_Array {
    // fastest solution
    int arr[] = new int[nums.length * 2]; // creating new array for result
    System.arraycopy(nums,0,arr,0,nums.length); // copying upto the length of the array
    System.arraycopy(nums,0,arr,nums.length,nums.length); // now copying the same on the next n/2 elements
    return arr;
}
    // memory efficent

public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] concat = new int[n * 2];
    for (int i = 0; i < n; i++) {
        concat[i] = nums[i];
        concat[i + n] = nums[i];
    }
    return concat;
}