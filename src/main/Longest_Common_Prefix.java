package main;

import java.util.Arrays;

/**14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 最长公共前缀 https://leetcode.com/problems/longest-common-prefix/solution/
 * Created by zhouyu on 2017/11/20.
 */
public class Longest_Common_Prefix
{
    // 先字符串排序，再比较最大和最小的公共前缀串
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs!= null && strs.length > 0){

            Arrays.sort(strs);

            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();

            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }


}
