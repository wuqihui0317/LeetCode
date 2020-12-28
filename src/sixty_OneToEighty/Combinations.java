package sixty_OneToEighty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wub
 * LeetCode
 * 78.Combinations
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || k < 1 || n < k)
            return result;
        backtrack(n,k,new ArrayList<>());
        return result;
    }
    //回溯，从最后一个数开始加入stack
    //由于是排列，不需要考虑数字组合顺序
    void backtrack(int n, int k, List<Integer> list){
        if (k != 1) {
            //剪枝，当i<k时 ，1~i的个数全加到list中也不够
            for (int i = n; i >= k; i--) {
                //遍历
                list.add(i);
                backtrack(i-1,k-1,list);
                list.remove(list.size()-1);
            }
        }
        else {
            for (int i = 1; i <= n; i++) {
                list.add(i);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,3));
    }
}
