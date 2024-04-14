public class Binary {

    public static void binarydigit(){

        System.out.println(5&6);
        System.out.println(8|7);
        System.out.println(8^7);
        System.out.println(~5);
        System.out.println(5<<2); //=> L.B.S ( a << b ) => a * 2^b;
        System.out.println(5>>2); // => R.B.S ( a >> b ) => a / 2^b;

    }

    public static void OddEven(int n){

        int bitMask = 1;

        if((n&bitMask)==0){
            System.out.println("Even no");
        }else{
            System.out.println("Odd no");
        }

    }

    public static int getIthBit(int n, int i){

        int bitMask = 1 << i;
        if((n & bitMask) == 0){
            System.out.println("Bit is 0");
            return 0;
        }else {
            System.out.println("Bits is 1");
            return 1;
        }

    };

    public static int setIthBit(int n, int i){

        int bitMask = 1 << i;

        return n| bitMask;

    };

    public static int clearIthBit(int n, int i){

        int bitMask = ~(1 << i);

        return n & bitMask;

    };

    public static int updateIthBit(int n, int i, int newBit){

        // if( newBit == 0)
        //     return clearIthBit(n, i);
        // else 
        //     return setIthBit(n, i);

        n = clearIthBit(n, i);
        
        int bitMask = newBit << i;

        return n | bitMask;

    };

    public static int clearIBit(int n, int i){

        // int bitMask = ~(0) << i;
        //or
        int bitMask = -1 << i;

        return n & bitMask;

    };

    public static int clearRangeOfBit(int n, int i, int j){

        // int bitMask = ~(0) << i;
        //or
        int bitMask = (-1 << (j+1)) | ((1 << i) - 1);

        return n & bitMask;

    };

    public static void Power2(int n){

        if((n & (n-1)) == 0 ) System.out.println("It is Power of 2");
        else System.out.println("It is not a power of 2");

    }


    public static void main(String[] args) {

        // int[] arr={1,2,4,6,4,7,8};
        // binarydigit();
        OddEven(8);
        getIthBit(1, 3);
        System.out.println(setIthBit(8, 2));
        System.out.println(clearIthBit(10, 1));
        System.out.println(updateIthBit(10, 2, 1));
        System.out.println(clearIBit(15, 2));
        System.out.println(clearRangeOfBit(10, 2, 4));
        Power2(256);

    }
};