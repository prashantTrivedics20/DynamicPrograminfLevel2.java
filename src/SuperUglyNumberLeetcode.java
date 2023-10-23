import java.util.Arrays;
import java.util.Scanner;

public class SuperUglyNumberLeetcode {
    public static int solution(int[] primes, int n) {
        // write your code here
        int dp[]=new int[n+1];
        int pointer[]=new int[primes.length];
        Arrays.fill(pointer,1);
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int min=Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++)
            {
                min=Math.min(primes[j]*dp[pointer[j]],min);
            }
            dp[i]=min;
            for(int j=0;j<primes.length;j++) {
                if (primes[j] * dp[pointer[j]] == min) {
                    pointer[j]++;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int k = scn.nextInt();
        int[] primes = new int[k];
        for (int i = 0 ; i < k; i++) {
            primes[i] = scn.nextInt();
        }
        int n = scn.nextInt();
        System.out.println(solution(primes, n));
    }
}

//1. You are given an array(arr) of size k which contains prime numbers in ascending order, and an integer N.
//2. You have to find Nth super ugly number.
//3. Super ugly number is defined as the number whose prime factors are elements of the given array.
//
//Assumption -> 1 is the first super ugly number.

//A number K
//arr1
//arr2.. K prime numbers in ascending order
//A number N

//A number representing Nth super ugly number.
