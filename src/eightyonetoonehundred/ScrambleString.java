package eightyonetoonehundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wqh
 * @description :87. 扰乱字符串
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 *
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 *
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 *
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 *
 * 同样地，如果我们继续交换节点 "eat" 和 "at" 的子节点，将会产生另一个新的扰乱字符串 "rgtae" 。
 *
 * @create :2020-12-28 10:46:00
 */
public class ScrambleString {
    //将s1拆分为两个非空子串，如果s2也可以拆分为对应长度的子串且字符一致，则说明有可能，继续递归，直到s1 == s2
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        } else if (s1.length() == 1 || s1.length() != s2.length()){
            return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            String s1_ = s1.substring(0,i);
            String s2_ = s2.substring(0,i);
            if (possible(s1_,s2_) && (isScramble(s1.substring(0,i), s2.substring(0,i))
                        && isScramble(s1.substring(i), s2.substring(i)))){
                    return true;
            }
            s2_ = s2.substring(s2.length()-i);
            if (possible(s1_,s2_) && (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0,s2.length()-i)))){
                return true;
            }
        }
        return false;
    }
    Map<Character, Integer> possibleUtil = new HashMap<>();
    boolean possible(String s1,String s2){
        for (int i = 0; i < s1.length(); i++) {
            Integer num = possibleUtil.get(s1.charAt(i));
            if (num != null){
                possibleUtil.put(s1.charAt(i),num+1);
            }else {
                possibleUtil.put(s1.charAt(i),1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            Integer num = possibleUtil.get(s2.charAt(i));
            if (num == null){
                possibleUtil.clear();
                return false;
            }else {
                if (num == 1){
                    possibleUtil.remove(s2.charAt(i));
                }else {
                    possibleUtil.put(s2.charAt(i), num-1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("abcdefghijklmnopq",
                "efghijklmnopqcadb"));
    }
}
