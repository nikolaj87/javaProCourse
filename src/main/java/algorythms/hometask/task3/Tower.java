package main.java.algorythms.hometask.task3;

import java.util.LinkedList;
import java.util.List;

public class Tower {

    static int counterIteration = 1;
    static int lastMoved;
    static int sizeGame;
    static List<Integer> first = new LinkedList<>();
    static List<Integer> second = new LinkedList<>();
    static List<Integer> third = new LinkedList<>();
    static int detail1;
    static int detail2;
    static int detail3;


    public static void main(String[] args) {

        /*
         * Перемещая детальки около часа я заметил такой алгоритм
         * - если мы переместили деталь, то ее не трогаем следующим ходом
         * - мы перемешам меньшую деталь из двух возможных
         * - если есть однозначность в перемешении - меньшая на большую в одном
         * варианте, то все просто.
         * - если перемещяемая деталь меньше остальных двух  - надо проверять
         * четность или нечетность порядка одиаковых деталей под ней. Четная идет
         * на большую, нечетная - на меньшую.
         *
         * мы имеем 3 LinkedList с числами - размерами деталей. Верхняя перекладывается
         * из списка в список по алгоритму. После каждой итерации пирамидка распечатывает
         * себя в консоль. Обошлись пока без фронтэнда)))
         * уверен у этой задачи есть куда более изяшное решение, но это уже надо
         * смотреть в интернет.
         * ===============================================================================
         * да не лекции во вторник я уже понял лучший алгоритм - попарная работа стержней
         *  1-3 1-2 2-3 и не надо четность проверять и логики в 2 раза меньше надо.
         *================================================================================
         * По поводу рекурсивности впринципе понятно. собрать из 3х - надо 7 итераций.
         * чтоб собрать из четырех - надо собрать из трех - переместить основание собрать еще раз
         * из трех на основании.   1, 3, 7, это 2n + 1... так что:
         *
         * static int recurs (int n) {
               if (n==1) return 1;
               return   (2 * recurs(n - 1) + 1);
           }
         * */

        generateDetails();

        Printer.print();

        lastMoved = first.get(first.size() - 1);
        second.add(lastMoved);
        first.remove((Integer) lastMoved);

        Printer.print();


        while (!(first.isEmpty() && third.isEmpty() || (first.isEmpty() &&
                second.isEmpty()))) {

            topDetailsGenerate();

            if (first.contains(lastMoved)) {
                if (detail2 < detail3) {
                    secondMove();
                } else {
                    thirdMove();
                }
            }

            topDetailsGenerate();

            if (second.contains(lastMoved)) {
                if (detail1 < detail3) {
                    firstMove();
                } else {
                    thirdMove();
                }
            }

            topDetailsGenerate();

            if (third.contains(lastMoved)) {
                if (detail1 < detail2) {
                    firstMove();
                } else {
                    secondMove();
                }
            }
        }
    }

    private static void thirdMove() {

        lastMoved = third.get(third.size() - 1);

        if (lastMoved < detail1 && lastMoved > detail2) {
            first.add(lastMoved);
        }
        if (lastMoved > detail1 && lastMoved < detail2) {
            second.add(lastMoved);
        }
        if (lastMoved < detail1 && lastMoved < detail2) {
            if (check(third)) {
                if (detail1 < detail2) {
                    first.add(lastMoved);
                } else {
                    second.add(lastMoved);
                }
            } else {
                if (detail1 < detail2) {
                    second.add(lastMoved);
                } else {
                    first.add(lastMoved);
                }

            }
        }
        third.remove((Integer) lastMoved);
        counterIteration++;
        Printer.print();
    }


    private static void secondMove() {

        lastMoved = second.get(second.size() - 1);

        if (lastMoved < detail1 && lastMoved > detail3) {
            first.add(lastMoved);
        }
        if (lastMoved > detail1 && lastMoved < detail3) {
            third.add(lastMoved);
        }
        if (lastMoved < detail1 && lastMoved < detail3) {
            if (check(second)) {
                if (detail1 < detail3) {
                    first.add(lastMoved);
                } else {
                    third.add(lastMoved);
                }
            } else {
                if (detail1 < detail3) {
                    third.add(lastMoved);
                } else {
                    first.add(lastMoved);
                }
            }
        }

        second.remove((Integer) lastMoved);
        counterIteration++;
        Printer.print();
    }

    private static void firstMove() {

        lastMoved = first.get(first.size() - 1);

        if (lastMoved < detail2 && lastMoved > detail3) {
            second.add(lastMoved);
        }
        if (lastMoved > detail2 && lastMoved < detail3) {
            third.add(lastMoved);
        }
        if (lastMoved < detail2 && lastMoved < detail3) {
            if (check(first)) {
                if (detail2 < detail3) {
                    second.add(lastMoved);
                } else {
                    third.add(lastMoved);
                }
            } else {
                if (detail2 < detail3) {
                    third.add(lastMoved);
                } else {
                    second.add(lastMoved);
                }
            }
        }
        first.remove((Integer) lastMoved);
        counterIteration++;
        Printer.print();
    }

    private static boolean check(List<Integer> list) {
        int counter = 1;
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i - 1) - list.get(i) == 2) {
                counter++;
            } else break;
        }
        return counter % 2 == 1;
    }

    private static void generateDetails() {
        sizeGame = Request.sizeRequest();
        int startElement = 3;
        for (int i = 0; i < sizeGame; i++) {
            first.add(0, startElement);
            startElement += 2;
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    private static void topDetailsGenerate() {
        detail1 = first.size() == 0 ? Integer.MAX_VALUE - 1 : first.get(first.size() - 1);
        detail2 = second.size() == 0 ? Integer.MAX_VALUE - 2 : second.get(second.size() - 1);
        detail3 = third.size() == 0 ? Integer.MAX_VALUE - 3 : third.get(third.size() - 1);
    }


}
