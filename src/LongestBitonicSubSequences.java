import java.util.Scanner;

public class LongestBitonicSubSequences {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        // LIS
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            int max=0;
            for(int j=0;j<i;j++)
            {
                if(arr[j]<=arr[i])
                {
                    if(dp[j]>max)
                    {
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
        }
        //LDS
        int lds[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            int max=0;
            for(int j=n-1;j>i;j--)
            {
                if(arr[j]<=arr[i])
                {
                    if(lds[j]>max)
                    {
                        max=lds[j];
                    }
                }
            }
            lds[i]=max+1;
        }
        int omax=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]+lds[i]-1>omax)
            {
                omax=dp[i]+lds[i]-1;
            }
        }
        System.out.println(omax);

;
    }
}
