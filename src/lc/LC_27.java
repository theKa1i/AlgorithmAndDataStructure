package lc;

public class LC_27 {
    public int removeElement(int[] nums, int val) {
        int tail = nums.length - 1;
        for (int i = 0; i <= tail; ){
            if (nums[i] == val){
                swap(nums, i, tail--);
            } else i++;
        }
        return tail + 1;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
