import java.util.*;

public class QHash {

    public static boolean isAnangram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch)!= null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch) - 1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {

        // Q - No - 1 Major Element and print > arr/3;
        int nums[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> majrElem = new HashMap<>();

        for(int i=0;i<nums.length;i++){  //O(n)
            // if(majrElem.containsKey(nums[i])){
            //     majrElem.put(nums[i],majrElem.get(nums[i])+1);
            // }else{
            //     majrElem.put(nums[i], 1);
            // }
            // --------OR-----------
            majrElem.put(nums[i],majrElem.getOrDefault(nums[i], 0)+1);
        }

        // Set<Integer> keySet = majrElem.keySet();
        // for(Integer k : keySet){
        //     if(majrElem.get(k) > nums.length/3){
        //         System.out.println(k);
        //     }
        // }
        //  -----OR-----
        for(Integer k : majrElem.keySet()){
            if(majrElem.get(k) > nums.length/3){
                System.out.println(k);
            }
        }

        // Q - No - 2 Valid Anagrams
        String s = "knee", t="keen";
        String x = "knee", y="keenu";
        System.out.println(isAnangram(s, t) );
        System.out.println(isAnangram(x, y) );
    }
}
