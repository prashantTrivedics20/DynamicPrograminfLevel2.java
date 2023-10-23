import java.util.Scanner;

public class LongestCommonSubsequences {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String s1=readme.nextLine();
        String s2=readme.nextLine();
        int [][]dp=new int[s1.length()+1][s2.length()+1];
        for(int i=dp.length-2;i>=0;i--)
        {
            for(int j=dp[0].length-2;j>=0;j--)
            {
                if(s1.charAt(i)==s2.charAt(j))
                {
                    dp[i][j]=1+dp[i+1][j+1];
                }
                else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
