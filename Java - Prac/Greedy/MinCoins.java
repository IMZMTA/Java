import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinCoins {
    public static void main(String[] args) {
        Integer coin[] = {1,2,5,10,20,50,100,200,500,1000,2000};

        Arrays.sort(coin, Comparator.reverseOrder());

        int count = 0;
        int amount = 11590;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<coin.length; i++){
            if(coin[i] <= amount){
                while(coin[i] <= amount){
                    count++;
                    ans.add(coin[i]);
                    amount -=coin[i];
                }
            }
        }
        System.out.println("Min coins : "+ count);

        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
