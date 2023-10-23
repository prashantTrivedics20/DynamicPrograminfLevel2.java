import java.util.Scanner;
public class minimumCostToMakeTwoStringIdentical {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String s1=readme.next();
        String s2=readme.next();
        int x=readme.nextInt();
        int y=readme.nextInt();
        int dp[][]=new int[s1.length()+1][s2.length()+1];
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
        int len=dp[0][0];
        int c1=s1.length()-len;
        int c2=s2.length()-len;
        int cost=x*c1+y*c2;
        System.out.println(cost);

    }
}
