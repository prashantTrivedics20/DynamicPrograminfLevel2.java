import java.util.Scanner;

public class minimumInsertionToMakePalindrome {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str=readme.nextLine();
        int dp[][]=new int[str.length()][str.length()];
        for(int g=0;g<dp.length;g++)
        {
            for(int i=0,j=g;j<dp[0].length;j++,i++)
            {
                if(g==0)
                {
                    dp[i][j]=1;
                }
                else {
                    if(str.charAt(i)==str.charAt(j))
                    {
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                    else {
                        dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
        }
        int res=str.length()-dp[0][str.length()-1];
        System.out.println(res);

    }

}

//Minimum Insertions To Make Palindrome
//Easy  Prev   Next
//1. You are given a string(str).
//2. You have to find the minimum number of characters to be inserted to convert it to a palindrome.



