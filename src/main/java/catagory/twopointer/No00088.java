package catagory.twopointer;

public class No00088 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = m + n + 1; i >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n--];
            } else if (n < 0) {
                nums1[i] = nums1[m--];
            } else {
                if (nums1[m] > nums2[n]) {
                    nums1[i] = nums1[m];
                    m--;
                } else {
                    nums1[i] = nums2[n];
                    n--;
                }
            }
        }
    }

    public static void main(String[] args) {
        merge(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2,5,6}, 3);
    }
}
