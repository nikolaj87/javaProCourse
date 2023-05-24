package javatask.adds.htmlreader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadHtml {

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("C:\\Users\\Slonick\\IdeaProjects\\javaProCourse\\src\\" +
                "javatask\\adds\\htmlreader\\index.html");

        BufferedReader bf = new BufferedReader(fr);
        List<String> list =new ArrayList<>();
        String str = "";

        while((str = bf.readLine()) != null) {
            list.add(str);
        }

        bf.close();
        fr.close();
        list.forEach(System.out::println);
    }

}
