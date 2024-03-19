package LCR;

public class LCR_068 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        if (target < nums[0]) return 0;
        int mid = (nums.length / 2), start = 0, end = nums.length;
        while (true){
            if (nums[mid] == target || (nums[mid - 1] <target && nums[mid] > target)) return mid;
            else if (nums[mid - 1] >= target){
                end = mid;
                mid = (mid+start) / 2;
            } else if (nums[mid] < target) {
                start = mid;
                mid = (mid + end) / 2;
            }
        }
    }
}
