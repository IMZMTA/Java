package FileWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodingWriter {
    public static void main(String[] args) {
        String filename = "java.txt";

        try(FileWriter writer = new FileWriter(filename)) {
            writer.write("This is FileWrite Code");
            writer.flush();
            System.out.println("File written successfully");
        }catch (IOException e){
            System.out.printf("Exception Handled : %s", e.getMessage());
        }
        try(FileReader reader = new FileReader(filename)){
            int read = 0;
            do{
                read = reader.read();
                System.out.print((char)read);
            }while (read != -1);
        }catch (IOException e){
            System.out.printf("Read Exception : %s",e.getMessage());
        }
    }
}
