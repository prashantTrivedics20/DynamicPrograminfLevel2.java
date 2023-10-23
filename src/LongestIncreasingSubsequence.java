import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        int res=1;
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<dp.length;i++)
        {
            int max=Integer.MIN_VALUE;
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
            if(dp[i]>res)
            {
                res=dp[i];
            }
        }
        System.out.println(res);
    }
}
