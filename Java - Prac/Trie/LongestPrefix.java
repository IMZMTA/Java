import java.lang.*;

public class LongestPrefix {
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

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){

        if(root == null){
            return;
        }

        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char) (i +'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                //Backtrack
                temp.deleteCharAt(temp.length()-1);

            }
        }
    }

    public static boolean startsWithProblem(String prefix){

        Node curr = root;

        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {

        String words[] = {"a","banana", "app", "appl", "ap", "apply", "apple"};

        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }

        longestWord(root, new StringBuilder(""));
        System.out.println(ans);

        String word[] = {"apple", "app", "mango", "man", "woman"};

        //Start With Poblem Prefix
        for(int i=0; i<word.length; i++){
            insert(word[i]);
        }

        System.out.println(startsWithProblem("mango"));
    }
}
