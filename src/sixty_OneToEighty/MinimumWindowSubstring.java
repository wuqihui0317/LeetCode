package sixty_OneToEighty;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wub
 * LeetCode
 * 76.MinimumWindowSubstring
 * 字符串s中包含所有t字符串中所有字母（顺序不限）的最小子串
 */
public class MinimumWindowSubstring {
    //用一个数组arrS记录s中所有字符的个数,arrT记录t
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        Map<Character,Integer> arrS = new HashMap<>();
        Map<Character,Integer> arrT = new HashMap<>();
        for (Character c:s.toCharArray()) {
            int count = arrS.getOrDefault(c,0);
            arrS.put(c,count+1);
        }
        for (Character c:t.toCharArray()) {
            int count = arrT.getOrDefault(c,0);
            arrT.put(c,count+1);
        }
        int i = 0;
        int j = 0;
        int size = arrT.size();//未遍历完的字符
        String result = s+"a";
        while (j < s.length()){
            //在i~j的字符没有满足要求前一直遍历j
            while(j < s.length() && size != 0){
                char ch = s.charAt(j++);
                if (arrT.containsKey(ch)){
                    int count = arrT.get(ch);
                    arrT.put(ch,count-1);
                    //只有count=1时，说明这个字符遍历完了 size--
                    if (count == 1)
                        size--;
                }
            }
            //递增i 直到i~j不满足子串规则位置
            while (size == 0){
                char ch = s.charAt(i++);
                if (arrT.containsKey(ch)){
                    int count = arrT.get(ch);
                    arrT.put(ch,count+1);
                    if (count == 0)
                        size++;
                    //更新最小子串
                    if (result.length() > j-i+1 )
                        result = s.substring(i-1,j);
                }
            }
        }
        if (result.equals(s+"a"))
            return "";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("a","b"));
    }
}
