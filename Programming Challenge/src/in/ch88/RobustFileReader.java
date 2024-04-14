package in.ch88;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RobustFileReader {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please the enter of file you want to read : ");
        String filename = input.next();

        try (FileReader reader = new FileReader(filename)) {
            int read;
            while ((read = reader.read()) != -1) {
                System.out.print((char) read);
            }
        }catch (FileNotFoundException e){
            System.out.printf("%s not found",filename);
        }catch (IOException e){
            System.out.printf("Exception Occurred : %s", e.getMessage());
        }
    }
}
