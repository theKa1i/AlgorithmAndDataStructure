package LCR;
//给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
//函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
//
//假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
public class LCR_006 {
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0;
        int ptr2 = numbers.length - 1;
        while (true){
            if (numbers[ptr1] + numbers[ptr2] > target) ptr2 --;
            else if (numbers[ptr1] + numbers[ptr2] < target) ptr1++;
            else return new int[]{ptr1, ptr2};
        }
    }
}
