package main.java.javamain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo {

    public static void main(String[] args) throws IOException {

        String str = "my first io program will be created very soon";

        FileWriter writer = new FileWriter("demo.txt");
        for (int i = 0; i < str.length(); i++) {
            writer.write(str.charAt(i));
        }
        writer.close();

        FileReader reader = new FileReader("demo.txt");
        BufferedReader r = new BufferedReader(reader);

        String line = r.readLine();
        System.out.println("line456 " + line);
        r.close();

        FileReader reader2 = new FileReader("demo.txt");

        StringBuilder sb = new StringBuilder();

        int decode;
        while((decode = reader2.read()) != -1) {
             sb.append((char) decode);
        }
        reader2.close();
        System.out.println("created str --- " + sb);
    }

}
