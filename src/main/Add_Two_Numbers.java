package main;

/**
 * 2. Add Two Numbers
 *  相加两个用链表表示的数
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 * Created by zhouyu on 2017/11/6.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 *
 Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.

 Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
 */
public class Add_Two_Numbers
{
    private static class ListNode {
        int val; // 值
        ListNode next; //next指针
        ListNode(int x) { val = x; } //设置值
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Head = new ListNode(0);   // 创建新链表Head，设置头结点值为null -> 0
        ListNode p = l1, q = l2, curr = Head; // 初始化两条链表的指针，以及结果指针
        int carry = 0; // 进位初始化0
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0; // 返回当前结点的值，为空则返回0，这样是保证位数不一样时能相加。
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y; // 求和
            carry = sum / 10; // 更新进位
            curr.next = new ListNode(sum % 10); // 和保存到结果指针
            curr = curr.next; // 指向下一个已赋值的指针
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {  //最后如果有进位1，要将进位1存入结点
            curr.next = new ListNode(carry);
        }
        return Head.next; //返回指针,注意这里Head.val的是0，应该返回Head.next
    }

    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(2);
        ListNode p = l1;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode q = l2;
        q.next = new ListNode(6);
        q = q.next;
        q.next = new ListNode(4);
        Add_Two_Numbers add_two_numbers = new Add_Two_Numbers();
        ListNode l3 = add_two_numbers.addTwoNumbers(l1,l2);
        ListNode curr = l3;
        while (curr != null){
            System.out.print(curr.val);
            curr = curr.next;
        }
    }
}
