package contest.week268;

import java.util.*;

public class RangeFreqQuery {
    private Map<Integer, ArrayList<Integer>> theMap;

    public RangeFreqQuery(int[] arr) {
        theMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (theMap.containsKey(arr[i])) {
                theMap.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                theMap.put(arr[i], newList);
            }
        }
    }

    public int query(int left, int right, int value) {
        if (theMap.get(value) == null) {
            return 0;
        }
        int ret = 0;
        ArrayList<Integer> indexArrayList = theMap.get(value);
        // FIXME: I think its mainly because the Array.Copy() takes O(N) time here, the java is really disgusting
        Integer[] indexArray = indexArrayList.toArray(new Integer[0]);
        int leftIndex = Arrays.binarySearch(indexArray, left);
        if (leftIndex < 0) {
            int IP = -(leftIndex + 1);
            leftIndex = IP;
        }
        int rightIndex = Arrays.binarySearch(indexArray, right);
        if (rightIndex < 0) {
            int IP = -(rightIndex + 1);
            if (IP == indexArray.length) {
                rightIndex = IP - 1;
            } else {
                if (indexArray[IP] == rightIndex) {
                    rightIndex = IP;
                } else {
                    rightIndex = IP - 1;
                }
            }
        }
        if (rightIndex >= leftIndex) {
            ret = rightIndex - leftIndex + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        RangeFreqQuery query = new RangeFreqQuery(new int[] {3,4,5,3,3,2,2,2,5,4});
        System.out.println(query.query(0, 2, 3));
       //  System.out.println(query.query(0, 11, 33));
    }
}

/**
 * ["RangeFreqQuery","query","query","query","query","query"]
 * [[[3,4,5,3,3,2,2,2,5,4]],[2,6,3],[5,6,5],[1,6,2],[0,2,3],[5,6,4]]
 */
