package algorythms.hometask.task3;

public class Test {
    public static void main(String[] args) {
        int x = 1680;
        int y = 640;
        System.out.println(recurs(x, y));
    }

    static int recurs (int x, int y) {
        int delitel = x-1;

        while(y % delitel != 0 || x % delitel !=0)
            delitel--;
        return delitel;
    }

}
