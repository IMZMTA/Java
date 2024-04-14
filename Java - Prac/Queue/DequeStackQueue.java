import java.util.*;

public class DequeStackQueue {

    //Stack through Deque
    static class Stack {
        Deque<Integer> q = new LinkedList<>();

        public void push(int data){
            q.addLast(data);
        }

        public int pop(){
            if(q.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return q.removeLast();
        }

        public int peek(){
            if(q.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return q.getLast();
        }
    }

    //Queue through Deque
    static class Queue {
        Deque<Integer> q = new LinkedList<>();

        public void add(int data){
            q.addLast(data);
        }

        public int remove(){
            if(q.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return q.removeFirst();
        }

        public int peek(){
            if(q.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return q.getFirst();
        }
    }

    public static void main(String[] args) {
        //Stack
        Stack s = new Stack();
        s.push(1);
        s.push(3);
        s.push(2);
        s.push(5);

        System.out.println("Peek : " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println("Peek : " + s.peek());

        //Queue
        Queue s1 = new Queue();
        s1.add(1);
        s1.add(3);
        s1.add(2);
        s1.add(5);

        System.out.println("-----");

        System.out.println("Peek : " + s1.peek());
        System.out.println(s1.remove());
        System.out.println(s1.remove());
        System.out.println(s1.remove());
        System.out.println(s1.remove());
        System.out.println("Peek : " + s.peek());
    }
}
