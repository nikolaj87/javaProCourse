package javamain.threads.exchanger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Exchanger;
/*
  A  _ _ _ _             _ _ _ _ B
          \          /
          - - E - -
  _ _ _ _ /          \ _ _ _ _
  C                              D

          E - точка обмена

          необходимо доставить посылки двумя грузовиками
          грузовик 1: посылка A -> C и A -> D
          грузовик 2: посылка B -> C и B -> D

          создать пункт E для обмена конечными посылками, чтобы итоговые конечные точки были одинаковые, то есть
          грузовик 1: посылка A -> C и A -> D, после обмена: A -> D и B -> D
          грузовик 2: посылка B -> C и B -> D, после обмена: B -> C и A -> C
*/


public class DeliveryExample {
    public static void main(String[] args) {
        // создаем Exchanger

        Exchanger<List<String>> exchanger = new Exchanger<>();

        List<String> goods1 = new ArrayList<>();
        goods1.add("A -> D");
        goods1.add("A -> C");

        List<String> goods2 = new ArrayList<>();
        goods2.add("B -> C");
        goods2.add("B -> D");


        // создадим список товаров для грузовика 1,2
        Truck t1 = new Truck(1, "A", "C", goods1, exchanger);
        Truck t2 = new Truck(2, "B", "D", goods2, exchanger);

        new Thread(t1).start();
        new Thread(t2).start();

    }
}
