package javatask.task16_home_work;

import java.util.ArrayList;
import java.util.List;

public class KingAndQuins {
    public static void main(String[] args) {
        Cell king = new Cell(1, 1);
        Cell quin1 = new Cell(3, 3);
        Cell quin2 = new Cell(1, 7);
        Cell quin3 = new Cell(2, 3);

        List<Cell> quins = new ArrayList<>();
        quins.add(quin1);
        quins.add(quin2);
        quins.add(quin3);
        System.out.println("king position " + king);

        System.out.println("list of quins " + quins);

        System.out.println( "list of checked quins " +
                check(king, quins)
        );


    }

    public static List<Cell> check(Cell king, List<Cell> quins) {

        List<Cell> newList = new ArrayList<>();
        int x = 0;
        int y = 0;


        for (Cell quin : quins) {
            if (quin.y == king.y || quin.x == king.x) {
                newList.add(quin);
                continue;
            }


            boolean flag = false;

            y = quin.y;
            x = quin.x;
            while(y < 7 && x < 7) {
                x++;
                y++;
            }

            while(y >= 0 && x >= 0) {
                if (y == king.y && x == king.x) {
                    flag = true;
                    break;
                }
                y--;
                x--;
            }

            if(flag) newList.add(quin);

        }

        return newList;
    }

}

class Cell {
    int y;
    int x;

    public Cell(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}
