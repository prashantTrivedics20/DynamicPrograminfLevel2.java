import java.util.Scanner;
public class InterLeavingOfTwoString {
    public static boolean solution(String s1, String s2, String s3,int i,int j,boolean [][]dp) {
        // write your code here
        if(i==s1.length()&&j==s2.length())
        {
            return true;
        }
        if(dp[i][j]==true)
        {
            return dp[i][j];
        }
        if(i<s1.length()&&s1.charAt(i)==s3.charAt(i+j)) {
            boolean f1 = solution(s1, s2,s3,i+1,j,dp);
            dp[i][j]=f1;
            if(f1==true)
            {
                return true;
            }
        }
        if(j<s2.length()&&s2.charAt(j)==s3.charAt(i+j)){
            boolean f2=solution(s1,s2,s3,i,j+1,dp);
            dp[i][j]=f2;
            if(f2==true)
            {
                return true;
            }
        }
        dp[i][j]=false;
        return false;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
        System.out.println(solution(s1, s2, s3,0,0,new boolean[s1.length()+1][s2.length()+1]));
    }

}

//1. You are given three strings - s1, s2 and s3.
//2. You have to find whether s3 is formed by interleaving of s1 and s2.
//3. s3 is interleaving if it contains all characters of s1 and s2, and order of all characters in individual string is preserved.

