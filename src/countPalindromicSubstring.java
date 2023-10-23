import java.util.Arrays;
import java.util.Scanner;

public class countPalindromicSubstring {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str=readme.nextLine();
        boolean dp[][]=new boolean[str.length()][str.length()];
        for(int g=0;g<dp.length;g++)
        {
            for(int i=0,j=g;j<dp.length;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=true;
                }
                else if(g==1)
                {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        dp[i][j]=true;
                    }
                    else {
                        dp[i][j]=false;
                    }
                }
                else
                {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        if(dp[i+1][j-1]==true)
                        {
                            dp[i][j]=true;
                        }
                        else {
                            dp[i][j]=false;
                        }
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                if(dp[i][j]=true)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
