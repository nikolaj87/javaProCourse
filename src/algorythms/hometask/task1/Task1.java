package algorythms.hometask.task1;

public class Task1 {
    public static void main(String[] args) {


//        1. Palindrome Number
//        Given an integer x, return true if x is a palindrome, and false otherwise.

        System.out.println("заданое число палидром? - " + isPalindromeStr(121));


//        2.        Find the element that appears once in a sorted array
//        Given a sorted array in which all elements occur twice (one after the other)
//        and one element appears only once.

        System.out.println("элемент, появляюшийся в массиве 1 раз - " +
                findSingleElem(new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));

        System.out.println(findSingleElem(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5}));


    }

    private static boolean isPalindromeStr (int number){
        String newNumber = String.valueOf(number);
        String check = "";
        for (int i = newNumber.length() - 1; i >= 0; i--) {
            check += newNumber.charAt(i);
        }
        return check.equals(newNumber);
    }

    private static int findSingleElem(int[] arr){
        for (int i = 0; i < arr.length; i = i + 2) {
            // если дошли до последнего элемента в массиве нечетного размера то возвращаем этот элемент
            if (i == arr.length - 1 & arr.length % 2 == 1) return arr[i];
            if (arr[i] != arr[i+1]) return arr[i];
        }
        return -1;
    }



}