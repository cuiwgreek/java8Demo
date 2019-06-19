package com.cuiwjava;

import java.util.Arrays;

/**
 * Created by caden on 2017/5/4.
 */
public class SearchMain {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int[] seq = {654, 671, 677, 686, 699, 703, 716, 729, 738, 752, 794, 807, 828, 829, 981, 1276, 1381, 1383, 1384, 1385, 1386, 1387, 1523, 1524, 1525, 1526, 1527, 1528, 1529, 1581, 1583, 1584, 1585, 1625, 2641, 3258, 3259, 3260, 3261, 3262, 3263, 3264, 3265, 3266, 3267, 3269, 3270, 3271, 3272, 3273, 3274, 3275, 3276, 3277, 3279, 3280, 3281, 3282, 3284, 3285, 3286, 3287, 3288, 3289, 3290, 3291, 3294, 3296, 4758, 4826, 4830, 4855, 4973, 4976, 4979, 4980, 4997, 5019, 6313, 6740, 6742, 6743, 6745, 6747, 6929, 9193, 9194, 9195, 9196, 9197, 9278, 9291, 9301, 9309, 9314, 9340, 9351, 9368, 11047, 11745, 11842, 12190, 12193, 12202, 12345, 12346, 12402, 12632, 12775, 12776, 12800, 13256, 13297, 13613, 13627, 13634, 13893, 14203, 14669, 14857, 14941, 16831, 16832, 16943, 16946, 16951, 16962, 17394, 17407};
        System.out.println(" seq.size "+ seq.length);
//        int result = search(seq, 5, 0, seq.length);
//        System.out.println(result);
//
//        result = search2(seq, 5, 0, seq.length);
//        System.out.println(result);

        int result = Arrays.binarySearch(seq,0,seq.length,17407);
        //System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);

    }


    public static int search(int[] seq, int v, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (v == seq[mid]) {
                return mid;
            } else if (v > seq[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return Integer.MIN_VALUE;
    }

    public static int search2(int[] seq, int v, int low, int high) {
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        int mid = (low + high) / 2;
        if (v == seq[mid]) {
            return mid;
        } else if (v > seq[mid]) {
            return search2(seq, v, mid + 1, high);
        } else {
            return search2(seq, v, low, mid - 1);
        }
    }
}