import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K,V> { //=> generic ->Parameter is generic which is any data-type
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n ->total no of nodes
        private int N;
        private LinkedList<Node> buckets[]; //N = buckets.length size of Array of LL;

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        public int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        public int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)% N;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[2*N];
            N = 2*N;
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            //nodes -> add in bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){ // O(lambda) -> O(1)
            int bi = hashFunction(key); // 0  to 3 Or size-1;
            int di = searchInLL(key,bi); // => valid di OR -1;

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamba = (double) n/N;
            if(lamba > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){ //O(1)
            int bi = hashFunction(key); // 0  to 3 Or size-1;
            int di = searchInLL(key,bi); // => valid di OR -1;

            if(di != -1){ //Valid value is returned
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){ //O(1)
            int bi = hashFunction(key); // 0  to 3 Or size-1;
            int di = searchInLL(key,bi); // => valid di OR -1;

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){ //O(1)
            int bi = hashFunction(key); // 0  to 3 Or size-1;
            int di = searchInLL(key,bi); // => valid di OR -1;

            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 160);
        hm.put("UK", 80);

        ArrayList<String> keys = hm.keySet();
        for(String k:keys){
            System.out.println(k);
        }

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));
        System.out.println(hm.isEmpty());
    }
}
