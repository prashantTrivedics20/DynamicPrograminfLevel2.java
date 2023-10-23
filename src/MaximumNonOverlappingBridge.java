import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Scanner;
public class MaximumNonOverlappingBridge {
    public static class bridge implements Comparable<bridge>
    {
        int n;
        int s;
        public bridge(int n,int s) {
            this.n = n;
            this.s = s;
        }
        public int compareTo(bridge o)
        {
            if(this.n!=o.n)
            {
                return this.n-o.n;
            }
            return this.s-o.s;
        }
    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=Integer.parseInt(readme.next());
        bridge []brig=new bridge[n];
        for(int i=0;i<brig.length;i++)
        {
            String str=readme.nextLine();
            String arr[]=str.split(" ");
            int north=Integer.parseInt(arr[0]);
            int south=Integer.parseInt(arr[1]);
            brig[i]=new bridge(north,south);
        }
        Arrays.sort(brig);
        // LIS for south..
        int dp[]=new int[n];
        int omax=0;
        for(int i=0;i<brig.length;i++)
        {
            int max=Integer.MIN_VALUE;
            for(int j=0;j<i;j++)
            {
                if(brig[j].s<=brig[i].s)
                {
                    if(dp[j]>max)
                    {
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            if(omax<dp[i])
            {
                omax=dp[i];
            }
        }
        System.out.println(omax);

    }
}
