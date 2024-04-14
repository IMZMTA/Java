
//Unique substring = All prefix of all suffix
// Substring - Prefix cut - suffix cut
// Trie already store unique prefix letter
// and No of node in a trie is equal to unique substrings
// Count nodes = unique prefix = unique substring

public class CountUniqueSubstring {
    static class Node {
    
        Node[] children = new Node[26];
        boolean eow;
        
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;

        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx]  = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;

        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow = true;
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++){
            if(root.children[i]!=null){
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }
    public static void main(String[] args) {
        
        String str = "ababa";

        for(int i=0; i<str.length(); i++){
            String s = str.substring(i);
            insert(s);
        }

        int ans = countNodes(root);

        System.out.println(ans);
    }
}
