package javamain.testSecondModule.task2;

import java.util.List;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {


        DoctorQueue slots = new DoctorQueue();
        Visit visit6 = new Visit("6 11:30", "Петров");
        Visit visit4 = new Visit("4 10:30", "Сидоров");
        Visit visit1 = new Visit("1 9:00", "Кузнецов");
        Visit visit2 = new Visit("3 10:00", "Ребров");
        Visit visit3 = new Visit("2 9:30", "Александров");
        Visit visit5 = new Visit("5 11:00", "Котов");
        slots.getVisits().addAll(List.of(visit6, visit4, visit1,
                visit2, visit3, visit5));


        System.out.println("при беспорядочном добавлении визитов " +
                "в коллекцию - получаем отсортированную по времени " +
        slots.getVisits());



    }

}
