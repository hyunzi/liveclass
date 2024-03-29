package com.liveclass.codingtest.w6;

import java.util.Arrays;

public class W6LongestIncreasingSubsequence {

    /* https://leetcode.com/problems/longest-increasing-subsequence/description/ */

    /*
    Example 1:

    Input: nums = [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    Example 2:

    Input: nums = [0,1,0,3,2,3]
    Output: 4
    Example 3:

    Input: nums = [7,7,7,7,7,7,7]
    Output: 1
    */

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int result = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {

        int result1 = lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println("result1 = " + result1);
        int result2 = lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println("result2 = " + result2);
        int result3 = lengthOfLIS(new int[]{7,7,7,7,7,7,7});
        System.out.println("result3 = " + result3);
        int result4 = lengthOfLIS(new int[]{4,10,4,3,8,9});
        System.out.println("result4 = " + result4);

    }
}
