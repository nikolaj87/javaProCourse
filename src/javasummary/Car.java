package javasummary;

public abstract class Car {

    String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void service (){
        System.out.println("проходим то для " + this.name);
    }

}
