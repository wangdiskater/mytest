package mytest.algoritm;

/**
 * @version 1.0
 * @ClassName QINGWATIAOTAIJIE
 * @Description todo
 * @Author wangdi
 * @Date 2021/5/15 13:24
 **/


import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，或者3级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 青蛙在最后一步的时候有两种跳法：
 * 1）最后一步跳一级台阶，那么剩下的n-1个台阶，一共有f(n-1)种跳法
 * 2）最后一步跳二级台阶，那么剩下的n-2个台阶，一共有f(n-2)种跳法
 * 3）最后一步跳三级台阶，那么剩下的n-3个台阶，一共有f(n-3)种跳法
 * <p>
 * 所以，当有n个台阶的时候，他的总可能数是上面两种情况之和
 * f(n) = f(n-1)+f(n-2) +f(n-3) 这是一种递归的关系，但是使用动态规划来解决更简单一些。
 * 用动态规划数组存放1.....n之间每个数的情况值，这样结果只需要取数组最后一个元素即可。
 */
public class QINGWATIAOTAIJIE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = fun(n);
        System.out.println(result);
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    private static int fun(int n) {
        // 声明一个动态规划数组，存放每一步的值
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 1;  // 默认如果为0返回1，题目要求
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;

        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1] + dp[i - 3]) ;
        }
        return dp[n];
    }
}

