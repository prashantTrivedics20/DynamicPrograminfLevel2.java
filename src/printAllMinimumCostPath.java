import java.util.ArrayDeque;
import java.util.Scanner;

public class printAllMinimumCostPath {
    public static class Pair
    {
        String path;
        int i;
        int j;
        Pair(String path,int i,int j)
        {
            this.path=path;
            this.i=i;
            this.j=j;
        }
    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int m=readme.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=readme.nextInt();
            }
        }
        // dp
        int dp[][]=new int[n][m];
//        dp[n-1][m-1]=arr[n-1][m-1];
        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1&&j==dp[0].length-1)
                {
                    dp[i][j]=arr[i][j];
                }
                else if(i==dp.length-1)
                {
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                else if(j==dp[0].length-1)
                {
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                }
                else {
                    dp[i][j]=arr[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
        ArrayDeque<Pair>queue=new ArrayDeque<>();
        queue.add(new Pair("",0,0));
        while(queue.size()>0)
        {
            Pair rm=queue.removeFirst();
            if(rm.i==dp.length-1&&rm.j==dp[0].length-1)
            {
                System.out.println(rm.path+".");
            }
            else if(rm.i==dp.length-1)
            {
                queue.add(new Pair(rm.path+"H",rm.i,rm.j+1));
            }
            else if(rm.j==dp[0].length-1)
            {
                queue.add(new Pair(rm.path+"V",rm.i+1,rm.j));
            }
            else {
                if(dp[rm.i][rm.j+1]<dp[rm.i+1][rm.j])
                {
                    queue.add(new Pair(rm.path+"H",rm.i,rm.j+1));
                }
                else if(dp[rm.i][rm.j+1]>dp[rm.i+1][rm.j])
                {
                    queue.add(new Pair(rm.path+"V",rm.i+1,rm.j));

                }
                else
                {
                    queue.add(new Pair(rm.path+"H",rm.i,rm.j+1));
                    queue.add(new Pair(rm.path+"V",rm.i+1,rm.j));
                }

            }
        }

    }

}
//6
//6
//0 1 4 2 8 2
//4 3 6 5 0 4
//1 2 4 1 4 6
//2 0 7 3 2 2
//3 1 5 9 2 4
//2 7 0 8 5 1
//23
//HVVHHVHHVV.
//HVVHHVHVHV.
