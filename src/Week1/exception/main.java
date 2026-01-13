package Week1.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//exceptions → must handle (try-catch) or declare (throws).

public class main {

    //Must handle or declare checked exceptions, otherwise compile-time error
    //FileReader → reads characters from the file
    //BufferedReader → adds buffering + convenient methods like readLine()

//checked exception handling technique
    static void readFile() throws IOException{// transfer to the main method to handle it

        FileReader ft= new FileReader("text.txt");
        BufferedReader br= new BufferedReader(ft);
        System.out.println(br.readLine());
        br.close();
        // means BufferedReader br = new BufferedReader(new FileReader("test.txt"));
    }
    public static void main(String[] args) {

        try {
            readFile();

        } catch (IOException e) {
            System.out.println("file not found"+e.getMessage());
        }
    }
}
