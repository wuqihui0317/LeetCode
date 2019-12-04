package Forty_OneToSixty;
/**
 * @author wub
 * LeetCode
 * 43.Multiply String
 * 两数相乘，不能用BigInteger这些算，也不能直接把输入值转为整数
 */
public class MultiplyString {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] num_1;
        char[] num_2;
        //num_2代表长度较短数
        if (len1 < len2){
            int temp = len1;len1 = len2;len2 = temp;
            num_1 = num2.toCharArray();num_2 = num1.toCharArray();
        }else{
            num_1 = num1.toCharArray();num_2 = num2.toCharArray();
        }
        if (len2 < 10 && Integer.parseInt(new StringBuilder().append(num_2).toString()) == 0)  return "0";
        //计算num_1与num_2单个数相乘结果
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = len2-1; i >= 0; i--) {
            int count = 0;//进位
            sb.delete(0,sb.length());
            for (int j = len1-1; j >= 0; j--) {
                int a = num_2[i] - '0';
                if (a == 0) break;
                int temp = count + a * (num_1[j] - '0');
                sb.append(temp%10);
                count = temp/10;
            }
            if (sb.length() == 0)   continue;
            if (count != 0) sb.append(count);
            sb.reverse();
            for (int j = len2-1; j > i; j--) {
                sb.append(0);
            }
            add(result,sb.toString());
        }
        return result.toString();
    }
    //将num加到result中
    public void add(StringBuilder result,String num){
        if (result.length() == 0){
            result.append(num);return;
        }
        char[] num1 = result.toString().toCharArray();
        char[] num2 = num.toCharArray();
        result.delete(0,num1.length);
        //num1较长 num2较短
        if (num1.length < num2.length){
            char[] temp = num1;num1 = num2;num2 = temp;
        }
        int count = 0;//进位
        int len1 = num1.length;
        int len2 = num2.length;
        for (int i = 0; i < len2; i++) {
            int temp = num1[len1-1-i] - '0' + num2[len2-1-i] - '0' + count;
            count = temp/10;
            result.append(temp%10);
        }
        for (int i = len2; i < len1; i++) {
            if (count == 0) {
                for (int j = i; j < len1; j++) {
                    result.append(num1[len1 - 1 - j]);
                }
                break;
            }
            int temp = num1[len1-1-i] - '0' + count;
            count = temp/10;
            result.append(temp%10);
        }
        if (count == 1)
            result.append(1);
        result.reverse();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyString().multiply("498828660196","840477629533"));
    }
}
