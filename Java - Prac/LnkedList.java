


public class LnkedList {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        //Step-1 = Create new node
        Node newNode = new Node(data);

        if(head == null){
            head = tail =newNode;
            size++;
            return;
        }

        //step-2 = newNode next = head
        newNode.next = head;

        //step -3 = head = newNode
        head = newNode;

        size++;
    }

    public void addLast(int data){
        //step 1 = create a new Node
        Node newNode = new Node(data);

        if(head == null){
            head = tail =newNode;
            size++;
            return;
        }

        //step 2 = tail next
        tail.next = newNode;

        //step -3 = tail = new
        tail = newNode;

        size++;
    }

    public void addMiddle(int data, int index){
        Node newNode = new Node(data);

        if(index == 0){
            addFirst(data);
            return;
        }
        if(index == size -1){
            addLast(data);
            return;
        }
        Node temp = head;
        int i=0;

        while(i<index-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;

    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("can't delete -> LL is empty");
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
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("can't delete -> LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // or -> tail.data
        tail = prev;
        prev.next = null;
        size--;
        return val; 
    }

    public int removeMiddleOrNthNode(int nth){
        if(size == 0){
            System.out.println("can't delete -> LL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == nth){
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-nth-1; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // or -> tail.data
        prev.next = prev.next.next;
        size--;
        return val; 
    }

    public void printLL(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean itrSearchLL(int key){ //O(n)
        if(head == null){
            System.out.println("LL is empty");
            return false;
        }
        Node temp = head;
        while(temp!=null){
            if(temp.data == key){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        };
        if(head.data == key){
            return 0;
        };
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;

    };

    public int recurSearchLL(int key){
        return helper(head, key);
    }

    public void reverseLL(){
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

    }

    //Slow-fats approach
    public Node findMid(Node head){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;            
        }
        return slow;
    }

    public boolean PalindromeCheck(){
        if(head == null || head.next == null){
            return true;
        };

        // find mid
        Node midNode = findMid(head);

        //reverse half ll
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        };

        //set up starting node 
        Node right = prev;
        Node left =  head;

        //step3 - check left half & right half
        while(right != null){
            if(right.data != left.data){
                return false;
            }
            right =  right.next;
            left = left.next;
        };
        return true;
    }
    
    //Slow-fats approach -> Cycle in a loop =>Floyd cycle algorithm
    public static boolean isCycle(){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }            
        }
        return false;
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null; //last done
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        };

        //remove cycle -> last.next = null
        prev.next = null;
        
    }

    private Node getMid(Node head){

        Node slow = head;
        Node fast = head.next;

        if(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    private Node merge(Node headL, Node headR){

        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while( headL != null && headR != null){
            if(headL.data <= headR.data){
                temp.next = headL;
                headL = headL.next;
                temp = temp.next;
            }
            else{
                temp.next = headR;
                headR = headR.next;
                temp = temp.next;
            }
        }
        while( headL != null){
            temp.next = headL;
            headL = headL.next;
            temp = temp.next;
        }
        while (headR != null) {
            temp.next = headR;
            headR = headR.next;
            temp = temp.next;
        }

        return mergedLL.next;

    }

    public Node mergeSort(Node head){

        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = getMid(head);

        //divide the list
        Node right = mid.next;
        mid.next = null;

        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(right);

        //conqeror the list
        return merge(leftHead,rightHead);

    }

    public void zigzag(){
        //find mid node
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        //alt merge
        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public static void main(String[] args) {
        // LnkedList ll = new LnkedList();
        // ll.addFirst(3);
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        
        // System.out.println(LnkedList.size);
        // ll.printLL();
        // System.out.println(LnkedList.size);
        // ll.removeLast();
        // ll.printLL();
        // System.out.println(LnkedList.size);
        // boolean itrS = ll.itrSearchLL(3);
        // if(itrS == true){
        //     System.out.println("Key is present");
        // }else{
        //     System.out.println("Key is not present");
        // };

        // System.out.println(ll.recurSearchLL(3));
        // System.out.println(ll.recurSearchLL(10));

        // ll.printLL();
        // ll.reverseLL();
        // ll.printLL();
        // System.out.println(ll.removeMiddleOrNthNode(4));
        // ll.printLL();

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(4);
        // head.next.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        LnkedList l1 = new LnkedList();

        l1.addFirst(1);
        l1.addFirst(2);
        l1.addFirst(5);
        l1.addFirst(7);
        l1.addFirst(6);
        l1.addFirst(8);

        System.out.println("---------");

        l1.printLL();
        l1.head = l1.mergeSort(l1.head);
        l1.printLL();
        l1.zigzag();
        l1.printLL();
    }
    
}
