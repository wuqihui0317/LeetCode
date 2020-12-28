package oneToTwenty;
/**
 * @author wub
 * LeetCode
 * 6.ZigZagConvert
 */
public class ZigZagConvert {
    /*
    理解错误，不需要输出空格回车
     */
    //思路：numRows+numRows-2为一组
    /*public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();//返回值
        int len = s.length();
        int aGroup = numRows+numRows-2;
        int i = len/aGroup;// 组数
        int j = len%aGroup;//最后一组的字符个数
        if(j != 0)
            i++;
        String[] strs = new String[i];
        for (int k = 0; k < i-1 ; k++) {
            strs[k] = s.substring(k*aGroup,(k+1)*aGroup);
        }
        strs[i-1] = s.substring((i-1)*aGroup);
        //第k行
        for (int k = 0; k < numRows; k++) {
            //前i-1组
            for (int l = 0; l < i-1; l++) {
                //先添加第一个字符
                sb.append(strs[l].charAt(k));
                //第一行和最后一行添加numRows-2个空格
                if(k == 0 || k == numRows-1){
                    for (int m = 0; m < numRows-2; m++) {
                        sb.append(' ');
                    }
                }
                else{
                    //其他行先添加numRows-2-k个空格
                    for (int m = 0; m < numRows-2-k; m++) {
                        sb.append(' ');
                    }
                    //再添加strs[l][2*numRows-2-k]
                    sb.append(strs[l].charAt(2*numRows-2-k));
                    //最后添加k-1个空格
                    for (int m = 0; m < k-1 ; m++) {
                        sb.append(' ');
                    }
                }

            }
            //最后一组的情况
            //第一行或最后一行，有的话只输出一个字符
            if(k == 0 || (k == numRows-1 && j >= numRows)){
                sb.append(strs[i-1].charAt(k));
                sb.append('\n');
                continue;
            }
            //最后一行没有的话添加换行
            else if(k == numRows-1 && j < numRows){
                sb.append('\n');
                continue;
            }
            //其他行输出两个字符的情况
            else if(j >= 2*numRows-k){
                //先添加第一个字符
                sb.append(strs[i-1].charAt(k));
                //第一行和最后一行添加numRows-2个空格
                if(k == 0 || k == numRows-1){
                    for (int m = 0; m < numRows-2; m++) {
                        sb.append(' ');
                    }
                }
                else{
                    //其他行先添加numRows-2-k个空格
                    for (int m = 0; m < numRows-2-k; m++) {
                        sb.append(' ');
                    }
                    //再添加strs[i-1][2*numRows-2-k]
                    sb.append(strs[i-1].charAt(2*numRows-2-k));
                    //最后添加换行
                    sb.append('\n');
                }
                continue;
            }
            //要输出一个字符的情况
            else if(k+1 <= j){
                sb.append(strs[i-1].charAt(k));
                sb.append('\n');
                continue;
            }
            //其他行一个字符也没有的情况
            else{
                sb.append('\n');
                continue;
            }
        }
        return sb.toString();
    }*/
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();//返回值
        int len = s.length();
        int aGroup = numRows + numRows - 2;
        int i = len / aGroup;// 组数
        int j = len % aGroup;//最后一组的字符个数
        if (j != 0)
            i++;
        else j = (len < aGroup ? len : aGroup);
        String[] strs = new String[i];
        for (int k = 0; k < i - 1; k++) {
            strs[k] = s.substring(k * aGroup, (k + 1) * aGroup);
        }
        strs[i - 1] = s.substring((i - 1) * aGroup);
        //第k行
        for (int k = 0; k < numRows; k++) {
            //前i-1组
            for (int l = 0; l < i - 1; l++) {
                //先添加第一个字符
                sb.append(strs[l].charAt(k));
                if (k != 0 && k != numRows - 1) {
                    //再添加strs[l][2*numRows-2-k]
                    sb.append(strs[l].charAt(2 * numRows - 2 - k));
                }

            }
            //最后一组的情况
            //第一行或最后一行，有的话只添加一个字符
            if (k == 0 || (k == numRows - 1 && j >= numRows)) {
                sb.append(strs[i - 1].charAt(k));
                continue;
            }
            //最后一行没有字符的情况
            else if (k == numRows - 1 && j > numRows)
                continue;
                //其他行输出两个字符的情况
            else if (j >= 2 * numRows - k - 1) {
                //先添加第一个字符
                sb.append(strs[i - 1].charAt(k));
                if (k != 0 && k != numRows - 1) {
                    //非第一和最后一行添加strs[i-1][2*numRows-2-k]
                    sb.append(strs[i - 1].charAt(2 * numRows - 2 - k));
                }
                continue;
            }
            //要输出一个字符的情况
            else if (k + 1 <= j) {
                sb.append(strs[i - 1].charAt(k));
                continue;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConvert().convert("abcd", 3));
    }
}
