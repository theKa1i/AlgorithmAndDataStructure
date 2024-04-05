package lc;

import java.util.Arrays;

public class LC_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int s1 = m - 1, s2 = n - 1, ptr = m + n - 1;

        while (s1 >= 0 || s2 >= 0){
            if (s1 == -1)
                nums1[ptr--] = nums2[s2--];
            else if(s2 == -1)
                nums1[ptr--] = nums1[s1--];
            else if(nums1[s1] > nums2[s2])
                nums1[ptr--] = nums1[s1--];
            else nums1[ptr--] = nums2[s2--];
        }
    }
}
