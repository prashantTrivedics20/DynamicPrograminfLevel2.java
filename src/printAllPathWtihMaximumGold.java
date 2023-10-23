import java.util.ArrayDeque;
import java.util.Scanner;

public class printAllPathWtihMaximumGold {
    public static class Pair
    {
        int i;
        int j;
        String path;
        Pair(String path,int i,int j)
        {
            this.i=i;
            this.j=j;
            this.path=path;
        }
    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int m=readme.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=readme.nextInt();
            }
        }
        int dp[][]=new int[n][m];
        for(int j=arr[0].length-1;j>=0;j--)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(j==arr[0].length-1)
                {
                    dp[i][j]=arr[i][j];
                }
                else if(i==0)
                {
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i+1][j+1]);
                }
                else if(i==arr.length-1)
                {
                    dp[i][j]=arr[i][j]+Math.max(dp[i-1][j],dp[i][j+1]);
                }
                else {
                    dp[i][j]=arr[i][j]+Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i][0]>max)
            {
                max=dp[i][0];
            }
        }
        System.out.println(max);
        ArrayDeque<Pair>queue=new ArrayDeque<>();
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i][0]==max)
            {
                queue.add(new Pair(i+" ",i,0));
            }
        }
        while(queue.size()>0)
        {
            Pair rm=queue.removeFirst();
            if(rm.j==arr[0].length-1)
            {
                System.out.println(rm.path);
            }
            else if(rm.i==0){
                int greater=Math.max(dp[rm.i][rm.j+1],dp[rm.i+1][rm.j+1]);

                if(greater==dp[rm.i][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d2",rm.i,rm.j+1));
                }
                if(greater==dp[rm.i+1][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d3",rm.i+1,rm.j+1));
                }
            }
            else if(rm.i==arr.length-1)
            {
                int greater=Math.max(dp[rm.i][rm.j+1],dp[rm.i-1][rm.j+1]);
                if(greater==dp[rm.i-1][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d1",rm.i-1,rm.j+1));
                }
                if(greater==dp[rm.i][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d2",rm.i,rm.j+1));
                }
            }
            else {
                int greater=Math.max(dp[rm.i][rm.j+1],Math.max(dp[rm.i+1][rm.j+1],dp[rm.i-1][rm.j+1]));
                if(greater==dp[rm.i-1][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d1",rm.i-1,rm.j+1));
                }
                if(greater==dp[rm.i][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d2",rm.i,rm.j+1));
                }
                if(greater==dp[rm.i+1][rm.j+1])
                {
                    queue.add(new Pair(rm.path+"d3",rm.i+1,rm.j+1));
                }
            }
        }
    }
}
