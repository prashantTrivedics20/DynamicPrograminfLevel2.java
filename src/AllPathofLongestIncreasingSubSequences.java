import java.util.ArrayDeque;
import java.util.Scanner;

public class AllPathofLongestIncreasingSubSequences {
    public static class Pair
    {
        int l;
        int i;
        int v;
        String path;
        Pair(int l,int i,int v,String path)
        {
            this.l=l;
            this.i=i;
            this.v=v;
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
        int dp[]=new int[n];
        int omax=0;
        for(int i=0;i<dp.length;i++)
        {
            int max=0;
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                {
                    if(dp[j]>max)
                    {
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            if(dp[i]>omax)
            {
                omax=dp[i];
            }
        }

        ArrayDeque<Pair>queue=new ArrayDeque<>();
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]==omax)
            {
                queue.add(new Pair(omax,i,arr[i],arr[i]+""));
            }
        }
        while(queue.size()>0)
        {
            Pair rm=queue.removeFirst();
            if(rm.l==1)
            {
                System.out.println(rm.path+" .");
            }

            for(int j=rm.i-1;j>=0;j--)
            {
                if(dp[j]==rm.l-1&&arr[j]<=rm.v)
                {
                    queue.add(new Pair(dp[j],j,arr[j],arr[j]+"->"+rm.path));
                }
            }
        }


    }
}
