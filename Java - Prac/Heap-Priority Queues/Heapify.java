// //Min Heap

// import java.util.ArrayList;

// public class Heapify {
//     static class Heap {

//         ArrayList<Integer> arr = new ArrayList<>();

//         public void add(int data){ // O(log n)
//             //step - 1 -> add at last idx
//             arr.add(data);

//             int childidx = arr.size() - 1; //child index
//             int paridx = (childidx - 1 )/2; //parent index

//             while(arr.get(childidx) < arr.get(paridx)){
//                 //swap
//                 int temp = arr.get(childidx);
//                 arr.set(childidx, arr.get(paridx));
//                 arr.set(paridx, temp);

//                 childidx = paridx;
//                 paridx = (childidx - 1)/2;
//             }
//         }

//         private void heapifymeth(int idx){

//             int leftchildidx = 2 * idx + 1;
//             int rightchildidx = 2 * idx + 2;
//             int minidx = idx;

//             if(leftchildidx < arr.size() && arr.get(minidx) > arr.get(leftchildidx)){
//                 minidx = leftchildidx;
//             }

//             if(rightchildidx < arr.size() && arr.get(minidx) > arr.get(rightchildidx)) {
//                 minidx = rightchildidx;
//             }

//             if(minidx != idx){
//                 //swap
//                 int temp = arr.get(idx);
//                 arr.set(idx, arr.get(minidx));
//                 arr.set(minidx, temp);

//                 heapifymeth(minidx);
//             }
//         }

//         public int remove(){

//             int data = arr.get(0);

//             //s-1 -> swap first && last
//             int temp = arr.get(0);
//             arr.set(0, arr.get(arr.size()-1));
//             arr.set(arr.size()-1, temp);

//             //step - 2 -> delete last
//             arr.remove(arr.size()-1);
            
//             //step - 3 -> heapify
//             heapifymeth(0);

//             return data;
//         }

//         public int peek(){
//             return arr.get(0);
//         }

//         public boolean isEmpty(){
//             return arr.size() == 0;
//         }
//     }

//     public static void main(String[] args) {
        
//         Heap h = new Heap();
//         h.add(38);
//         h.add(31);
//         h.add(37);
//         h.add(32);
//         h.add(35);
//         h.add(33);

//         while(!h.isEmpty()){
//             System.out.print(h.peek()+ " ");
//             h.remove();
//         }
//         System.out.println();

//     }
// }

// MAX HEAP
import java.util.ArrayList;

public class Heapify {
    static class Heap {

        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){ // O(log n)
            //step - 1 -> add at last idx
            arr.add(data);

            int childidx = arr.size() - 1; //child index
            int paridx = (childidx - 1 )/2; //parent index

            while(arr.get(childidx) > arr.get(paridx)){
                //swap
                int temp = arr.get(childidx);
                arr.set(childidx, arr.get(paridx));
                arr.set(paridx, temp);

                childidx = paridx;
                paridx = (childidx - 1)/2;
            }
        }

        private void heapifymeth(int idx){

            int leftchildidx = 2 * idx + 1;
            int rightchildidx = 2 * idx + 2;
            int maxidx = idx;

            if(leftchildidx < arr.size() && arr.get(maxidx) < arr.get(leftchildidx)){
                maxidx = leftchildidx;
            }

            if(rightchildidx < arr.size() && arr.get(maxidx) < arr.get(rightchildidx)) {
                maxidx = rightchildidx;
            }

            if(maxidx != idx){
                //swap
                int temp = arr.get(idx);
                arr.set(idx, arr.get(maxidx));
                arr.set(maxidx, temp);

                heapifymeth(maxidx);
            }
        }

        public int remove(){

            int data = arr.get(0);

            //s-1 -> swap first && last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step - 2 -> delete last
            arr.remove(arr.size()-1);
            
            //step - 3 -> heapify
            heapifymeth(0);

            return data;
        }

        public int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        
        Heap h = new Heap();
        h.add(38);
        h.add(31);
        h.add(37);
        h.add(32);
        h.add(35);
        h.add(33);

        while(!h.isEmpty()){ //Heap Sort - O(log n)
            System.out.print(h.peek()+ " ");
            h.remove();
        }
        System.out.println();

    }
}
