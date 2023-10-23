import java.util.Scanner;

public class CountPalindromicSubSequence {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str=readme.nextLine();
        int dp[][]=new int[str.length()][str.length()];
        for(int g=0;g<str.length();g++)
        {
            for(int i=0,j=g;j<dp.length;j++)
            {
                if(g==0)
                {
                    dp[i][j]=1;

                }
                else if(g==1)
                {
                    dp[i][j]=str.charAt(i)==str.charAt(j)?2:1;
                }
                else {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j]+dp[i][j+1]+1;
                    }
                    else {
                        dp[i][j]=dp[i+1][j]+dp[i][j+1]-dp[i+1][j+1];
                    }

                }
            }
        }
        System.out.println(dp[0][str.length()-1]);
    }
}
