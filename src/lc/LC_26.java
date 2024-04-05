package lc;

public class LC_26 {
    public int removeDuplicates(int[] nums) {
        int tail = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[tail] == nums[i]) i++;
            else swap(nums, ++tail, i++);
        }
        return tail + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
