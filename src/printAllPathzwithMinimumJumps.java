import java.util.ArrayDeque;
import java.util.Scanner;
public class printAllPathzwithMinimumJumps {

    public static class Pair
    {
        int i;
        int s;
        int j;
        String path;
        Pair(int i,int s,int j,String path)
        {
            this.i=i;
            this.s=s;
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
        Integer dp[]=new Integer[n];
        dp[n-1]=0;
        for(int i=dp.length-2;i>=0;i--)
        {
            int steps=arr[i];
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=steps&&(i+j)<dp.length;j++)
            {
                if(dp[i+j]!=null&&dp[i+j]<min)
                {
                    min=dp[i+j];
                }
            }
            if(min!=Integer.MAX_VALUE)
            {
                dp[i]=min+1;
            }

        }
        System.out.println(dp[0]);
        ArrayDeque<Pair>queue=new ArrayDeque<>();
        queue.add(new Pair(0,arr[0],dp[0],0+" "));
        while (queue.size()>0)
        {
            Pair rm=queue.removeFirst();
            if(rm.j==0)
            {
                System.out.println(rm.path+".");
            }
            for(int j=1;j<=rm.s&&rm.i+j<dp.length;j++)
            {
                int ci=rm.i+j;
                if(dp[ci]!=null&&dp[ci]==rm.j-1)
                {
                    queue.add(new Pair(ci,arr[ci],dp[ci],rm.path+"->"+ci));
                }

            }
        }
    }
}
