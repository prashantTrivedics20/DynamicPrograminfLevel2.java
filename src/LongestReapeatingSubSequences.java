import java.util.Scanner;
public class LongestReapeatingSubSequences {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String s1=readme.next();
        int [][]dp=new int[s1.length()+1][s1.length()+1];
        for(int i=dp.length-2;i>=0;i--)
        {
            for(int j=dp[0].length-2;j>=0;j--)
            {
                if(s1.charAt(i)==s1.charAt(j)&&i!=j)
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
