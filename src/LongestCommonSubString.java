import java.util.Scanner;

public class LongestCommonSubString {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String s1=readme.next();
        String s2=readme.next();
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        int max=0;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=1;j<dp[0].length;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=0;
                }
                if(dp[i][j]>max)
                {
                    max=dp[i][j];
                }
            }
        }
        System.out.println(max);

    }
}
