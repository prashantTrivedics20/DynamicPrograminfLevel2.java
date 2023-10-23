import java.util.ArrayDeque;
import java.util.Scanner;
public class printAllPath01KnapSackProblem {
    public static class Pair
    {
        int i;
        int j;
        String path;
        Pair(int i,int j,String path)
        {
            this.i=i;
            this.j=j;
            this.path=path;
        }
    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        int wt[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        for(int i=0;i<wt.length;i++)
        {
            wt[i]=readme.nextInt();
        }
        int cap=readme.nextInt();
        int dp[][]=new int[n+1][cap+1];
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(j>=wt[i-1])
                {
                    if(dp[i-1][j-wt[i-1]]+arr[i-1]>dp[i-1][j]);
                    {
                        dp[i][j]=dp[i-1][j-wt[i-1]]+arr[i-1];
                    }
                }
            }
        }
        int ans=dp[n][cap];
        System.out.println(ans);

        ArrayDeque<Pair>queue=new ArrayDeque<>();
        queue.add(new Pair(n,cap,""));
        while(queue.size()>0)
        {
            Pair rem=queue.removeFirst();
            if(rem.i==0||rem.j==0)
            {
                System.out.println(rem.path+" ");
            }
            else {
                int exc=dp[rem.i-1][rem.j];
                if(rem.j>=wt[rem.i-1])
                {
                    int inc=dp[rem.i-1][rem.j-wt[rem.i-1]]+arr[rem.i-1];
                    if(dp[rem.i][rem.j]==inc)
                    {
                        queue.add(new Pair(rem.i-1,rem.j-wt[rem.i-1],rem.path+" "+(rem.i-1)));
                    }
                }
                if(dp[rem.i][rem.j]==exc)
                {
                    queue.add(new Pair(rem.i-1,rem.j,rem.path));
                }
            }
        }
    }
}
