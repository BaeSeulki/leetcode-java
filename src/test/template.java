package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhouyu on 2018/4/5.
 */
public class template
{
    public void read(){
        Scanner reader =new Scanner(System.in);
        while (reader.hasNext()) {
            int start=reader.nextInt();
            int end=reader.nextInt();
        }
    }

    // public static void main(String[] args)
    // {
    //       /*
    //   * 循环连续输入和输出
    //   * 输入：一个数字 3
    //   *     一个数组 1 2 3
    //   */
    //     Scanner x=new Scanner(System.in);
    //     while(x.hasNext()){
    //         int m=x.nextInt();
    //         //System.out.println(m);
    //         int[] number=new int[m];
    //         for(int i=0;i<m;i++){
    //             number[i]=x.nextInt();
    //         }
    //         // Arrays.sort(number);
    //         System.out.println(Arrays.toString(number));
    //     }
    // }

    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        String m=cin.nextLine();
        System.out.println(Integer.parseInt(m));

        String str=cin.nextLine();//读入一行数据
        // int[] a=new int[100];
        ArrayList a = new ArrayList<Integer>();
        String[] str1=str.split(" ");//以空格为分割，注意用双引号
        int length=0;
        for(String s : str1){
            //使用foreach依次将字符串数组的元素转换为整型，也可以转换为其他类型
            // a[length++]=Integer.parseInt(s);
            a.add(Integer.parseInt(s));
        }
        // for(int i=0;i<length;i++){
        //     System.out.println(a[i]);
        // }
        System.out.println(a.get(0));
    }
}
