import java.util.Scanner;
public class DistinctTransformation {
    public static int solution(String str,String tar,int si,int ti,int dp[][])
    {
        if(si==str.length())
        {
            if(ti<tar.length())
            {
                return 0;
            }
            else {
                return 1;
            }
        }
        else if(ti==tar.length())
        {
            return 1;
        }
        if(dp[si][ti]!=-1)
        {
            return dp[si][ti];
        }
        int tw=0;
        if(str.charAt(si)!=tar.charAt(ti))
        {
            tw=solution(str,tar,si+1,ti,dp);
        }
        else {
            int tw1=solution(str,tar,si+1,ti,dp);//remove
            int tw2=solution(str,tar,si+1,ti+1,dp);
            tw=tw1+tw2;
        }

        return dp[si][ti]=tw;
    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str=readme.nextLine();
        String tar=readme.nextLine();
        int arr[][]=new int[str.length()][tar.length()];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                arr[i][j]=-1;
            }
        }
        System.out.println(solution(str,tar,0,0,arr));

    }
}
