package Boardpath;

import java.util.Scanner;

public class cherrypickup {
    public static  boolean check(int a,int b,int c)
    {
        if(a+b>c&&c+a>b&&b+c>a)
        {
            return true;
        }
        return  false;
    }
    public int count(int arr[])
    {
        int n=arr.length;
        int a=arr[0];
        int b=arr[1];
        int c=arr[2];
        boolean ch=check(a,b,c);
        int ans=0;
        if(ch==true)
        {
            ans++;
        }
        for(int i=3;i<n;i++)
        {
            a=b;
            b=c;
            c=arr[i];
            boolean val=check(a,b,c);
            if(val==true)
            {
                ans++;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=readme.nextInt();
        }

//        int a=arr[0];
//        int b=arr[1];
//        int c=arr[2];
//        boolean ch=check(a,b,c);
//        int ans=0;
//        if(ch==true)
//        {
//            ans++;
//        }
//        for(int i=3;i<n;i++)
//        {
//            a=b;
//            b=c;
//            c=arr[i];
//            boolean val=check(a,b,c);
//            if(val==true)
//            {
//                ans++;
//            }
//        }
//        System.out.print(ans);
    }
}
