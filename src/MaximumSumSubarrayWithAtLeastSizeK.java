import java.util.Scanner;

public class MaximumSumSubarrayWithAtLeastSizeK {
    public static int solution(int arr[],int k)
    {
        int ans=0;
        int csum=arr[0];
        int []maxSum=new int[arr.length];
        maxSum[0]=csum;
        for(int i=1;i<arr.length;i++)
        {
            if(csum>0)
            {
                csum+=arr[i];
            }
            else {
                csum=arr[i];
            }
            maxSum[i]=csum;
        }

        int exactk=0;
        for(int i=0;i<k;i++)
        {
            exactk+=arr[i];
        }
        if(exactk>ans)
        {
            ans=exactk;
        }
        for(int i=k;i<arr.length;i++)
        {
            exactk+=arr[i];
            exactk-=arr[i-k];
            if(exactk>ans)
            {
                ans=exactk;
            }
            int morethank=maxSum[i-k]+exactk;
            if(morethank>ans)
            {
                ans=morethank;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=readme.nextInt();
        }
        int k=readme.nextInt();
        System.out.println(solution(arr,k));
    }
}
