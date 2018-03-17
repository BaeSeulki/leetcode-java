package main;

import java.util.Scanner;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Created by zhouyu on 2017/11/14.
 */
public class Reverse_Integer
{
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(x); //整型转字符串的三种方法
        // String s1 = Integer.toString(x);
        // String s2 = ""+x;
        if(s.charAt(0)=='-'){
            sb.append('-');
            for(int i=s.length()-1;i>0;i--)
                sb.append(s.charAt(i));
        }
        else{
            // StringBuilder stringBuilder = new StringBuilder(s).reverse(); // 使用reverse方法反转字符串
            for(int i=s.length()-1;i>=0;i--)
                sb.append(s.charAt(i));
        }
        try{
            return  Integer.parseInt(sb.toString()); //字符串转整型的两种方法
            // return Integer.valueOf(sb.toString());
        }catch (NumberFormatException e){
            System.out.println(e); // 注意溢出异常
        }
        return 0;
    }

    public int reverse1(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args)
    {
        int x = -153423646;
        Reverse_Integer rs = new Reverse_Integer();
        int y = rs.reverse(x);
        System.out.println(y);
    }
}
