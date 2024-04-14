package in.ch82;

import java.util.Arrays;

public class ArrayOperations {

    private int[] numbers;

    public ArrayOperations(int[] numbers) {
        this.numbers = numbers;
    }

    public static void main(String[] args) {
        ArrayOperations a = new ArrayOperations(new int[]{1,2,3,4,5,75});
        ArrayOperations.Statistics s = a.new Statistics();
        System.out.println(s.mean());
        System.out.println(s.median());
    }
    public class Statistics{
        double mean(){
            double sum = 0;
            for (int number : numbers) {
                sum += number;
            }
            return sum / numbers.length;
        }

        double median(){
            Arrays.sort(numbers);
            if(numbers.length % 2 == 0){
                int mid = numbers.length/2;
                return (double) (numbers[mid] + numbers[mid - 1]) /2;
            }else{
                return numbers[numbers.length/2];
            }
        }
    }
}
