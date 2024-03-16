package LCR;
//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
//
//输入为 非空 字符串且只包含数字 1 和 0。
public class LCR_002 {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while(i >= 0 || j >= 0 || c != 0){
            int i_digit = i >= 0 ? a.charAt(i) - '0' : 0;
            int j_digit = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = i_digit + j_digit + c;
            c = sum >= 2 ? 1 : 0;
            sum %= 2;
            sb.append(sum);
            i--;j--;
        }
        return sb.reverse().toString();
    }
}
