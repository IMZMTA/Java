import java.util.ArrayList;

public class Bst {

    static class Node {
    
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }

        if(root.data > val){
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean searchBST(Node root, int key){

        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return searchBST(root.left, key);
        }
        else{
            return searchBST(root.right, key);
        }

    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static Node delete(Node root, int val){

        if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data > val){
            root.left = delete(root.left, val);
        }
        else{
            //case 1 - leaf node delete
            if(root.left == null && root.right == null){
                return null;
            }

            //case 2 - single child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.right;
            }

            //case 3 - both children having
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInOrderSuccessor(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRange(root.left, k1, k2);
        }
        else{
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path){

        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");

    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        
        if(root == null){
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }

        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min !=null && root.data <=min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }
        
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }

    public static Node mirrorBST(Node root){

        if(root == null){
            return null;
        }

        Node leftS = mirrorBST(root.left);
        Node rightS = mirrorBST(root.right);

        root.left = rightS;
        root.right = leftS;

        return root;
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int arr[], int s, int e ){
        
        if(s>e){
            return null;
        }
        
        int mid = (s+e)/2;

        Node root = new Node(arr[mid]);
        root.left = createBST(arr, s, mid-1);
        root.right = createBST(arr, mid+1, e);

        return root;
    }

    public static void getInOrder(Node root, ArrayList<Integer> inorder){

        if(root == null){
            return;
        }

        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);

    }

    public static Node convBalBST(ArrayList<Integer> inorder, int s, int e){

        if(s>e){
            return null;
        }

        int mid = (s+e)/2;
        Node root = new Node(inorder.get(mid));
        root.left = convBalBST(inorder, s, mid-1);
        root.right = convBalBST(inorder, mid+1, e);

        return root;

    }

    public static Node convertBST(Node root){

        //inorder serquence -> ascending order tree
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);

        //sorted inorder -> convert Balanced BST
        root = convBalBST(inorder, 0, inorder.size()-1);
        return root;

    }

    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        int values1[] = {8,5,3,1,4,6,10,11,14};//delete node

        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        Node root1 = null;

        for(int i=0; i<values1.length; i++){
            root1 = insert(root1, values1[i]);
        }

        inOrder(root);
        System.out.println();
        System.out.println(searchBST(root, 13));

        inOrder(root1);  
        System.out.println();
        root1 = delete(root1, 1);
        
        inOrder(root1);
        System.out.println();

        printInRange(root1, 5, 12);
        System.out.println();

        ArrayList<Integer> path = new ArrayList<>();
        printRoot2Leaf(root1, path);

        System.out.println(isValidBST(root1, null, null));

        Node mirror = new Node(8);
        mirror.left = new Node(5);
        mirror.right = new Node(10);
        mirror.left.left = new Node(3);
        mirror.left.right = new Node(6);
        mirror.right.right = new Node(11);

        preOrder(mirror);
        System.out.println();
        mirrorBST(mirror);
        preOrder(mirror);
        System.out.println();

        int arr[] = {3,5,6,8,10,11,12};

        Node balNode = createBST(arr, 0, arr.length-1);

        System.out.println("-----");
        preOrder(balNode);
        System.out.println();

        Node convNode = new Node(8);
        convNode.left = new Node(6);
        convNode.left.left = new Node(5);
        convNode.left.left.left = new Node(3);

        convNode.right = new Node(10);
        convNode.right.right = new Node(11);
        convNode.right.right.right = new Node(12);

        convNode = convertBST(convNode);
        preOrder(convNode);
        System.out.println();
    }
}
