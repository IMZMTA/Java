import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class QueueI {    
    
    //Implentation through Array -> Linear Array
    static class QueueLA {
        static int arr[];
        static int size;
        static int rear;

        QueueLA(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }

        //add -> enqueue
        public static void add(int data){
            if(rear == size - 1){
                System.out.println("Queue is full");
                return;
            }
            rear = rear +1;
            arr[rear] = data;
        }

        //remove -> dequeue
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[0];
        }
    }

    //Implentation through Array -> Circular Array
    static class QueueCA {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        QueueCA(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1)%size == front;
        }

        //add -> enqueue
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //addd  1st elem
            if(front == -1){
                front = 0;
            }
            rear = (rear +1)%size;
            arr[rear] = data;
        }

        //remove -> dequeue
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int result = arr[front];

            //last element delete
            if( rear == front){
                rear = front = -1;
            }else{
                front = (front + 1)% size;
            }
            return result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }
    }

    //Implentation through Linkedlist
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class QueueLL {

        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head == null && tail == null;
        }

        //add -> enqueue
        public static void add(int data){
            Node newNode = new Node(data);
            
            if(head == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //remove -> dequeue
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }

            int front = head.data;
            if(tail == head){
                head = tail = null;
            }
            else{
            head = head.next;
            }
            return front;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {


        QueueLA q = new QueueLA(5);
        q.add(1);
        q.add(2);
        q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(1);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

        QueueCA c = new QueueCA(3);
        c.add(1);
        c.add(2);
        c.add(3);

        System.out.println(q.remove());
        c.add(4);
        System.out.println(q.remove());
        c.add(5);

        while(!c.isEmpty()){
            System.out.println(c.peek());
            c.remove();
        }

        QueueLL ql = new QueueLL();
        ql.add(10);
        ql.add(20);
        ql.add(30);

        while(!ql.isEmpty()){
            System.out.println(ql.peek());
            ql.remove();
        }

        Queue<Integer> qc = new LinkedList<>(); // through Linked List
        qc.add(10);
        qc.add(20);
        qc.add(30);
        
        while(!qc.isEmpty()){
            System.out.println(qc.peek());
            qc.remove();
        }

        Queue<Integer> qc1 = new ArrayDeque<>(); //through ArrayDeque
        qc1.add(101);
        qc1.add(201);
        qc1.add(301);
        
        while(!qc1.isEmpty()){
            System.out.println(qc1.peek());
            qc1.remove();
        }
    }
}
