package algorythms.hometask.task3;

import java.util.LinkedList;
import java.util.List;

public class Tower {

    static int counterIteration = 1;
    static int lastMove;
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
        * - если перемещяемая деталь меньше двух вариантов - надо проверять
        * четность или нечетность порядка одиаковых деталей под ней. Четная идет
        * на меньшую, нечетная - на большую.
        *
        * мы имеем 3 списка с числами - размерами деталей. Верхняя перекладывается
        * из списка в список по алгоритму. После каждой итерации пирамидка распечатывает
        * себя в консоль. Обошлись пока без фронтэнда)))
        * уверен у этой задачи есть куда более изяшное решение, но это уже надо
        * смотреть в интернет.
        * */

        generateDetails();

        lastMove = first.get(first.size() - 1);
        second.add(lastMove);
        first.remove((Integer) lastMove);

        Printer.print();


        while ( !(first.isEmpty() && third.isEmpty() || (first.isEmpty() &&
                second.isEmpty()))  ) {

            topDetailsGenerate();

            if (first.contains(lastMove)) {
                if (detail2 < detail3) {
                    secondMove();
                } else {
                    thirdMove();
                }
            }

            topDetailsGenerate();

            if (second.contains(lastMove)) {
                if (detail1 < detail3) {
                    firstMove();
                } else {
                    thirdMove();
                }
            }

            topDetailsGenerate();

            if (third.contains(lastMove)) {
                if (detail1 < detail2) {
                    firstMove();
                } else {
                    secondMove();
                }
            }
        }
    }


    private static void thirdMove() {

        lastMove = third.get(third.size() - 1);

        if (lastMove < detail1 && lastMove > detail2) {
            first.add(lastMove);
        }
        if (lastMove > detail1 && lastMove < detail2) {
            second.add(lastMove);
        }
        if (lastMove < detail1 && lastMove < detail2) {
            if (check(third)) {
                if (detail1 < detail2) {
                    first.add(lastMove);
                } else {
                    second.add(lastMove);
                }
            } else {
                if (detail1 < detail2) {
                    second.add(lastMove);
                } else {
                    first.add(lastMove);
                }

            }
        }
        third.remove((Integer) lastMove);
        counterIteration++;
        Printer.print();
    }


    private static void secondMove() {

        lastMove = second.get(second.size() - 1);

        if (lastMove < detail1 && lastMove > detail3) {
            first.add(lastMove);
        }
        if (lastMove > detail1 && lastMove < detail3) {
            third.add(lastMove);
        }
        if (lastMove < detail1 && lastMove < detail3) {
            if (check(second)) {
                if (detail1 < detail3) {
                    first.add(lastMove);
                } else {
                    third.add(lastMove);
                }
            } else {
                if (detail1 < detail3) {
                    third.add(lastMove);
                } else {
                    first.add(lastMove);
                }
            }
        }

        second.remove((Integer) lastMove);
        counterIteration++;
        Printer.print();
    }

    private static void firstMove() {

        lastMove = first.get(first.size() - 1);

        if (lastMove < detail2 && lastMove > detail3) {
            second.add(lastMove);
        }
        if (lastMove > detail2 && lastMove < detail3) {
            third.add(lastMove);
        }
        if (lastMove < detail2 && lastMove < detail3) {
            if (check(first)) {
                if (detail2 < detail3) {
                    second.add(lastMove);
                } else {
                    third.add(lastMove);
                }
            } else {
                if (detail2 < detail3) {
                    third.add(lastMove);
                } else {
                    second.add(lastMove);
                }
            }
        }
        first.remove((Integer) lastMove);
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
    }

    private static void topDetailsGenerate() {
        detail1 = first.size() == 0 ? Integer.MAX_VALUE - 1 : first.get(first.size() - 1);
        detail2 = second.size() == 0 ? Integer.MAX_VALUE - 2 : second.get(second.size() - 1);
        detail3 = third.size() == 0 ? Integer.MAX_VALUE - 3 : third.get(third.size() - 1);
    }



}
