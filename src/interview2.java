import java.util.*;
public class interview2 {
    public static int secondLargest(int arr[])
    {
        int n=arr.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        // traversing the map
        // storing the unique value in the arraylist
        List<Integer>al=new ArrayList<>();
        for(int v:map.keySet())
        {
            if(map.get(v)==1)
            {
                al.add(v);
            }
        }
        if(al.size()<2) {
            return -1;
        }
        int fmax=0;
        int smax=0;
        for(int i=0;i<al.size();i++)
        {
            if(fmax<al.get(i))
            {
                smax=fmax;
                fmax=al.get(i);
            }
            else if(smax<al.get(i))
            {
                smax=al.get(i);
            }
        }
        return smax;
    }
    public static void main(String[] args) {
        Scanner readme=new Scanner(System.in);
        int n=readme.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=readme.nextInt();
        }
        System.out.println(secondLargest(arr));

    }
}
