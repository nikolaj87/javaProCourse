package javatask.adds.enums;

public enum Transport {

    ELECTROBIKE(30),
    BUS(60),
    CAR(100),
    ONFOOT(5);

    int speed;

    Transport(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
