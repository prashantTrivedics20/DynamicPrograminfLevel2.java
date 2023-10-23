import java.util.Scanner;

public class FindWaterInGlass {
    public static double solution(int k, int r, int c) {
        // write your code her
        System.out.println(k);

        int v=r*c;
        System.out.println(v);
        return 1.0;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        System.out.println(solution(k, r, c));
    }
}

//1. Pepcoder arranged some glasses in the form of pascal triangle.
//2. Capacity of each glass is 1 litre. If you pour K amount of water in a glass, it will retain 1 litre and
//   rest of it gets equally distributed in left bottom glass and right bottom glass.
//3. If pepcoder pours K litres of water in the topmost glass, you have to find out the amount of water in Cth glass of Rth row.
//
//Assumption -> There are enough glasses in the triangle till no glass overflows.

//Input Format
//    A number K representing amount of water poured in topmost glass.
//        Two numbers R and C
//        Output Format
//        A number representing the amount of water present in Cth glass of Rth row.
