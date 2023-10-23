import java.util.Scanner;
public class MaximumSumOfTwoNonOverlappingSubarray {
    public static int solution(int arr[],int x,int y)
    {
        int ans=0;
        int n=arr.length;
        int dp1[]=new int[n];
        int dp2[]=new int[n];
        int sum=0;
        // first x size then y size
        for(int i=0;i<n;i++)
        {
            if(i<x)
            {
                sum+=arr[i];
                dp1[i]=sum;
            }
            else {
                sum+=arr[i]-arr[i-x];
                dp1[i]=Math.max(sum,dp1[i-1]);
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--) {
            if (i + y >= n) {
                sum += arr[i];
                dp2[i]=sum;
            } else {
                sum += arr[i] - arr[i + y];
                dp2[i] = Math.max(sum, dp2[i + 1]);
            }
        }
        for(int i=x-1;i<n-y;i++)
        {
            ans=Math.max(ans,dp1[i]+dp2[i+1]);
        }
        dp1=new int[n];
        dp2=new int[n];
        sum=0;
        // first y size then x size
        for(int i=0;i<n;i++)
        {
            if(i<y)
            {
                sum+=arr[i];
                dp1[i]=sum;
            }
            else {
                sum+=arr[i]-arr[i-y];
                dp1[i]=Math.max(sum,dp1[i-1]);
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--) {
            if (i + x >= n) {
                sum += arr[i];
                dp2[i]=sum;
            } else {
                sum += arr[i] - arr[i + x];
                dp2[i] = Math.max(sum, dp2[i + 1]);
            }
        }
        for(int i=y-1;i<n-x;i++)
        {
            ans=Math.max(ans,dp1[i]+dp2[i+1]);
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
        int x=readme.nextInt();
        int y=readme.nextInt();
        System.out.println(solution(arr,x,y));
    }
}
