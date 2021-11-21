package contest.week268;

public class No2 {
    public static int wateringPlants(int[] plants, int capacity) {
        int maxCap = capacity;
        int len = plants.length;
        int ret = 0;
        int index = 0;
        while (index < len) {
            ret += index + 1;
            while (index < len) {
                if (capacity >= plants[index]) {
                    capacity -= plants[index];
                    plants[index] = 0;
                    if (index < len - 1 && plants[index + 1] <= capacity) {
                        index++;
                        ret++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (plants[len - 1] == 0) {
                break;
            } else {
                ret += index + 1;
                capacity = maxCap;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        // System.out.println(wateringPlants(new int[] {2,2,3,3}, 5));
        System.out.println(wateringPlants(new int[] {1,1,1,4,2,3}, 4));
    }
}
