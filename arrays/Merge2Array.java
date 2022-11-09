public class Merge2Array {

    public static void main(String[] args) {
        int[] arr1 = { 1, 6, 8, 9 };
        int[] arr2 = { 2, 3, 4, 5, 7 };
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);
        return median(arr, arr.length);

    }

    static double median(int[] arr, int n) {
        if (n % 2 == 0) {
            return (double) (arr[arr.length / 2] + arr[(arr.length / 2) - 1]) / 2;
        } else {
            return arr[n / 2];
        }
    }

    static int[] merge(int[] arr1, int[] arr2) {

        int[] arr = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                k++;
                j++;
            }
        }
        while (i < arr1.length) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
        return arr;
    }

}
