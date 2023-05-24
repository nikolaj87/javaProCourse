package javasummary.lesson19_05;

import java.io.*;

public class IO {

    public static void main(String[] args) {
//1. Создайте файл, используя FileOutputStream, с текстом:
        String str = "This is my first experience when I myself work with IO API. I can do everything!";
        createFile(str);
        String str2 = readFile();
        System.out.println(str2);

//2. Создайте файл используя new File() в каталоге folder,
//    убедитесь, что файл существует, удалите файл.
        System.out.println("=============================================================");
        task2();
    }

    public static void task2() {
        File file2 = new File("C:\\Users\\Slonick\\IdeaProjects\\javaProCourse" +
                "\\src\\javasummary\\lesson19_05\\2.txt");
        try {
            file2.createNewFile();
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
        System.out.println("файл существует? - " + file2.exists());

        if (file2.exists()) {
            System.out.println("удаляю");
            file2.delete();
            System.out.println("файл существует? - " + file2.exists());
        }
    }

    public static String readFile() {
        try (FileReader fr = new FileReader("src/javasummary/lesson19_05/1.txt");
             BufferedReader br = new BufferedReader(fr)) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile(String str) {

        try (FileOutputStream fos = new FileOutputStream("src/javasummary/lesson19_05/1.txt")) {
            fos.write(str.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
