package main;

import java.util.Scanner;

/**
 * 5. Longest Palindromic Substring
 * 最长回文子串
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 * Created by zhouyu on 2017/11/12.
 */
public class Longest_Palindromic_Substring
{
    private int expandAroundCenter(String s, int left, int right)
    {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R))
        {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1); // substring方法

    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Longest_Palindromic_Substring lps = new Longest_Palindromic_Substring();
        System.out.println(lps.longestPalindrome(s));
    }
}
