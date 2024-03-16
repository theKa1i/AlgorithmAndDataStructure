package LCR;
//给定一个字符串数组 words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，
// 它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
public class LCR_005 {

    public int maxProduct(String[] words) {
        int[] has_same_char = new int[words.length];
        for (int i = 0; i < words.length; i++)
            for (char s : words[i].toCharArray()) has_same_char[i] |= (1 << (s - 'a'));

        int max = 0;
        int n = words.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1 ; j < n; j++){
                if ((has_same_char[i] & has_same_char[j]) == 0) max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }
}
