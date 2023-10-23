import java.util.HashMap;
import java.util.Scanner;
public class countDistinctSubSequence {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str=readme.nextLine();
        int n=str.length();
        int dp[]=new int[n+1];
        dp[0]=1;// empty subsequences..
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=1;i<dp.length;i++) {
            char ch=str.charAt(i-1);
            dp[i]=dp[i-1]*2;
            if(map.containsKey(ch)==true)
            {
                int j=map.get(ch);
                dp[i]=dp[i]-dp[j-1];
            }
            map.put(ch,i);
        }
        System.out.println(dp[n]);
    }
}
