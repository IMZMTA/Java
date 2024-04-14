// import java.util.*;

public class SubArray {

    public static void subArray(int arr[]) {

        int n = arr.length;
        int csa = 0;
        int maxSumSub = Integer.MIN_VALUE;
        int currmax = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                currmax = 0;
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                    currmax += arr[k];
                };
                System.out.println();
                maxSumSub = (maxSumSub > currmax) ? maxSumSub : currmax;
                csa++;
            };
        };
        System.out.println("\nMaxSubArraySum : " + maxSumSub);
        System.out.println(csa);

    };

    public static void subArray2(int arr[]) {

        int n = arr.length;
        int currmax = 0;
        int maxSumSub = Integer.MIN_VALUE;
        int prefix[] = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        };

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                currmax = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSumSub = (maxSumSub > currmax) ? maxSumSub : currmax;
            };
        };
        System.out.println("MaxSubArraySum : " + maxSumSub);
    };

    //kadana's 

    public static void subArray3(int arr[]) {

        int n = arr.length;
        int currmax = 0;
        int maxSumSub = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            currmax += arr[i];
            maxSumSub = maxSumSub > currmax ? maxSumSub : currmax;
        };

        System.out.println("MaxSubArraySum : " + maxSumSub);
    };

    public static void main(String[] args) {
        int[] arr = { -2, -5, -4, -3, -66 };
        // subArray(arr);
        // subArray2(arr);
        subArray3(arr);
    };
};