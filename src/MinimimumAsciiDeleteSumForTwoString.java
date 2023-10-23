import java.util.Scanner;
public class MinimimumAsciiDeleteSumForTwoString {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str1=readme.nextLine();
        String str2=readme.nextLine();
        int dp[][]=new int[str1.length()+1][str2.length()+1];
        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1&&j==dp[0].length-1)
                {
                    dp[i][j]=0;
                }
                else if(i==dp.length-1)
                {
                    dp[i][j]=(int)str2.charAt(j)+dp[i][j+1];

                }
                else if(j==dp[0].length-1)
                {
                    dp[i][j]=(int)str1.charAt(i)+dp[i+1][j];
                }
                else {
                    if(str1.charAt(i)==str2.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j+1];
                    }
                    else {
                        dp[i][j]=Math.min((int)str1.charAt(i)+dp[i+1][j],(int)str2.charAt(j)+dp[i][j+1]);
                    }
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
