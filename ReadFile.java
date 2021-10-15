package stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\naturales.dat.txt");
        Scanner reader = new Scanner(file);
        Stack<Integer> file_stack = new Stack();

        try {
            // we will read the file
            System.out.println("...Reading the file...");

            // we read number a number
            while (reader.hasNext()) {
                int number = reader.nextInt();
                file_stack.push(number);

            }

            while(!file_stack.empty()) {
                System.out.print(" "+file_stack.pop());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}