package test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhouyu on 2018/4/20.
 */
public class Main1
{
    private static double count(int n)
    {
        double sum = 0;
        double sum1 = 0;
        for(int i=0; i<10; i++)
        {
            double k = 9*Math.pow(10,i);
            sum1 += k;
            sum += 9*Math.pow(10,i-1)*i;
            if(n-sum1<0){
                double dif = n-sum1+k;
                sum += dif*(i+1);
                break;
            }

        }
        return sum;
    }
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        int m=cin.nextInt();
        for (int i=0; i<m; i++)
        {
            int n=cin.nextInt();
            System.out.println((int)count(n));

        }
    }

}
