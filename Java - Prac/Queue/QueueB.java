    //No - 1 - Queue using 2 stack
    //No - 2 - Stack using 2 Queue
    //No - 3 - First non-repeating letter in a stream of characters
    //No - 4 - Interleave the queue element

    // No -1
// import java.util.*;

// public class QueueB {

//     static  class Queue {
//         static Stack<Integer> s1 = new Stack<>();
//         static Stack<Integer> s2 = new Stack<>();

//         public static boolean isEmpty(){
//             return s1.isEmpty();
//         }

//         //add
//         public static void add(int data){
//             while(!s1.isEmpty()){
//                 s2.push(s1.pop());
//             }

//             s1.push(data);

//             while(!s2.isEmpty()){
//                 s1.push(s2.pop());
//             }
//         }

//         //remove
//         public static int remove(){
//             if(isEmpty()){
//                 System.out.println("Queue is Empty");
//                 return -1;
//             }
//             return s1.pop();
//         }

//         //peek
//         public static int peek(){
//             if(isEmpty()){
//                 System.out.println("Queue is Empty");
//                 return -1;
//             }
//             return s1.peek();
//         }
//     }

//     public static void main(String[] args) {
//         Queue q = new Queue();
//         q.add(1);
//         q.add(14);
//         q.add(12);
//         q.add(10);

//         while(!q.isEmpty()){
//             System.out.println(q.peek());
//             q.remove();
//         }
//     }
// }


// // No -2
// import java.util.LinkedList;
// import java.util.Queue;

// public class QueueB {
    
//     static class Stack{
//         static Queue<Integer> q1 = new LinkedList<>();
//         static Queue<Integer> q2 = new LinkedList<>();

//         public static boolean isEmpty(){
//             return q1.isEmpty() && q2.isEmpty();
//         }

//         //add
//         public static void push(int data){
//             if(!q1.isEmpty()){
//                 q1.add(data);
//             }
//             else{
//                 q2.add(data);
//             }
//         }

//         //pop
//         public static int pop(){
//             if(isEmpty()){
//                 System.out.println("Empty Stack");
//                 return -1;
//             }
//             int top = -1;

//             if(!q1.isEmpty()){
//                 while(!q1.isEmpty()) {
//                     top = q1.remove();
//                     if(q1.isEmpty()){
//                         break;
//                     }
//                     q2.add(top);
//                 }
//             }else{
//                 while(!q2.isEmpty()) {
//                     top = q2.remove();
//                     if(q2.isEmpty()){
//                         break;
//                     }
//                     q1.add(top);
//                 }
//             }
//             return top;
//         }

//         //peek
//         public static int peek(){
//             if(isEmpty()){
//                 System.out.println("Empty Stack");
//                 return -1;
//             }
//             int top = -1;

//             if(!q1.isEmpty()){
//                 while(!q1.isEmpty()) {
//                     top = q1.remove();
//                     q2.add(top);
//                 }
//             }else{
//                 while(!q2.isEmpty()) {
//                     top = q2.remove();
//                     q1.add(top);
//                 }
//             }
//             return top;
//         }
//     }

//     public static void main(String[] args) {
        
//         Stack s = new Stack();

//         s.push(1);
//         s.push(2);
//         s.push(3);
//         s.push(4);

//         while(!s.isEmpty()){
//             System.out.println(s.peek());
//             s.pop();
//         }
//     }
// }


import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;;

public class QueueB {
    
    //No - 3
    public static void nonRepeating(String str){

        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek()- 'a']> 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();

    }

    //No -4
    public static void interLeave(Queue<Integer> q){
        Queue<Integer> q1 = new LinkedList<>();
        int size = q.size();

        for(int i=0; i<size/2; i++){
            q1.add(q.remove());
        }

        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }

    }

    //No -5
    public static void reversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    // Deque = Double ended queue;  when can add and remove from both front as well as rear but on single queue we can remove from front and add from rear
    //Dequeue -> verb,action, method means to remove an element from queue
    
    //No-6
    

    public static void main(String[] args) {
        //No -3
        String str = "aabccxb";
        nonRepeating(str);

        //No - 4
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);
        // print Interleave
        while(!q.isEmpty()){
            System.out.print(q.remove()+ " ");
        }
        System.out.println("\n---");


        //No - 5
        Queue<Integer> qr = new LinkedList<>();
        qr.add(1);
        qr.add(3);
        qr.add(5);
        qr.add(7);
        qr.add(9);
        reversal(qr);
        // print Interleave
        while(!qr.isEmpty()){
            System.out.print(qr.remove()+ " ");
        }
        System.out.println();
    }
}