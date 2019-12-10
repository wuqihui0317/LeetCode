package Forty_OneToSixty;

import java.util.*;

/**
 * @author wub
 * LeetCode
 * 49.Group Anagrams
 * 找出一个字符串数组中所有相同字母的异序词
 */
public class GroupAnagrams {
    //通过改版的hashCode方法来判断两个字符串是否是anagram
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Integer,List<String>> map = new HashMap<>();
        for (String str:strs) {
            int hash = hashCode(str);
            if (map.containsKey(hash)){
                map.get(hash).add(str);
            }else {
                List list = new ArrayList();
                list.add(str);
                map.put(hash,list);
            }
        }
        for (List<String> list:map.values()) {
            result.add(list);
        }
        return result;
    }
    public int hashCode(String s){
        int h = 0;
        char val[] = s.toCharArray();
        Arrays.sort(val);
        for (int i = 0; i < val.length; i++) {
            h = 31 * h + val[i];
        }
        return h;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(str));
    }
}
