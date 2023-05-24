package javatask.adds.exception_practice;

//     Использование блока finally
class UseFinally {
    public static void genException(int what) {
        int t;
        int nums[] = new int[2];

        System.out.println("Получено: " + what);

        try {
            switch (what) {
                case 0:
                    t = 10 / what; // сгенерировать ошибку деления
                                   // на нуль
                    break;
                case 1:
                    nums[4] = 4; // сгенерировать ошибку обращения
                    // к массиву
                    break;
                case 2:
                    return;
                    // возврат из блока try
            }
        }

        finally {
            System.out.println("Выход из блока try");
        }
    }
}


class FinallyDemo {
    public static void main(String args[]) {
        for (int i = 0; i < 3; i++) {
            UseFinally.genException(i);
            System.out.println();
        }
    }
}
