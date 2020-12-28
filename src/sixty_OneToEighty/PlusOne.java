package sixty_OneToEighty;

/**
 * @author wub
 * LeetCode
 * 66.Plus One
 * 给一个数组当成一个十进制数字，返回一个数组代表他加1后的结果
 * 假设除整数0外，这个数组不会以0开头
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            digits[0]++;
            return digits;
        }
        for (int i = digits.length-1; i != -1; i--) {
            digits[i] = (digits[i]+1)%10;
            if (digits[i] != 0)
                break;
        }
        if (digits[0] == 0){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(new PlusOne().plusOne(new int[]{1}));
    }
}
