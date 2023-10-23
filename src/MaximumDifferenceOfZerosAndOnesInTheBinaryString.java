import java.util.Scanner;
public class MaximumDifferenceOfZerosAndOnesInTheBinaryString {
    // kadance algorithm...
    public static int solution(String str)
    {
        int ans=0;
        int csum=0;
        for(int i=0;i<str.length();i++)
        {
            int val=0;
            char ch=str.charAt(i);
            if(ch=='0')
            {
                val=1;
            }
            else if(ch=='1'){
                val=-1;
            }
            if(csum>0)
            {
                csum+=val;
            }
            else {
                csum=val;
            }
            if(csum>ans)
            {
                ans=csum;
            }

        }
        if(ans==0)
        {
            return -1;
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        String str=readme.nextLine();
        System.out.println(solution(str));
    }
}
