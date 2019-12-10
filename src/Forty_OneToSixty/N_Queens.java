package Forty_OneToSixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    int[] position = null;//每列放置的位置
    String str;
    int[][] canPut = null;//约束矩阵，判断这个位置能否放置皇后，0为可以放置
    public List<List<String>> solveNQueens(int n) {
        canPut = new int[n][n];//约束矩阵，判断这个位置能否放置皇后
        position = new int[n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            sb.append('.');
        }
        str = sb.toString();
        return backtrack(0,n);
    }
    //回溯
    List<List<String>> backtrack(int row,int n){
        List<List<String>> result = new ArrayList<>();
        //试图在该行0-n个位置分别放置
        for (int i = 0; i < n; i++) {
            if (canPut[row][i] == 0){
                //到达最后一行，结束回溯
                if (row == n-1){
                    //生成字符串
                    StringBuilder sb = new StringBuilder(str);
                    sb.insert(i,'Q');
                    List<String> list = new ArrayList<>();
                    list.add(sb.toString());
                    result.add(list);
                    break;
                }
                setBound(row,i,n,1);
                //回溯下一行
                List<List<String>> temp = backtrack(row+1,n);
                //回溯结束还原约束矩阵
                setBound(row,i,n,-1);
                if (temp.size() == 0)   continue;
                //加入这次的字符串
                StringBuilder sb = new StringBuilder(str);
                sb.insert(i,'Q');//生成本次字符串
                for (List<String> list:temp) {
                    list.add(sb.toString());
                    result.add(list);
                }
            }

        }
        return result;
    }
    void setBound(int row,int column,int n,int way){
        int i = row+1;
        int j = column+1;
        //当前点右下方
        while (i < n && j < n) {
            canPut[i][j] += way;
            i++;j++;
        }
        i = row-1;j = column-1;
        //当前点左上方
        while (i>=0 && j >= 0){
            canPut[i][j] += way;
            i--;j--;
        }
        i = row+1;j = column-1;
        //当前点右上方
        while (i<n && j >= 0){
            canPut[i][j] += way;
            i++;j--;
        }
        i = row-1;j = column+1;
        //当前点左下方
        while (i>=0 && j<n){
            canPut[i][j] += way;
            i--;j++;
        }
        //当前点的上下
        i = row;j = column;
        for (int k = 0; k < n; k++) {
            canPut[i][k] += way;
            canPut[k][j] += way;
        }
    }
    public static void main(String[] args) {
        System.out.println(new N_Queens().solveNQueens(5));
    }
}
