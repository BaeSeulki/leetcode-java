package main;

import java.util.Scanner;

/**
 * 6. ZigZag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 4:
 P     I     N
 A   L S   I G
 Y A   H R
 P     I
 * Created by zhouyu on 2017/11/14.
 */
public class ZigZag_Conversion
{
    public String convert(String s, int numRows){
        StringBuilder sb = new StringBuilder();
        if(numRows==1) return s;
        else {
            int num=numRows;
            int maxnum=2*(num-1);
            int sl=s.length();
            for(int i=0; i<sl && numRows>0; i++){
                for(int j=i,k=0; j<sl;k++)
                {
                    sb.append(s.charAt(j));
                    if(i==0||i==num-1) {
                        j+=maxnum;
                        continue;
                    }
                    if((k&1)!=0) j+=maxnum-2*(numRows-1);
                    else j+=2*(numRows-1);
                }
                numRows--;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args)
    {
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        // int numRows = sc.nextInt();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        ZigZag_Conversion zzc = new ZigZag_Conversion();
        String str = zzc.convert(s,numRows);
        System.out.println(str);
    }
}
