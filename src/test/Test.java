package test;

import java.util.Scanner;

public class Test
{

    private int pass(int x)
    {
        if(x==1 || x==2 || x==0) return x;
        if(x%2 == 0)
        {
            return pass(x/2) +1;
        }
        else{
            return Math.min(pass(x+1)+1, pass(x-1)+1);
        }

    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Test t = new Test();
        while(in.hasNext())
        {
            int x = in.nextInt();
            System.out.println(t.pass(Math.abs(x)));
        }

    }
}
