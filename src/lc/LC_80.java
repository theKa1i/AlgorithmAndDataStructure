package lc;

public class LC_80 {
    public int removeDuplicates(int[] nums) {
        int tail = 0;
        boolean check = true;
        for (int i = 1; i < nums.length; ) {
            if (nums[i] == nums[tail]){
                if (check){
                    check = false;
                    swap(nums, ++tail, i);
                }
                i++;
            } else {
                check = true;
                swap(nums, ++tail, i++);
            }
        }
        return tail + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
