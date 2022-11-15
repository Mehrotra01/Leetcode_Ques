class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []arr = new int[2];
      arr[0] = findElementPosition(nums, target, true);
        arr[1] = findElementPosition(nums, target, false);
        return arr;
    }
    
    public static int findElementPosition(int[] nums, int target, boolean firstIndex) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                if (firstIndex) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ans;
    }
}
