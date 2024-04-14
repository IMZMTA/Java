public class DoublyLL {

    public class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //remove
    public int removeFirst(){
        if(head == null){
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast(){
        if(head == null){
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void reverse(){

        Node curr = head;
        Node prev = null;
        Node next;

        while( curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev =curr;
            curr = next;
        }
        tail = head;
        head = prev;
    }

    //print
    public void printDLL(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " <--> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addLast(7);

        dll.printDLL();

        System.out.println(dll.removeFirst());
        System.out.println(dll.removeLast());

        // dll.printDLL();
        dll.reverse();
        dll.printDLL();
        dll.addFirst(8);
        dll.printDLL();
        dll.addLast(10);
        dll.printDLL();
        System.out.println(dll.removeFirst());
        dll.printDLL();
        System.out.println(dll.removeLast());
        dll.printDLL();
    }
}
