package catagory.binarysearch;

public class No00004 {
    // FIXME:
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m + n % 2 == 0) {
            return (double) (helper(nums1, 0, m, nums2, 0, n, (m + n) / 2 - 1) + helper(nums1, 0, m, nums2, 0, n, (m + n) / 2)) / 2;
        } else {
            return (helper(nums1, 0, m, nums2, 0, n, (m + n) / 2));
        }
    }

    private static int helper(int[] nums1, int a, int m, int[] nums2, int b, int n, int k) {

        if (m == 0) {
            return nums2[b + k - 1];
        }

        if (n == 0) {
            return nums1[a + k - 1];
        }

        if (k == 0) {
            return Math.min(nums1[a], nums1[b]);
        }

        int k1 = Math.min(k / 2, m - 1);
        int k2 = k = k1;

        if (nums1[k1] < nums2[k2]) {
            return helper(nums1, a + k1 + 1, m - k1 - 1, nums2, b, n, k - k1 - 1);
        } else if (nums1[k1] > nums1[k2]){
            return helper(nums1, a, m, nums2, b + k2 + 1, n - k2 - 1, k - k2 -1);
        } else {
            return nums1[k1];
        }
    }
}
