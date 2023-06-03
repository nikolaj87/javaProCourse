package main.java.algorythms.hometask.task2;

public class Task2 {

//
//   Task 1. Оценить временную сложность следующий алгоритмов:
// а)
//    void test1(int n)
//    {
//        if (n==1)
//            return;
//        for (int i=1; i<=n; i++)
//            for (int j = 1; j <= n; j++)
//                System.out.println(i + " " + j);
//                break;
//     }
//                Данный код не скомпилуруется. break не входит не в 1 не во 2 цикл.
//                  Но если имелся ввиду следуюший код:
//
//    static void test1(int n) {
//        if (n==1)
//            return;
//        for (int i=1; i<=n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.println(i + " " + j);
//                break;
//            }
//        }
//     }
//           То инструкция break прерывает внутренний цикл после 1 итерации. А значит он
//    проработает столько же как и внешний.
//    ответ: O(n * 2)
//------------------------------------------------------------------------------------------
//  б)
//    void test2(int n)
//    {
//        int a = 0;
//        for (i = 0; i < n; i++)
//            for (j = n; j > i; j--)
//                a = a + i + j;
//    }
//    Опять же код не скомпилируется, но в следующем варианте
//    static void test2 (int n) {
//        int a = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = n; j > i; j--) {
//                a = a + i + j;
//                System.out.println(" ");
//            }
//        }
//    }
//            ответ: тут работают 2 цикла, но количество итераций сокращается с каждым повторением и сокращается линейно.
//          предположу что будет O(n * n / 2)
//----------------------------------------------------------------------------------------------------------
//    в)
//    void test3(int n) {
//        int i, j, a = 0;
//        for (i = n/2; i <=n; i++)
//            for (j = 2; j <=n; j=j2)
//                a=a+n/2;
//    }
//            Код не скомпилируется. Если имелось ввиду следующе
//    static void test3(int n) {
//        int i, j, a = 0;
//        for (i = n / 2; i <= n; i++)
//            for (j = 2; j <= n; j = j * 2)
//
//            }
//
//---------------------------------------------------------------------------------------------------
//    г) (*)
//    static void test4(int n) {
//        int a = 0, i = n;
//        while (i > 0) {
//            a = a + i;
//            i = i / 2;
//        }
//    }
//            самая легкая задачка со звездочкой :-) i /= 2 это бинарный поиск O(log n)
//
//    Task 2. Познакомиться с «Задачей коммивояжёра».
//    https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BA%D0%BE%D0%BC%D0%BC%D0%B8%D0%B2%D0%BE%D1%8F%D0%B6%D1%91%D1%80%D0%B0
//
//
//    Task 3. (*)
//    Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".
//
//
//    Example 1:
//    Input: strs = ["flower","flow","flight"]
//    Output: "fl"
//
//

    public static void main(String[] args) {
        System.out.println(prefixFind(new String[]{"flower","flow","flight"}));
    }

    static String prefixFind (String[] arr) {
        char temp;
        String myStr = "";

        for (int i = 0; i < minLength(arr); i++) {
            temp = arr[0].charAt(i);
            for (int j = 1; j < arr.length; j++) {
                if (temp != arr[j].charAt(i)) {
                    return myStr;
                }
            }
            myStr += temp;
        }
        return myStr;
    }

    private static int minLength(String[] arr){
        int min = arr[0].length();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return min;
    }
}

