import javax.swing.*;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\i'bo'o'o'o'o\\Desktop\\Java");
        String[] fileList = file.list();
        for(String name: fileList) {
            System.out.println(name);
        }


    }
    public static float test(float a, float b) {
        return a*b;
    }
}
