import java.util.ArrayList;

public class Bst2 {
    static class Node {
    
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
        
    }

    static class Info {
    
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }        
    }

    public static int maxBST = 0;

    public static Info largestBstSize(Node root){

        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = largestBstSize(root.left);
        Info rightInfo = largestBstSize(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min,rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min,max);
        }

        return new Info(false, size, min, max);
    }

    public static void getInOrder(Node root, ArrayList<Integer> inorder){
        
        if(root == null){
            return;
        }
        
        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);

    }

    public static Node conBst(ArrayList<Integer> inorder, int s, int e){

        if(s>e){
            return null;
        }

        int mid = (s+e)/2;
        Node root = new Node(inorder.get(mid));
        root.left = conBst(inorder, s, mid-1);
        root.right = conBst(inorder, mid+1, e);

        return root;

    }

    public static Node mergeBST(Node root1, Node root2){

        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        ArrayList<Integer> inorder = new ArrayList<>();
        //step-1 getInOrder
        getInOrder(root1, inorder1);
        getInOrder(root2, inorder2);

        //merger
        int i=0, j=0;
        while(i<inorder1.size()&& j<inorder2.size()){
            if(inorder1.get(i)<= inorder2.get(j)){
                inorder.add(inorder1.get(i++));
            }else{
                inorder.add(inorder2.get(j++));
            }
        }
        while(i<inorder1.size()){
            inorder.add(inorder1.get(i++));
        }
        while (j<inorder2.size()) {
            inorder.add(inorder2.get(j++));
        }

        //4th - sorted Array to MergesBst
        Node merNode = conBst(inorder, 0, inorder.size()-1);
        return merNode;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBstSize(root);
        System.out.println("Max Bst size : " + maxBST);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node merNode = mergeBST(root1, root2);
        preOrder(merNode);
        System.out.println();
    }
}
