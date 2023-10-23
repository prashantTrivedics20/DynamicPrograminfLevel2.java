import java.util.Scanner;

public class MaximumSumLongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        int dp[]=new int[n];
        int res=0;
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
            dp[i]=max+arr[i];
            if(dp[i]>res)
            {
                res=dp[i];
            }
        }
        System.out.println(res);
    }
}
