package main;

/**
 * 8. String to Integer
 * 字符串转整数
 * Requirements for atoi:
 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits
 as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no
 effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists
 because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of
 representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * Created by zhouyu on 2017/11/14.
 */
public class String_to_Integer
{
    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0'; // char 转 int
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            //不用long，进行int最大值比较
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public int myAtoi1(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0; // 定义long，因为有溢出
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) sum * sign;
    }

    public static void main(String[] args)
    {
        String s = "  -12323232";
        String_to_Integer sti = new String_to_Integer();
        int x=sti.myAtoi(s);
        System.out.println(x);
    }
}
