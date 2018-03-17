package main;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by zhouyu on 2017/11/8.
 */
public class Longest_Substring_Without_Repeating_Characters
{
    // Brute Force 方法，Time complexity :O(n^3)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    // 判断一个字符串的字符是否唯一，使用set； 单字符：Character； 字符串： String
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);  //charAt(index)方法，可用于遍历string
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    // Time complexity :O(2n)
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){ // 如果新扫描的字符出现在set中，则set移除最左的字符
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // HashMap 优化上诉方法的左边界
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) { // 找到重复的字符，就以重复的字符的下一个字符为头
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }


    // int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    // int[128] for ASCII
    // int[256] for Extended ASCII
    // 利用ASCII码唯一性取代hashMap, int index['a']
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i); // 更新左边界，即重复字符的下一个
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        //在java scanner中，next()方法是不接收空格的，在接收到有效数据前，所有的空格或者tab键等输入被忽略，若有有效数据，则遇到这些键退出。
        // nextLine()可以接收空格或者tab键，其输入应该以enter键结束。
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String:\n");
        String s = scanner.nextLine();
        System.out.println(s);
        Longest_Substring_Without_Repeating_Characters l = new Longest_Substring_Without_Repeating_Characters();
        System.out.println(l.lengthOfLongestSubstring3(s));
    }
}
