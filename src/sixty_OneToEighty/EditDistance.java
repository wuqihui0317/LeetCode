package sixty_OneToEighty;
/**
 * @author wub
 * LeetCode
 * 72.Edit Distance
 * 给定两个单词 word1 和 word2
 * 计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 可以进行以下操作：插入一个字符、删除一个字符、替换一个字符
 */
public class EditDistance {
    //动态规划
    //dp[i][j]代表从word1到i位置转换成word2到j位置需要最少的步数
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //初始化
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        //dp
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //更新dp[i][j]
                if (word1.charAt(i-1) != word2.charAt(j-1))
                    dp[i][j] = 1 + min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j-1];
            }
        }
        return dp[word1.length()][word2.length()];
    }
    int min(int a,int b,int c){
        int min = a;
        if (min > b)
            min = b;
        if (min > c)
            min = c;
        return min;
    }
}
