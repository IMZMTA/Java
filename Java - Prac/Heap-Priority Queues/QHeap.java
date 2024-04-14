import java.util.PriorityQueue;

public class QHeap {

    static class WinSlideMax implements Comparable<WinSlideMax> {
        int val, idx;

        public WinSlideMax(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(WinSlideMax w2){
            return w2.val - this.val;
        }
    }

    static class Row implements Comparable<Row> {
        int size, idx;

        public Row(int size, int idx){
            this.size=size;
            this.idx=idx;
        }

        @Override
        public int compareTo(Row r2){
            if(this.size == r2.size){
                return this.idx - r2.idx;
            }
            return this.size - r2.size;
        }
    }

    static class Point implements Comparable<Point>{
    
        int x,y, distSq,idx;
        
        public Point(int x,int y, int distSq, int idx){
            this.x=x;
            this.y=y;
            this.distSq=distSq;
            this.idx=idx;
        }

        @Override
        public int compareTo(Point p2){
            // return p2.distSq-this.distSq;
            //Or ->but have to reverse in priorityQueue
            return this.distSq - p2.distSq;
        }
    }
    public static void main(String[] args) {

        //Q - No - Nearest K or Cars
        
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<pts.length; i++){
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        //Print nearest K cars or points
        for(int i=0; i<k; i++){
            System.out.println("C -> " + pq.remove().idx);
        }

        // Q - No - 2 -> Connect n ropes different with greedy approach
        
        int ropes[] = {2,3,3,4,6};
        
        PriorityQueue<Integer> pc = new PriorityQueue<>();

        for(int i=0; i<ropes.length; i++){
            pc.add(ropes[i]);
        }

        int cost = 0;
        while (pc.size()>1) {
            int min = pc.remove();
            int min2 = pc.remove();
            cost += min + min2;
            pc.add(min + min2);
        }

        System.out.println("Cost of ropes : " + cost);

        //Q - N0 -3 Weakest Army
        int army[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,1}};
        int kn=2;

        PriorityQueue<Row> pr = new PriorityQueue<>();

        for(int i=0; i<army.length; i++){
            int count = 0;
            for(int j=0; j<army[0].length; j++){
                count += army[i][j] == 1 ? 1:0;
            }
            pr.add(new Row(count, i));
        }

        for(int i=0; i<kn; i++){
            System.out.println("R" + pr.remove().idx);
        }

        //Q - No - 4 Sliding Window Maximum =>O(n log k)
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int ks = 3;
        int res[] = new int[arr.length-ks+1];

        PriorityQueue<WinSlideMax> w = new PriorityQueue<>();

        //1st window slide
        for(int i=0; i<ks; i++){
            w.add(new WinSlideMax(arr[i], i));
        }

        res[0] = w.peek().val;

        for(int i=ks; i<arr.length; i++){
            while(w.size() > 0 && w.peek().idx <= (i-ks)){
                w.remove();
            }
            w.add(new WinSlideMax(arr[i], i));
            res[i-ks+1] = w.peek().val;
        }

        for(int i=0; i<res.length; i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
