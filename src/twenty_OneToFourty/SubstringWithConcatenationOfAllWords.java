package twenty_OneToFourty;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 30.Substring with Concatenation of All Words
 * 给定一个字符串s和一些长度相同的字符串words
 * 找出s中由words中所有单词组成（顺序任意，但全都要用上）的第一个子串和最后一个子串
 * 返回第一个子串的首字母下标和最后一个子串的首字母下标
 */
public class SubstringWithConcatenationOfAllWords {
    //差不多就是滑动窗口
    //思路：用List存储words字符串，并用一个队列存储已经有的word，用index记录队列中首字符串在word中的起始下标
    //如果deque中有word，则从那个word后一个开始存储
    //如果deque的大小等于words.length，则把index加入list
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0) {
            return result;
        }
        int word_len = words[0].length();//words中单个单词的长度
        List<String> list = new ArrayList<>();
        for (String str:words)
            list.add(str);
        Deque<String> deque = new ArrayDeque();
        //以0~word_len-1为开始结点开始找
        for (int i = 0; i < word_len; i++) {
            while (deque.size()!=0)
                list.add(deque.pollFirst());
            int index = i;
            for (int j = i; j < s.length()-word_len+1; j += word_len) {
                if (index + word_len * words.length > s.length())
                    break;
                String temp = s.substring(j,j+word_len);
                if (list.remove(temp))
                    deque.addLast(temp);
                else if (deque.contains(temp)){
                    //把队列中temp元素之前的（不包括temp）全部返回到list中
                    while(true){
                        //把temp放回到list中又从list中放到队尾
                        index += word_len;//更新队列中首字符串的下标
                        String str = deque.pollFirst();
                        if (str.equals(temp)){
                            deque.addLast(str);break;
                        }
                        list.add(str);
                    }
                }
                else {
                    //如果list和队列中都没有，回收队列中的所有元素，并把index更新为下一个word的下标
                    while (deque.size()!=0)
                        list.add(deque.pollFirst());
                    index = j+word_len;
                }
                //如果list空了，则把index加入结果集，并在队列出队一个元素放回到list，更新index
                if (list.size() == 0) {
                    result.add(index);
                    list.add(deque.pollFirst());
                    index += word_len;
                }
            }
            //一遍结束后要把队列和list还原

        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abababab";
        String[] words = new String[]{"a","b","a"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s,words));
    }
}
