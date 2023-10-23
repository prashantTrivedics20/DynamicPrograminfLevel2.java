import java.util.Scanner;
public class ArithmeticSlices1 {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        if(n<=2)
        {
            System.out.println(0);
        }
        int dp[]=new int[n];
        int ans=0;
        for(int i=2;i<n;i++)
        {
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2])
            {
                dp[i]=dp[i-1]+1;
            }
            ans+=dp[i];
        }
        System.out.println(ans);
    }
}
