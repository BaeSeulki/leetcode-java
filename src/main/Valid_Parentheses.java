package main;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * 括号匹配
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Created by zhouyu on 2018/3/17.
 */
public class Valid_Parentheses
{
    // 利用栈的后进后出解决
    public boolean isValid(String s) {
        if(s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char anArr : s.toCharArray())
        {
            stack.push(anArr);
            if (stack.size() >= 2)
            {
                if ((stack.peek() == ')' && stack.get(stack.size() - 2) == '(')
                        || (stack.peek() == ']' && stack.get(stack.size() - 2) == '[')
                        || (stack.peek() == '}' && stack.get(stack.size() - 2) == '{'))
                {
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    // 同样利用栈，但是stack里面表示的是需要与之匹配的右括号，这样错误的匹配可以提前发现
    public boolean isValid1(String s) {

        if(s.length() % 2 == 1)
            return false;

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                stack.push(')');
            }
            else if(s.charAt(i) == '{')
            {
                stack.push('}');
            }
            else if(s.charAt(i) == '[')
            {
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        String s = "([{}])";
        Valid_Parentheses vp = new Valid_Parentheses();
        System.out.println(vp.isValid(s));
    }
}
