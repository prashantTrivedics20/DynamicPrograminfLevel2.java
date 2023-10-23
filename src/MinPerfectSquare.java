import java.util.Scanner;

public class MinPerfectSquare {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++)
        {
            int min=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++)
            {
                int net=i-j*j;
                if(dp[net]<min)
                {
                    min=dp[net];
                }
            }
            dp[i]=min+1;
        }
        System.out.println(dp[n]);
    }
}
