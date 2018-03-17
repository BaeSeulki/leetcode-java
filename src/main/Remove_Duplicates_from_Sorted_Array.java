package main;

/**26.Remove Duplicates from Sorted Array
 * 不用额外空间，移除重复数
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Created by zhouyu on 2018/3/17.
 */
public class Remove_Duplicates_from_Sorted_Array
{
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

}
