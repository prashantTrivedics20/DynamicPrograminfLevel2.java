//Sum of diagonal of 2d array using recursion
//1 2 3
//4 5 6
//7 8 9
//Answer should be 1+5+9+3+7. Here 5 should be added only once.


import java.util.Scanner;

public class interview3 {
    static int val=0;
    static int sum=0;
    public  static void  getElements(int arr[],int idx,int val,int i)
    {
        if(idx>=arr.length)
        {
            return;
        }
        if(idx==i)
        {
            val=arr[idx];
            sum+=val;
//            System.out.print(val);
            return;
        }
        getElements(arr,idx+1,val,i);

    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int m=readme.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=readme.nextInt();
            }
        }
//        int sum=0;
        int i=0;
        for(int a[]:arr)
        {
            getElements(a,0,val,i);
//            sum+=val;
            val=0;
            i++;
        }
        System.out.println(sum);


    }
}
