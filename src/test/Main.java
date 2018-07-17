package test;

import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] weight = {1,2,3};
        int[] val = {4,5,6};
        int n = val.length;

        int[] dp = new int[m+1];
        for(int i=1;i<dp.length;i++){
            dp[i] = 0;
        }
        for(int i=0;i<n;i++){
            for(int j=dp.length-1;j>=weight[i];j--){
                dp[j] = Math.max(dp[j], dp[j-weight[i]]+val[i]);
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}
