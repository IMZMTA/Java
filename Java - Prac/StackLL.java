
// //stack through LinkedList
// public class StackLL {
//     static class Node{
//         int data;
//         Node next;
//         Node(int data){
//             this.data = data;
//             this.next = null;
//         }
//     }
//     static class Stack {
//         static Node head = null;

//         public static boolean isEmpty(){
//             return head == null;
//         }

//         //push
//         public static void push(int data){
//             Node newNode = new Node(data);

//             if(isEmpty()){
//                 head = newNode;
//                 return;
//             }

//             newNode.next = head;
//             head = newNode;
//         }

//         public static int pop(){
//             if(isEmpty()){
//                 return -1;
//             }
//             int top = head.data;
//             head = head.next;
//             return top;
//         }

//         public static int peek(){
//             if (isEmpty()) {
//                 return -1;
//             }
//             return head.data;
//         }
//     }
//     public static void main(String[] args) {
//         Stack s = new Stack();
//         s.push(9);
//         s.push(2);
//         s.push(4);
//         s.push(2);
//         while (!s.isEmpty()) {
//             System.out.println(s.pop());
//         }
//     }
// }

//Stack through LinkedList with help of Java Collection Framework

// //stack through LinkedList ->JCF


// import java.util.*;
// public class StackLL {
    
//     public static void main(String[] args) {
//         Stack<Integer> s = new Stack<>();
//         s.push(9);
//         s.push(2);
//         s.push(4);
//         s.push(2);
//         while (!s.isEmpty()) {
//             System.out.println(s.pop());
//         }
//     }
// }


// Stack question

// No-1 - Push new element at the bottom of the stack 
// No-2 - Reverse a String using a stack
// No-3 - Reverse Stack
// No-4 - Stock span Problem
// No-5 - Next Greater Element***
// No-6 - Valid Parenthesis
// No-7 - Duplicate Parenthesis
// No-8 - Maximum Area

import java.util.*;
public class StackLL {

    public static void pushAtBottom( Stack<Integer> s ,int data){

        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str){
        
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        };

        StringBuilder result = new StringBuilder("");

        while(!s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();

    }

    public static void reverseStack(Stack<Integer> s){

        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void stockSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else {
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

    public static boolean validParenthesis(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[' ){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean doubleBrackets(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            // closing
            if(ch == ')'){
                int count = 0;
                while(!s.isEmpty() && s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count< 1){
                    return true;
                }else{
                    s.pop();
                }
                // or
                // while(s.pop() != '('){
                //     count++;
                // }
                // if(count< 1){
                //     return true;
                // }
            }else{
                //opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next Smaller Left
        s = new Stack<>();

        for(int i = 0; i< arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //Current Area : width = j-i-1
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println("Max Area of histogram : " + maxArea);
    }
    
    public static void main(String[] args) {

        // // No - 1
        // Stack<Integer> s = new Stack<>();
        // s.push(9);
        // s.push(2);
        // s.push(4);
        // s.push(2);
        
        // pushAtBottom(s,5);

        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // //No-2
        // String str = "abc";
        // String result = reverseString(str);
        // System.out.println(result);

        // //No -3
        // Stack<Integer> s = new Stack<>();
        // s.push(9);
        // s.push(2);
        // s.push(4);
        // s.push(2);

        // System.out.println("Before :");
        // while (!s.isEmpty()) {
        //     System.out.print(s.pop() + " - ");
        // }

        // s.push(9);
        // s.push(2);
        // s.push(4);
        // s.push(2);

        // reverseStack(s);
        // System.out.println();
        // System.out.println("After :");
        // while (!s.isEmpty()) {
        //     System.out.print(s.pop() + " - ");
        // }

        // //No -4
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i=0; i<span.length; i++){
        //     System.out.println(span[i] + " ");
        // }

        // //No - 5 - **** IMPORTANT ****
        // /* 4 forms of this NextGreater 
        //  * 1-> Next Greater Right 
        //  * 2-> Next Greater Left for loop exchange
        //  * 3-> Next Smaller Right if condition exchange
        //  * 4-> Next Smaller Left for loop exchange + if condition exchange
        // */

        // int arr[] = {6, 8, 0, 1, 3};
        // Stack<Integer> s = new Stack<>();
        // int nextGreater[] = new int[arr.length];

        // for(int i = arr.length-1; i>=0; i--){
        //     //1.while
        //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
        //         s.pop();
        //     }

        //     //2 if-else
        //     if(s.isEmpty()){
        //         nextGreater[i] = -1;
        //     }
        //     else{
        //         nextGreater[i] = arr[s.peek()];
        //     }

        //     //3 push in stack s
        //     s.push(i);
        // }

        // for(int i=0; i<nextGreater.length; i++){
        //     System.out.print(nextGreater[i]+ " ");
        // }
        // System.out.println();


        // //No - 6
        // String str = "({[]}){}";
        // String st = "({[]})}";
        // System.out.println(validParenthesis(str));
        // System.out.println(validParenthesis(st));

        // //No - 7
        // String str = "({a+b}-c)";
        // String str1 = "((a+b))";
        // String str2 = "(a+b)";
        // System.out.println(validParenthesis(str));
        // System.out.println(doubleBrackets(str1));
        // System.out.println(doubleBrackets(str2));

        // No - 8
        int arr[] = {2,1,5,6,2,3};
        maxArea(arr);

    }
}

