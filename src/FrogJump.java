import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class FrogJump {
    public static boolean solution(int[] stones) {
        // write your code here
        HashMap<Integer, HashSet<Integer>>map=new HashMap<Integer, HashSet<Integer>>();
        for(int i=0;i<stones.length;i++)
        {
            map.put(stones[i],new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for(int i=1;i<stones.length;i++)
        {
            int currStone=stones[i];
            HashSet<Integer>jumps=map.get(currStone);
            for(int jump:jumps)
            {
                int position=currStone+jump;
                if(position==stones[stones.length-1])
                {
                    return true;
                }
                if(map.containsKey(position))
                {
                    if(jump-1>0) {
                        map.get(position).add(jump - 1);
                    }
                    map.get(position).add(jump);
                    map.get(position).add(jump+1);
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println(solution(arr));
    }
}

//1. You are given an array of positive integers in ascending order, which represents the position of stones in the river.
//2. A frog is trying to cross a river. It can jump on a stone, but it must not jump into the water.
//3. You have to find if the frog can cross the river by landing on the last stone.
//4. The frog is on the first stone initially, and from first stone it can jump 1 unit only.
//5. The frog can only jump k-1, k, or k+1 units in the forward direction, where k is the frog's last jump.

//Input Format
//A number N
//a1
//a2.. N numbers
//Output Format
//true/false

