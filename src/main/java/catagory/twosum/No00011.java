package catagory.twosum;

public class No00011 {
    public static int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = height[0];
        int right = height[height.length - 1];
        int maxArea = Math.min(left, right) * (height.length - 1);
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (left >= right) {
                while (j >= 0 && height[j] <= right) {
                    j--;
                }
                if (j >= 0 && i < j) {
                    right = height[j];
                    maxArea = Math.max(maxArea, Math.min(left, right) * (j - i));
                }
            } else {
                while (i < height.length && height[i] <= left) {
                    i++;
                }
                if (i < height.length && i < j) {
                    left = height[i];
                    maxArea = Math.max(maxArea, Math.min(left, right) * (j - i));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // System.out.println(maxArea(new int[]{4,3,2,1,4}));
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
