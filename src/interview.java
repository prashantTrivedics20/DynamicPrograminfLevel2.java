//        1
//      2 3 2
//    3 4 5 4 3
//  4 5 6 7 6 5 4
//5 6 7 8 9 8 7 6 5

import java.util.Scanner;
public class interview {
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int c=1;
        int k=1;
        int r=1;
        int temp=n;
        while(n-->0)
        {
            int v=c/2;
            int t=v;
            for(int j=0;j<temp-k;j++)
            {
                System.out.print("\t");
            }
            for(int i=0;i<v;i++)
            {
                t++;
                System.out.print(t+"\t");
            }
            System.out.print(c+"\t");
            int val=c;
            for(int i=0;i<v;i++) {
                val--;
                System.out.print(val+"\t");
            }
            for(int j=1;j<r;j++)
            {
                System.out.print("\t");
            }
            System.out.println();
            c=c+2;
            k++;
            r++;
        }
    }
}
