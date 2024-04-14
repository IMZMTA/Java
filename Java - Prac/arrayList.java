import java.util.*;


//ArrayList => C++(Vectors)=> Same
//ArrayList Part of Java Collection Framework
public class arrayList {

    public static boolean pairSum1(ArrayList<Integer> list, int target){
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum2PointerRotated(ArrayList<Integer> list, int target){
        
        int n = list.size();
        
        int bp=-1;
        for( int i=0; i<n-1; i++){
            if(list.get(i)>list.get(i+1)){
                bp = i;
                break;
            }
        }

        int lp = (bp+1)%n;
        int rp = (n+bp-1)%n;

        while(lp !=rp){
            if(list.get(lp)+list.get(rp) == target){
                return true;
            }
            else if(list.get(lp)+list.get(rp) < target){
                lp=(lp+1)%n;
            }
            else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }

    public static boolean pairSum2Pointer(ArrayList<Integer> list, int target){

        int lp = 0;
        int rp = list.size()-1;

        while(lp<rp){
            if(list.get(lp)+list.get(rp) == target){
                return true;
            }
            else if(list.get(lp)+list.get(rp) < target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //ClassName objectName = new ClassName();

        ArrayList<Integer> list = new ArrayList<>();
        // ArrayList<String> strlist = new ArrayList<>();

        //add operation=>O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.add(4);
        System.out.println(list);

        //another add type=>O(n)
        list.add(1, 15);
        System.out.println(list);
        list.add(6, 45);
        System.out.println(list);

        //get operation
        System.out.println(list.get(3));
        // System.out.println(list.get(5));

        //remove or delete element;
        list.remove(2);
        System.err.println(list);

        //set element at index;
        list.set(2,10);
        System.out.println(list);
        list.set(3,10);
        System.out.println(list);

        //contains element
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        //size of ArrayList
        System.out.println(list.size());

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //optimised Sorting =>ascen
        System.out.println("----");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        System.out.println("----");

        //optimised Sorting =>desc
        // System.out.println("----");
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());
        // //comaparator - fnx logic can be applist alos in object
        // System.out.println(list);
        // System.out.println("----");


        //2-D ArrayList

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        arr1.add(2);
        arr1.add(4);
        arr1.add(6);
        arr1.add(8);

        arr2.add(3);
        arr2.add(6);
        arr2.add(9);
        arr2.add(12);

        mainList.add(arr);
        mainList.add(arr1);
        mainList.add(arr2);
        mainList.add(arr);

        System.out.println(mainList);

        System.out.println(pairSum1(list, 15));

        System.out.println(pairSum2Pointer(list,5));
        System.out.println(pairSum2PointerRotated(list,5));

    }
}
