import java.util.*;

public class QHshSet {

    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String> revMap = new HashMap<>();

        for(String key : tickets.keySet() ){
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet() ){
            if(!revMap.containsKey(key)){
                return key; //starting point
            }
        }
        return null;
    }

    public static void main(String[] args) {
        
        // Q - No - 1 -> Count Distinct Elements
        HashSet<Integer> set = new HashSet<>();

        int num[] = {4,3,2,5,6,7,3,4,2,1};

        for(Integer n : num){
            set.add(n);
        }

        System.out.println(set.size());

        // Q - No - 2 -> Union or Intersection of 2 arrays

        HashSet<Integer> union = new HashSet<>();
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};

        for(int i=0; i<arr1.length || i < arr2.length; i++){
            if(i<arr1.length){
                union.add(arr1[i]);
            }
            if(i<arr2.length){
                union.add(arr2[i]);
            }
        }

        System.out.println(union + "\nUnion : " + union.size());

        HashSet<Integer> intersection = new HashSet<>();
        HashSet<Integer> inter = new HashSet<>();

        for(int i=0;i<arr1.length; i++){
            intersection.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(intersection.contains(arr2[i])){
                inter.add(arr2[i]);
                count++;
                intersection.remove(arr2[i]);
            }
        }
        System.out.println("Intersection : " + count);

        System.out.println(inter + "--Intersection : " + inter.size());

        // Q - No - 3 - Iternary Tickets from and to //O(log n)

        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print("-->" + tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();

        // Q - No - 4 Largest subArray with 0 sum //O(n)
        //preSum formula -> sum(i+1,j) = sum(0,j) - sum(0,i) where j>i;
        //store -> (sum, idx);

        int arr[] = { 15, -2,2,-8,1,7,10,23};

        HashMap<Integer,Integer> larsubmap = new HashMap<>();

        int sum =0, len =0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(larsubmap.containsKey(sum)){
                len = Math.max(len, j-larsubmap.get(sum));
            }else{
                larsubmap.put(sum, j);
            }            
        }

        System.out.println("Largest sub Array with sum as 0 : " + len);

        // Q- No - 5 - Subarray Sum equal to K
        //preSum formula -> sum(i,j) = sum(0,j) - sum(0,i-1);
        // store -> (sum, count);
        //O(log n)

        int ar[] = {10,2,-2,-20,10};
        int k = -10;

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0, 1); //Initialize for k of individual subarray

        int s = 0, ans =0;

        for(int i=0; i<ar.length; i++){
            s += ar[i]; //sum[j]
            if(map.containsKey(s-k)){
                ans += map.get(s-k);
            }
            map.put(s,map.getOrDefault(s, 0)+1);
        }
        System.out.println(ans);

    }
}
