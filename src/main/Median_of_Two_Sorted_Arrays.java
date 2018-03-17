package main;

import java.util.ArrayList;
import java.util.List;

/**
 * 4. Median of Two Sorted Arrays
 * 两个已排序数组的中位数
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 * Created by zhouyu on 2017/11/9.
 */
public class Median_of_Two_Sorted_Arrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int med = len/2+1;
        System.out.println(med);
        ArrayList<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i+j < med){
            if (i<len1 && j<len2)
            {
                if (nums1[i] < nums2[j])
                {
                    list.add(nums1[i]);
                    i++;
                } else
                {
                    list.add(nums2[j]);
                    j++;
                }
            }
            else if (i == len1){
                for (int k=j; k<len2; k++)
                    list.add(nums2[k]);
                break;
            }
            else if (j == len2){
                for (int k=i; k<len1; k++)
                    list.add(nums1[k]);
                break;
            }
        }
        for(int k : list)
            System.out.println(k);
        if ((len&1) != 0)// 判断奇偶的方法
            return list.get(med-1);
        else
            return (list.get(med-2)+list.get(med-1))/2.0;
    }

    public static void main(String[] args)
    {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,3,5,6,7,8,9,9};
        Median_of_Two_Sorted_Arrays m = new Median_of_Two_Sorted_Arrays();
        System.out.println(m.findMedianSortedArrays(nums1, nums2));
    }
}
