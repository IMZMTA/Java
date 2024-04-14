import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeHeight {
    static class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int lh = countNode(root.left);
        int rh = countNode(root.right);
        return (lh + rh + 1);
    }

    public static int sumOfNode(Node root){
        if(root == null){
            return 0;
        }
        int ls = sumOfNode(root.left);
        int rs = sumOfNode(root.right);
        return (ls + rs + root.data);
    }

    public static int diameterNode(Node root){//O(n2)
        if(root == null){
            return 0;
        }
        int ld = diameterNode(root.left);
        int rd = diameterNode(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh+rh+1, Math.max(ld,rd));
    }

    static class  Info {
    
        int height;
        int diameter;

        public Info(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public static Info diameter(Node root){ //O(n)

        if(root == null){
            return new Info(0,0);
        }

        Info leftinfo = diameter(root.left);
        Info rightinfo = diameter(root.right);

        int diam = Math.max(Math.max(leftinfo.diameter, rightinfo.diameter), leftinfo.height + rightinfo.height + 1);

        int ht = Math.max(leftinfo.height, rightinfo.height) + 1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subroot){
        if(node == null && subroot == null){
            return true;
        }else if(node == null || subroot == null || node.data != subroot.data){
            return false;
        }
        if(!isIdentical(node.left, subroot.left)){
            return false;
        }
        if(!isIdentical(node.right, subroot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubTree(Node root, Node subroot){

        if(root == null){
            return false;
        }

        if(root.data == subroot.data){
            if(isIdentical(root, subroot)){
                return true;
            }
        }
            return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
    }
    static class InfView {
        Node node;
        int hd;

        public InfView(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root){
        //Level Order
        Queue<InfView> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0, max=0;
        q.add(new InfView(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            InfView curr = q.remove();

            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){//does exist first time appearing
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new InfView(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new InfView(curr.node.right, curr.hd+1));
                    max = Math.max(min, curr.hd+1);
                }
            }
        }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    
    public static void KthLevel(Node root, int level, int k){
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }
        KthLevel(root.left, level+1, k);
        KthLevel(root.right, level+1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        
        if(root == null){
            return false;
        }
        
        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }

    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        Node lca = path1.get(i-1);

        return lca;

    }

    public static Node lca2(Node root, int n1, int n2){


        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        //leftlca = val, rightlca = null
        if(rightlca == null){
            return leftlca;
        }

        if(leftlca == null){
            return rightlca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n){

        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
            return rightDist +1;
        }else{
            return leftDist +1;
        }

    }

    public static int minDist(Node root, int n1, int n2){

        Node lca = lca(root, n1, n2);

        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1 + dist2;
    }

    public static int KthAncestor(Node root, int n, int k){

        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }

        int max = Math.max(leftDist, rightDist);

        if(max +1 == k){
            System.out.println(root.data);
        }

        return max+1;

    }

    public static int sumTreeTransform(Node root){

        if(root == null){
            return 0;
        }

        int leftChild = sumTreeTransform(root.left);
        int rightChild = sumTreeTransform(root.right);

        int data = root.data;
        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data = newleft + leftChild + newright + rightChild;

        return data;

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
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(height(root));
        System.out.println(countNode(root));
        System.out.println(sumOfNode(root));
        System.out.println(diameterNode(root));
        System.out.println(diameter(root).diameter);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        // subroot.right = new Node(5);

        System.out.println(isSubTree(root, subroot));
        topView(root);

        // int k=2;
        int k=2;
        KthLevel(root,1,k);

        int n1=4, n2=6;
        System.out.println();
        System.out.println(lca(root, n1, n2).data);
        System.out.println(lca(root, n1, n2).data);

        System.out.println(minDist(root, n1, n2));
        System.out.println(KthAncestor(root, n2, k));

        // // System.out.println("data : " +root.data);
        // int data = root.data;
        // System.out.println("d :" + data);
        // root.data = 5;
        // System.out.println("d : " +data + " data :" + root.data);

        // sumTreeTransform(root);
        // preOrder(root);
    }
}
