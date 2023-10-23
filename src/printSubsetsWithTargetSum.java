import java.util.ArrayDeque;
import java.util.Scanner;
public class printSubsetsWithTargetSum {
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
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        int tar=readme.nextInt();
        boolean dp[][]=new boolean[n+1][tar+1];
        for(int i=0;i<dp.length;i++)// target
        {

            for(int j=0;j<dp[0].length;j++)// arr
            {
                if(i==0&&j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else {
                    boolean exe=dp[i-1][j];
                    if(exe)
                    {
                        dp[i][j]=true;
                    }
                    else {
                        if (j >= arr[i - 1]) {
                            boolean inc = dp[i - 1][j - arr[i - 1]];
                            if (inc) {
                                dp[i][j] = true;

                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);

        ArrayDeque<Pair>queue=new ArrayDeque<>();
        queue.add(new Pair(n,tar,""));
        while(queue.size()>0)// bfs...
        {
            Pair rem=queue.removeFirst();
            if(rem.j==0||rem.i==0)
            {
                System.out.println(rem.path+" ");
            }
            else {
                if(rem.j>=arr[rem.i-1])
                {
                    boolean inc=dp[rem.i-1][rem.j-arr[rem.i-1]];
                    if(inc)
                    {
                        queue.add(new Pair(rem.i-1,rem.j-arr[rem.i-1], rem.path+(rem.i-1)));
                    }
                }
                boolean exe=dp[rem.i-1][rem.j];
                if(exe)
                {
                    queue.add(new Pair(rem.i-1,rem.j, rem.path));
                }
            }
        }

    }
}
