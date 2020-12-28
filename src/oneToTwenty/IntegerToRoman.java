package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 12.Integer to Roman
 * 阿拉伯数字转罗马数
 */
public class IntegerToRoman {
    //我的傻瓜式解法
    /*public String intToRoman(int num){
        StringBuilder str = new StringBuilder("");//Roman字符串
        for (int i = 0; i < 4; i++) {
            switch (i){
                case 0:
                    if (num/1000 != 0){
                        str.append(new char[]{'M','M','M'},0,num/1000);
                        num %= 1000;
                    }break;
                case 1:
                    if (num/100 != 0){
                        switch (num/100){
                            case 1:str.append("C");break;
                            case 2:str.append("CC");break;
                            case 3:str.append("CCC");break;
                            case 4:str.append("CD");break;
                            case 5:str.append("D");break;
                            case 6:str.append("DC");break;
                            case 7:str.append("DCC");break;
                            case 8:str.append("DCCC");break;
                            case 9:str.append("CM");break;
                        }
                        num %= 100;
                    }break;
                case 2:
                    if (num/10 != 0){
                        switch (num/10){
                            case 1:str.append("X");break;
                            case 2:str.append("XX");break;
                            case 3:str.append("XXX");break;
                            case 4:str.append("XL");break;
                            case 5:str.append("L");break;
                            case 6:str.append("LX");break;
                            case 7:str.append("LXX");break;
                            case 8:str.append("LXXX");break;
                            case 9:str.append("XC");break;
                        }
                        num %= 10;
                    }break;
                case 3:
                    if (num != 0){
                        switch (num){
                            case 1:str.append("I");break;
                            case 2:str.append("II");break;
                            case 3:str.append("III");break;
                            case 4:str.append("IV");break;
                            case 5:str.append("V");break;
                            case 6:str.append("VI");break;
                            case 7:str.append("VII");break;
                            case 8:str.append("VIII");break;
                            case 9:str.append("IX");break;
                        }
                    }break;
            }
        }
        return str.toString();
    }*/

    //思路：把罗马数字和阿拉伯数字的转换关系用两个数组表示，然后
    // 不断将当前数字与当前最大单位作比较，每次转换完就减去已转换的数
    // 字，再比较...直到当前数字等于0.
    public String intToRoman(int num) {
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < 13; i++) {
            int v = value[i];
            while (num >= v) {
                num -= v;
                str.append(symbol[i]);
                if (num == 0)
                    return str.toString();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1993));
    }
}
