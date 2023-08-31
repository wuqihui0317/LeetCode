package forty_OneToSixty;

import java.util.*;

/**
 * @author wub
 * LeetCode
 * 51.N-Queens
 * 将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
 * 规则:同一行/列/对角线可以攻击
 */
public class N_Queens {
    //每行每列肯定都会有一个
    //用一个int数组记录n行中每个元素在这行的第几个（数组元素不重复）
    //  相当于对1-n进行排列组合，并保证了每行每列不会冲突
    //然后对排列组合进行判断，如果符合不在则加入result
    /*
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            sb.append('.');
        }
        for (List<Integer> list:permute(a)) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder(sb);
                str.insert((int)list.get(i),'Q');
                temp.add(str.toString());
            }
            result.add(temp);
        }
        return result;
    }
    List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);result.add(list);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            //交换i和0
            int temp = nums[0];nums[0] = nums[i];nums[i] = temp;
            List<List<Integer>> list = permute(Arrays.copyOfRange(nums,1,nums.length));
            for (List l:list) {
                l.add(nums[0]);
                if (cannotAttack(l))
                    result.add(l);
            }
            //交换回数组
            temp = nums[0];nums[0] = nums[i];nums[i] = temp;
        }
        return result;
    }
    //已经确保是不同行不同列的了，只要各个数的横竖坐标的差不相同，就不在同意对角线上
    boolean cannotAttack(List<Integer> list){
        int size = list.size();
        if (size == 1)  return true;
        int a = list.get(size-1);
        //前size-1个数之前递归时已经确保true了
        //将最后一个数与前面所有数遍历，如果有冲突则返回false
        for (int i = 0; i < size-1; i++) {
            int b = list.get(i);
            if (Math.abs(a-b) == size-1-i)
                return false;
        }
        return true;
    }
    */

    //约束编程：在棋盘上放置一个皇后后，立即排除当前行、列、以及对角线
    int[][] canPut;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);
        if (n <= 0) {
            return result;
        }
        // 位置上能否放置
        canPut = new int[n][n];
        backtrack(result, n, 0);
        return result;
    }

    StringBuilder str = new StringBuilder();
    private void backtrack(List<List<String>> result, int n, int i) {
        if (i == n) {
            // 放置完成所有皇后 添加result
            List<String> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    str.append(canPut[j][k] == 1 ? 'Q' : '.');
                }
                list.add(str.toString());
                str.delete(0, n);
            }
            result.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPut[i][j] == 0) {
                // 可以放置，在当前位置放置q，并设置下面行无法到的位置
                canPut[i][j] = 1;
                setBound(i, j, n, -1);//放置限制
                backtrack(result, n, i + 1);
                canPut[i][j] = 0;
                setBound(i, j, n, 1);//恢复限制
            }
        }
    }

    // 将i+1行设置放置限制/或者恢复限制
    private void setBound(int i, int j, int n, int setVal) {
        for (int k = i + 1; k < n; k++) {
            canPut[k][j] += setVal;
            if (j - (k - i) >= 0) {
                canPut[k][j - (k - i)] += setVal;
            }
            if (j + k - i < n) {
                canPut[k][j + (k - i)] += setVal;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new N_Queens().solveNQueens(4));
    }
}
