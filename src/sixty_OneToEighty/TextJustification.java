package sixty_OneToEighty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 68.Text Justification
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每
 * 行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。

 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> result = new ArrayList<>();
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);
            int nowLen = words[i].length();
            if (i == words.length-1)
                i++;
            for (int j = i+1; j < words.length; j++) {
                //还能再加单词
                if (nowLen + 1 + words[j].length() <= maxWidth){
                    nowLen += words[j].length() + 1;
                    sb.append(' ');
                    sb.append(words[j]);
                    if (j == words.length-1) {
                        i = j + 1;
                        break;
                    }
                }
                //不能加单词了，开始填单词之间的空格
                else {
                    //只有一个单词情况下，直接在末尾填
                    if (j - i == 1){
                        for (int k = 0; k < maxWidth-nowLen; k++)
                            sb.append(' ');
                    }
                    //有两个及以上单词
                    else {
                        int k = i;
                        int addBlankIndex = words[k++].length();
                        int addBlankNumber = 1;
                        //第1到倒数第二个单词后面依次加空格
                        while (nowLen++ != maxWidth){
                            sb.insert(addBlankIndex,' ');
                            if (k == j-1) {
                                k = i;
                                addBlankIndex = words[k++].length();
                                addBlankNumber++;
                                continue;
                            }
                            addBlankIndex += 1 + addBlankNumber + words[k++].length();
                        }
                    }
                    i = j;
                    result.add(sb.toString());
                    break;
                }
            }
            if (i == words.length) {
                while (nowLen++ != maxWidth)
                    sb.append(' ');
                result.add(sb.toString());
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(new TextJustification().fullJustify(words,16));
    }
}
