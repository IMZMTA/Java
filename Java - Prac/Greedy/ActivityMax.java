import java.util.*;

public class ActivityMax {

    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] =   {2,4,6,7,9,9};

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        //1st Activity
        maxAct =1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++){
            if(start[i]>=lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        
        System.out.println("Max activities : "+ maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + ans.get(i)+ " ");
        }
        System.out.println();
        
        //if not sorted
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length;i++){
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        
        //lambda function -> short form of camparing
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        ArrayList<Integer> nans = new ArrayList<>();
        
        //1st Activity
        int nmaxAct =1;
        nans.add(activities[0][0]);
        int nlastEnd = activities[0][2];
        for(int i=1; i<end.length; i++){
            if(activities[i][1]>=nlastEnd){
                nmaxAct++;
                nans.add(activities[i][0]);
                nlastEnd = activities[i][2];
            }
        }

        System.out.println("Max activities : "+ nmaxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A" + nans.get(i) + " ");
        }
        System.out.println();

        //Max Length Chain of Pairs
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainlen = 1;
        int chainEnd = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] > chainEnd){
                chainlen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max - len : " + chainlen);
    }
}