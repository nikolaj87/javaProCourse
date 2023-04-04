package javasummary.pack2;

public class Mechanic {

    public void service(Car car){
        commomService();

        car.service();

//        if (car.getClass() == Tesla.class){
//            System.out.println("Special service for Tesla");
//        } else if (car.getClass() == Nissan.class){
//            System.out.println("Special service for Nissan");
//        } else if (car.getClass() == BMW.class) {
//            System.out.println("Special service for BMW");
//        } else if (car.getClass() == BMW2.class) {
//            System.out.println("Special service for BMW2");
//        }

        washCar();
    }

//    private void specialService(Car car) {
//        System.out.println("special service for" + car.getName());
//    }

    private void washCar() {
        System.out.println("Washing a car");
    }

    private void commomService() {
        System.out.println("Common service for a car");
    }



}
