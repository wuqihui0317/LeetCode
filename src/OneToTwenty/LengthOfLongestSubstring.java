package OneToTwenty;
import java.util.*;

/**
 * @author wub
 * LeetCode
 * 3.Longest Substring Without Repeating Characters
 */


public class LengthOfLongestSubstring {
    //暴力算法
    //复杂度较高，会达到 O(n^2)
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;
        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            Set<Character> set = new HashSet<Character>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j)) && j - i <= max) {
                    break;
                } else if (set.contains(s.charAt(j)) && j - i > max) {
                    max = j - i;
                    break;
                } else if (j - i + 1 > max) {
                    max = j - i + 1;
                }
                set.add(s.charAt(j));
            }
        }
        return max;
    }

    //滑动窗口
    //时间复杂度：O(n)
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;//存储当前的最大子串长度
        int end, start;
        for (start = 0, end = 0; end < s.length(); end++) {
            //如果end上的值出现过,并且是在start之后的
            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                max = max > (end - start) ? max : (end - start);
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end), end);//更新map或者加入map
        }
        return max > (end - start) ? max : (end - start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring2(str));
    }
}





