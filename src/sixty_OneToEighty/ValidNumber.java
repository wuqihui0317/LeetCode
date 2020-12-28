package sixty_OneToEighty;

/**
 * @author wub
 * LeetCode
 * 65.Valid Number
 * 判断传入的字符串能否用十进制数字表示
 */
public class ValidNumber {
    //思路：可能是数字的情况：1~9 +-（正负号） e指数 .小数点
    //最多三部分，将e前 e e后 这样分为三部分进行判断
    //经测试part2  不能为小数  3.0也不行
    //part1  不能以空格结尾
    boolean onlyPart1 = true;
    public boolean isNumber(String s) {
        int i;
        for (i = 0;i < s.length() && s.charAt(i) != 'e'; i++);
        String part1 = s.substring(0,i);
        if (i < s.length() && s.charAt(i) == 'e'){
            onlyPart1 = false;
            if (i == s.length()-1 || i == 0)
                return false;
            String part2 = s.substring(i+1,s.length());
            if (!(isValid(part1,false) && isValid(part2,true)))
                return false;

        }
        return isValid(part1,false);
    }
    //判断是否是一个有效的数字
    boolean isValid(String s,boolean isPart2){
        Boolean decimal = null;
        int i = 0;
        //先过掉空格
        while (i < s.length() && s.charAt(i) == ' ')
            i++;
        if (i == s.length()) return false;
        //正负号的判断，如果有两个正负号 或者不是在数字开头出现，返回false
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            if (i == s.length()-1 || s.charAt(i+1) == ' ')
                return false;
            i++;
        }
        //接下来应该都是数字或者一个小数点 或者以空格结尾
        for (;i < s.length();i++){
            char ch = s.charAt(i);
            if (ch == '.'){
                if (isPart2)
                    return false;
                if (decimal == null)
                    decimal = true;
                else return false;
                //判断是不是以.直接结束了
                if (i == s.length()-1 && (i == 0 || s.charAt(i-1) == ' ' || s.charAt(i-1) == '+' || s.charAt(i-1) == '-'))
                    return false;
                continue;
            }
            //空格结尾了
            if (ch == ' '){
                //有part2  并且当前是part1
                if (!onlyPart1 && !isPart2)
                    return false;
                //判断前面是否只有一个 .
                if (s.charAt(i-1) == '.'){
                    if (i-1 == 0 || s.charAt(i-2) == ' ' || s.charAt(i-2) == '+' || s.charAt(i-2) == '-')
                        return false;
                }
                //判断是否一直空格到末尾
                while (i<s.length() && s.charAt(i) == ' ')
                    i++;
                if (i == s.length())
                    return true;
                else return false;
            }
            //非数字
            else if (ch > '9' || ch < '0')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("  -90e3.0   "));
    }
}
