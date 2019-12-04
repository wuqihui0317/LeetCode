package OneToTwenty;
/**
 * @author wub
 * LeetCode
 * 7.Reverse Interge
 */
public class ReverseInterge {
    //构造一个char[]数组，该方法耗时和内存都较高
    /*public int reverse(int x){
        boolean negative = false;//判断x是否是复数
        if(x < 0) {
            negative = true;
            x = 0 - x;
        }
        char[] s = new Integer(x).toString().toCharArray();
        long result = 0;
        int index = 0;
        for(char ch:s){
            result += (ch - '0') * Math.pow(10,index++);
        }
        if (negative)
            result = -result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        else
            return (int)result;
    }*/

    //直接在数字上进行运算，耗时和内存会低很多
    public int reverse(int x) {
        long result = 0L;
        boolean negative = false;
        long input = x;
        if (x < 0) {
            negative = true;
            input = -input;
        }
        while (input != 0) {
            result = result * 10 + (input % 10);
            input /= 10;
        }
        if (result > Integer.MAX_VALUE)
            return 0;
        if (negative)
            return (int) -result;
        else
            return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInterge().reverse(-2147483648));
    }
}
