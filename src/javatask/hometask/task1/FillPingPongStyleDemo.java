package javatask.hometask.task1;

public class FillPingPongStyleDemo {
    public static void main(String[] args) {
        FillArrayPingPong obj = new FillArrayPingPong(new int[6][21],2,3);
        obj.fillArrayPingPongStyle();
        obj.printArray();
    }
}